package service;

import java.util.List;

import model.StaffInfo;

public interface StaffService {

	/*
	 *�������Ա���б�
	 */
	public List<StaffInfo> getStaffList();
	
	/*
	 * �����������Ա���б�
	 */
	public List<StaffInfo> searchStaffByName(String staffname);
	
	/*����ְ����Ա���б�
	 * 
	 */
	public List<StaffInfo> searchStaffByProposition(String position);
	
	/*
	 * ����Ա��ID���Ա����Ϣ
	 */
	public StaffInfo searchStaffByStaffid(String staffid);
	
	/*
	 * ����Ա��
	 */
	public void addNewStaff(StaffInfo staffinfo);
	
	/*
	 * �޸�Ա����Ϣ
	 */
	public void modifyStaffInfo(StaffInfo staffinfo);
	
	/*
	 * ɾ��Ա��
	 */
	public void deleteStaff(StaffInfo staffinfo);
	
	/*
	 * ��¼���
	 */
	public boolean login(String staffid, String password);
}
