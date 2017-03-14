package cn.edu.zzia.bookstore.dao;

import cn.edu.zzia.bookstore.domain.Category;

public interface ICategoryDao extends ICommonDao<Category>{

	public static final String SERVICE_NAME = "cn.edu.zzia.bookstore.dao.impl.CategoryDaoImpl";
}