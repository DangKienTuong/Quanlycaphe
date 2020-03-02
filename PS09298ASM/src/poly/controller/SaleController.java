package poly.controller;

import java.util.Date;
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

import poly.entity.Product;
import poly.entity.Sale;

@Transactional
@Controller
@RequestMapping("/manage/")
public class SaleController {
	@Autowired
	SessionFactory factory;

	@RequestMapping(value = "sale", method = RequestMethod.GET)
	public String index(ModelMap model) {
		Session session = factory.getCurrentSession();
		String hql = "FROM Sale";
		Query query = session.createQuery(hql);
		List<Sale> list = query.list();
		model.addAttribute("sales", list);
		model.addAttribute("sale", new Sale());
		return "manage/sale";
	}

	@RequestMapping("searchSale")
	public String search(ModelMap model, @RequestParam("search") String search) {
		Session session = factory.getCurrentSession();
		String hql = "FROM Sale WHERE id LIKE '" + search + "%'";
		Query query = session.createQuery(hql);
		List<Sale> list = query.list();
		model.addAttribute("sales", list);
		model.addAttribute("sale", new Sale());
		return "manage/sale";
	}

	@RequestMapping(value = "insertSale", method = RequestMethod.POST)
	public String insert(ModelMap model, @ModelAttribute("sale") Sale sale) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			sale.setDate(new Date());
			session.save(sale);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			model.addAttribute("messageI", "Thất bại !");
		} finally {
			session.close();
		}
		return "manage/sale";
	}

	@RequestMapping(value = "deleteSale", method = RequestMethod.POST)
	public String delete(ModelMap model, @ModelAttribute("sale") Sale sale) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.delete(sale);
			t.commit();
			sale.setDate(null);
			String hql = "FROM Sale";
			Query query = session.createQuery(hql);
			List<Sale> list = query.list();
			model.addAttribute("sales", list);
		} catch (Exception e) {
			t.rollback();
		} finally {
			session.close();
		}
		return "manage/sale";
	}

	@RequestMapping(value = "editSale", method = RequestMethod.POST)
	public String edit(ModelMap model, @ModelAttribute("sale") Sale sale) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			sale.setDate(new Date());
			session.update(sale);
			t.commit();
			model.addAttribute("message", "Thêm mới thành công !");
		} catch (Exception e) {
			t.rollback();
			model.addAttribute("message", "Thêm mới thất bại !");
		} finally {
			session.close();
		}
		return "manage/sale";
	}

	public Product findProduct(int ide) {
		Session session = factory.getCurrentSession();
		String hql = "FROM Product WHERE id LIKE '" + ide + "%'";
		Query query = session.createQuery(hql);
		Product list = (Product) query.uniqueResult();
		return list;
	}

	@ModelAttribute("products")
	public List<Product> getProduct() {
		Session session = factory.getCurrentSession();
		String hql = "FROM Product";
		Query query = session.createQuery(hql);
		List<Product> list = query.list();
		return list;
	}

}
