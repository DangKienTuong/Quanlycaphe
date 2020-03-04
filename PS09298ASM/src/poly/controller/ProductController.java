package poly.controller;

import java.io.File;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import poly.entity.Category;
import poly.entity.Product;

@Transactional
@Controller
@RequestMapping("/manage/")
public class ProductController {
	@Autowired
	SessionFactory factory;

	@RequestMapping(value = "product", method = RequestMethod.GET)
	public String index(ModelMap model) {
		Session session = factory.getCurrentSession();
		String hql = "FROM Product";
		Query query = session.createQuery(hql);
		List<Product> list = query.list();
		model.addAttribute("products", list);
		model.addAttribute("product", new Product());
		return "manage/product";
	}

	@RequestMapping("searchPro")
	public String search(ModelMap model, @RequestParam("search") String search) {
		Session session = factory.getCurrentSession();
		String hql = "FROM Product WHERE name LIKE '" + search + "%'";
		Query query = session.createQuery(hql);
		List<Product> list = query.list();
		model.addAttribute("products", list);
		model.addAttribute("product", new Product());
		return "manage/product";
	}

	ServletContext context;

	@RequestMapping(value = "insertPro", method = RequestMethod.POST)

	public String insert(ModelMap model, @RequestParam("photo") MultipartFile photo) {
		try {
			String photoPath = context.getRealPath("/files/" + photo.getOriginalFilename());
			photo.transferTo(new File(photoPath));
			model.addAttribute("photo_name", photo.getOriginalFilename());
			return "apply";
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "manage/product";
	}

	@RequestMapping(value = "deletePro", method = RequestMethod.POST)
	public String delete(ModelMap model, @ModelAttribute("product") Product product) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.delete(product);
			t.commit();
			String hql = "FROM Product";
			Query query = session.createQuery(hql);
			List<Product> list = query.list();
			model.addAttribute("products", list);
		} catch (Exception e) {
			t.rollback();
		} finally {
			session.close();
		}
		return "manage/product";
	}

	@RequestMapping(value = "editPro", method = RequestMethod.POST)
	public String edit(ModelMap model, @ModelAttribute("product") Product product) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.update(product);
			t.commit();
			model.addAttribute("message", "Thêm mới thành công !");
		} catch (Exception e) {
			t.rollback();
			model.addAttribute("message", "Thêm mới thất bại !");
		} finally {
			session.close();
		}
		return "manage/product";
	}

	public Category findCat(int ide) {
		Session session = factory.getCurrentSession();
		String hql = "FROM Category WHERE id LIKE '" + ide + "%'";
		Query query = session.createQuery(hql);
		Category list = (Category) query.uniqueResult();
		return list;
	}

	@ModelAttribute("categories")
	public List<Category> getCategory() {
		Session session = factory.getCurrentSession();
		String hql = "FROM Category";
		Query query = session.createQuery(hql);
		List<Category> list = query.list();
		return list;
	}

}
