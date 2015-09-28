package dao;

import java.util.List;

import entity.Member;

public interface MemberDao {

	public void create(Member member);
	
	public void modify(Member member);
	
	public void delete(Member member);	
	
	public Member findById(int id);
	
	public Member findBymemberid(String memberid);
	
	public List<Member> findByName(String name);	

	public List<Member> findAll();
}
