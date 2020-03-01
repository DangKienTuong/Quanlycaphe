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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import poly.entity.Category;

@Transactional
@Controller
@RequestMapping("/manage/")
public class CategoryController {
	@Autowired
	SessionFactory factory;

	@RequestMapping(value = "category", method = RequestMethod.GET)
	public String index(ModelMap model) {
		Session session = factory.getCurrentSession();
		String hql = "FROM Category";
		Query query = session.createQuery(hql);
		List<Category> list = query.list();
		model.addAttribute("categories", list);
		model.addAttribute("category", new Category());
		return "manage/category";
	}

	@RequestMapping("searchCat")
	public String search(ModelMap model, @RequestParam("search") String search) {
		Session session = factory.getCurrentSession();
		String hql = "FROM Category WHERE name LIKE '" + search + "%'";
		Query query = session.createQuery(hql);
		List<Category> list = query.list();
		model.addAttribute("categories", list);
		model.addAttribute("category", new Category());
		return "manage/category";
	}

	@RequestMapping(value = "insertCat", method = RequestMethod.POST)
	public String insert(ModelMap model, @ModelAttribute("category") Category category) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.save(category);
			t.commit();
			String hql = "FROM Category";
			Query query = session.createQuery(hql);
			List<Category> list = query.list();
			model.addAttribute("categories", list);
			model.addAttribute("messageI", "Thành công !");
		} catch (Exception e) {
			t.rollback();
			model.addAttribute("messageI", "Thất bại !");
		} finally {
			session.close();
		}
		return "manage/category";
	}

	@RequestMapping(value = "deleteCat", method = RequestMethod.POST)
	public String delete(ModelMap model, @ModelAttribute("category") Category category) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.delete(category);
			t.commit();
			category.setId(null);
			category.setName(null);
			String hql = "FROM Category";
			Query query = session.createQuery(hql);
			List<Category> list = query.list();
			model.addAttribute("categories", list);
		} catch (Exception e) {
			t.rollback();
		} finally {
			session.close();
		}
		return "manage/category";
	}

	@RequestMapping(value = "editCat", method = RequestMethod.POST)
	public String edit(ModelMap model, @ModelAttribute("category") Category category, @RequestParam("id") String id,
			@RequestParam("name") String name) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			category.setId(id);
			category.setName(name);
			session.update(category);
			t.commit();
			String hql = "FROM Category";
			Query query = session.createQuery(hql);
			List<Category> list = query.list();
			model.addAttribute("categories", list);
			model.addAttribute("messageE", "Thành công !");
		} catch (Exception e) {
			t.rollback();
			model.addAttribute("messageE", "Thất bại !");
		} finally {
			session.close();
		}
		return "manage/category";
	}
}
