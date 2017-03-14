package cn.edu.zzia.bookstore.dao;

import cn.edu.zzia.bookstore.domain.User;

public interface IUserDao extends ICommonDao<User>{

	public static final String SERVICE_NAME = "cn.edu.zzia.bookstore.dao.impl.UserDaoImpl";
}