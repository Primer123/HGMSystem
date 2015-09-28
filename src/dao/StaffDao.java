package dao;

import java.util.List;

import entity.Staff;

public interface StaffDao {
	public void create(Staff staff);
	
	public void modify(Staff staff);
	
	public void delete(Staff staff);
	
	public void delete(List<Staff> staffs);
	
	public Staff findById(int id);
	
	public Staff findByStaffId(String staffId);
	
	public List<Staff> findByPosition(String position);
	
	public List<Staff> findByName(String staffName);
	
	public List<Staff> findAll();
}
