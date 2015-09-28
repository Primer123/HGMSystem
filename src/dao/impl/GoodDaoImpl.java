package dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import dao.GoodDao;
import entity.Good;

public class GoodDaoImpl implements GoodDao {

	private GoodDaoImpl() {
	}

	@Override
	public void create(Good good) {
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.save(good);
			tx.commit();
			session.close();
			sessionFactory.close();
			System.out.println("ok");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void modify(Good good) {
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			Good good_tmp = findById(good.getId());
			good_tmp.setGoodcode(good.getGoodcode());
			good_tmp.setGoodname(good.getGoodname());
			good_tmp.setTypecode(good.getTypecode());
			good_tmp.setUnitprice(good.getUnitprice());
			good_tmp.setUnitSymbol(good.getUnitSymbol());
			good_tmp.setRemarks(good.getRemarks());

			session.update(good_tmp);
			tx.commit();
			session.close();
			sessionFactory.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Good good) {
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			Good good_tmp = findById(good.getId());

			session.delete(good_tmp);
			tx.commit();
			session.close();
			sessionFactory.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void modify(List<Good> goods) {
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			int size = goods.size();
			if (size > 0) {
				for (int i = 0; i < size; i++) {
					Good good_tmp = findById(goods.get(i).getId());
					good_tmp.setGoodcode(goods.get(i).getGoodcode());
					good_tmp.setGoodname(goods.get(i).getGoodname());
					good_tmp.setTypecode(goods.get(i).getTypecode());
					good_tmp.setUnitprice(goods.get(i).getUnitprice());
					good_tmp.setUnitSymbol(goods.get(i).getUnitSymbol());
					good_tmp.setRemarks(goods.get(i).getRemarks());
					session.update(good_tmp);
				}
			}

			tx.commit();
			session.close();
			sessionFactory.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(List<Good> goods) {
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			int size = goods.size();
			if (size > 0) {
				for (int i = 0; i < size; i++) {
					Good good_tmp = findById(goods.get(i).getId());
					session.delete(good_tmp);
				}
			}

			tx.commit();
			session.close();
			sessionFactory.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Good findById(int id) {
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session = sessionFactory.openSession();

			String hql = "from entity.Good as goods where goods.id ='" + id
					+ "'";
			Query query = session.createQuery(hql);
			@SuppressWarnings("unchecked")
			List<Good> list = query.list();

			if ((list.size()) == 0)
				return null;
			else
				return (Good) list.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Good findByGoodCode(String goodcode) {
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session = sessionFactory.openSession();

			String hql = "from entity.Good as goods where goods.goodcode ='"
					+ goodcode + "'";
			Query query = session.createQuery(hql);
			@SuppressWarnings("unchecked")
			List<Good> list = query.list();

			if ((list.size()) == 0)
				return null;
			else
				return (Good) list.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Good findByGoodName(String goodname) {
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session = sessionFactory.openSession();

			String hql = "from entity.Good as goods where goods.goodname ='"
					+ goodname + "'";
			Query query = session.createQuery(hql);
			@SuppressWarnings("unchecked")
			List<Good> list = query.list();

			if ((list.size()) == 0)
				return null;
			else
				return (Good) list.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<Good> findByTypecode(String typecode) {
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session = sessionFactory.openSession();

			String hql = "from entity.Good as goods where goods.typecode ='"
					+ typecode + "'";
			Query query = session.createQuery(hql);
			@SuppressWarnings("unchecked")
			List<Good> list = query.list();

			if ((list.size()) == 0)
				return null;
			else
				return list;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<Good> findByUnitPrice(double unitprice1, double unitprice2) {
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session = sessionFactory.openSession();

			String hql = "from entity.Good as goods where goods.unitprice >= '"
					+ unitprice1 + "' and goods.unitprice <= '" + unitprice2
					+ "'";
			Query query = session.createQuery(hql);
			@SuppressWarnings("unchecked")
			List<Good> list = query.list();

			if ((list.size()) == 0)
				return null;
			else
				return list;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<Good> findAll() {
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session = sessionFactory.openSession();

			String hql = "from entity.Good as goods";
			Query query = session.createQuery(hql);
			@SuppressWarnings("unchecked")
			List<Good> list = query.list();

			if ((list.size()) == 0)
				return null;
			else
				return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
}
