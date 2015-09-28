package service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import jxl.write.WriteException;
import model.CheckinInfo;
import model.CheckoutInfo;
import dao.CheckinRecordDao;
import dao.CheckoutRecordDao;
import dao.CommodityDiscDao;
import dao.ConsumptionRecordDao;
import dao.LogFileDao;
import dao.MemberDao;
import dao.RoomDao;
import dao.RoomTypeDao;
import dao.StaffDao;
import entity.CheckinRecord;
import entity.CheckoutRecord;
import entity.CommodityDisc;
import entity.ConsumptionRecord;
import entity.LogFile;
import entity.Member;
import entity.Room;
import entity.RoomType;
import entity.Staff;
import service.CheckoutService;
import util.ExcelOperation;

public class CheckoutServiceImpl implements CheckoutService {
	private CheckoutRecordDao checkoutRecordDao;
	private CheckinRecordDao checkinRecordDao;
	private ConsumptionRecordDao consumptionRecordDao;
	private CommodityDiscDao commodityDiscDao;
	private RoomDao roomDao;
	private RoomTypeDao roomTypeDao;
	private LogFileDao logFileDao;
	private MemberDao memberDao;
	private StaffDao staffDao;

	@Override
	public CheckoutInfo checkout(CheckinInfo checkinInfo, String staffid) {
		String checkinnum = checkinInfo.getCheckinnum();
		String roomnum = checkinInfo.getRoomnum();
		double deposit = checkinInfo.getDeposit();

		String checkindt = checkinInfo.getArrivingdt();

		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		String checkoutdt = dateFormat.format(now);
		
		DecimalFormat df = new DecimalFormat("#.#");
		String memberid = checkinInfo.getMemberid();
		double roomrate = calcuRoomRate(checkindt, checkoutdt, roomnum,
				memberid);
		double discount = getDiscount(memberid);
		double consumption = calcuConsumption(checkinnum, roomnum, discount);
		consumption = Double.parseDouble(df.format(consumption));

		double mealrate = calceMealRate(checkinnum, roomnum);
		double telrate = calcuTelRate(checkinnum, roomnum);
		double totalexpense = calcuTotalExpense(roomrate, consumption,
				mealrate, telrate);
		double ar = calcuAR(totalexpense, deposit);
		ar = Double.parseDouble(df.format(ar));

		Staff staff = staffDao.findByStaffId(staffid);
		String staffname = staff.getStaffname();

		CheckoutInfo checkoutInfo = new CheckoutInfo();
		checkoutInfo.setCheckinnum(checkinnum);
		checkoutInfo.setRoomnum(roomnum);
		checkoutInfo.setDeposit(deposit);
		checkoutInfo.setCheckindt(checkindt);
		checkoutInfo.setCheckoutdt(checkoutdt);
		checkoutInfo.setRoomrate(roomrate);
		checkoutInfo.setGoodsdisc(discount);
		checkoutInfo.setConsumption(consumption);
		checkoutInfo.setMealrate(mealrate);
		checkoutInfo.setTelrate(telrate);
		if (ar >= 0) {
			checkoutInfo.setAr(ar);
		} else {
			checkoutInfo.setChanges(ar*(-1));
		}
		checkoutInfo.setStaffname(staffname);
		checkoutInfo.setRemarks(checkinInfo.getRemarks());

		return checkoutInfo;
	}

	@Override
	public void printCheckoutBill(OutputStream os, CheckoutInfo checkoutInfo) {
		// TODO Auto-generated method stub
		Map<String, Object> content = new HashMap<String, Object>();

		String checkinnum = checkoutInfo.getCheckinnum();
		content.put("checkinnum", checkinnum);

		String roomnum = checkoutInfo.getRoomnum();
		content.put("roomnum", roomnum);

		CheckinRecord checkinRecord = checkinRecordDao.findByCRNum(checkinnum,
				roomnum);
		String memberid = checkinRecord.getMemberid();

		content.put("roomprice", "��" + getRoomRatePerDay(roomnum, memberid));
		content.put("roomrate", "��" + checkoutInfo.getRoomrate());
		content.put("deposit", "��" + checkoutInfo.getDeposit());
		content.put("checkindt", checkoutInfo.getCheckindt());
		content.put("checkoutdt", checkoutInfo.getCheckoutdt());
		content.put("consumption", "��" + checkoutInfo.getConsumption());
		content.put("mealrate", "��" + checkoutInfo.getMealrate());
		content.put("telrate", "��" + checkoutInfo.getTelrate());
		content.put("ar", "��" + checkoutInfo.getAr());

		int paymeth = checkoutInfo.getPaymeth();
		if (paymeth == 0) {
			content.put("paymeth", "�ֽ�");
		} else {
			content.put("paymeth", "ˢ��");
		}

		content.put("actualpay", "��" + checkoutInfo.getActualpay());
		content.put("change", "��" + checkoutInfo.getChanges());
		content.put("staffname", checkoutInfo.getStaffname());
		content.put("remarks", checkoutInfo.getRemarks());

		try {
			ExcelOperation.createExcel(os, "�˷��Ǽ�", content);
		} catch (WriteException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void saveCheckoutRecord(CheckoutInfo checkoutInfo, String staffid) {
		// TODO Auto-generated method stub
		String checkinnum = checkoutInfo.getCheckinnum();
		String roomnum = checkoutInfo.getRoomnum();
		String checkindt = checkoutInfo.getCheckindt();
		String checkoutdt = checkoutInfo.getCheckoutdt();
		double goodsdisc = checkoutInfo.getGoodsdisc();
		double consumption = checkoutInfo.getConsumption();
		double roomrate = checkoutInfo.getRoomrate();
		double mealrate = checkoutInfo.getMealrate();
		double telrate = checkoutInfo.getTelrate();
		double ar = checkoutInfo.getAr();
		int paymeth = checkoutInfo.getPaymeth();
		double actualpay = checkoutInfo.getActualpay();
		double change = checkoutInfo.getChanges();
		String remarks = checkoutInfo.getRemarks();

		CheckoutRecord checkoutRecord = new CheckoutRecord();
		checkoutRecord.setCheckinnum(checkinnum);
		checkoutRecord.setRoomnum(roomnum);
		checkoutRecord.setCheckindt(checkindt);
		checkoutRecord.setCheckoutdt(checkoutdt);
		checkoutRecord.setGoodsdisc(goodsdisc);
		checkoutRecord.setConsumption(consumption);
		checkoutRecord.setRoomrate(roomrate);
		checkoutRecord.setMealrate(mealrate);
		checkoutRecord.setTelrate(telrate);
		checkoutRecord.setAr(ar);
		checkoutRecord.setPaymeth(paymeth);
		checkoutRecord.setActualpay(actualpay);
		checkoutRecord.setChanges(change);
		checkoutRecord.setRemarks(remarks);
		checkoutRecord.setStaffid(staffid);

		CheckinRecord checkinRecord = checkinRecordDao.findByCRNum(checkinnum,
				roomnum);
		checkinRecord.setDeparturedt(checkoutdt);
		checkinRecordDao.modify(checkinRecord);

		Room room = roomDao.findByRoomnum(roomnum);
		room.setRoomstate(0);
		roomDao.modify(room);
		checkoutRecordDao.create(checkoutRecord);
		
		newLogFile(staffid, "�˷�", checkoutInfo.getCheckinnum(),
				checkoutInfo.getRoomnum());
	}

	@Override
	public double calcuRoomRate(String checkindt, String checkoutdt,
			String roomnum, String memberid) {
		// TODO Auto-generated method stub
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		long nd = 1000 * 24 * 60 * 60;// һ��ĺ�����
		long nh = 1000 * 60 * 60;// һСʱ�ĺ�����
		long nm = 1000 * 60;// һ���ӵĺ�����
		double roomratePerDay = getRoomRatePerDay(roomnum, memberid);
		double roomrate = 0;

		try {
			Date checkin = sd.parse(checkindt);
			Date checkout = sd.parse(checkoutdt);
			long diff = checkout.getTime() - checkin.getTime();
			long day = diff / nd;// ����������
			long hour = diff % nd / nh;// ��������Сʱ
			long min = diff % nd % nh / nm;// �������ٷ���

			// �����ж��Ƿ�Ϊ�ӵ㷿
			if (day == 0 && (hour < 4 || (hour == 4 && min == 0))) {
				// �ӵ㷿��Ϊȫ���۵�40%
				roomrate = (int) (roomratePerDay * 0.4);
			}

			// �ж��ӵ㷿�Ƿ񳬹�4Сʱ��С��8Сʱ
			if (day == 0 && (hour < 8 || (hour == 8 && min == 0))) {
				// ����4Сʱ����8Сʱ�������ӵ㷿�ۼ���
				roomrate = (int) (roomratePerDay * 0.4 * 2);
			}

			// ���������˷�ʱ��
			String[] deadlineStrList = checkoutdt.split(" ");
			String deadlinedt = deadlineStrList[0] + " 13:00:00";
			Date deadline = sd.parse(deadlinedt);

			diff = deadline.getTime() - checkin.getTime();
			day = diff / nd;// ����������
			hour = diff % nd / nh;// ��������Сʱ

			if (day == 0 || hour < 0) {
				// �൱����סһ��
				roomrate = (int) (roomratePerDay);
			}

			if (day > 0) {
				if (checkout.before(deadline)) {
					// ����1��֮ǰ�˷������ӷ���
					roomrate = (int) (roomratePerDay * day);
				}

				String[] lastStrList = deadlinedt.split(" ");
				String lastdt = lastStrList[0] + " 18:00:00";
				Date last = sd.parse(lastdt);
				if (checkout.after(deadline) && checkout.before(last)) {
					// ����1��֮��6��֮ǰ�˷������췿��
					roomrate = (int) (roomratePerDay * (day + 0.5));
				}

				if (checkout.after(last)) {
					// ����6��֮���˷���һ�췿��
					roomrate = (int) (roomratePerDay * (day + 1));
				}
			}

			return roomrate;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0.0;
	}

	private double getRoomRatePerDay(String roomnum, String memberid) {
		Room room = roomDao.findByRoomnum(roomnum);
		int typeid = room.getTypeid();
		RoomType roomType = roomTypeDao.findById(typeid);

		double roomrate = 0;
		if (memberid.equals("")) {
			roomrate = roomType.getDiscprice();
		}

		Member member = memberDao.findBymemberid(memberid);
		if (member == null) {
			return roomrate;
		}

		int rank = member.getRank();
		if (rank == 0) {
			roomrate = roomType.getRmprice();
		} else {
			roomrate = roomType.getVmprice();
		}

		return roomrate;
	}

	private double getDiscount(String memberid) {
		double discount = 0;
		CommodityDisc commodityDisc;

		if (memberid.equals("")) {
			commodityDisc = commodityDiscDao.findByStatus("�ǻ�Ա");
			discount = commodityDisc.getDiscount();
		}

		Member member = memberDao.findBymemberid(memberid);
		if (member == null) {
			return discount;
		}
		int rank = member.getRank();
		if (rank == 0) {
			commodityDisc = commodityDiscDao.findByStatus("��ͨ��Ա");
			discount = commodityDisc.getDiscount();
		} else {
			commodityDisc = commodityDiscDao.findByStatus("VIP��Ա");
			discount = commodityDisc.getDiscount();
		}

		return discount;
	}

	private double calcuConsumption(String checkinnum, String roomnum,
			double discount) {
		double totalConsumption = 0;

		List<ConsumptionRecord> consumptionRecords = consumptionRecordDao
				.findByCRNnum(checkinnum, roomnum);

		if (consumptionRecords == null) {
			return 0;
		}
		int size = consumptionRecords.size();
		for (int i = 0; i < size; i++) {
			totalConsumption = totalConsumption
					+ consumptionRecords.get(i).getSubtotal();
		}

		totalConsumption = totalConsumption * discount;

		return totalConsumption;
	}

	private double calceMealRate(String checkinnum, String roomnum) {
		// method stub

		return 0.0;
	}

	private double calcuTelRate(String checkinnum, String roomnum) {
		// method stub

		return 0.0;
	}

	private double calcuTotalExpense(double roomrate, double consumption,
			double mealRate, double telRate) {
		double totalExpense = roomrate + consumption + mealRate + telRate;

		return totalExpense;
	}

	private double calcuAR(double totalexpense, double deposit) {
		double ar = totalexpense - deposit;

		return ar;
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
		logFile.setRemarks("��ס����/�����:" + checkinnum + "/" + roomnum);
		logFileDao.create(logFile);
	}

	public CheckoutRecordDao getCheckoutRecordDao() {
		return checkoutRecordDao;
	}

	public void setCheckoutRecordDao(CheckoutRecordDao checkoutRecordDao) {
		this.checkoutRecordDao = checkoutRecordDao;
	}

	public CheckinRecordDao getCheckinRecordDao() {
		return checkinRecordDao;
	}

	public void setCheckinRecordDao(CheckinRecordDao checkinRecordDao) {
		this.checkinRecordDao = checkinRecordDao;
	}

	public ConsumptionRecordDao getConsumptionRecordDao() {
		return consumptionRecordDao;
	}

	public void setConsumptionRecordDao(
			ConsumptionRecordDao consumptionRecordDao) {
		this.consumptionRecordDao = consumptionRecordDao;
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

	public RoomDao getRoomDao() {
		return roomDao;
	}

	public void setRoomDao(RoomDao roomDao) {
		this.roomDao = roomDao;
	}

	public RoomTypeDao getRoomTypeDao() {
		return roomTypeDao;
	}

	public void setRoomTypeDao(RoomTypeDao roomTypeDao) {
		this.roomTypeDao = roomTypeDao;
	}

	public MemberDao getMemberDao() {
		return memberDao;
	}

	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	public CommodityDiscDao getCommodityDiscDao() {
		return commodityDiscDao;
	}

	public void setCommodityDiscDao(CommodityDiscDao commodityDiscDao) {
		this.commodityDiscDao = commodityDiscDao;
	}
}