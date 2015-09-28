package service.impl;

import java.util.List;

import dao.RoomDao;
import dao.WakeupDao;
import entity.Room;
import entity.Wakeup;
import service.WakeupService;

public class WakeupServiceImpl implements WakeupService {
	private WakeupDao wakeupDao;
	private RoomDao roomDao;

	@Override
	public List<Wakeup> getNonactivatedWakeup() {
		List<Wakeup> wakeups = wakeupDao.findByFuture();
		if (wakeups == null) {
			return null;
		}

		for (int i = 0; i < wakeups.size(); i++) {
			Wakeup wakeup = wakeups.get(i);
			wakeup.setDatetime(wakeup.getDatetime().substring(0, 19));
		}

		return wakeups;
	}

	@Override
	public boolean addWakeupService(String roomnum, String datetime) {
		Room room = roomDao.findByRoomnum(roomnum);
		if (room == null) {
			return false;
		}

		int roomstate = room.getRoomstate();
		if (roomstate != 2) {
			return false;
		}

		Wakeup wakeup = new Wakeup();
		wakeup.setRoomnum(roomnum);
		wakeup.setDatetime(datetime);
		wakeupDao.create(wakeup);

		return true;
	}

	@Override
	public void setWakeupDatetime(Wakeup wakeup) {
		wakeupDao.modify(wakeup);
	}

	public WakeupDao getWakeupDao() {
		return wakeupDao;
	}

	public void setWakeupDao(WakeupDao wakeup) {
		this.wakeupDao = wakeup;
	}

	public RoomDao getRoomDao() {
		return roomDao;
	}

	public void setRoomDao(RoomDao roomDao) {
		this.roomDao = roomDao;
	}

}
