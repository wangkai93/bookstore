package cn.edu.zzia.bookstore.web.client;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.edu.zzia.bookstore.domain.User;
import cn.edu.zzia.bookstore.exception.UserExistException;
import cn.edu.zzia.bookstore.service.IUserService;
import cn.edu.zzia.bookstore.util.WebUtils;
import cn.edu.zzia.bookstore.web.form.RegisterForm;

@Controller
@RequestMapping("/client/user")
public class UserController {

	@Resource(name = IUserService.SERVICE_NAME)
	private IUserService userService = null;

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
			return "client/updateuser";
		}
		if (!b) {
			// 要把错误信息带过去，就把form存在request域里面，以方便在jsp页面中取出错误消息
			request.setAttribute("form", form);
			return "client/updateuser";
		}
		// 2.如果校验失败，跳到表单页面，回显校验失败信息
		// 3.如果校验成功，则调用service处理注册请求
		User user = new User();
		WebUtils.copyBean(form, user);
		try {
			userService.updateUser(user);

			// 6.如果service处理成功，跳转到网站的全局消息显示页面，为用户显示注册成功信息
			request.setAttribute("message", "恭喜您，注册成功！！！3 秒后跳到主页！！<meta http-equiv='refresh' content='3;url="
					+ request.getContextPath() + "/index.jsp'>");
			return "message";
		} catch (Exception e) {
			// 5.如果service处理不成功，并且不成功的原因是其他原因的话，跳转到网站的全局消息显示页面，为用户显示友好错误信息
			e.printStackTrace();
			request.setAttribute("message", "服务器出现未知错误！！！！");
			return "/message";
		}
	}

	/**
	 * 显示修改用户信息的界面
	 * 
	 * @param userId
	 * @param request
	 * @return
	 */
	@RequestMapping("/edit/{userId}")
	public String edit(@PathVariable("userId") String userId, HttpServletRequest request) {

		try {
			User user = userService.findUserByUserId(userId);
			request.setAttribute("user", user);
			return "client/updateuser";
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "服务器出现未知错误！！！！");
			return "message";
		}
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
			return "lient/register";
		}
		if (!b) {
			// 要把错误信息带过去，就把form存在request域里面，以方便在jsp页面中取出错误消息
			request.setAttribute("form", form);
			return "client/register";
		}
		// 2.如果校验失败，跳到表单页面，回显校验失败信息
		// 3.如果校验成功，则调用service处理注册请求
		User user = new User();
		WebUtils.copyBean(form, user);
		user.setId(WebUtils.makeID());
		try {
			userService.saveUser(user);

			// 6.如果service处理成功，跳转到网站的全局消息显示页面，为用户显示注册成功信息
			request.setAttribute("message", "恭喜您，注册成功！！！3 秒后跳到主页！！<meta http-equiv='refresh' content='3;url="
					+ request.getContextPath() + "/index.jsp'>");
			return "message";
		} catch (UserExistException e) {
			// 4.如果service处理不成功，并且不成功的原因，是应为注册用户已存在的话，则跳回到注册页面，显示注册用户已存在的消息
			form.getErrors().put("username", "此用户已存在！！");
			request.setAttribute("form", form);
			// request.setAttribute("message", "此用户已存在！！！");
			return "client/register";
		} catch (Exception e) {
			// 5.如果service处理不成功，并且不成功的原因是其他原因的话，跳转到网站的全局消息显示页面，为用户显示友好错误信息
			e.printStackTrace();
			request.setAttribute("message", "服务器出现未知错误！！！！");
			return "message";
		}
	}

	/**
	 * 显示注册页面
	 * 
	 * @return
	 */
	@RequestMapping("/register")
	public String add() {
		return "client/register";
	}
}
