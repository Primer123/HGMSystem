package dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import dao.GuestDao;
import entity.Guest;

public class GuestDaoImpl implements GuestDao{
	public GuestDaoImpl(){
		
	}

	@Override
	public void create(Guest guest) {
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			session.save(guest);
			tx.commit();
			session.close();
			sessionFactory.close();
			System.out.println("ok");
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

	@Override
	public void modify(Guest guest) {
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			
			Guest guest_tmp = findById(guest.getId());
			guest_tmp.setCheckinnum(guest.getCheckinnum());
			guest_tmp.setRoomnum(guest.getRoomnum());
			guest_tmp.setName(guest.getName());
			guest_tmp.setIdtype(guest.getIdtype());
			guest_tmp.setIdnum(guest.getIdnum());
			guest_tmp.setTelnum(guest.getTelnum());
			guest_tmp.setAddress(guest.getAddress());
			
			session.update(guest_tmp);
			tx.commit();
			session.close();
			sessionFactory.close();			
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

	@Override
	public void delete(Guest guest) {
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			Guest guest_tmp = findById(guest.getId());
			session.delete(guest_tmp);
			tx.commit();
			session.close();
			sessionFactory.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(List<Guest> guestlist) {
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			Guest guest_tmp = null;
			for(int i=0;i<guestlist.size();i++){
				guest_tmp=findById(guestlist.get(i).getId());
				session.delete(guest_tmp);
			}			
			tx.commit();
			session.close();
			sessionFactory.close();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

	@Override
	public Guest findById(int id) {
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session=sessionFactory.openSession();

			String hql = "from entity.Guest as guest where guest.id = " + id;
			Query query = session.createQuery(hql);
			@SuppressWarnings("unchecked")
			List<Guest> list = query.list();

			if ((list.size()) == 0)
				return null;
			else
				return (Guest) list.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Guest> findByCRNum(String checkinnum, String roomnum) {
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session=sessionFactory.openSession();

			String hql = "from entity.Guest as guest where guest.checkinnum = '" 
			             + checkinnum + "' and guest.roomnum = '"+ roomnum+"'";
			Query query = session.createQuery(hql);
			@SuppressWarnings("unchecked")
			List<Guest> list = query.list();

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
	public List<Guest> findByCheckinnum(String checkinnum) {
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session=sessionFactory.openSession();

			String hql = "from entity.Guest as guest where guest.checkinnum = '"+ checkinnum +"'";
			Query query = session.createQuery(hql);
			@SuppressWarnings("unchecked")
			List<Guest> list = query.list();

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
	public List<Guest> findByName(String name) {
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session=sessionFactory.openSession();

			String hql = "from entity.Guest as guest where guest.name = '"+ name +"'";
			Query query = session.createQuery(hql);
			@SuppressWarnings("unchecked")
			List<Guest> list = query.list();

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
