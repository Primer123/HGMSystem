package dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import dao.ConsumptionRecordDao;
import entity.ConsumptionRecord;

public class ConsumptionRecordDaoImpl implements ConsumptionRecordDao {

	private ConsumptionRecordDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void create(ConsumptionRecord consumptionRecord) {
		// TODO Auto-generated method stub
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.save(consumptionRecord);
			tx.commit();
			session.close();
			sessionFactory.close();
			System.out.println("ok");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void modify(ConsumptionRecord consumptionRecord) {
		// TODO Auto-generated method stub
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			ConsumptionRecord consumptionRecord_tmp = findById(consumptionRecord
					.getId());
			consumptionRecord_tmp.setCheckinnum(consumptionRecord
					.getCheckinnum());
			consumptionRecord_tmp.setRoomnum(consumptionRecord.getRoomnum());
			consumptionRecord_tmp.setGoodcode(consumptionRecord.getGoodcode());
			consumptionRecord_tmp.setAmount(consumptionRecord.getAmount());
			consumptionRecord_tmp.setSubtotal(consumptionRecord.getSubtotal());
			consumptionRecord_tmp.setStaffid(consumptionRecord.getStaffid());
			consumptionRecord_tmp.setDatetime(consumptionRecord.getDatetime());
			consumptionRecord_tmp.setRemarks(consumptionRecord.getRemarks());

			session.update(consumptionRecord_tmp);
			tx.commit();
			session.close();
			sessionFactory.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(ConsumptionRecord consumptionRecord) {
		// TODO Auto-generated method stub
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			ConsumptionRecord consumptionRecord_tmp = findById(consumptionRecord
					.getId());
			session.delete(consumptionRecord_tmp);
			tx.commit();
			session.close();
			sessionFactory.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(List<ConsumptionRecord> consumptionRecords) {
		// TODO Auto-generated method stub
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			int size = consumptionRecords.size();
			if (size > 0) {
				for (int i = 0; i < size; i++) {
					ConsumptionRecord consumptionRecord_tmp = findById(consumptionRecords
							.get(i).getId());
					session.delete(consumptionRecord_tmp);
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
	public ConsumptionRecord findById(int id) {
		// TODO Auto-generated method stub
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session = sessionFactory.openSession();

			String hql = "from entity.ConsumptionRecord as consumption where"
					+ " consumption.id ='" + id + "'";
			Query query = session.createQuery(hql);
			@SuppressWarnings("unchecked")
			List<ConsumptionRecord> list = query.list();

			if ((list.size()) == 0)
				return null;
			else
				return (ConsumptionRecord) list.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<ConsumptionRecord> findByCRNnum(String checkinnum,
			String roomnum) {
		// TODO Auto-generated method stub
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session = sessionFactory.openSession();

			String hql = "from entity.ConsumptionRecord as consumption where "
					+ "consumption.checkinnum ='" + checkinnum
					+ "' and consumption.roomnum = '" + roomnum
					+ "' order by consumption.datetime desc";

			Query query = session.createQuery(hql);
			@SuppressWarnings("unchecked")
			List<ConsumptionRecord> list = query.list();

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
	public List<ConsumptionRecord> findByCheckinNum(String checkinnum) {
		// TODO Auto-generated method stub
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session = sessionFactory.openSession();

			String hql = "from entity.ConsumptionRecord as consumption where "
					+ "consumption.checkinnum ='" + checkinnum + "'";
			Query query = session.createQuery(hql);
			@SuppressWarnings("unchecked")
			List<ConsumptionRecord> list = query.list();

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
	public List<ConsumptionRecord> findByRoomNum(String roomnum) {
		// TODO Auto-generated method stub
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session = sessionFactory.openSession();

			String hql = "from entity.ConsumptionRecord as consumption where "
					+ "consumption.roomnum ='" + roomnum + "'";
			Query query = session.createQuery(hql);
			@SuppressWarnings("unchecked")
			List<ConsumptionRecord> list = query.list();

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
	public List<ConsumptionRecord> findByDateTime(String datetime1,
			String datetime2) {
		// TODO Auto-generated method stub
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session = sessionFactory.openSession();

			String hql = "from entity.ConsumptionRecord as c where "
					+ "c.datetime >= '" + datetime1 + "' and c.datetime <= '"
					+ datetime2 + "'";
			Query query = session.createQuery(hql);
			@SuppressWarnings("unchecked")
			List<ConsumptionRecord> list = query.list();

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
