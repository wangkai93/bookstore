package cn.edu.zzia.bookstore.dao;

import cn.edu.zzia.bookstore.domain.Book;

public interface IBookDao extends ICommonDao<Book>{

	public static final String SERVICE_NAME = "cn.edu.zzia.bookstore.dao.impl.BookDaoImpl";
	
	/**
	 * 获取数的数量
	 * @return
	 */
	Integer getTotalRecord();
	
}