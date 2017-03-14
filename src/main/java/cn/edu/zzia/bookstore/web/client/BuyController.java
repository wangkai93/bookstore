package cn.edu.zzia.bookstore.web.client;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.edu.zzia.bookstore.domain.Book;
import cn.edu.zzia.bookstore.domain.Cart;
import cn.edu.zzia.bookstore.service.IBookService;
import cn.edu.zzia.bookstore.service.IOrderService;

@Controller
@RequestMapping("client/buy")
public class BuyController {

	@Resource(name = IBookService.SERVICE_NAME)
	private IBookService bookService = null;

	@Resource(name = IOrderService.SERVICE_NAME)
	private IOrderService orderService =  null;

	/**
	 * 删除选中的书
	 * @param bookid
	 * @param request
	 * @return
	 */
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable("id")String bookid,HttpServletRequest request) {

		try {
			Cart cart = (Cart) request.getSession().getAttribute("cart");
			orderService.deleteBook(bookid, cart);

			return "client/listcart";
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("从购物车中删除失败。");
		}
	}

	/**
	 * 清空购物车
	 * @param request
	 * @return
	 */
	@RequestMapping("/clear")
	public String clear(HttpServletRequest request) {
		try{
			Cart cart = (Cart) request.getSession().getAttribute("cart");
			orderService.clearCart(cart);
			return "client/listcart";
			
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("清空购物车失败！");
		}
	}

	/**
	 * 展示购物车页面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/listcart")
	public String listcart(HttpServletRequest request) {
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		request.setAttribute("cart", cart);
		return "client/listcart";
	}

	/**
	 * 将选中的书加入购物车
	 * 
	 * @param bookId
	 * @param request
	 * @return
	 */
	@RequestMapping("/book/{bookId}")
	public String buy(@PathVariable("bookId") String bookId, HttpServletRequest request) {

		try {
			Book book = bookService.findBookById(bookId);

			Cart cart = (Cart) request.getSession().getAttribute("cart");
			if (cart == null) {
				cart = new Cart();
				request.getSession().setAttribute("cart", cart);
			}
			orderService.buybook(cart, book);
			return "/client/listcart";
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "加入购物车失败！！");
			return "/message";
		}

	}

}
