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

import poly.entity.Product;

@Transactional
@Controller
@RequestMapping("/manage/")
public class TopController {
	@Autowired
	SessionFactory factory;

	@RequestMapping(value = "top", method = RequestMethod.GET)
	public String index(ModelMap model) {
		Session session = factory.getCurrentSession();
		String hql = "SELECT p.name, sum(1) FROM Sale s INNER JOIN s.product p group by p.name order by sum(1) desc";
		Query query = session.createQuery(hql).setMaxResults(5);
		List<Object[]> list = query.list();
		model.addAttribute("arrays", list);
		return "manage/top";
	}
}
