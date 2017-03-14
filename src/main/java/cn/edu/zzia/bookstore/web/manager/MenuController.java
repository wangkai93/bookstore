package cn.edu.zzia.bookstore.web.manager;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manager/menu")
public class MenuController {

	@RequestMapping("/top")
	public String top() {

		return "manager/head";
	}

	@RequestMapping("/left")
	public String left() {

		return "manager/left";
	}
	
	
	@RequestMapping("/main")
	public String main() {

		return "manager/body";
	}

}
