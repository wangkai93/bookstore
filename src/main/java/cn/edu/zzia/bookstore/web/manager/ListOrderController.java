package cn.edu.zzia.bookstore.web.manager;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.edu.zzia.bookstore.domain.Order;
import cn.edu.zzia.bookstore.domain.Page;
import cn.edu.zzia.bookstore.service.IOrderService;

@Controller
@RequestMapping("/manager/listorder")
public class ListOrderController {

	@Resource(name = IOrderService.SERVICE_NAME)
	private IOrderService orderService = null;

	/**
	 * 确认订单，发货
	 * 
	 * @param orderId
	 * @return
	 */
	@RequestMapping("/send/{id}")
	public String send(@PathVariable("id") String orderId) {

		orderService.updateOrderStatus(orderId);
		return "redirect:/manager/listorder/list?status=true";
	}

	/**
	 * 展示订单的详情页
	 * 
	 * @param orderId
	 * @param request
	 * @return
	 */
	@RequestMapping("/detail/{orderId}")
	public String detail(@PathVariable("orderId") String orderId, HttpServletRequest request) {

		try {
			Order order = orderService.findOrderById(orderId);
			request.setAttribute("order", order);
			return "manager/orderdetail";
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 删除一个订单
	 * 
	 * @param orderId
	 * @return
	 */
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable("id") String orderId, @RequestParam("status") Boolean status) {

		orderService.deleteOrderById(orderId);
		return "redirect:/manager/listorder/list?status=" + status;
	}

	/**
	 * 根据状态显示订单
	 * 
	 * @param status
	 * @param pagenum
	 * @param request
	 * @return
	 */
	@RequestMapping("/list")
	public String list(@RequestParam("status") Boolean status,
			@RequestParam(value = "pagenum", required = false) String pagenum, HttpServletRequest request) {

		Page page = orderService.findOrderByStatus(status, pagenum);

		request.setAttribute("page", page);
		return "manager/listorder";
	}

}
