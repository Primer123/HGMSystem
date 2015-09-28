package dao.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import dao.WakeupDao;
import entity.Wakeup;

public class WakeupDaoImpl implements WakeupDao {

	private WakeupDaoImpl() {
	}
	
	@Override
	public void create(Wakeup wakeup) {
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.save(wakeup);
			tx.commit();
			session.close();
			sessionFactory.close();
			System.out.println("ok");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void modify(Wakeup wakeup) {
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			Wakeup wakeup_tmp = findById(wakeup.getId());
			wakeup_tmp.setRoomnum(wakeup.getRoomnum());
			wakeup_tmp.setDatetime(wakeup.getDatetime());
			session.update(wakeup_tmp);
			tx.commit();
			session.close();
			sessionFactory.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Wakeup wakeup) {
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			Wakeup wakeup_tmp = findById(wakeup.getId());
			session.delete(wakeup_tmp);
			tx.commit();
			session.close();
			sessionFactory.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	@Override
	public List<Wakeup> findByFuture() {
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session = sessionFactory.openSession();

			Date now = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			String datetime = dateFormat.format(now);
			
			String hql = "from entity.Wakeup as wakeup where"
					+ " wakeup.datetime >='" + datetime + "'";
			Query query = session.createQuery(hql);
			@SuppressWarnings("unchecked")
			List<Wakeup> list = query.list();

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
	public Wakeup findById(int id) {
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session = sessionFactory.openSession();

			String hql = "from entity.Wakeup as wakeup where"
					+ " wakeup.id ='" + id + "'";
			Query query = session.createQuery(hql);
			@SuppressWarnings("unchecked")
			List<Wakeup> list = query.list();

			if ((list.size()) == 0)
				return null;
			else
				return (Wakeup) list.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}
