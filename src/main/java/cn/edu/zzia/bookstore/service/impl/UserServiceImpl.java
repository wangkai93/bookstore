package cn.edu.zzia.bookstore.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.zzia.bookstore.dao.IUserDao;
import cn.edu.zzia.bookstore.domain.Page;
import cn.edu.zzia.bookstore.domain.User;
import cn.edu.zzia.bookstore.exception.UserExistException;
import cn.edu.zzia.bookstore.service.IUserService;

@Service(IUserService.SERVICE_NAME)
@Transactional(readOnly = true)
public class UserServiceImpl implements IUserService {

	@Resource(name = IUserDao.SERVICE_NAME)
	private IUserDao userDao = null;

	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
	public void saveUser(User user) throws UserExistException {

		// 先检查用户名是否重复
		String username = user.getUsername();
		if (StringUtils.isNotBlank(username)) {
			String whereHql = " and o.username = ? ";
			Object[] params = { username };
			List<User> users = userDao.findObjectsByConditionWithNoPage(whereHql, params);

			if (null != users && users.size() > 0) {
				throw new UserExistException("");
			} else {
				user.setState(1);
				userDao.save(user);
			}
		}
	}

	@Override
	public User findUserByUsernameAndPassword(String username, String password, Boolean isBackend) {

		if (StringUtils.isNotBlank(username) && StringUtils.isNotBlank(password)) {

			StringBuilder whereHql = new StringBuilder(" and o.username = ? and o.password = ? and o.state = ?");
			List<Object> paramsList = new ArrayList<>();
			paramsList.add(username);
			paramsList.add(password);
			paramsList.add(1);
			if (isBackend) {
				whereHql.append(" and o.type = ? ");
				paramsList.add(true);
			}

			List<User> users = userDao.findObjectsByConditionWithNoPage(whereHql.toString(), paramsList.toArray());
			if (null != users && users.size() > 0) {
				return users.get(0);
			}
		}
		return null;
	}

	@Override
	public User findUserByUserId(String userId) {
		if (StringUtils.isNotBlank(userId)) {
			return userDao.findObjectById(userId);
		}
		return null;
	}

	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
	public void updateUser(User user) {

		if (null != user)
			userDao.update(user);
	}

	@Override
	public Page findAllUserByPage(String pagenum) {
		Page page = new Page(StringUtils.isBlank(pagenum) ? 1 : Integer.parseInt(pagenum));
		String whereHql = " and o.type = ? and o.state = ?";
		Object[] params = { false, 1 };
		List<User> list = userDao.findCollectionByConditionWithPage(whereHql, params, null, page);
		page.setList(list);
		return page;
	}

	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteUserById(String accountId) {

		if (StringUtils.isNotBlank(accountId)) {
			User user = userDao.findObjectById(accountId);
			if (null != user) {
				userDao.update(user);
			}
		}
	}
}
