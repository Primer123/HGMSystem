package dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import dao.FloorDao;
import entity.Floor;

public class FloorDaoImpl implements FloorDao {
	
	private FloorDaoImpl() {
	}

	@Override
	public void create(Floor floor) {
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			session.save(floor);
			tx.commit();
			session.close();
			sessionFactory.close();
			System.out.println("ok");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void modify(Floor floor) {
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			Floor floor_tmp = findById(floor.getId());
			floor_tmp.setFloorname(floor.getFloorname());
			floor_tmp.setRemarks(floor.getRemarks());
			
			session.update(floor_tmp);
			tx.commit();
			session.close();
			sessionFactory.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Floor floor) {
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			Floor floor_tmp = findById(floor.getId());
			session.delete(floor_tmp);
			tx.commit();
			session.close();
			sessionFactory.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(List<Floor> floors) {
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			int size = floors.size();
			if(size > 0) {
				for(int i = 0; i < size; i++) {
					Floor floor_tmp = findById(floors.get(i).getId());
					session.delete(floor_tmp);
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
	public Floor findById(int id) {
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session=sessionFactory.openSession();

			String hql = "from entity.Floor as floor where"
					+ " floor.id ='" + id + "'";
			Query query = session.createQuery(hql);
			@SuppressWarnings("unchecked")
			List<Floor> list = query.list();

			if ((list.size()) == 0)
				return null;
			else
				return (Floor) list.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Floor findByFloorname(String floorname) {
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session=sessionFactory.openSession();

			String hql = "from entity.Floor as floor where"
					+ " floor.floorname ='" + floorname + "'";
			Query query = session.createQuery(hql);
			@SuppressWarnings("unchecked")
			List<Floor> list = query.list();

			if ((list.size()) == 0)
				return null;
			else
				return (Floor) list.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<Floor> findAll() {
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session=sessionFactory.openSession();

			String hql = "from entity.Floor as floor";
			Query query = session.createQuery(hql);
			@SuppressWarnings("unchecked")
			List<Floor> list = query.list();

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
