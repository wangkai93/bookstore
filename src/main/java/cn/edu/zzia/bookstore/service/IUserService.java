package cn.edu.zzia.bookstore.service;

import cn.edu.zzia.bookstore.domain.Page;
import cn.edu.zzia.bookstore.domain.User;
import cn.edu.zzia.bookstore.exception.UserExistException;

public interface IUserService {

	public static final String SERVICE_NAME = "cn.edu.zzia.bookstore.service.impl.UserServiceImpl";

	/**
	 * 保存用户到数据库,并在保存之前检查用户名是否存在
	 * @param user
	 * @throws UserExistException
	 */
	void saveUser(User user)throws UserExistException;

	/**
	 * 根据用户名和密码查找用户,区分用户
	 * @param username
	 * @param password
	 * @param isBackend
	 * @return
	 */
	User findUserByUsernameAndPassword(String username, String password,Boolean isBackend);

	/**
	 * 根据用户id查找用户信息
	 * @param userId
	 * @return
	 */
	User findUserByUserId(String userId);

	/**
	 * 更新用户信息
	 * @param user
	 */
	void updateUser(User user);

	/**
	 * 分页查找用户信息
	 * @param pagenum
	 * @return
	 */
	Page findAllUserByPage(String pagenum);

	/**
	 * 根据用户id删除用户
	 * @param accountId
	 */
	void deleteUserById(String accountId);
}
