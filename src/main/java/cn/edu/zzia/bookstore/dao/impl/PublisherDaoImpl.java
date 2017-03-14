package cn.edu.zzia.bookstore.dao.impl;

import org.springframework.stereotype.Repository;

import cn.edu.zzia.bookstore.dao.IPublisherDao;
import cn.edu.zzia.bookstore.domain.Publisher;

@Repository(IPublisherDao.SERVICE_NAME)
public class PublisherDaoImpl extends CommonDaoImpl<Publisher> implements IPublisherDao {

}
