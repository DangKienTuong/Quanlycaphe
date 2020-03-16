package poly.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import poly.entity.User;

@Transactional
@Controller
public class LoginController {
	@Autowired
	SessionFactory factory;

	@RequestMapping("login")
	public String index(ModelMap model, @RequestParam("username") String username, @RequestParam("pass") String pass,
			HttpSession session1) {
		Session session = factory.getCurrentSession();
		String path = null;
		try {
			String hql = "FROM User where username = '" + username + "' and password ='" + pass + "'";
			Query query = session.createQuery(hql);
			List<User> list = query.list();
			if (list.isEmpty()) {
				path = "erorr";
			} else {
				session1.setAttribute("user", username);
				path = "manage/welcome";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return path;
	}

}
