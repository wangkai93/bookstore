package cn.edu.zzia.bookstore.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.edu.zzia.bookstore.dao.IBookDao;
import cn.edu.zzia.bookstore.domain.Book;

@Repository(IBookDao.SERVICE_NAME)
public class BookDaoImpl extends CommonDaoImpl<Book> implements IBookDao {

	@Override
	public int getTotalRecord() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Book> getPageData(int startindex, int pagesize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> getPageData(int startindex, int pagesize, String category_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTotalRecord(String category_id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
