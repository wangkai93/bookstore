package cn.edu.zzia.bookstore.web.client;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import cn.edu.zzia.bookstore.domain.Message;
import cn.edu.zzia.bookstore.domain.Page;
import cn.edu.zzia.bookstore.domain.User;
import cn.edu.zzia.bookstore.service.ICollectService;

@Controller
@RequestMapping("/client/collect")
public class CollectController {

	@Resource(name = ICollectService.SERVICE_NAME)
	private ICollectService collectService = null;

	/**
	 * 保存添加的分类信息
	 * 
	 * @param collect
	 * @return
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String save(@RequestParam("bookId") String bookId, HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		Message msg = null;
		if (null != session) {
			User user = (User) session.getAttribute("user");
			if (null != user) {
				collectService.saveCollect(user.getId(), bookId);
				msg = new Message(10004, "收藏成功");
				return JSON.toJSONString(msg);
			}
		}
		msg = new Message(10005, "请先登录");
		return JSON.toJSONString(msg);
	}

	/**
	 * 显示分类列表
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(@RequestParam(value="pagenum",required = false)String pagenum,HttpServletRequest request) {

		HttpSession session = request.getSession(false);
		if (null != session) {
			User user = (User) session.getAttribute("user");
			if (null != user) {
				Page page = collectService.findAllCollectByUserId(user.getId(),pagenum);
				request.setAttribute("page", page);
				return "client/listcollect";
			}
		}
		return null;
	}

	/**
	 * 删除分类信息
	 * 
	 * @param collectId
	 * @return
	 */
	@RequestMapping(value = "/delete", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String delete(@RequestParam("bookId") String bookId, HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		Message msg = null;
		if (null != session) {
			User user = (User) session.getAttribute("user");
			if (null != user) {
				collectService.deleteCollectByUserIdAndBookId(user.getId(),bookId);
				msg = new Message(10006, "取消收藏成功");
				return JSON.toJSONString(msg);
			}
		}
		msg = new Message(10007, "请先登录");
		return JSON.toJSONString(msg);
	}

}
