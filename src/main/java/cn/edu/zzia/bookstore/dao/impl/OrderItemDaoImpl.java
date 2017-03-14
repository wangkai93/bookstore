package cn.edu.zzia.bookstore.dao.impl;

import org.springframework.stereotype.Repository;

import cn.edu.zzia.bookstore.dao.IOrderItemDao;
import cn.edu.zzia.bookstore.domain.Orderitem;
@Repository(IOrderItemDao.SERVICE_NAME)
public class OrderItemDaoImpl extends CommonDaoImpl<Orderitem> implements IOrderItemDao {
}
