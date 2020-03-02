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

	@RequestMapping("revenue")
	public String revenue() {
		return "manage/revenue";
	}

	@RequestMapping("top")
	public String top() {
		return "manage/top";
	}

}
