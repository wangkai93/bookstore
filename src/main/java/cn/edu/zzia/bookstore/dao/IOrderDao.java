package cn.edu.zzia.bookstore.dao;

import cn.edu.zzia.bookstore.domain.Order;

public interface IOrderDao extends ICommonDao<Order>{

	public static final String SERVICE_NAME = "cn.edu.zzia.bookstore.dao.impl.OrderDaoImpl";
}