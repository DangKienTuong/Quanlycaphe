package poly.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Transactional
@Controller
@RequestMapping("/manage/")
public class RevenueController {
	@Autowired
	SessionFactory factory;

	@RequestMapping(value = "revenue", method = RequestMethod.GET)
	public String index(ModelMap model) {
		Session session = factory.getCurrentSession();
		String hql = "SELECT p.name, s.date, sum(p.price) FROM Sale s INNER JOIN s.product p group by p.name,s.date order by sum(p.price) desc";
		Query query = session.createQuery(hql);
		List<Object[]> list = query.list();
		model.addAttribute("arrays", list);
		return "manage/revenue";
	}

}
