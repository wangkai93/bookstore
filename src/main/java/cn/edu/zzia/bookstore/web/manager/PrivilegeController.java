package cn.edu.zzia.bookstore.web.manager;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.edu.zzia.bookstore.domain.Page;
import cn.edu.zzia.bookstore.domain.Privilege;
import cn.edu.zzia.bookstore.service.IPrivilegeService;

@Controller
@RequestMapping("/manager/privilege")
public class PrivilegeController {

	@Resource(name = IPrivilegeService.SERVICE_NAME)
	private IPrivilegeService privilegeService = null;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add() {

		return "manager/addprivilege";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Privilege privilege) {

		privilegeService.savePrivilege(privilege);
		return "redirect:/manager/privilege/list";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit() {

		return "manager/editprivilege";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update() {

		return "redirect:/manager/privilege/list";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(@RequestParam(value = "pagenum", required = false) String pagenum, HttpServletRequest request) {

		Page page = privilegeService.findPrivilegesByPage(pagenum);
		request.setAttribute("page", page);
		return "manager/listprivilege";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete() {

		return "redirect:/manager/privilege/list";
	}

	@RequestMapping(value = "/grant", method = RequestMethod.GET)
	public String grant(HttpServletRequest request) {

		List<Privilege> privileges = privilegeService.findAllPrivilege();
		request.setAttribute("privileges", privileges);
		return "/manager/giveprivilege";
	}
}
