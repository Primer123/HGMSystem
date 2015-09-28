package dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import dao.CommodityDiscDao;
import entity.CommodityDisc;

public class CommodityDiscDaoImpl implements CommodityDiscDao {
	
	private CommodityDiscDaoImpl() {
		// TODO Auto-generated constructor stub
		
	}

	@Override
	public void create(CommodityDisc commodityDisc) {
		// TODO Auto-generated method stub
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.save(commodityDisc);
			tx.commit();
			session.close();
			sessionFactory.close();
			System.out.println("ok");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void modify(CommodityDisc commodityDisc) {
		// TODO Auto-generated method stub
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			CommodityDisc commodityDisc_tmp = findById(commodityDisc.getId());
			commodityDisc_tmp.setStatus(commodityDisc.getStatus());
			commodityDisc_tmp.setDiscount(commodityDisc.getDiscount());
			session.update(commodityDisc_tmp);
			tx.commit();
			session.close();
			sessionFactory.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(CommodityDisc commodityDisc) {
		// TODO Auto-generated method stub
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			CommodityDisc commodityDisc_tmp = findById(commodityDisc.getId());
			session.delete(commodityDisc_tmp);
			tx.commit();
			session.close();
			sessionFactory.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public CommodityDisc findByStatus(String status) {
		// TODO Auto-generated method stub
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session = sessionFactory.openSession();

			String hql = "from entity.CommodityDisc as commodityDisc where"
					+ " commodityDisc.status ='" + status + "'";
			Query query = session.createQuery(hql);
			@SuppressWarnings("unchecked")
			List<CommodityDisc> list = query.list();

			if ((list.size()) == 0)
				return null;
			else
				return (CommodityDisc) list.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public CommodityDisc findById(int id) {
		// TODO Auto-generated method stub
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session = sessionFactory.openSession();

			String hql = "from entity.CommodityDisc as commodityDisc where"
					+ " commodityDisc.id ='" + id + "'";
			Query query = session.createQuery(hql);
			@SuppressWarnings("unchecked")
			List<CommodityDisc> list = query.list();

			if ((list.size()) == 0)
				return null;
			else
				return (CommodityDisc) list.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<CommodityDisc> findAll() {
		// TODO Auto-generated method stub
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session = sessionFactory.openSession();

			String hql = "from entity.CommodityDisc as commodityDisc";
			Query query = session.createQuery(hql);
			@SuppressWarnings("unchecked")
			List<CommodityDisc> list = query.list();

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
