package service.impl;

import java.io.IOException;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jxl.write.WriteException;
import model.ConsumptionInfo;
import dao.CheckinRecordDao;
import dao.CommodityDiscDao;
import dao.ConsumptionRecordDao;
import dao.GoodDao;
import dao.LogFileDao;
import dao.MemberDao;
import dao.StaffDao;
import entity.CheckinRecord;
import entity.CommodityDisc;
import entity.ConsumptionRecord;
import entity.Good;
import entity.LogFile;
import entity.Member;
import entity.Staff;
import service.ConsumptionService;
import util.ExcelOperation;

public class ConsumptionServiceImpl implements ConsumptionService {
	private CheckinRecordDao checkinRecordDao;
	private MemberDao memberDao;
	private ConsumptionRecordDao consumptionRecordDao;
	private CommodityDiscDao commodityDiscDao;
	private GoodDao goodDao;
	private LogFileDao logFileDao;
	private StaffDao staffDao;

	@Override
	public List<ConsumptionInfo> searchConsumptionByCRNum(String checkinnum,
			String roomnum) {
		List<ConsumptionRecord> entitylist = consumptionRecordDao.findByCRNnum(
				checkinnum, roomnum);
		if (entitylist == null) {
			return new ArrayList<ConsumptionInfo>();
		}

		List<ConsumptionInfo> infolist = new ArrayList<ConsumptionInfo>();
		for (int i = 0; i < entitylist.size(); i++) {
			infolist.add(transferEntityToModel(entitylist.get(i)));
		}
		return infolist;
	}

	@Override
	public void printConsumptionBill(OutputStream os,
			List<ConsumptionInfo> consumptionInfos) {
		Map<String, Object> content = new HashMap<String, Object>();

		String checkinnum = consumptionInfos.get(0).getCheckinnum();
		String roomnum = consumptionInfos.get(0).getRoomnum();
		content.put("checkinnum", checkinnum);
		content.put("roomnum", roomnum);

		int size = consumptionInfos.size();
		for (int i = 0; i < size; i++) {
			content.put("" + i, consumptionInfos.get(i));
		}

		double commodityDisc = getCommodityDisc(checkinnum, roomnum);
		content.put("discount", "" + commodityDisc);

		double totalConsumption = 0;
		for (int i = 0; i < size; i++) {
			totalConsumption = totalConsumption
					+ consumptionInfos.get(i).getSubtotal();
		}

		content.put("totalConsumption", "￥" + totalConsumption);
		content.put("expenseAfterDiscount", "￥" + totalConsumption
				* commodityDisc);

		try {
			ExcelOperation.createExcel(os, "消费账单", content);
		} catch (WriteException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public double calcuTotalConsumption(double discount,
			List<ConsumptionInfo> consumptions) {
		double totalConsumption = 0;

		int size = consumptions.size();
		for (int i = 0; i < size; i++) {
			totalConsumption = totalConsumption
					+ consumptions.get(i).getSubtotal();
		}

		totalConsumption = totalConsumption * discount;
		
		DecimalFormat df = new DecimalFormat("#.#");    
		double result = Double.parseDouble(df.format(totalConsumption));

		return result;
	}

	@Override
	public void addNewConsumptionItem(List<ConsumptionInfo> consumptions,
			String staffid) {
		int size = consumptions.size();
		for (int i = 0; i < size; i++) {
			ConsumptionRecord entity = transferModelToEntity(
					consumptions.get(i), staffid);
			consumptionRecordDao.create(entity);
		}
		
		String checkinnum = consumptions.get(0).getCheckinnum();
		String roomnum = consumptions.get(0).getRoomnum();
		newLogFile(staffid, "消费入账", checkinnum, roomnum);
	}

	@Override
	public void modifyConsumptionInfo(List<ConsumptionInfo> consumptions,
			String staffid) {
		int size = consumptions.size();
		for (int i = 0; i < size; i++) {
			ConsumptionRecord entity = transferModelToEntity(
					consumptions.get(i), staffid);
			consumptionRecordDao.modify(entity);
		}
	}

	@Override
	public void deleteConsumption(ConsumptionInfo consumption, String staffid) {
		ConsumptionRecord entity = transferModelToEntity(consumption, staffid);
		consumptionRecordDao.delete(entity);
	}

	private ConsumptionInfo transferEntityToModel(ConsumptionRecord entity) {
		ConsumptionInfo info = new ConsumptionInfo();
		Good good = goodDao.findByGoodCode(entity.getGoodcode());
		info.setId(entity.getId());
		info.setCheckinnum(entity.getCheckinnum());
		info.setRoomnum(entity.getRoomnum());
		info.setGoodname(good.getGoodname());
		info.setAmount(entity.getAmount());
		info.setUnitprice(good.getUnitprice());
		info.setUnitSymbol(good.getUnitSymbol());
		info.setSubtotal(entity.getSubtotal());

		Staff staff = staffDao.findByStaffId(entity.getStaffid());
		String staffname = staff.getStaffname();
		info.setStaffname(staffname);

		info.setDatetime(entity.getDatetime());
		info.setRemarks(entity.getRemarks());
		return info;
	}

	private ConsumptionRecord transferModelToEntity(ConsumptionInfo info,
			String staffid) {
		ConsumptionRecord entity = new ConsumptionRecord();
		if (info.getId() != 0) {
			entity.setId(info.getId());
		}
		entity.setCheckinnum(info.getCheckinnum());
		entity.setRoomnum(info.getRoomnum());
		entity.setGoodcode(goodDao.findByGoodName(info.getGoodname())
				.getGoodcode());
		entity.setAmount(info.getAmount());
		entity.setSubtotal(info.getSubtotal());
		entity.setStaffid(staffid);
		entity.setDatetime(info.getDatetime());
		entity.setRemarks(info.getRemarks());
		return entity;
	}

	private double getCommodityDisc(String checkinnum, String roomnum) {
		CommodityDisc commodityDisc = commodityDiscDao.findByStatus("非会员");

		CheckinRecord checkinRecord = checkinRecordDao.findByCRNum(checkinnum,
				roomnum);
		String memberid = checkinRecord.getMemberid();
		if (!memberid.equals("")) {
			Member member = memberDao.findBymemberid(memberid);
			int rank = member.getRank();
			if (rank == 0) {
				commodityDisc = commodityDiscDao.findByStatus("普通会员");
			} else {
				commodityDisc = commodityDiscDao.findByStatus("VIP会员");
			}
		}

		return commodityDisc.getDiscount();
	}
	
	private void newLogFile(String staffid, String operation,
			String checkinnum, String roomnum) {
		LogFile logFile = new LogFile();
		logFile.setStaffid(staffid);
		logFile.setOperation(operation);

		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		String datetime = dateFormat.format(now);
		logFile.setDatetime(datetime);
		logFile.setRemarks("入住单号/房间号:" + checkinnum + "/" + roomnum);
		logFileDao.create(logFile);
	}

	public CheckinRecordDao getCheckinRecordDao() {
		return checkinRecordDao;
	}

	public void setCheckinRecordDao(CheckinRecordDao checkinRecordDao) {
		this.checkinRecordDao = checkinRecordDao;
	}

	public MemberDao getMemberDao() {
		return memberDao;
	}

	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	public ConsumptionRecordDao getConsumptionRecordDao() {
		return consumptionRecordDao;
	}

	public void setConsumptionRecordDao(
			ConsumptionRecordDao consumptionRecordDao) {
		this.consumptionRecordDao = consumptionRecordDao;
	}

	public GoodDao getGoodDao() {
		return goodDao;
	}

	public void setGoodDao(GoodDao goodDao) {
		this.goodDao = goodDao;
	}

	public LogFileDao getLogFileDao() {
		return logFileDao;
	}

	public void setLogFileDao(LogFileDao logFileDao) {
		this.logFileDao = logFileDao;
	}

	public StaffDao getStaffDao() {
		return staffDao;
	}

	public void setStaffDao(StaffDao staffDao) {
		this.staffDao = staffDao;
	}

	public CommodityDiscDao getCommodityDiscDao() {
		return commodityDiscDao;
	}

	public void setCommodityDiscDao(CommodityDiscDao commodityDiscDao) {
		this.commodityDiscDao = commodityDiscDao;
	}
}
