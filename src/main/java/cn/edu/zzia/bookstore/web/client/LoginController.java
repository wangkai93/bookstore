package cn.edu.zzia.bookstore.web.client;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.edu.zzia.bookstore.domain.User;
import cn.edu.zzia.bookstore.service.IUserService;

@Controller
@RequestMapping("/client/login")
public class LoginController {
	
	
	@Resource(name = IUserService.SERVICE_NAME)
	private IUserService userService = null;

	
	/**
	 * 登出系统
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/logout")
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "/client/head";
	}
	
	/**
	 * 使用用户名和密码登录到系统
	 * @param username
	 * @param password
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam("username") String username, @RequestParam("password") String password,
			HttpServletRequest request) {
		try{
			User user = userService.findUserByUsernameAndPassword(username, password,false);
			if(user == null){
				request.setAttribute("message", "用户名或密码错误！！！！！1 秒后跳到登陆界面，请重新登陆！<meta http-equiv='refresh' content='1;url="+request.getContextPath()+"/client/head.jsp'>");
				return "message";
			}
			request.getSession().setAttribute("user", user);
			return "client/head";
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("查找用户出错");
		}

	}

}
