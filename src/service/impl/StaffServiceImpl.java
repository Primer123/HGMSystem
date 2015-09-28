package service.impl;

import java.util.ArrayList;
import java.util.List;

import model.StaffInfo;
import dao.StaffDao;
import entity.Staff;
import service.StaffService;

public class StaffServiceImpl implements StaffService {
	private StaffDao staffDao;

	@Override
	public List<StaffInfo> getStaffList() {
		List<StaffInfo> stafflist = new ArrayList<StaffInfo>();
		List<Staff> entitylist = staffDao.findAll();
		
		if(entitylist != null) {
			for (int i = 0; i < entitylist.size(); i++) {
				StaffInfo temp = convertEntity(entitylist.get(i));
				stafflist.add(temp);
			}
		}
		
		return stafflist;
	}

	@Override
	public List<StaffInfo> searchStaffByName(String staffname) {
		List<StaffInfo> stafflist = new ArrayList<StaffInfo>();
		List<Staff> entitylist = staffDao.findByName(staffname);
		
		if(entitylist != null) {
			for (int i = 0; i < entitylist.size(); i++) {
				StaffInfo temp = convertEntity(entitylist.get(i));
				stafflist.add(temp);
			}
		}
		
		return stafflist;
	}

	@Override
	public List<StaffInfo> searchStaffByProposition(String position) {
		List<StaffInfo> stafflist = new ArrayList<StaffInfo>();
		List<Staff> entitylist = staffDao.findByPosition(position);
		
		if(entitylist != null) {
			for (int i = 0; i < entitylist.size(); i++) {
				StaffInfo temp = convertEntity(entitylist.get(i));
				stafflist.add(temp);
			}
		}
		
		return stafflist;
	}

	@Override
	public StaffInfo searchStaffByStaffid(String staffid) {
		StaffInfo staff = new StaffInfo();
		Staff staffentity = staffDao.findByStaffId(staffid);

		if (staffentity != null) {
			staff = convertEntity(staffentity);
		}

		return staff;
	}

	@Override
	public void addNewStaff(StaffInfo staffinfo) {
		Staff staff = convertInfo(staffinfo);
		staff.setStaffid(newStaffId(staffinfo.getPosition()));
		staffDao.create(staff);
	}

	@Override
	public void modifyStaffInfo(StaffInfo staffinfo) {
		Staff staff = convertInfo(staffinfo);
		staffDao.modify(staff);
	}

	@Override
	public void deleteStaff(StaffInfo staffinfo) {
		Staff staff = convertInfo(staffinfo);
		staffDao.delete(staff);
	}

	@Override
	public boolean login(String staffid, String password) {
		Staff staff = staffDao.findByStaffId(staffid);
		if(staff == null) {
			return false;
		}
		
		if (password.equals(staff.getPassword()))
			return true;
		else
			return false;
	}
	
	private String newStaffId(String position) {
		if (position.equals("管理员")) {
			List<Staff> list = staffDao.findByPosition(position);
			int num = list.size() + 1;
			String id = "";
			if (num < 10) {
				id = "S" + "000" + num;
			} else if (100 > num && num >= 10) {
				id = "S" + "00" + num;
			} else if (1000 > num && num >= 100) {
				id = "S" + "0" + num;
			} else {
				id = "S" + num;
			}
			return id;
		} else if (position.equals("经理")) {
			List<Staff> list = staffDao.findByPosition(position);
			int num = list.size() + 1;
			String id = "";
			if (num < 10) {
				id = "A" + "000" + num;
			} else if (100 > num && num >= 10) {
				id = "A" + "00" + num;
			} else if (1000 > num && num >= 100) {
				id = "A" + "0" + num;
			} else {
				id = "A" + num;
			}
			return id;
		} else {
			List<Staff> list = staffDao.findByPosition(position);
			int num = list.size() + 1;
			String id = "";
			if (num < 10) {
				id = "C" + "000" + num;
			} else if (100 > num && num >= 10) {
				id = "C" + "00" + num;
			} else if (1000 > num && num >= 100) {
				id = "C" + "0" + num;
			} else {
				id = "C" + num;
			}
			return id;
		}
	}

	private Staff convertInfo(StaffInfo info) {
		Staff temp = new Staff();
		if(info.getId() != 0) {
			temp.setId(info.getId());
		}
		
		temp.setStaffid(info.getStaffid());
		temp.setPosition(info.getPosition());
		temp.setStaffname(info.getStaffname());
		temp.setPassword(info.getPassword());
		temp.setRemarks(info.getRemarks());
		return temp;
	}

	private StaffInfo convertEntity(Staff entity) {
		StaffInfo temp = new StaffInfo();
		temp.setId(entity.getId());
		temp.setStaffid(entity.getStaffid());
		temp.setPosition(entity.getPosition());
		temp.setStaffname(entity.getStaffname());
		temp.setPassword(entity.getPassword());
		temp.setRemarks(entity.getRemarks());
		return temp;
	}

	public StaffDao getStaffDao() {
		return staffDao;
	}

	public void setStaffDao(StaffDao staffDao) {
		this.staffDao = staffDao;
	}

}
