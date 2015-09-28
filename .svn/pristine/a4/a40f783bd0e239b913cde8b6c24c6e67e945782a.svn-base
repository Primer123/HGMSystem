package dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entity.Room;
import dao.RoomDao;

public class RoomDaoImpl implements RoomDao {
	
	public RoomDaoImpl(){
		
	}

	@Override
	public void create(Room room) {
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			session.save(room);
			tx.commit();
			session.close();
			sessionFactory.close();
			System.out.println("ok");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void modify(Room room) {
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			
			//认为roomnum不能修改
			Room room_tmp = findById(room.getId());
			room_tmp.setRoomnum(room.getRoomnum());
			room_tmp.setTypeid(room.getTypeid());
			room_tmp.setRoomstate(room.getRoomstate());
			room_tmp.setFloorname(room.getFloorname());
			room_tmp.setProperties(room.getProperties());
			room_tmp.setRemarks(room.getRemarks());
			
			session.update(room_tmp);
			tx.commit();
			session.close();
			sessionFactory.close();			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Room room) {
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			Room room_tmp = findById(room.getId());
			session.delete(room_tmp);
			tx.commit();
			session.close();
			sessionFactory.close();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}	

	@Override
	public void delete(List<Room> roomlist) {
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			Room room_tmp = null;
			for(int i=0;i<roomlist.size();i++){
				room_tmp=findById(roomlist.get(i).getId());
				session.delete(room_tmp);
			}			
			tx.commit();
			session.close();
			sessionFactory.close();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

	@Override
	public Room findById(int roomId) {
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session=sessionFactory.openSession();

			String hql = "from entity.Room as room where room.id = " + roomId;
			Query query = session.createQuery(hql);
			@SuppressWarnings("unchecked")
			List<Room> list = query.list();

			if ((list.size()) == 0)
				return null;
			else
				return (Room) list.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Room findByRoomnum(String roomNum) {
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session=sessionFactory.openSession();

			String hql = "from entity.Room as room where room.roomnum ='" + roomNum + "'";
			Query query = session.createQuery(hql);
			@SuppressWarnings("unchecked")
			List<Room> list = query.list();

			if ((list.size()) == 0)
				return null;
			else
				return (Room) list.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Room> findByTypeid(int typeid) {
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session=sessionFactory.openSession();

			String hql = "from entity.Room as room where room.typeid ='" + typeid + "'";
			Query query = session.createQuery(hql);
			@SuppressWarnings("unchecked")
			List<Room> list = query.list();

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
	public List<Room> findByRoomstate(int roomState) {
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session=sessionFactory.openSession();

			String hql = "from entity.Room as room where room.roomstate = " + roomState;
			Query query = session.createQuery(hql);
			@SuppressWarnings("unchecked")
			List<Room> list = query.list();

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
	public List<Room> findByFloorname(String floorName) {
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session=sessionFactory.openSession();

			String hql = "from entity.Room as room where room.floorname ='" + floorName + "'";
			Query query = session.createQuery(hql);
			@SuppressWarnings("unchecked")
			List<Room> list = query.list();

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
	public List<Room> findByProperties(List<String> properties) {
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session = sessionFactory.openSession();

			List<String> keywords = getKeywords(properties);

			String hql = "from entity.Room as room where room.properties like '"
					+ keywords.get(0) + "'";
			for (int i = 1; i < keywords.size(); i++) {
				hql = hql + " or room.properties like '" + keywords.get(i)
						+ "'";
			}

			Query query = session.createQuery(hql);
			@SuppressWarnings("unchecked")
			List<Room> list = query.list();

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
	public List<Room> findAll() {
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session=sessionFactory.openSession();

			String hql = "from entity.Room as room";
			Query query = session.createQuery(hql);
			@SuppressWarnings("unchecked")
			List<Room> list = query.list();

			if ((list.size()) == 0)
				return null;
			else
				return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/*
	 * 获得关键字的各种排列方式
	 */
	private List<String> getKeywords(List<String> source) {
		Map<String, String> map = new HashMap<String, String>();

		String keyStr = "";
		for (int i = 0; i < source.size(); i++) {
			map.put("" + i, source.get(i));
			keyStr = keyStr + i;
		}

		List<String> keyStrList = pailie(keyStr);

		List<String> result = new ArrayList<String>();
		for (int i = 0; i < keyStrList.size(); i++) {
			keyStr = keyStrList.get(i);
			String valueStr = "%";
			for (int j = 0; j < keyStr.length(); j++) {
				String value = map.get("" + keyStr.charAt(j));
				valueStr = valueStr + value + "%";
			}
			result.add(valueStr);
		}

		return result;
	}

	private List<String> pailie(String source) {
		if (source == null || source.equals("")) {
			return null;
		}
		List<String> result = new ArrayList<String>();
		if (source.length() == 1) {
			result.add(source);
		} else {
			char thisChar = source.charAt(0);
			List<String> temps = pailie(source.substring(1));
			for (int i = 0; i < temps.size(); i++) {
				// 增一个字符通过插空得到所有的可能清空
				String temp = temps.get(i);
				for (int j = 0; j <= temp.length(); j++) {
					String head = temp.substring(0, j);
					String tail = temp.substring(j);
					result.add(head + thisChar + tail);
				}
			}
		}
		return result;
	}
		
}
