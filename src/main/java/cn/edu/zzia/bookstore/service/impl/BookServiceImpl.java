package cn.edu.zzia.bookstore.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.zzia.bookstore.dao.IBookDao;
import cn.edu.zzia.bookstore.dao.ICategoryDao;
import cn.edu.zzia.bookstore.dao.IPublisherDao;
import cn.edu.zzia.bookstore.domain.Book;
import cn.edu.zzia.bookstore.domain.Category;
import cn.edu.zzia.bookstore.domain.Page;
import cn.edu.zzia.bookstore.domain.Publisher;
import cn.edu.zzia.bookstore.service.IBookService;
import cn.edu.zzia.bookstore.util.DateUtil;

@Service(IBookService.SERVICE_NAME)
@Transactional(readOnly = true)
public class BookServiceImpl implements IBookService {

	@Resource(name = IBookDao.SERVICE_NAME)
	private IBookDao bookDao = null;

	@Resource(name = ICategoryDao.SERVICE_NAME)
	private ICategoryDao categoryDao = null;

	@Resource(name = IPublisherDao.SERVICE_NAME)
	private IPublisherDao publisherDao = null;

	public static void main(String[] args) {
		long time = DateUtils.getFragmentInMilliseconds(new Date(), Calendar.DATE);
		System.out.println(time);
	}

	@Override
	public Page findBooksWithPage(String pagenum) {

		Page page = new Page(StringUtils.isBlank(pagenum) ? 1 : Integer.parseInt(pagenum));

		LinkedHashMap<String, String> orderby = new LinkedHashMap<>();
		orderby.put("o.sort", "desc");

		List<Book> books = bookDao.findCollectionByConditionWithPage(null, null, orderby, page);
		if (null != books && books.size() > 0) {
			for (Book book : books) {
				if (null != book && null != book.getAddDate()
						&& (DateUtil.getOffsetDays(new Date(),book.getAddDate())) < 3)
					book.setIsNew(true);
			}
		}
		page.setList(books);

		return page;
	}

	@Override
	public Page findBooksWithPageByCategoryId(String pagenum, String categoryId) {

		if (StringUtils.isNotBlank(categoryId)) {

			Page page = new Page(StringUtils.isBlank(pagenum) ? 1 : Integer.parseInt(pagenum));

			String whereHql = " and o.category.id = ? ";
			Object[] params = { categoryId };
			LinkedHashMap<String, String> orderby = new LinkedHashMap<>();
			orderby.put("o.sort", "desc");

			List<Book> books = bookDao.findCollectionByConditionWithPage(whereHql, params, orderby, page);
			page.setList(books);

			return page;
		}

		return null;
	}

	@Override
	public Book findBookById(String bookId) {

		if (StringUtils.isNotBlank(bookId)) {
			return bookDao.findObjectById(bookId);
		}
		return null;
	}

	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteBookById(String bookId) {
		if (StringUtils.isNotBlank(bookId)) {
			bookDao.deleteByIds(bookId);
		}

	}

	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
	public void updateBook(Book book, String categoryId, String publisherId) {

		if (null != book && StringUtils.isNotBlank(book.getId())) {
			if (StringUtils.isNotBlank(categoryId) && StringUtils.isNotBlank(publisherId)) {
				Category category = categoryDao.findObjectById(categoryId);
				Publisher publisher = publisherDao.findObjectById(publisherId);
				if (null != category && null != publisher) {
					book.setCategory(category);
					book.setPublisher(publisher);
					book.setAddDate(new Date());
					bookDao.update(book);
				}
			}

		}
	}

	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
	public void saveBook(Book book, String categoryId, String publisherId) {

		if (StringUtils.isNotBlank(categoryId) && StringUtils.isNotBlank(publisherId)) {
			// 获取书籍的总数
			Integer count = bookDao.getTotalRecord();
			System.out.println("count = " + count);
			Category category = categoryDao.findObjectById(categoryId);
			Publisher publisher = publisherDao.findObjectById(publisherId);
			if (null != category && null != publisher) {
				book.setCategory(category);
				book.setPublisher(publisher);
				book.setAddDate(new Date());
				book.setSort(count + 1);
				bookDao.save(book);
			}
		}
	}

	@Override
	public Page findBookByName(String bookName, String pagenum) {

		if (StringUtils.isNotBlank(bookName)) {

			Page page = new Page(StringUtils.isBlank(pagenum) ? 1 : Integer.parseInt(pagenum));
			String whereHql = " and o.name like ? ";
			Object[] params = { "%" + bookName + "%" };
			LinkedHashMap<String, String> orderby = new LinkedHashMap<>();
			orderby.put("o.sort", "desc");
			List<Book> books = bookDao.findCollectionByConditionWithPage(whereHql, params, orderby, page);
			page.setList(books);

			return page;
		}

		return null;
	}
}
