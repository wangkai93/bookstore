package cn.edu.zzia.bookstore.web.manager;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.edu.zzia.bookstore.domain.Page;
import cn.edu.zzia.bookstore.domain.User;
import cn.edu.zzia.bookstore.exception.UserExistException;
import cn.edu.zzia.bookstore.service.IUserService;
import cn.edu.zzia.bookstore.util.WebUtils;
import cn.edu.zzia.bookstore.web.form.RegisterForm;

@Controller
@RequestMapping("manager/account")
public class AccountController {

	@Resource(name = IUserService.SERVICE_NAME)
	private IUserService userService = null;

	/**
	 * 显示添加用户页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add() {
		return "manager/addaccount";
	}

	/**
	 * 校验并保存用户
	 * 
	 * @param form
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(RegisterForm form, HttpServletRequest request) {
		boolean b = form.validate();// 对数据进行校验
		String input = request.getParameter("checkcode");
		HttpSession session = request.getSession();
		String code = (String) session.getAttribute("CHECK_NUMBER_KEY");
		if (!input.equals(code)) {
			form.getErrors().put("checkcode", "验证码不正确！！！");
			request.setAttribute("form", form);
			return "manager/addaccount";
		}
		if (!b) {
			// 要把错误信息带过去，就把form存在request域里面，以方便在jsp页面中取出错误消息
			request.setAttribute("form", form);
			return "manager/addaccount";
		}
		// 2.如果校验失败，跳到表单页面，回显校验失败信息
		// 3.如果校验成功，则调用service处理注册请求
		User user = new User();
		WebUtils.copyBean(form, user);
		user.setId(WebUtils.makeID());
		try {
			userService.saveUser(user);

			return "redirect:/manager/account/list";
		} catch (UserExistException e) {
			// 4.如果service处理不成功，并且不成功的原因，是应为注册用户已存在的话，则跳回到注册页面，显示注册用户已存在的消息
			form.getErrors().put("username", "此用户已存在！！");
			request.setAttribute("form", form);
			// request.setAttribute("message", "此用户已存在！！！");
			return "manager/addaccount";
		} catch (Exception e) {
			// 5.如果service处理不成功，并且不成功的原因是其他原因的话，跳转到网站的全局消息显示页面，为用户显示友好错误信息
			e.printStackTrace();
			request.setAttribute("message", "服务器出现未知错误！！！！");
			return "message";
		}
	}

	/**
	 * 显示编辑用户的页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable("id") String accountId, HttpServletRequest request) {

		User account = userService.findUserByUserId(accountId);
		request.setAttribute("user", account);
		return "manager/editaccount";
	}

	/**
	 * 校验并更新用户
	 * 
	 * @param form
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(RegisterForm form, HttpServletRequest request) {

		boolean b = form.validate();// 对数据进行校验
		String input = request.getParameter("checkcode");
		HttpSession session = request.getSession();
		String code = (String) session.getAttribute("CHECK_NUMBER_KEY");
		if (!input.equals(code)) {
			form.getErrors().put("checkcode", "验证码不正确！！！");
			request.setAttribute("form", form);
			return "manager/editaccount";
		}
		if (!b) {
			// 要把错误信息带过去，就把form存在request域里面，以方便在jsp页面中取出错误消息
			request.setAttribute("form", form);
			return "manager/editaccount";
		}
		// 2.如果校验失败，跳到表单页面，回显校验失败信息
		// 3.如果校验成功，则调用service处理注册请求
		User user = new User();
		WebUtils.copyBean(form, user);
		try {
			userService.updateUser(user);
			return "redirect:/manager/account/list";
		} catch (Exception e) {
			// 5.如果service处理不成功，并且不成功的原因是其他原因的话，跳转到网站的全局消息显示页面，为用户显示友好错误信息
			e.printStackTrace();
			request.setAttribute("message", "服务器出现未知错误！！！！");
			return "/message";
		}
	}

	/**
	 * 显示用户列表
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(@RequestParam(value = "pagenum",required = false)String pagenum,HttpServletRequest request) {

		Page page = userService.findAllUserByPage(pagenum);
		request.setAttribute("page", page);
		return "manager/listaccount";
	}

	/**
	 * 删除用户信息
	 * @param accountId
	 * @return
	 */
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") String accountId) {
		userService.deleteUserById(accountId);
		return "redirect:/manager/account/list";
	}
}
