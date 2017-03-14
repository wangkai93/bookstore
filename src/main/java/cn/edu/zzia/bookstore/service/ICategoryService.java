package cn.edu.zzia.bookstore.service;

import java.util.List;

import cn.edu.zzia.bookstore.domain.Category;

public interface ICategoryService {

	public static final String SERVICE_NAME = "cn.edu.zzia.bookstore.service.impl.CategoryServiceImpl";

	/**
	 * 查询所有的分类信息
	 * @return
	 */
	List<Category> findAllCategory();

	/**
	 * 添加分类
	 * @param category
	 */
	void addCategory(Category category);

	/**
	 * 根据分类id查找分类信息
	 * @param categoryId
	 * @return
	 */
	Category findCategoryById(String categoryId);

	/**
	 * 更新分类信息
	 * @param category
	 */
	void updateCategory(Category category);

	/**
	 * 根据分类id删除分类信息
	 * @param categoryId
	 */
	void deleteCategoryById(String categoryId);

}
