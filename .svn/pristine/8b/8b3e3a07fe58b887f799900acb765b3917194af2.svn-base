package dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import dao.GoodTypeDao;
import entity.GoodType;

public class GoodTypeDaoImpl implements GoodTypeDao {
	
	private GoodTypeDaoImpl() {
	}

	@Override
	public void create(GoodType goodType) {
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			session.save(goodType);
			tx.commit();
			session.close();
			sessionFactory.close();
			System.out.println("ok");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void modify(GoodType goodType) {
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			GoodType goodType_tmp = findById(goodType.getId());
			goodType_tmp.setTypecode(goodType.getTypecode());
			goodType_tmp.setTypename(goodType.getTypename());
			goodType_tmp.setRemarks(goodType.getRemarks());
			
			session.update(goodType_tmp);
			tx.commit();
			session.close();
			sessionFactory.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(GoodType goodType) {
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			GoodType goodType_tmp = findById(goodType.getId());
			
			session.delete(goodType_tmp);
			tx.commit();
			session.close();
			sessionFactory.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(List<GoodType> goodTypes) {
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			int size = goodTypes.size();
			if(size > 0) {
				for(int i = 0; i < size; i++) {
					GoodType goodType_tmp = findById(goodTypes.get(i).getId());
					session.delete(goodType_tmp);
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
	public GoodType findById(int id) {
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session=sessionFactory.openSession();

			String hql = "from entity.GoodType as goodtypes where goodtypes.id ='" + id + "'";
			Query query = session.createQuery(hql);
			@SuppressWarnings("unchecked")
			List<GoodType> list = query.list();

			if ((list.size()) == 0)
				return null;
			else
				return (GoodType) list.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public GoodType findByTypecode(String typecode) {
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session=sessionFactory.openSession();

			String hql = "from entity.GoodType as goodtypes where"
					+ " goodtypes.typecode ='" + typecode + "'";
			Query query = session.createQuery(hql);
			@SuppressWarnings("unchecked")
			List<GoodType> list = query.list();

			if ((list.size()) == 0)
				return null;
			else
				return (GoodType) list.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public GoodType findByTypename(String typename) {
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session=sessionFactory.openSession();

			String hql = "from entity.GoodType as goodtypes where"
					+ " goodtypes.typename ='" + typename + "'";
			Query query = session.createQuery(hql);
			@SuppressWarnings("unchecked")
			List<GoodType> list = query.list();

			if ((list.size()) == 0)
				return null;
			else
				return (GoodType) list.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<GoodType> findAll() {
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session=sessionFactory.openSession();

			String hql = "from entity.GoodType as goodtypes";
			Query query = session.createQuery(hql);
			@SuppressWarnings("unchecked")
			List<GoodType> list = query.list();

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
