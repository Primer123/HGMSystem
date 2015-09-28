package dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import dao.MemberDao;
import entity.Member;

public class MemberDaoImpl implements MemberDao {
	
	private MemberDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void create(Member member) {
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.save(member);
			tx.commit();
			session.close();
			sessionFactory.close();
			System.out.println("ok");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void modify(Member member) {
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();

			Member mem_tmp = findById(member.getId());
			mem_tmp.setMemberid(member.getMemberid());
			mem_tmp.setName(member.getName());
			mem_tmp.setGender(member.getGender());
			mem_tmp.setPassword(member.getPassword());
			mem_tmp.setTelnum(member.getTelnum());
			mem_tmp.setAddress(member.getAddress());
			mem_tmp.setEmail(member.getEmail());
			mem_tmp.setCredits(member.getCredits());
			mem_tmp.setRemarks(member.getRemarks());

			session.update(mem_tmp);
			tx.commit();
			session.close();
			sessionFactory.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void delete(Member member) {
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			Member mem_tmp = findById(member.getId());
			session.delete(mem_tmp);
			tx.commit();
			session.close();
			sessionFactory.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public Member findById(int id) {
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session = sessionFactory.openSession();

			String hql = "from entity.Member as member where member.id = '"
					+ id + "'";
			Query query = session.createQuery(hql);
			@SuppressWarnings("unchecked")
			List<Member> list = query.list();

			if ((list.size()) == 0)
				return null;
			else
				return (Member) list.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Member findBymemberid(String memberid) {
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session = sessionFactory.openSession();

			String hql = "from entity.Member where "
					+ " memberid ='" + memberid + "'";
			Query query = session.createQuery(hql);
			@SuppressWarnings("unchecked")
			List<Member> list = query.list();

			if ((list.size()) == 0)
				return null;
			else
				return list.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<Member> findByName(String name) {
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session = sessionFactory.openSession();

			String hql = "from entity.Member as member where member.name = '"
					+ name + "'";
			Query query = session.createQuery(hql);
			@SuppressWarnings("unchecked")
			List<Member> list = query.list();

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
	public List<Member> findAll() {
		try {
			Configuration config = new Configuration().configure();
			@SuppressWarnings("deprecation")
			SessionFactory sessionFactory = config.buildSessionFactory();
			Session session = sessionFactory.openSession();

			String hql = "from entity.Member as member";
			Query query = session.createQuery(hql);
			@SuppressWarnings("unchecked")
			List<Member> list = query.list();

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
