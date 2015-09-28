package dao;

import java.util.List;

import entity.ReservationRecord;

public interface ReservationRecordDao {
	 public void create(ReservationRecord reservation);
		
	 public void modify(ReservationRecord reservation);
	 	
	 public void delete(ReservationRecord reservation);	
		
	 public void delete(List<ReservationRecord> reservationlist);
		
	 public ReservationRecord findById(int id);
	 
	 public ReservationRecord findByRRNum(String rsrvnum, String roomnum);
	 
	 public List<ReservationRecord> findByRsrvnum(String rsrvnum);
	 
	 public List<ReservationRecord> findByRoomnum(String roomnum);
	 
	 public List<ReservationRecord> findByName(String name);
	 
	 public List<ReservationRecord> findByRsrvstate(int rsrvstate);
	 
	 public List<ReservationRecord> findByArrivingdt(String arrivingdt1, String arrivingdt2);
	 
	 public List<ReservationRecord> findByArrivingDate(String arrivingDate);
	 
	 /*
	  * 找出入住期间包含某日期的所有预定信息
	  */
	 public List<ReservationRecord> findByParticularDay(String date);
	 
	 public List<ReservationRecord> findByMemberid(String memberid);
	 
	 public int getNumOfTodayRsrv();
}
