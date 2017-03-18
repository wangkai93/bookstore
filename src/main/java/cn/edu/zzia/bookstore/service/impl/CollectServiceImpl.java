package cn.edu.zzia.bookstore.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.zzia.bookstore.dao.IBookDao;
import cn.edu.zzia.bookstore.dao.ICollectDao;
import cn.edu.zzia.bookstore.domain.Book;
import cn.edu.zzia.bookstore.domain.Collect;
import cn.edu.zzia.bookstore.domain.CollectId;
import cn.edu.zzia.bookstore.domain.Page;
import cn.edu.zzia.bookstore.service.ICollectService;

@Service(ICollectService.SERVICE_NAME)
@Transactional(readOnly = false)
public class CollectServiceImpl implements ICollectService {

	@Resource(name = ICollectDao.SERVICE_NAME)
	private ICollectDao collectDao = null;

	@Resource(name = IBookDao.SERVICE_NAME)
	private IBookDao bookDao = null;

	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
	public void saveCollect(String userId, String bookId) {

		if (StringUtils.isNotBlank(userId) && StringUtils.isNotBlank(bookId)) {
			CollectId id = new CollectId(userId, bookId);
			Collect collect = new Collect();
			collect.setId(id);
			collect.setCollectTime(new Date());
			collectDao.save(collect);
		}

	}

	@Override
	public Page findAllCollectByUserId(String userId, String pagenum) {

		if (StringUtils.isNotBlank(userId)) {

			Page page = new Page(StringUtils.isBlank(pagenum) ? 1 : Integer.parseInt(pagenum));

			String whereHql = " and o.id.userId = ? ";
			Object[] params = { userId };
			LinkedHashMap<String, String> orderby = new LinkedHashMap<>();
			orderby.put("o.collectTime", "desc");
			List<Collect> collects = collectDao.findCollectionByConditionWithPage(whereHql, params, orderby, page);

			if (null != collects && collects.size() > 0) {
				List<Book> list = new ArrayList<>();
				for (Collect collect : collects) {

					Book book = bookDao.findObjectById(collect.getId().getBookId());
					list.add(book);
				}
				page.setList(list);
				return page;
			}
		}
		return null;
	}

	@Override
	public void deleteCollectByUserIdAndBookId(String userId, String bookId) {

		if (StringUtils.isNotBlank(userId) && StringUtils.isNotBlank(bookId)) {

			String whereHql = " and o.id.userId = ? and o.id.bookId = ? ";
			Object[] params = { userId, bookId };
			List<Collect> list = collectDao.findObjectsByConditionWithNoPage(whereHql, params);

			if (null != list && list.size() > 0) {
				collectDao.deleteAllObjects(list);
			}
		}
	}

	@Override
	public List<Collect> selectCollectByUserId(String userId) {

		if (StringUtils.isNotBlank(userId)) {

			String whereHql = " and o.id.userId = ? ";
			Object[] params = { userId };
			return collectDao.findObjectsByConditionWithNoPage(whereHql, params);
		}
		return null;
	}
}
