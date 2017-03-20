package cn.edu.zzia.bookstore.web.manager;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.edu.zzia.bookstore.domain.User;
import cn.edu.zzia.bookstore.service.IUserService;

@Controller("backendLogin")
@RequestMapping("/backend")
public class LoginController {

	@Resource(name = IUserService.SERVICE_NAME)
	private IUserService userService = null;
	
	
	@RequestMapping(value = "/logout")
	public void logout(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		HttpSession session = request.getSession(false);
		if(null == session){
			response.sendRedirect(request.getContextPath() + "/backend");
		}
		User user = (User) session.getAttribute("manager");
		if(null == user){
			response.sendRedirect(request.getContextPath() + "/backend");
		}
		
		session.removeAttribute("manager");
		session.invalidate();
		response.sendRedirect(request.getContextPath() + "/backend");
	}

	/**
	 * 展示后台登陆页面
	 * 
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String login() {

		return "manager/login";
	}

	/**
	 * 登陆到后台管理平台
	 * 
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String login(@RequestParam("username") String username, @RequestParam("password") String password,
			@RequestParam("checkcode") String checkCode, HttpServletRequest request) {

		HttpSession session = request.getSession();
		String code = (String) session.getAttribute("CHECK_NUMBER_KEY");
		if (!checkCode.equals(code)) {
			request.setAttribute("codeError", "验证码输入错误");
			return "manager/login";
		}

		User user = userService.findUserByUsernameAndPassword(username, password, true);
		if (null == user) {
			request.setAttribute("loginError", "用户名或者密码错误");
			return "manager/login";
		}

		session.setAttribute("manager", user);

		return "manager/manager";
	}
	
}
