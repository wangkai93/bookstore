package cn.edu.zzia.bookstore.service;

import java.util.List;

import cn.edu.zzia.bookstore.domain.Page;
import cn.edu.zzia.bookstore.domain.Privilege;

public interface IPrivilegeService {
	
	public static final String SERVICE_NAME = "cn.edu.zzia.bookstore.service.impl.PrivilegeServiceImpl";

	/**
	 * 分页查找权限信息
	 * @param pagenum
	 * @return
	 */
	Page findPrivilegesByPage(String pagenum);

	/**
	 * 保存权限信息
	 * @param privilege
	 */
	void savePrivilege(Privilege privilege);

	/**
	 * 查找所有的权限信息
	 * @return
	 */
	List<Privilege> findAllPrivilege();

}
