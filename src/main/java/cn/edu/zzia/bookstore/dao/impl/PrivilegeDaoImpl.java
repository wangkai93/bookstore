package cn.edu.zzia.bookstore.dao.impl;

import org.springframework.stereotype.Repository;

import cn.edu.zzia.bookstore.dao.IPrivilegeDao;
import cn.edu.zzia.bookstore.domain.Privilege;
@Repository(IPrivilegeDao.SERVICE_NAME)
public class PrivilegeDaoImpl extends CommonDaoImpl<Privilege> implements IPrivilegeDao {
	
}
