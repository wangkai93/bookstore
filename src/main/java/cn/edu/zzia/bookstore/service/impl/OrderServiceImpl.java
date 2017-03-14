package cn.edu.zzia.bookstore.service.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.zzia.bookstore.dao.IOrderDao;
import cn.edu.zzia.bookstore.dao.IOrderItemDao;
import cn.edu.zzia.bookstore.domain.Book;
import cn.edu.zzia.bookstore.domain.Cart;
import cn.edu.zzia.bookstore.domain.CartItem;
import cn.edu.zzia.bookstore.domain.Order;
import cn.edu.zzia.bookstore.domain.Orderitem;
import cn.edu.zzia.bookstore.domain.Page;
import cn.edu.zzia.bookstore.domain.User;
import cn.edu.zzia.bookstore.service.IOrderService;
import cn.edu.zzia.bookstore.util.WebUtils;

@Service(IOrderService.SERVICE_NAME)
@Transactional(readOnly = true)
public class OrderServiceImpl implements IOrderService {

	@Resource(name = IOrderDao.SERVICE_NAME)
	private IOrderDao orderDao = null;

	@Resource(name = IOrderItemDao.SERVICE_NAME)
	private IOrderItemDao orderItemDao = null;

	@Override
	public Order findOrderById(String orderId) {

		if (StringUtils.isNotBlank(orderId)) {

			Order order = orderDao.findObjectById(orderId);
			String whereHql = " and o.order.id = ? ";
			Object[] params = { orderId };
			List<Orderitem> items = orderItemDao.findObjectsByConditionWithNoPage(whereHql, params);
			order.setOrderitems(new HashSet<>(items));
			return order;
		}

		return null;
	}

	@Override
	public Page findOrdersByUserPage(User user, String pagenum) {
		if (null != user) {

			Page page = new Page(StringUtils.isBlank(pagenum) ? 1 : Integer.parseInt(pagenum));

			String userId = user.getId();
			if (StringUtils.isNotBlank(userId)) {

				String whereHql = " and o.user.id = ? and o.isDelete = ? ";
				Object[] params = { userId, false };
				List<Order> orders = orderDao.findCollectionByConditionWithPage(whereHql, params, null, page);

				page.setList(orders);
				return page;
			}

		}
		return null;
	}

	@Override
	public void createOrder(Cart cart, User user) {
		if (null == cart) {
			throw new RuntimeException("对不起，你没有购买！");
		}
		if (null == user) {
			throw new RuntimeException("对不起，请先登录！");
		}
		Order order = new Order();
		order.setId(WebUtils.makeID());
		order.setOrdertime(new Date());
		order.setPrice(cart.getPrice());
		order.setState(false);
		order.setUser(user);

		// 这里有多少个购物项，就有多少个订单项
		for (Map.Entry<String, CartItem> me : cart.getMap().entrySet()) {
			// 得到一个购物项，就生成一个订单项
			CartItem citem = me.getValue();
			Orderitem oitem = new Orderitem();

			oitem.setBook(citem.getBook());
			oitem.setId(WebUtils.makeID());
			oitem.setPrice(citem.getPrice());
			oitem.setQuantity(citem.getQuantity());
			oitem.setOrder(order);

			order.getOrderitems().add(oitem);
		}
		clearCart(cart);
		orderDao.save(order);

		for (Orderitem item : order.getOrderitems()) {
			orderItemDao.save(item);
		}

	}

	@Override
	public void clearCart(Cart cart) {
		cart.getMap().clear();
	}

	@Override
	public void buybook(Cart cart, Book book) {

		cart.add(book);
	}

	@Override
	public void deleteBook(String bookid, Cart cart) {

		cart.getMap().remove(bookid);

	}

	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteOrderById(String orderId) {

		if (StringUtils.isNotBlank(orderId)) {

			Order order = orderDao.findObjectById(orderId);
			order.setIsDelete(true);
			orderDao.update(order);
		}
	}

	@Override
	public Page findOrderByStatus(Boolean status, String pagenum) {

		if (null != status) {

			Page page = new Page(StringUtils.isBlank(pagenum) ? 1 : Integer.parseInt(pagenum));

			String whereHql = " and o.state = ? and o.isDelete = ?";

			Object[] params = { status,false };

			List<Order> orders = orderDao.findCollectionByConditionWithPage(whereHql, params, null, page);

			page.setList(orders);

			return page;
		}

		return null;
	}

	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
	public void updateOrderStatus(String orderId) {

		if (StringUtils.isNotBlank(orderId)) {

			Order order = orderDao.findObjectById(orderId);

			if (null != order) {
				order.setState(true);
				orderDao.update(order);
			}
		}
	}
}
