package service.impl;

import java.util.ArrayList;
import java.util.List;

import dao.CheckinRecordDao;
import dao.GuestDao;
import dao.MemberDao;
import dao.RoomDao;
import dao.RoomTypeDao;
import dao.StaffDao;
import entity.CheckinRecord;
import entity.Guest;
import entity.Member;
import entity.Room;
import entity.RoomType;
import entity.Staff;
import model.CheckinInfo;
import service.CheckinRcdSearchService;

public class CheckinRcdSearchServiceImpl implements CheckinRcdSearchService {
	private CheckinRecordDao checkinRecordDao;
	private RoomDao roomDao;
	private RoomTypeDao roomTypeDao;
	private GuestDao guestDao;
	private StaffDao staffDao;
	private MemberDao memberDao;

	@Override
	public List<CheckinInfo> searchCheckinInfo(String checkinnum,
			String roomtype, String roomnum, String name, String arrivingdt1,
			String arrivingdt2) {
		// TODO Auto-generated method stub
		List<CheckinInfo> result = new ArrayList<CheckinInfo>();

		if (!checkinnum.equals("") && !roomnum.equals("")) {
			CheckinInfo checkinInfo = getByCRNum(checkinnum, roomnum);
			if (checkinInfo != null) {
				result.add(checkinInfo);
			}
			return result;
		}

		if (!checkinnum.equals("")) {
			List<CheckinInfo> checkinInfos = getByCheckinnum(checkinnum);
			if (checkinInfos != null) {
				result.addAll(checkinInfos);
			}
			return result;
		}

		if (!roomnum.equals("") && roomtype.equals("") && name.equals("")
				&& arrivingdt1.equals("")) {
			List<CheckinInfo> checkinInfos = getByRoomnum(roomnum);
			if (checkinInfos != null) {
				result.addAll(checkinInfos);
			}
			return result;
		}

		if (roomnum.equals("") && !roomtype.equals("") && name.equals("")
				&& arrivingdt1.equals("")) {
			List<CheckinInfo> checkinInfos = getByRoomType(roomtype);
			if (checkinInfos != null) {
				result.addAll(checkinInfos);
			}
			return result;
		}

		if (roomnum.equals("") && roomtype.equals("") && !name.equals("")
				&& arrivingdt1.equals("")) {
			List<CheckinInfo> checkinInfos = getByName(name);
			if (checkinInfos != null) {
				result.addAll(checkinInfos);
			}
			return result;
		}

		if (roomnum.equals("") && roomtype.equals("") && name.equals("")
				&& !arrivingdt1.equals("")) {
			List<CheckinInfo> checkinInfos = getByArrivingdt(arrivingdt1,
					arrivingdt2);
			if (checkinInfos != null) {
				result.addAll(checkinInfos);
			}
			return result;
		}

		if (!roomnum.equals("") && roomtype.equals("") && !name.equals("")
				&& arrivingdt1.equals("")) {
			List<CheckinInfo> checkinInfos = getByRoomnumName(roomnum, name);
			if (checkinInfos != null) {
				result.addAll(checkinInfos);
			}
			return result;
		}

		if (!roomnum.equals("") && roomtype.equals("") && name.equals("")
				&& !arrivingdt1.equals("")) {
			List<CheckinInfo> checkinInfos = getByRoomnumArrivingdt(roomnum,
					arrivingdt1, arrivingdt2);
			if (checkinInfos != null) {
				result.addAll(checkinInfos);
			}
			return result;
		}

		if (roomnum.equals("") && !roomtype.equals("") && !name.equals("")
				&& arrivingdt1.equals("")) {
			List<CheckinInfo> checkinInfos = getByRoomtypeName(roomtype, name);
			if (checkinInfos != null) {
				result.addAll(checkinInfos);
			}
			return result;
		}

		if (roomnum.equals("") && !roomtype.equals("") && name.equals("")
				&& !arrivingdt1.equals("")) {
			List<CheckinInfo> checkinInfos = getByRoomtypeArrivingdt(roomtype,
					arrivingdt1, arrivingdt2);
			if (checkinInfos != null) {
				result.addAll(checkinInfos);
			}
			return result;
		}

		if (roomnum.equals("") && roomtype.equals("") && !name.equals("")
				&& !arrivingdt1.equals("")) {
			List<CheckinInfo> checkinInfos = getByNameArrivingdt(name,
					arrivingdt1, arrivingdt2);
			if (checkinInfos != null) {
				result.addAll(checkinInfos);
			}
			return result;
		}

		if (!roomnum.equals("") && roomtype.equals("") && !name.equals("")
				&& !arrivingdt1.equals("")) {
			List<CheckinInfo> checkinInfos = getExceptRoomtype(roomnum, name,
					arrivingdt1, arrivingdt2);
			if (checkinInfos != null) {
				result.addAll(checkinInfos);
			}
			return result;
		}

		if (roomnum.equals("") && !roomtype.equals("") && !name.equals("")
				&& !arrivingdt1.equals("")) {
			List<CheckinInfo> checkinInfos = getExceptRoomnum(roomtype, name,
					arrivingdt1, arrivingdt2);
			if (checkinInfos != null) {
				result.addAll(checkinInfos);
			}
			return result;
		}

		return result;
	}

	/**
	 * private functions
	 */
	private CheckinInfo getByCRNum(String checkinnum, String roomnum) {
		CheckinRecord checkinRecord = checkinRecordDao.findByCRNum(checkinnum,
				roomnum);
		if (checkinRecord != null) {
			CheckinInfo checkinInfo = transferEntityToModel(checkinRecord);
			return checkinInfo;
		}

		return null;
	}

	private List<CheckinInfo> getByCheckinnum(String checkinnum) {
		List<CheckinRecord> checkinRecords = checkinRecordDao
				.findByCheckinNum(checkinnum);
		List<CheckinInfo> checkinInfos = new ArrayList<CheckinInfo>();

		if (checkinRecords == null) {
			return null;
		}

		int size = checkinRecords.size();
		CheckinRecord checkinRecord = new CheckinRecord();
		CheckinInfo checkinInfo = new CheckinInfo();
		for (int i = 0; i < size; i++) {
			checkinRecord = checkinRecords.get(i);
			checkinInfo = transferEntityToModel(checkinRecord);
			checkinInfos.add(checkinInfo);
		}

		return checkinInfos;
	}

	private List<CheckinInfo> getByRoomnum(String roomnum) {
		List<CheckinRecord> checkinRecords = checkinRecordDao
				.findByRoomNum(roomnum);
		List<CheckinInfo> checkinInfos = new ArrayList<CheckinInfo>();

		if (checkinRecords == null) {
			return null;
		}

		int size = checkinRecords.size();
		CheckinRecord checkinRecord = new CheckinRecord();
		CheckinInfo checkinInfo = new CheckinInfo();
		for (int i = 0; i < size; i++) {
			checkinRecord = checkinRecords.get(i);
			checkinInfo = transferEntityToModel(checkinRecord);
			checkinInfos.add(checkinInfo);
		}

		return checkinInfos;
	}

	private List<CheckinInfo> getByRoomType(String roomtype) {
		List<RoomType> roomTypes = roomTypeDao.findByTypename(roomtype);
		List<Integer> typeids = new ArrayList<Integer>();

		if (roomTypes == null) {
			return null;
		}

		int size = roomTypes.size();
		for (int i = 0; i < size; i++) {
			typeids.add(roomTypes.get(i).getId());
		}

		List<Room> rooms = new ArrayList<Room>();
		for (int i = 0; i < size; i++) {
			int typeid = typeids.get(i);
			List<Room> subRooms = roomDao.findByTypeid(typeid);
			if (subRooms != null) {
				rooms.addAll(subRooms);
			}
		}

		List<String> roomnums = new ArrayList<String>();
		size = rooms.size();
		for (int i = 0; i < size; i++) {
			String roomnum = rooms.get(i).getRoomnum();
			roomnums.add(roomnum);
		}

		List<CheckinInfo> checkinInfos = new ArrayList<CheckinInfo>();
		for (int i = 0; i < size; i++) {
			List<CheckinInfo> subCheckinInfos = getByRoomnum(roomnums.get(i));
			if (subCheckinInfos != null) {
				checkinInfos.addAll(subCheckinInfos);
			}
		}

		return checkinInfos;
	}

	private List<CheckinInfo> getByName(String name) {
		List<Guest> guests = guestDao.findByName(name);
		List<CheckinInfo> checkinInfos = new ArrayList<CheckinInfo>();

		if (guests == null) {
			return null;
		}

		int size = guests.size();
		for (int i = 0; i < size; i++) {
			String checkinnum = guests.get(i).getCheckinnum();
			checkinInfos.addAll(getByCheckinnum(checkinnum));
		}

		return checkinInfos;
	}

	private List<CheckinInfo> getByArrivingdt(String arrivingdt1,
			String arrivingdt2) {
		List<CheckinRecord> checkinRecords = checkinRecordDao.findByArrivingDT(
				arrivingdt1, arrivingdt2);
		List<CheckinInfo> checkinInfos = new ArrayList<CheckinInfo>();

		if (checkinRecords == null) {
			return null;
		}

		int size = checkinRecords.size();
		CheckinRecord checkinRecord = new CheckinRecord();
		CheckinInfo checkinInfo = new CheckinInfo();
		for (int i = 0; i < size; i++) {
			checkinRecord = checkinRecords.get(i);
			checkinInfo = transferEntityToModel(checkinRecord);
			checkinInfos.add(checkinInfo);
		}

		return checkinInfos;
	}

	private List<CheckinInfo> getByRoomnumName(String roomnum, String name) {
		List<CheckinInfo> checkInfos1 = getByRoomnum(roomnum);
		List<CheckinInfo> checkInfos2 = getByName(name);

		if (checkInfos1 != null && checkInfos2 != null) {
			checkInfos1.retainAll(checkInfos2);
			return checkInfos1;
		}

		return null;
	}

	private List<CheckinInfo> getByRoomnumArrivingdt(String roomnum,
			String arrivingdt1, String arrivingdt2) {
		List<CheckinInfo> checkInfos1 = getByRoomnum(roomnum);
		List<CheckinInfo> checkInfos2 = getByArrivingdt(arrivingdt1,
				arrivingdt2);

		if (checkInfos1 != null && checkInfos2 != null) {
			checkInfos1.retainAll(checkInfos2);
			return checkInfos1;
		}

		return null;
	}

	private List<CheckinInfo> getByRoomtypeName(String roomtype, String name) {
		List<CheckinInfo> checkInfos1 = getByRoomType(roomtype);
		List<CheckinInfo> checkInfos2 = getByName(name);

		if (checkInfos1 != null && checkInfos2 != null) {
			checkInfos1.retainAll(checkInfos2);
			return checkInfos1;
		}

		return null;
	}

	private List<CheckinInfo> getByRoomtypeArrivingdt(String roomtype,
			String arrivingdt1, String arrivingdt2) {
		List<CheckinInfo> checkInfos1 = getByRoomType(roomtype);
		List<CheckinInfo> checkInfos2 = getByArrivingdt(arrivingdt1,
				arrivingdt2);
		
		if (checkInfos1 != null && checkInfos2 != null) {
			checkInfos1.retainAll(checkInfos2);
			return checkInfos1;
		}

		return null;
	}

	private List<CheckinInfo> getByNameArrivingdt(String name,
			String arrivingdt1, String arrivingdt2) {
		List<CheckinInfo> checkInfos1 = getByName(name);
		List<CheckinInfo> checkInfos2 = getByArrivingdt(arrivingdt1,
				arrivingdt2);

		if (checkInfos1 != null && checkInfos2 != null) {
			checkInfos1.retainAll(checkInfos2);
			return checkInfos1;
		}

		return null;
	}

	private List<CheckinInfo> getExceptRoomnum(String roomtype, String name,
			String arrivingdt1, String arrivingdt2) {
		List<CheckinInfo> checkInfos1 = getByRoomtypeName(roomtype, name);
		List<CheckinInfo> checkInfos2 = getByArrivingdt(arrivingdt1,
				arrivingdt2);

		if (checkInfos1 != null && checkInfos2 != null) {
			checkInfos1.retainAll(checkInfos2);
			return checkInfos1;
		}

		return null;
	}

	private List<CheckinInfo> getExceptRoomtype(String roomnum, String name,
			String arrivingdt1, String arrivingdt2) {
		List<CheckinInfo> checkInfos1 = getByRoomnumName(roomnum, name);
		List<CheckinInfo> checkInfos2 = getByArrivingdt(arrivingdt1,
				arrivingdt2);

		if (checkInfos1 != null && checkInfos2 != null) {
			checkInfos1.retainAll(checkInfos2);
			return checkInfos1;
		}

		return null;
	}

	/**
	 * ½«Entity×ª»»ÎªModel
	 */
	private CheckinInfo transferEntityToModel(CheckinRecord checkinRecord) {
		int id = checkinRecord.getId();
		String checkinnum = checkinRecord.getCheckinnum();
		String roomnum = checkinRecord.getRoomnum();
		double deposit = checkinRecord.getDeposit();
		int paymeth = checkinRecord.getPaymeth();
		String arrivingdt = checkinRecord.getArrivingdt();
		arrivingdt = arrivingdt.substring(0, 19);
		String departuredt = checkinRecord.getDeparturedt();
		departuredt = departuredt.substring(0, 19);
		String staffid = checkinRecord.getStaffid();
		String memberid = checkinRecord.getMemberid();
		int breakfast = checkinRecord.getBreakfast();
		String remarks = checkinRecord.getRemarks();

		Room room = roomDao.findByRoomnum(roomnum);
		int typeid = room.getTypeid();
		RoomType roomType = roomTypeDao.findById(typeid);
		double stdprice = roomType.getStdprice();
		double discprice = roomType.getDiscprice();
		String typename = roomType.getTypename();

		double mprice = 0;

		Member member = memberDao.findBymemberid(memberid);
		if (member != null) {
			int rank = member.getRank();
			if (rank == 0) {
				mprice = roomType.getRmprice();
			} else {
				mprice = roomType.getVmprice();
			}
		}

		List<Guest> guests = guestDao.findByCheckinnum(checkinnum);
		int numOfGuest = 0;
		if (guests != null) {
			numOfGuest = guests.size();
		}

		Staff staff = staffDao.findByStaffId(staffid);
		String staffname = staff.getStaffname();

		CheckinInfo checkinInfo = new CheckinInfo();
		checkinInfo.setArrivingdt(arrivingdt);
		checkinInfo.setBreakfast(breakfast);
		checkinInfo.setCheckinnum(checkinnum);
		checkinInfo.setDeparturedt(departuredt);
		checkinInfo.setDeposit(deposit);
		checkinInfo.setPaymeth(paymeth);
		checkinInfo.setDiscprice(discprice);
		checkinInfo.setId(id);
		checkinInfo.setMemberid(memberid);
		checkinInfo.setMprice(mprice);
		checkinInfo.setNumOfGuest(numOfGuest);
		checkinInfo.setRemarks(remarks);
		checkinInfo.setRoomnum(roomnum);
		checkinInfo.setTypename(typename);
		checkinInfo.setStaffname(staffname);
		checkinInfo.setStdprice(stdprice);
		return checkinInfo;
	}

	/**
	 * getter and setter
	 */
	public CheckinRecordDao getCheckinRecordDao() {
		return checkinRecordDao;
	}

	public void setCheckinRecordDao(CheckinRecordDao checkinRecordDao) {
		this.checkinRecordDao = checkinRecordDao;
	}

	public RoomDao getRoomDao() {
		return roomDao;
	}

	public void setRoomDao(RoomDao roomDao) {
		this.roomDao = roomDao;
	}

	public GuestDao getGuestDao() {
		return guestDao;
	}

	public void setGuestDao(GuestDao guestDao) {
		this.guestDao = guestDao;
	}

	public StaffDao getStaffDao() {
		return staffDao;
	}

	public void setStaffDao(StaffDao staffDao) {
		this.staffDao = staffDao;
	}

	public MemberDao getMemberDao() {
		return memberDao;
	}

	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	public RoomTypeDao getRoomTypeDao() {
		return roomTypeDao;
	}

	public void setRoomTypeDao(RoomTypeDao roomTypeDao) {
		this.roomTypeDao = roomTypeDao;
	}
}
