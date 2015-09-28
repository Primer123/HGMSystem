package dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import dao.CheckinRecordDao;
import entity.CheckinRecord;

public class CheckinRecordDaoImpl implements CheckinRecordDao {

	private CheckinRecordDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void create(CheckinRecord checkinRecord) {
		// TODO Auto-generated method stub
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.save(checkinRecord);
			tx.commit();
			session.close();
			sessionFactory.close();
			System.out.println("ok");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void modify(CheckinRecord checkinRecord) {
		// TODO Auto-generated method stub
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			CheckinRecord checkinRecord_tmp = findById(checkinRecord.getId());
			checkinRecord_tmp.setCheckinnum(checkinRecord.getCheckinnum());
			checkinRecord_tmp.setRoomnum(checkinRecord.getRoomnum());
			checkinRecord_tmp.setDeposit(checkinRecord.getDeposit());
			checkinRecord_tmp.setPaymeth(checkinRecord.getPaymeth());
			checkinRecord_tmp.setArrivingdt(checkinRecord.getArrivingdt());
			checkinRecord_tmp.setDeparturedt(checkinRecord.getDeparturedt());
			checkinRecord_tmp.setStaffid(checkinRecord.getStaffid());
			checkinRecord_tmp.setMemberid(checkinRecord.getMemberid());
			checkinRecord_tmp.setBreakfast(checkinRecord.getBreakfast());
			checkinRecord_tmp.setRemarks(checkinRecord.getRemarks());
			session.update(checkinRecord_tmp);
			tx.commit();
			session.close();
			sessionFactory.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(CheckinRecord checkinRecord) {
		// TODO Auto-generated method stub
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			CheckinRecord checkinRecord_tmp = findById(checkinRecord.getId());
			session.delete(checkinRecord_tmp);
			tx.commit();
			session.close();
			sessionFactory.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(List<CheckinRecord> checkinRecords) {
		// TODO Auto-generated method stub
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			int size = checkinRecords.size();
			if (size > 0) {
				for (int i = 0; i < size; i++) {
					CheckinRecord checkinRecord_tmp = findById(checkinRecords
							.get(i).getId());
					session.delete(checkinRecord_tmp);
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
	public CheckinRecord findById(int id) {
		// TODO Auto-generated method stub
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session = sessionFactory.openSession();

			String hql = "from entity.CheckinRecord as checkin where"
					+ " checkin.id ='" + id + "'";
			Query query = session.createQuery(hql);
			@SuppressWarnings("unchecked")
			List<CheckinRecord> list = query.list();

			if ((list.size()) == 0)
				return null;
			else
				return (CheckinRecord) list.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public CheckinRecord findByCRNum(String checkinNum, String roomNum) {
		// TODO Auto-generated method stub
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session = sessionFactory.openSession();

			String hql = "from entity.CheckinRecord as checkin where "
					+ "checkin.checkinnum ='" + checkinNum
					+ "' and checkin.roomnum = '" + roomNum + "'";
			Query query = session.createQuery(hql);
			@SuppressWarnings("unchecked")
			List<CheckinRecord> list = query.list();

			if ((list.size()) == 0)
				return null;
			else
				return (CheckinRecord) list.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<CheckinRecord> findByCheckinNum(String checkinNum) {
		// TODO Auto-generated method stub
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session = sessionFactory.openSession();

			String hql = "from entity.CheckinRecord as checkin where "
					+ "checkin.checkinnum ='" + checkinNum + "'";
			Query query = session.createQuery(hql);
			@SuppressWarnings("unchecked")
			List<CheckinRecord> list = query.list();

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
	public List<CheckinRecord> findByRoomNum(String roomNum) {
		// TODO Auto-generated method stub
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session = sessionFactory.openSession();

			String hql = "from entity.CheckinRecord as checkin where "
					+ "checkin.roomnum ='" + roomNum + "'";
			Query query = session.createQuery(hql);
			@SuppressWarnings("unchecked")
			List<CheckinRecord> list = query.list();

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
	public List<CheckinRecord> findByMemberId(String memberId) {
		// TODO Auto-generated method stub
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session = sessionFactory.openSession();

			String hql = "from entity.CheckinRecord as checkin where "
					+ "checkin.memberid ='" + memberId + "' order by checkin.arrivingdt desc";
			Query query = session.createQuery(hql);
			@SuppressWarnings("unchecked")
			List<CheckinRecord> list = query.list();

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
	public List<CheckinRecord> findByArrivingDT(String arrivingdt1,
			String arrivingdt2) {
		// TODO Auto-generated method stub
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session = sessionFactory.openSession();

			String hql = "from entity.CheckinRecord as checkin where "
					+ "checkin.arrivingdt >= '" + arrivingdt1
					+ "' and checkin.arrivingdt <= '" + arrivingdt2 + "'";
			Query query = session.createQuery(hql);
			@SuppressWarnings("unchecked")
			List<CheckinRecord> list = query.list();

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
	public List<CheckinRecord> findByArrivingDate(String arrivingDate) {
		// TODO Auto-generated method stub
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session = sessionFactory.openSession();

			String arrivingdt1 = arrivingDate + " 00:00:00";
			String arrivingdt2 = arrivingDate + " 23:59:59";
			String hql = "from entity.CheckinRecord as checkin where "
					+ "checkin.arrivingdt >= '" + arrivingdt1
					+ "' and checkin.arrivingdt <= '" + arrivingdt2 + "'";
			Query query = session.createQuery(hql);
			@SuppressWarnings("unchecked")
			List<CheckinRecord> list = query.list();

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
	public List<CheckinRecord> findByDepartureDT(String departuredt1,
			String departuredt2) {
		// TODO Auto-generated method stub
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session = sessionFactory.openSession();

			String hql = "from entity.CheckinRecord as checkin where "
					+ "checkin.departuredt >= '" + departuredt1
					+ "' and checkin.departuredt <= '" + departuredt2 + "'";
			Query query = session.createQuery(hql);
			@SuppressWarnings("unchecked")
			List<CheckinRecord> list = query.list();

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
	public List<CheckinRecord> findByDepartureDate(String departureDate) {
		// TODO Auto-generated method stub
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session = sessionFactory.openSession();

			String departuredt1 = departureDate + " 00:00:00";
			String departuredt2 = departureDate + " 23:59:59";
			String hql = "from entity.CheckinRecord as checkin where "
					+ "checkin.departuredt >= '" + departuredt1
					+ "' and checkin.departuredt <= '" + departuredt2 + "'";
			Query query = session.createQuery(hql);
			@SuppressWarnings("unchecked")
			List<CheckinRecord> list = query.list();

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
	public List<CheckinRecord> findByARdt(String arrivingdt1,
			String arrivingdt2, String departuredt1, String departuredt2) {
		// TODO Auto-generated method stub
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session = sessionFactory.openSession();

			String hql = "from entity.CheckinRecord as checkin where "
					+ "checkin.arrivingdt >= '" + arrivingdt1
					+ "' and checkin.arrivingdt <= '" + arrivingdt2
					+ "' and checkin.departuredt >= '" + departuredt1
					+ "' and checkin.departuredt <= '" + departuredt2 + "'";
			Query query = session.createQuery(hql);
			@SuppressWarnings("unchecked")
			List<CheckinRecord> list = query.list();

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
	public List<CheckinRecord> findByParticularDay(String date) {
		// TODO Auto-generated method stub
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session = sessionFactory.openSession();

			String date1 = date + " 23:59:59";
			String date2 = date + " 13:00:00";
			String hql = "from entity.CheckinRecord as checkin where checkin.arrivingdt <= '"
					+ date1
					+ "' and checkin.departuredt > '"
					+ date2 + "'";
			Query query = session.createQuery(hql);
			@SuppressWarnings("unchecked")
			List<CheckinRecord> list = query.list();

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
