package cn.edu.zzia.bookstore.service;

import cn.edu.zzia.bookstore.domain.Book;
import cn.edu.zzia.bookstore.domain.Cart;
import cn.edu.zzia.bookstore.domain.Order;
import cn.edu.zzia.bookstore.domain.Page;
import cn.edu.zzia.bookstore.domain.User;

public interface IOrderService {

	public static final String SERVICE_NAME = "cn.edu.zzia.bookstore.service.impl.OrderServiceImpl";


	/**
	 * 根据订单id查找订单详情
	 * @param orderId
	 * @return
	 */
	Order findOrderById(String orderId);

	/**
	 * 根据用户id查找用户所有的订单，并分页
	 * @param user
	 * @param pagenum
	 * @return
	 */
	Page findOrdersByUserPage(User user, String pagenum);

	/**
	 * 根据当前用户和购物车，创建订单
	 * @param cart
	 * @param user
	 */
	void createOrder(Cart cart, User user);

	/**
	 * 清空购物车
	 * @param cart
	 */
	void clearCart(Cart cart);

	/**
	 * 将书籍加入到购物车中
	 * @param cart
	 * @param book
	 */
	void buybook(Cart cart, Book book);

	/**
	 * 根据书的id从购物车中删除一本书
	 * @param bookid
	 * @param cart
	 */
	void deleteBook(String bookid, Cart cart);

	/**
	 * 根据订单id删除订单
	 * @param orderId
	 */
	void deleteOrderById(String orderId);

	/**
	 * 根据订单的状态查找分页查找订单
	 * @param status
	 * @param pagenum
	 * @return
	 */
	Page findOrderByStatus(Boolean status,String pagenum);
	
	/**
	 * 把订单状态改为发货
	 * @param orderId
	 */
	void updateOrderStatus(String orderId);

}
