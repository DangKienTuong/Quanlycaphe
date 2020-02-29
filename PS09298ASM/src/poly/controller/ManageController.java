package poly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manage/")
public class ManageController {
	@RequestMapping("product")
	public String product() {
		return "manage/product";
	}

	@RequestMapping("category")
	public String category() {
		return "manage/category";
	}

	@RequestMapping("revenue")
	public String revenue() {
		return "manage/revenue";
	}

	@RequestMapping("sale")
	public String sale() {
		return "manage/sale";
	}

	@RequestMapping("top")
	public String top() {
		return "manage/top";
	}

	@RequestMapping("user")
	public String user() {
		return "manage/user";
	}
}
