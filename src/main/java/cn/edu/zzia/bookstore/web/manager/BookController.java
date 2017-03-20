package cn.edu.zzia.bookstore.web.manager;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import cn.edu.zzia.bookstore.domain.Book;
import cn.edu.zzia.bookstore.domain.Category;
import cn.edu.zzia.bookstore.domain.Page;
import cn.edu.zzia.bookstore.domain.Publisher;
import cn.edu.zzia.bookstore.service.IBookService;
import cn.edu.zzia.bookstore.service.ICategoryService;
import cn.edu.zzia.bookstore.service.IPublisherService;
import cn.edu.zzia.bookstore.util.WebUtils;

@Controller
@RequestMapping("/manager/book")
public class BookController {

	@Resource(name = IBookService.SERVICE_NAME)
	private IBookService bookService = null;

	@Resource(name = ICategoryService.SERVICE_NAME)
	private ICategoryService categoryService = null;

	@Resource(name = IPublisherService.SERVICE_NAME)
	private IPublisherService publisherService = null;

	/**
	 * 显示添加书籍的页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(HttpServletRequest request) {
		List<Category> categories = categoryService.findAllCategory();
		List<Publisher> publishers = publisherService.findAllPublisher();
		request.setAttribute("categories", categories);
		request.setAttribute("publishers", publishers);
		return "manager/addbook";
	}

	/**
	 * 保存添加的书籍
	 * 
	 * @param book
	 * @param request
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Book book, @RequestParam("category_id") String categoryId,
			@RequestParam("publisher_id") String publisherId, HttpServletRequest request)
			throws IllegalStateException, IOException {

		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());

		String contextPath = request.getServletContext().getRealPath("/");
		// 检查form中是否有enctype="multipart/form-data"
		if (multipartResolver.isMultipart(request)) {
			// 将request变成多部分request
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			// 获取multiRequest 中所有的文件名
			Iterator iter = multiRequest.getFileNames();
			if (iter.hasNext()) {
				// 一次遍历所有文件
				MultipartFile file = multiRequest.getFile(iter.next().toString());
				String filename = "images" + File.separator + System.currentTimeMillis() + "";
				if (null != file) {
					// 获取扩展名
					String originalName = file.getOriginalFilename();
					String ext = originalName.substring(originalName.lastIndexOf("."), originalName.length());
					filename = filename + ext;
					File images = new File(contextPath + File.separator + filename);
					file.transferTo(images);
				} else {
					request.setAttribute("bookError", "图片不能为空");
					return "manager/addbook";
				}
				book.setId(WebUtils.makeID());
				book.setImage(filename);
				bookService.saveBook(book, categoryId, publisherId);
			}
		} else {
			request.setAttribute("bookError", "图片不能为空");
			return "manager/addbook";
		}

		return "redirect:/manager/book/list";
	}

	/**
	 * 显示编辑书籍的页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable("id") String bookId, HttpServletRequest request) {
		List<Category> categories = categoryService.findAllCategory();
		Book book = bookService.findBookById(bookId);
		List<Publisher> publishers = publisherService.findAllPublisher();
		request.setAttribute("publishers", publishers);
		request.setAttribute("categories", categories);
		request.setAttribute("book", book);
		return "manager/editbook";
	}

	/**
	 * 更新编辑页面的书籍信息
	 * 
	 * @param category
	 * @return
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(Book book, @RequestParam("category_id") String categoryId,
			@RequestParam("publisher_id") String publisherId, HttpServletRequest request) throws IllegalStateException, IOException {
		
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());

		String contextPath = request.getServletContext().getRealPath("/");
		// 检查form中是否有enctype="multipart/form-data"
		if (multipartResolver.isMultipart(request)) {
			// 将request变成多部分request
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			// 获取multiRequest 中所有的文件名
			Iterator iter = multiRequest.getFileNames();
			if (iter.hasNext()) {
				// 一次遍历所有文件
				MultipartFile file = multiRequest.getFile(iter.next().toString());
				String filename = null;
				if (null != file && file.getSize() > 0) {
					// 获取扩展名
					filename = "images" + File.separator + System.currentTimeMillis() + "";
					String originalName = file.getOriginalFilename();
					String ext = originalName.substring(originalName.lastIndexOf("."), originalName.length());
					filename = filename + ext;
					File images = new File(contextPath + File.separator + filename);
					file.transferTo(images);
				} 
				if(StringUtils.isNotBlank(filename))
					book.setImage(filename);
				bookService.updateBook(book, categoryId, publisherId);
			}
		} 


		return "redirect:/manager/book/list";
	}

	/**
	 * 显示书籍列表
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(@RequestParam(value = "pagenum", required = false) String pagenum, HttpServletRequest request) {

		Page page = bookService.findBooksWithPage(pagenum);
		request.setAttribute("page", page);
		return "manager/listbook";
	}

	/**
	 * 删除书籍信息
	 * 
	 * @param categoryId
	 * @return
	 */
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") String bookId) {
		bookService.deleteBookById(bookId);
		return "redirect:/manager/book/list";
	}
}
