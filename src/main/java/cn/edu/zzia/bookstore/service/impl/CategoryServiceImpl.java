package cn.edu.zzia.bookstore.service.impl;

import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.zzia.bookstore.dao.IBookDao;
import cn.edu.zzia.bookstore.dao.ICategoryDao;
import cn.edu.zzia.bookstore.domain.Category;
import cn.edu.zzia.bookstore.service.ICategoryService;
import cn.edu.zzia.bookstore.util.WebUtils;

@Service(ICategoryService.SERVICE_NAME)
@Transactional(readOnly = true)
public class CategoryServiceImpl implements ICategoryService {

	@Resource(name = ICategoryDao.SERVICE_NAME)
	private ICategoryDao categoryDao = null;
	
	@Resource(name = IBookDao.SERVICE_NAME)
	private IBookDao bookDao = null;

	@Override
	public List<Category> findAllCategory() {

		LinkedHashMap<String, String> orderby = new LinkedHashMap<>();
		orderby.put("o.id", "asc");
		return categoryDao.findObjectsByConditionWithNoPage(orderby);
	}

	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = true)
	public void addCategory(Category category) {

		if (null != category && StringUtils.isNotBlank(category.getName())) {
			category.setId(WebUtils.makeID());
			categoryDao.save(category);
		}
	}

	@Override
	public Category findCategoryById(String categoryId) {
		if (StringUtils.isNotBlank(categoryId)) {
			return categoryDao.findObjectById(categoryId);
		}
		return null;
	}

	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = true)
	public void updateCategory(Category category) {
		if (null != category && StringUtils.isNotBlank(category.getId())
				&& StringUtils.isNotBlank(category.getName())) {
			categoryDao.update(category);
		}
	}

	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = true)
	public void deleteCategoryById(String categoryId) {
		if(StringUtils.isNotBlank(categoryId)){
			
//			String whereHql = " and o.category.id = ? ";
//			Object[] params = {categoryId};
//			List<Book> books = bookDao.findObjectsByConditionWithNoPage(whereHql, params);
//			bookDao.deleteAllObjects(books);
			categoryDao.deleteByIds(categoryId);
		}
	}
}
