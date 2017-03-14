package cn.edu.zzia.bookstore.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.zzia.bookstore.dao.IPrivilegeDao;
import cn.edu.zzia.bookstore.domain.Page;
import cn.edu.zzia.bookstore.domain.Privilege;
import cn.edu.zzia.bookstore.service.IPrivilegeService;
import cn.edu.zzia.bookstore.util.WebUtils;

@Service(IPrivilegeService.SERVICE_NAME)
@Transactional(readOnly = true)
public class PrivilegeServiceImpl implements IPrivilegeService {

	@Resource(name = IPrivilegeDao.SERVICE_NAME)
	private IPrivilegeDao privilegeDao = null;

	@Override
	public Page findPrivilegesByPage(String pagenum) {

		Page page = new Page(StringUtils.isBlank(pagenum) ? 1 : Integer.parseInt(pagenum));

		List<Privilege> list = privilegeDao.findCollectionByConditionWithPage(null, null, null, page);
		page.setList(list);
		return page;
	}

	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
	public void savePrivilege(Privilege privilege) {

		if (null != privilege) {
			privilege.setId(WebUtils.makeID());
			privilegeDao.save(privilege);
		}
	}

	@Override
	public List<Privilege> findAllPrivilege() {
		
		return privilegeDao.findObjectsByConditionWithNoPage();
	}
}
