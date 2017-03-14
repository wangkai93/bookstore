package cn.edu.zzia.bookstore.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;

import cn.edu.zzia.bookstore.domain.User;

public class BackendFilter implements Filter {

	String filterPath = "";
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		String path = request.getServletPath();

		// 对 /image.jsp /index.jsp /login.jsp /sys/sysUserAction_isLogin路径过滤器要放行
		if (StringUtils.isNotBlank(filterPath) && path.contains(filterPath)) {
			
			// 获取当前的登陆用户
			HttpSession session = request.getSession(false);
			if(null == session){
				response.sendRedirect(request.getContextPath()+"/backend");
				return;
			}
			User sysUser = (User) session.getAttribute("manager");
			
			// 如果用户!=null 表示用户已经登陆
			if (sysUser != null) {
				// 放行
				chain.doFilter(request, response);
			} else { // 如果用户==null 表示用户没有登陆
				// 重定向到login.jsp(index.jsp)
				response.sendRedirect(request.getContextPath()+"/backend");
			}
			return;
		}
		chain.doFilter(request, response);

	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		// 自己处理放置在资源文件,利用流读入
		filterPath = "/manager";
	}

	@Override
	public void destroy() {

	}
}
