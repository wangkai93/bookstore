package cn.edu.zzia.bookstore.web.manager;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.edu.zzia.bookstore.domain.Publisher;
import cn.edu.zzia.bookstore.service.IPublisherService;

@Controller
@RequestMapping("manager/publisher")
public class PublisherController {

	@Resource(name = IPublisherService.SERVICE_NAME)
	private IPublisherService publisherService = null;
	

	/**
	 * 显示添加出版社页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add() {
		return "manager/addpublisher";
	}

	/**
	 * 保存添加的出版社信息
	 * 
	 * @param publisher
	 * @return
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Publisher publisher) {
		publisherService.addPublisher(publisher);
		return "redirect:/manager/publisher/list";
	}

	/**
	 * 显示编辑出版社的页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable("id") String publisherId, HttpServletRequest request) {

		Publisher publisher = publisherService.findPublisherById(publisherId);
		request.setAttribute("publisher", publisher);
		return "manager/editpublisher";
	}

	/**
	 * 更新编辑页面的出版社信息
	 * 
	 * @param publisher
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(Publisher publisher) {

		publisherService.updatePublisher(publisher);

		return "redirect:/manager/publisher/list";
	}

	/**
	 * 显示出版社列表
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(HttpServletRequest request) {

		List<Publisher> publishers = publisherService.findAllPublisher();
		request.setAttribute("publishers", publishers);
		return "manager/listpublisher";
	}

	/**
	 * 删除出版社信息
	 * @param publisherId
	 * @return
	 */
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") String publisherId) {
		publisherService.deletePublisherById(publisherId);
		return "redirect:/manager/publisher/list";
	}
}
