package dao;

import java.util.List;

import entity.CheckoutRecord;


public interface CheckoutRecordDao {
	public void create(CheckoutRecord checkoutRecord);
	
	public void modify(CheckoutRecord checkoutRecord);
	
	public void delete(CheckoutRecord checkoutRecord);
	
	public void delete(List<CheckoutRecord> checkoutRecords);
	
	public CheckoutRecord findById(int id);
	
	public CheckoutRecord findByCRNum(String checkinNum, String roomNum);
	
	public List<CheckoutRecord> findByCheckinNum(String checkinNum);
	
	public List<CheckoutRecord> findByRoomNum(String roomNum);
	
	public List<CheckoutRecord> findByCheckoutDt(String checkoutdt1,String checkoutdt2);
}
