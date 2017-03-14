package cn.edu.zzia.bookstore.web.client;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.edu.zzia.bookstore.domain.Category;
import cn.edu.zzia.bookstore.domain.Page;
import cn.edu.zzia.bookstore.service.IBookService;
import cn.edu.zzia.bookstore.service.ICategoryService;

@Controller
@RequestMapping("/client/index")
public class IndexController {

	// 注入类别的业务层
	@Resource(name = ICategoryService.SERVICE_NAME)
	private ICategoryService categoryService = null;

	// 注入书籍的业务层
	@Resource(name = IBookService.SERVICE_NAME)
	private IBookService bookService = null;

	/**
	 * 根据页数或者分类id和页数获取数据
	 * 
	 * @param pagenum
	 * @param categoryId
	 * @param request
	 * @return
	 */
	@RequestMapping("/getAll")
	public String getAll(@RequestParam(value = "pagenum", required = false) String pagenum,
			@RequestParam(value = "categoryId", required = false) String categoryId, HttpServletRequest request) {

		List<Category> categories = categoryService.findAllCategory();

		Page page = null;
		if (StringUtils.isNotBlank(categoryId)) {

			page = bookService.findBooksWithPageByCategoryId(pagenum, categoryId);

		} else {
			page = bookService.findBooksWithPage(pagenum);
		}

		request.setAttribute("categorys", categories);
		request.setAttribute("page", page);

		return "client/body";
	}

	/**
	 * 根据分类Id查找相应分类的书籍
	 * 
	 * @param categoryId
	 * @param request
	 * @return
	 */
	@RequestMapping("/category")
	public String category(@RequestParam(value = "categoryId", required = false) String categoryId, HttpServletRequest request) {
		List<Category> categories = categoryService.findAllCategory();

		Page page = bookService.findBooksWithPageByCategoryId(null, categoryId);

		request.setAttribute("categorys", categories);
		request.setAttribute("page", page);

		return "client/body";
	}

	/**
	 * 访问首页的头部jsp
	 * 
	 * @return
	 */
	@RequestMapping("/head")
	public String head() {
		return "client/head";
	}

}
