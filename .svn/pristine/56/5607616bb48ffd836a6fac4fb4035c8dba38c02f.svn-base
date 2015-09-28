package dao;

import java.util.List;

import entity.ConsumptionRecord;

public interface ConsumptionRecordDao {
	public void create(ConsumptionRecord consumptionRecord);
	
	public void modify(ConsumptionRecord consumptionRecord);
	
	public void delete(ConsumptionRecord consumptionRecord);
	
	public void delete(List<ConsumptionRecord> consumptionRecords);
	
	public ConsumptionRecord findById(int id);
	
	public List<ConsumptionRecord> findByCRNnum(String checkinnum, String roomnum);
	
	public List<ConsumptionRecord> findByCheckinNum(String checkinnum);
	
	public List<ConsumptionRecord> findByRoomNum(String roomnum);
	
	public List<ConsumptionRecord> findByDateTime(String datetime1, String datetime2);
}
