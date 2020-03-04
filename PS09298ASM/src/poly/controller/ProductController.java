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
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import poly.entity.Category;
import poly.entity.Product;
import poly.entity.Sale;

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

	@RequestMapping(value = "insertPro", method = RequestMethod.POST)

	public String insert(ModelMap model, @ModelAttribute("product") Product product, @RequestParam("name") String name,
			@RequestParam("catid") int catid, @RequestParam("photo") String photo, @RequestParam("price") Double price,
			@RequestParam("describe") String describe) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			product.setName(name);
			product.setCategory(findCat(catid));
			product.setPhoto("files/" + photo);
			product.setPrice(price);
			product.setDescribe(describe);
			session.save(product);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			model.addAttribute("messageI", "Thất bại !");
		} finally {
			session.close();
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
	public String edit(ModelMap model, @ModelAttribute("product") Product product, @RequestParam("name") String name,
			@RequestParam("price") Double price, @RequestParam("describe") String describe) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			product.setName(name);
			product.setDescribe(describe);
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

	@Autowired
	ServletContext context;

	@RequestMapping("apply")
	public String apply(ModelMap model, @RequestParam("photo") MultipartFile photo) {
		if (photo.isEmpty()) {
			model.addAttribute("message", "Vui lòng chọn file !");
		} else {
			try {
				String photoPath = context.getRealPath("/files/" + photo.getOriginalFilename());
				photo.transferTo(new File(photoPath));
				model.addAttribute("photo_name", photo.getOriginalFilename());
				return "apply";
			} catch (Exception e) {
				model.addAttribute("message", "Lỗi lưu file !");
			}
		}
		return "manage/product";

	}

	public Category findCategory(int ide) {
		Session session = factory.getCurrentSession();
		String hql = "FROM Category WHERE id LIKE '" + ide + "%'";
		Query query = session.createQuery(hql);
		Category list = (Category) query.uniqueResult();
		return list;
	}
}
