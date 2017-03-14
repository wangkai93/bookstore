package cn.edu.zzia.bookstore.dao.impl;

import org.springframework.stereotype.Repository;

import cn.edu.zzia.bookstore.dao.IUserDao;
import cn.edu.zzia.bookstore.domain.User;

@Repository(IUserDao.SERVICE_NAME)
public class UserDaoImpl extends CommonDaoImpl<User> implements IUserDao {
	
}
