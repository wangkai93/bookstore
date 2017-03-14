package cn.edu.zzia.bookstore.dao.impl;

import org.springframework.stereotype.Repository;

import cn.edu.zzia.bookstore.dao.IOrderDao;
import cn.edu.zzia.bookstore.domain.Order;
@Repository(IOrderDao.SERVICE_NAME)
public class OrderDaoImpl extends CommonDaoImpl<Order> implements IOrderDao {
}
