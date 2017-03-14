package cn.edu.zzia.bookstore.web.manager;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.edu.zzia.bookstore.domain.Category;
import cn.edu.zzia.bookstore.service.ICategoryService;

@Controller
@RequestMapping("/manager/category")
public class CategoryController {

	@Resource(name = ICategoryService.SERVICE_NAME)
	private ICategoryService categoryService = null;

	/**
	 * 显示添加分类页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add() {
		return "manager/addcategory";
	}

	/**
	 * 保存添加的分类信息
	 * 
	 * @param category
	 * @return
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Category category) {
		categoryService.addCategory(category);
		return "redirect:/manager/category/list";
	}

	/**
	 * 显示编辑分类的页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable("id") String categoryId, HttpServletRequest request) {

		Category category = categoryService.findCategoryById(categoryId);
		request.setAttribute("category", category);
		return "manager/editcategory";
	}

	/**
	 * 更新编辑页面的分类信息
	 * 
	 * @param category
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(Category category) {

		categoryService.updateCategory(category);

		return "redirect:/manager/category/list";
	}

	/**
	 * 显示分类列表
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(HttpServletRequest request) {

		List<Category> categories = categoryService.findAllCategory();
		request.setAttribute("categories", categories);
		return "manager/listcategory";
	}

	/**
	 * 删除分类信息
	 * @param categoryId
	 * @return
	 */
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") String categoryId) {
		categoryService.deleteCategoryById(categoryId);
		return "redirect:/manager/category/list";
	}
}
