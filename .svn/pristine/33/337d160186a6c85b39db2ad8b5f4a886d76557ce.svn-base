package service;

import java.util.List;

import model.StaffInfo;

public interface StaffService {

	/*
	 *获得所有员工列表
	 */
	public List<StaffInfo> getStaffList();
	
	/*
	 * 根据姓名获得员工列表
	 */
	public List<StaffInfo> searchStaffByName(String staffname);
	
	/*根据职务获得员工列表
	 * 
	 */
	public List<StaffInfo> searchStaffByProposition(String position);
	
	/*
	 * 根据员工ID获得员工信息
	 */
	public StaffInfo searchStaffByStaffid(String staffid);
	
	/*
	 * 新增员工
	 */
	public void addNewStaff(StaffInfo staffinfo);
	
	/*
	 * 修改员工信息
	 */
	public void modifyStaffInfo(StaffInfo staffinfo);
	
	/*
	 * 删除员工
	 */
	public void deleteStaff(StaffInfo staffinfo);
	
	/*
	 * 登录检测
	 */
	public boolean login(String staffid, String password);
}
