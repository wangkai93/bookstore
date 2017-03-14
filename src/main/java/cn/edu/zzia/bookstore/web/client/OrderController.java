package cn.edu.zzia.bookstore.web.client;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.edu.zzia.bookstore.domain.Cart;
import cn.edu.zzia.bookstore.domain.Order;
import cn.edu.zzia.bookstore.domain.Page;
import cn.edu.zzia.bookstore.domain.User;
import cn.edu.zzia.bookstore.service.IOrderService;

@Controller
@RequestMapping("/client/order")
public class OrderController {
	
	@Resource(name = IOrderService.SERVICE_NAME)
	private IOrderService orderService = null;
	
	/**
	 * 删除一个订单
	 * @param orderId
	 * @return
	 */
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable("id")String orderId){
		
		orderService.deleteOrderById(orderId);
		return "redirect:/client/order/list";
	}
	/**
	 * 下订单
	 * @param request
	 * @return
	 */
	@RequestMapping("/confirm")
	public String confirm(HttpServletRequest request) {
		try{
			User user = (User) request.getSession().getAttribute("user");
			if(user == null){
				request.setAttribute("message", "对不起，请先登录！！");
				return "message";
			}
			Cart cart = (Cart) request.getSession().getAttribute("cart");
			orderService.createOrder(cart, user);
			request.setAttribute("message", "订单已生成，请准备好钱收货！！");
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "订单生成失败！！");
		}
		return "message";
	}
	
	/**
	 * 展示订单的详情页
	 * @param orderId
	 * @param request
	 * @return
	 */
	@RequestMapping("/detail/{orderId}")
	public String detail(@PathVariable("orderId")String orderId,HttpServletRequest request) {

		try{
			User user = (User) request.getSession().getAttribute("user");
			if(user == null){
				request.setAttribute("message", "对不起，起先登陆！！！");
				return "message";
			}
			Order order = orderService.findOrderById(orderId);
			order.setUser(user);
			System.out.println( "order  = " + order);
			request.setAttribute("order", order);
			return "client/userorderdetail";
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	
	/**
	 * 根据登录用户列出该用户所有的订单
	 * @param request
	 * @return
	 */
	@RequestMapping("/list")
	public String list(@RequestParam(value = "pagenum",required = false)String pagenum,HttpServletRequest request) {
		try{
			User user = (User) request.getSession().getAttribute("user");
			if(user == null){
				request.setAttribute("message", "对不起，起先登陆！！！");
				return "message";
			}
			Page page = orderService.findOrdersByUserPage(user,pagenum);
			request.setAttribute("page", page);
			return "client/listuserorder";
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("查找订单出错");
		}
	}
}
