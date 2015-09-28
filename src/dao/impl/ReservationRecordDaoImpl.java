package dao.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import dao.ReservationRecordDao;
import entity.ReservationRecord;

public class ReservationRecordDaoImpl implements ReservationRecordDao {
	public ReservationRecordDaoImpl() {

	}

	@Override
	public void create(ReservationRecord reservation) {
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.save(reservation);
			tx.commit();
			session.close();
			sessionFactory.close();
			System.out.println("ok");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void modify(ReservationRecord reservation) {
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();

			ReservationRecord record = findById(reservation.getId());
			record.setRsrvnum(reservation.getRsrvnum());
			record.setRoomnum(reservation.getRoomnum());
			record.setName(reservation.getName());
			record.setIdtype(reservation.getIdtype());
			record.setIdnum(reservation.getIdnum());
			record.setTelnum(reservation.getTelnum());
			record.setArrivingdt(reservation.getArrivingdt());
			record.setDeparturedt(reservation.getDeparturedt());
			record.setStaffid(reservation.getStaffid());
			record.setMemberid(reservation.getMemberid());
			record.setRsrvstate(reservation.getRsrvstate());
			record.setRemarks(reservation.getRemarks());

			session.update(record);
			tx.commit();
			session.close();
			sessionFactory.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(ReservationRecord reservation) {
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			ReservationRecord record = findById(reservation.getId());
			session.delete(record);
			tx.commit();
			session.close();
			sessionFactory.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void delete(List<ReservationRecord> reservationlist) {
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			ReservationRecord rsrv_tmp = null;
			for (int i = 0; i < reservationlist.size(); i++) {
				rsrv_tmp = findById(reservationlist.get(i).getId());
				session.delete(rsrv_tmp);
			}
			tx.commit();
			session.close();
			sessionFactory.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public ReservationRecord findById(int id) {
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session = sessionFactory.openSession();

			String hql = "from entity.ReservationRecord as reservation where reservation.id ='"
					+ id + "'";
			Query query = session.createQuery(hql);
			@SuppressWarnings("unchecked")
			List<ReservationRecord> list = query.list();

			if ((list.size()) == 0)
				return null;
			else
				return (ReservationRecord) list.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ReservationRecord findByRRNum(String rsrvnum, String roomnum) {
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session = sessionFactory.openSession();

			String hql = "from entity.ReservationRecord as reservation where reservation.rsrvnum = '"
					+ rsrvnum + "' and reservation.roomnum = '" + roomnum + "'";
			Query query = session.createQuery(hql);
			@SuppressWarnings("unchecked")
			List<ReservationRecord> list = query.list();

			if ((list.size()) == 0)
				return null;
			else
				return (ReservationRecord) list.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<ReservationRecord> findByRsrvnum(String rsrvnum) {
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session = sessionFactory.openSession();

			String hql = "from entity.ReservationRecord as reservation where reservation.rsrvnum ='"
					+ rsrvnum + "'";
			Query query = session.createQuery(hql);
			@SuppressWarnings("unchecked")
			List<ReservationRecord> list = query.list();

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
	public List<ReservationRecord> findByRoomnum(String roomnum) {
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session = sessionFactory.openSession();

			String hql = "from entity.ReservationRecord as reservation where reservation.roomnum ='"
					+ roomnum + "'";
			Query query = session.createQuery(hql);
			@SuppressWarnings("unchecked")
			List<ReservationRecord> list = query.list();

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
	public List<ReservationRecord> findByName(String name) {
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session = sessionFactory.openSession();

			String hql = "from entity.ReservationRecord as reservation where reservation.name ='"
					+ name + "'";
			Query query = session.createQuery(hql);
			@SuppressWarnings("unchecked")
			List<ReservationRecord> list = query.list();

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
	public List<ReservationRecord> findByRsrvstate(int rsrvstate) {
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session = sessionFactory.openSession();

			String hql = "from entity.ReservationRecord as reservation where reservation.rsrvstate = "
					+ rsrvstate;
			Query query = session.createQuery(hql);
			@SuppressWarnings("unchecked")
			List<ReservationRecord> list = query.list();

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
	public List<ReservationRecord> findByArrivingdt(String arrivingdt1,
			String arrivingdt2) {
		// TODO Auto-generated method stub
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session = sessionFactory.openSession();

			String hql = "from entity.ReservationRecord as reservation where reservation.arrivingdt >= '"
					+ arrivingdt1
					+ "' and reservation.arrivingdt <= '"
					+ arrivingdt2 + "'";
			Query query = session.createQuery(hql);
			@SuppressWarnings("unchecked")
			List<ReservationRecord> list = query.list();

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
	public List<ReservationRecord> findByArrivingDate(String arrivingDate) {
		// TODO Auto-generated method stub
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session = sessionFactory.openSession();

			String arrivingdt1 = arrivingDate + " 00:00:00";
			String arrivingdt2 = arrivingDate + " 23:59:59";
			String hql = "from entity.ReservationRecord as reservation where reservation.arrivingdt >= '"
					+ arrivingdt1
					+ "' and reservation.arrivingdt <= '"
					+ arrivingdt2 + "'";
			Query query = session.createQuery(hql);
			@SuppressWarnings("unchecked")
			List<ReservationRecord> list = query.list();

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
	public List<ReservationRecord> findByParticularDay(String date) {
		// TODO Auto-generated method stub
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session = sessionFactory.openSession();

			String date1 = date + " 23:59:59";
			String date2 = date + " 13:00:00";
			String hql = "from entity.ReservationRecord as reservation where reservation.rsrvstate = 0 reservation.arrivingdt <= '"
					+ date1 + "' and reservation.departuredt > '" + date2 + "'";
			Query query = session.createQuery(hql);
			@SuppressWarnings("unchecked")
			List<ReservationRecord> list = query.list();

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
	public List<ReservationRecord> findByMemberid(String memberid) {
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session = sessionFactory.openSession();

			String hql = "from entity.ReservationRecord as reservation where reservation.memberid = '"
					+ memberid + "' order by reservation.reservationdt desc";
			Query query = session.createQuery(hql);
			@SuppressWarnings("unchecked")
			List<ReservationRecord> list = query.list();

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
	public int getNumOfTodayRsrv() {
		// TODO Auto-generated method stub
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session = sessionFactory.openSession();

			Date now = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String today = dateFormat.format(now);

			String hql = "from entity.ReservationRecord as reservation where reservation.rsrvnum like '"
					+ today + "%'";
			Query query = session.createQuery(hql);
			@SuppressWarnings("unchecked")
			List<ReservationRecord> list = query.list();

			if ((list.size()) == 0)
				return 0;
			else
				return list.size();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}