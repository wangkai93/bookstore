package cn.edu.zzia.bookstore.dao;

import java.util.List;

import cn.edu.zzia.bookstore.domain.Book;

public interface IBookDao extends ICommonDao<Book>{

	public static final String SERVICE_NAME = "cn.edu.zzia.bookstore.dao.impl.BookDaoImpl";
	
	int getTotalRecord();
	
	public List<Book> getPageData(int startindex,int pagesize);
	
	public List<Book> getPageData(int startindex,int pagesize,String category_id);
	
	
	public int getTotalRecord(String category_id);
}