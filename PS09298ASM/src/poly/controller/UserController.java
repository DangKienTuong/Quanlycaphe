package poly.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import poly.entity.User;

@Transactional
@Controller
@RequestMapping("/manage/")
public class UserController {
	@Autowired
	SessionFactory factory;

	@RequestMapping(value = "user", method = RequestMethod.GET)
	public String index(ModelMap model) {
		Session session = factory.getCurrentSession();
		String hql = "FROM User";
		Query query = session.createQuery(hql);
		List<User> list = query.list();
		model.addAttribute("users", list);
		model.addAttribute("user", new User());
		return "manage/user";
	}

	@RequestMapping("search")
	public String search(ModelMap model, @RequestParam("search") String search) {
		Session session = factory.getCurrentSession();
		String hql = "FROM User WHERE username LIKE '" + search + "%'";
		Query query = session.createQuery(hql);
		List<User> list = query.list();
		model.addAttribute("users", list);
		model.addAttribute("user", new User());
		return "manage/user";
	}

	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insert(ModelMap model, @Validated @ModelAttribute("user") User user, BindingResult errors) {
		if (errors.hasErrors()) {
			model.addAttribute("message", "Vui lòng sửa các lỗi sau đây !");
		} else {
			Session session = factory.openSession();
			Transaction t = session.beginTransaction();
			try {
				session.save(user);
				t.commit();
				String hql = "FROM User";
				Query query = session.createQuery(hql);
				List<User> list = query.list();
				model.addAttribute("users", list);
				model.addAttribute("messageI", "Thành công !");
			} catch (Exception e) {
				t.rollback();
				model.addAttribute("messageI", "Thất bại !");
			} finally {
				session.close();
			}
		}
		return "manage/user";
	}

	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public String delete(ModelMap model, @ModelAttribute("user") User user) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.delete(user);
			t.commit();
			user.setUsername(null);
			user.setFullname(null);
			user.setPassword(null);
			String hql = "FROM User";
			Query query = session.createQuery(hql);
			List<User> list = query.list();
			model.addAttribute("users", list);
			model.addAttribute("messageD", "Thành công !");
		} catch (Exception e) {
			t.rollback();
			model.addAttribute("messageD", "Thất bại !");
		} finally {
			session.close();
		}
		return "manage/user";
	}

	@RequestMapping(value = "edit", method = RequestMethod.POST)
	public String edit(ModelMap model, @ModelAttribute("user") User user, @RequestParam("username") String username,
			@RequestParam("password") String password, @RequestParam("fullname") String fullname) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			user.setUsername(username);
			user.setPassword(password);
			user.setFullname(fullname);
			session.update(user);
			t.commit();
			String hql = "FROM User";
			Query query = session.createQuery(hql);
			List<User> list = query.list();
			model.addAttribute("users", list);
			model.addAttribute("messageE", "Thành công !");
		} catch (Exception e) {
			t.rollback();
			model.addAttribute("messageE", "Thất bại !");
		} finally {
			session.close();
		}
		return "manage/user";
	}
}
