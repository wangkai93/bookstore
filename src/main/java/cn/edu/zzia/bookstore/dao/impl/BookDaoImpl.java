package cn.edu.zzia.bookstore.dao.impl;

import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import cn.edu.zzia.bookstore.dao.IBookDao;
import cn.edu.zzia.bookstore.domain.Book;

@Repository(IBookDao.SERVICE_NAME)
public class BookDaoImpl extends CommonDaoImpl<Book> implements IBookDao {

	@SuppressWarnings("unchecked")
	@Override
	public Integer getTotalRecord() {

		final String hql = "select count(*) from Book";

		return this.getHibernateTemplate().execute(new HibernateCallback() {

			@Override
			public Object doInHibernate(Session session) throws HibernateException, SQLException {

				Query query = session.createQuery(hql);
				return ((Number)query.uniqueResult()).intValue();
			}
		});
	}

}
