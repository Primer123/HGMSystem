package service.impl;

import java.util.List;

import dao.GuestDao;
import entity.Guest;
import service.GuestService;

public class GuestServiceImpl implements GuestService {
	private GuestDao guestDao;

	@Override
	public List<Guest> getGuestLsit(String checkinnum, String roomnum) {
		// TODO Auto-generated method stub
		List<Guest> guests = guestDao.findByCRNum(checkinnum, roomnum);
		
		return guests;
	}

	public GuestDao getGuestDao() {
		return guestDao;
	}

	public void setGuestDao(GuestDao guestDao) {
		this.guestDao = guestDao;
	}
}
