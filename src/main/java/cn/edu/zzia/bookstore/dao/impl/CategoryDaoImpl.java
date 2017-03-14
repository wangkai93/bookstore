package cn.edu.zzia.bookstore.dao.impl;

import org.springframework.stereotype.Repository;

import cn.edu.zzia.bookstore.dao.ICategoryDao;
import cn.edu.zzia.bookstore.domain.Category;
@Repository(ICategoryDao.SERVICE_NAME)
public class CategoryDaoImpl extends CommonDaoImpl<Category> implements ICategoryDao {
	
}
