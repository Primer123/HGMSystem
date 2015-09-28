package dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import dao.StaffDao;
import entity.Staff;

public class StaffDaoImpl implements StaffDao {

	private StaffDaoImpl() {
	}
	
	@Override
	public void create(Staff staff) {
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			session.save(staff);
			tx.commit();
			session.close();
			sessionFactory.close();
			System.out.println("ok");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void modify(Staff staff) {
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			Staff staff_tmp = findById(staff.getId());
			staff_tmp.setPassword(staff.getPassword());
			staff_tmp.setPosition(staff.getPosition());
			staff_tmp.setRemarks(staff.getRemarks());
			staff_tmp.setStaffname(staff.getStaffname());
			session.update(staff_tmp);
			tx.commit();
			session.close();
			sessionFactory.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Staff staff) {
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			Staff staff_tmp = findById(staff.getId());
			session.delete(staff_tmp);
			tx.commit();
			session.close();
			sessionFactory.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void delete(List<Staff> staffs) {
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			int size = staffs.size();
			if(size > 0) {
				for(int i = 0; i < size; i++) {
					Staff staff_tmp = findById(staffs.get(i).getId());
					session.delete(staff_tmp);
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
	public Staff findById(int id) {
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session=sessionFactory.openSession();

			String hql = "from entity.Staff as staff where staff.id ='" + id + "'";
			Query query = session.createQuery(hql);
			@SuppressWarnings("unchecked")
			List<Staff> list = query.list();

			if ((list.size()) == 0)
				return null;
			else
				return (Staff) list.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Staff findByStaffId(String staffId) {
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session=sessionFactory.openSession();

			String hql = "from entity.Staff as staff where staff.staffid ='" + staffId + "'";
			Query query = session.createQuery(hql);
			@SuppressWarnings("unchecked")
			List<Staff> list = query.list();

			if ((list.size()) == 0)
				return null;
			else
				return (Staff) list.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<Staff> findByPosition(String position) {
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session=sessionFactory.openSession();

			String hql = "from entity.Staff as staff where staff.position ='" + position + "'";
			Query query = session.createQuery(hql);
			@SuppressWarnings("unchecked")
			List<Staff> list = query.list();

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
	public List<Staff> findByName(String staffName) {
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session=sessionFactory.openSession();

			String hql = "from entity.Staff as staff where staff.staffname ='" + staffName + "'";
			Query query = session.createQuery(hql);
			@SuppressWarnings("unchecked")
			List<Staff> list = query.list();

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
	public List<Staff> findAll() {
		try {
			System.out.println("1");
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session=sessionFactory.openSession();

			System.out.println("2");
			String hql = "from entity.Staff as staff";
			Query query = session.createQuery(hql);
			System.out.println("3");
			@SuppressWarnings("unchecked")
			List<Staff> list = query.list();

			System.out.println("4");
			System.out.println(list.size());
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
