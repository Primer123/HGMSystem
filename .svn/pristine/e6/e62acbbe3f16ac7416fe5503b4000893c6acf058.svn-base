package service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import model.ReservationInfo;
import dao.LogFileDao;
import dao.ReservationRecordDao;
import dao.RoomDao;
import dao.StaffDao;
import entity.LogFile;
import entity.ReservationRecord;
import entity.Room;
import service.ReservationService;

public class ReservationServiceImpl implements ReservationService {
	private ReservationRecordDao reservationRecordDao;
	private RoomDao roomDao;
	private StaffDao staffDao;
	private LogFileDao logFileDao;

	@Override
	public void addNewReservation(List<ReservationInfo> rsrvinfos,
			String staffid) {
		int size = rsrvinfos.size();
		for (int i = 0; i < size; i++) {
			ReservationInfo rsrvinfo = rsrvinfos.get(i);
			rsrvinfo.setRsrvstate(0);
			ReservationRecord rsrv = transferModelToEntity(rsrvinfo, staffid);
			reservationRecordDao.create(rsrv);
			
			String rsrvnum = rsrvinfo.getRsrvnum();
			String roomnum = rsrvinfo.getRoomnum();
			newLogFile(staffid, "预定", rsrvnum, roomnum);
		}
	}

	@Override
	public void modifyReservationInfo(List<ReservationInfo> rsrvinfos,
			String staffid) {
		int size = rsrvinfos.size();
		for (int i = 0; i < size; i++) {
			ReservationRecord rsrv = transferModelToEntity(rsrvinfos.get(0),
					staffid);
			reservationRecordDao.modify(rsrv);
		}
	}

	@Override
	public void cancelReservation(List<ReservationInfo> rsrvinfos,
			String staffid) {
		int size = rsrvinfos.size();
		for (int i = 0; i < size; i++) {
			ReservationInfo reservationInfo = rsrvinfos.get(i);
			reservationInfo.setRsrvstate(1);
			ReservationRecord rsrv = transferModelToEntity(reservationInfo,
					staffid);
			reservationRecordDao.modify(rsrv);
			
			String roomnum = rsrv.getRoomnum();
			Room room = roomDao.findByRoomnum(roomnum);
			room.setRoomstate(0);
			roomDao.modify(room);
		}

	}
	
/*
	private String newRsrvnum() {
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String today = dateFormat.format(now);
		String[] todayList = today.split("-");
		String todaystr = todayList[0] + todayList[1] + todayList[2];

		int account = reservationRecordDao.getNumOfTodayRsrv() + 1;
		String rsrvnum = todaystr;
		if (account < 10) {
			rsrvnum += "00" + account;
		} else if (account < 100 && account >= 10) {
			rsrvnum += "0" + account;
		} else {
			rsrvnum += +account;
		}

		return rsrvnum;
	}
*/
	
	private ReservationRecord transferModelToEntity(ReservationInfo info,
			String staffid) {
		ReservationRecord entity = new ReservationRecord();

		entity.setId(info.getId());
		entity.setRsrvnum(info.getRsrvnum());
		entity.setRoomnum(info.getRoomnum());
		entity.setName(info.getName());
		entity.setIdtype(info.getIdtype());
		entity.setIdnum(info.getIdnum());
		entity.setTelnum(info.getTelnum());
		entity.setArrivingdt(info.getArrivingdt());
		entity.setDeparturedt(info.getDeparturedt());
		entity.setStaffid(staffid);
		entity.setMemberid(info.getMemberid());
		entity.setRsrvstate(info.getRsrvstate());
		entity.setRemarks(info.getRemarks());
		return entity;
	}
	
	private void newLogFile(String staffid, String operation,
			String rsrvnum, String roomnum) {
		LogFile logFile = new LogFile();
		logFile.setStaffid(staffid);
		logFile.setOperation(operation);

		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		String datetime = dateFormat.format(now);
		logFile.setDatetime(datetime);
		logFile.setRemarks("预定单号/房间号:" + rsrvnum + "/" + roomnum);
		logFileDao.create(logFile);
	}

	public ReservationRecordDao getReservationRecordDao() {
		return reservationRecordDao;
	}

	public void setReservationRecordDao(
			ReservationRecordDao reservationRecordDao) {
		this.reservationRecordDao = reservationRecordDao;
	}

	public RoomDao getRoomDao() {
		return roomDao;
	}

	public void setRoomDao(RoomDao roomDao) {
		this.roomDao = roomDao;
	}

	public StaffDao getStaffDao() {
		return staffDao;
	}

	public void setStaffDao(StaffDao staffDao) {
		this.staffDao = staffDao;
	}

	public LogFileDao getLogFileDao() {
		return logFileDao;
	}

	public void setLogFileDao(LogFileDao logFileDao) {
		this.logFileDao = logFileDao;
	}
}
