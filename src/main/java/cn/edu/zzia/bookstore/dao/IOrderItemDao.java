package cn.edu.zzia.bookstore.dao;

import cn.edu.zzia.bookstore.domain.Orderitem;

public interface IOrderItemDao extends ICommonDao<Orderitem>{

	public static final String SERVICE_NAME = "cn.edu.zzia.bookstore.dao.impl.OrderItemDaoImpl";
}