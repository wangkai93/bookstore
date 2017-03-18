package cn.edu.zzia.bookstore.service;

import cn.edu.zzia.bookstore.domain.Book;
import cn.edu.zzia.bookstore.domain.Page;

public interface IBookService {
	
	public static final String SERVICE_NAME = "cn.edu.zzia.bookstore.service.impl.BookServiceImpl";

	/**
	 * 根据页数分页查找书籍
	 * @param pagenum
	 * @return
	 */
	Page findBooksWithPage(String pagenum);

	/**
	 * 根据分类和页数查找一页书籍
	 * @param pagenum
	 * @param categoryId
	 * @return
	 */
	Page findBooksWithPageByCategoryId(String pagenum, String categoryId);

	/**
	 * 根据书籍的Id查找相应的书籍
	 * @param bookId
	 * @return
	 */
	Book findBookById(String bookId);

	/**
	 * 根据书籍id删除相应的书籍
	 * @param bookId
	 */
	void deleteBookById(String bookId);

	/**
	 * 更新书籍信息
	 * @param book
	 * @param publisherId 
	 * @param categoryId 
	 */
	void updateBook(Book book, String categoryId, String publisherId);

	/**
	 * 根据分类id保存书籍
	 * @param book
	 * @param categoryId
	 * @param publisherId
	 */
	void saveBook(Book book, String categoryId,String publisherId);

	/**
	 * 根据书的名字分页查找书籍
	 * @param bookName
	 * @param pagenum
	 * @return
	 */
	Page findBookByName(String bookName,String pagenum);

}
