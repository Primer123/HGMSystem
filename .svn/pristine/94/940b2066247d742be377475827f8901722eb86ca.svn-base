package service.impl;

import java.util.ArrayList;
import java.util.List;

import dao.MemberDao;
import dao.ReservationRecordDao;
import dao.RoomDao;
import dao.RoomTypeDao;
import dao.StaffDao;
import entity.Member;
import entity.ReservationRecord;
import entity.Room;
import entity.RoomType;
import entity.Staff;
import model.ReservationInfo;
import service.RsrvRcdSearchService;

public class RsrvRcdSearchServiceImpl implements RsrvRcdSearchService {
	private ReservationRecordDao reservationRecordDao;
	private RoomDao roomDao;
	private RoomTypeDao roomTypeDao;
	private StaffDao staffDao;
	private MemberDao memberDao;

	@Override
	public List<ReservationInfo> searchReservationInfo(String rsrvnum,
			String roomnum, String roomtype, String name, String arrivingdt1,
			String arrivingdt2) {
		// TODO Auto-generated method stub
		List<ReservationInfo> result = new ArrayList<ReservationInfo>();

		if (!rsrvnum.equals("") && !roomnum.equals("")) {
			ReservationInfo reservationInfo = getByRRNum(rsrvnum, roomnum);
			if(reservationInfo != null) {
				result.add(reservationInfo);
			}
			return result;
		}

		if (!rsrvnum.equals("")) {
			List<ReservationInfo> reservationInfos = getByRsrvnum(rsrvnum);
			if(reservationInfos != null) {
				result.addAll(reservationInfos);
			}
			return result;
		}

		if (!roomnum.equals("") && roomtype.equals("") && name.equals("")
				&& arrivingdt1.equals("")) {
			List<ReservationInfo> reservationInfos = getByRoomnum(roomnum);
			if(reservationInfos != null) {
				result.addAll(reservationInfos);
			}
			return result;
		}

		if (roomnum.equals("") && !roomtype.equals("") && name.equals("")
				&& arrivingdt1.equals("")) {
			List<ReservationInfo> reservationInfos = getByRoomType(roomtype);
			if(reservationInfos != null) {
				result.addAll(reservationInfos);
			}
			return result;
		}

		if (roomnum.equals("") && roomtype.equals("") && !name.equals("")
				&& arrivingdt1.equals("")) {
			List<ReservationInfo> reservationInfos = getByName(name);
			if(reservationInfos != null) {
				result.addAll(reservationInfos);
			}
			return result;
		}

		if (roomnum.equals("") && roomtype.equals("") && name.equals("")
				&& !arrivingdt1.equals("")) {
			List<ReservationInfo> reservationInfos = getByArrivingdt(arrivingdt1, arrivingdt2);
			if(reservationInfos != null) {
				result.addAll(reservationInfos);
			}
			return result;
		}

		if (!roomnum.equals("") && roomtype.equals("") && !name.equals("")
				&& arrivingdt1.equals("")) {
			List<ReservationInfo> reservationInfos = getByRoomnumName(roomnum, name);
			if(reservationInfos != null) {
				result.addAll(reservationInfos);
			}
			return result;
		}

		if (!roomnum.equals("") && roomtype.equals("") && name.equals("")
				&& !arrivingdt1.equals("")) {
			List<ReservationInfo> reservationInfos = getByRoomnumArrivingdt(roomnum, arrivingdt1,
					arrivingdt2);
			if(reservationInfos != null) {
				result.addAll(reservationInfos);
			}
			return result;
		}

		if (roomnum.equals("") && !roomtype.equals("") && !name.equals("")
				&& arrivingdt1.equals("")) {
			List<ReservationInfo> reservationInfos = getByRoomtypeName(roomtype, name);
			if(reservationInfos != null) {
				result.addAll(reservationInfos);
			}
			return result;
		}

		if (roomnum.equals("") && !roomtype.equals("") && name.equals("")
				&& !arrivingdt1.equals("")) {
			List<ReservationInfo> reservationInfos = getByRoomtypeArrivingdt(roomtype, arrivingdt1,
					arrivingdt2);
			if(reservationInfos != null) {
				result.addAll(reservationInfos);
			}
			return result;
		}

		if (roomnum.equals("") && roomtype.equals("") && !name.equals("")
				&& !arrivingdt1.equals("")) {
			List<ReservationInfo> reservationInfos = getByNameArrivingdt(name, arrivingdt1, arrivingdt2);
			if(reservationInfos != null) {
				result.addAll(reservationInfos);
			}
			return result;
		}

		if (!roomnum.equals("") && roomtype.equals("") && !name.equals("")
				&& !arrivingdt1.equals("")) {
			List<ReservationInfo> reservationInfos = getExceptRoomtype(roomnum, name, arrivingdt1,
					arrivingdt2);
			if(reservationInfos != null) {
				result.addAll(reservationInfos);
			}
			return result;
		}

		if (roomnum.equals("") && !roomtype.equals("") && !name.equals("")
				&& !arrivingdt1.equals("")) {
			List<ReservationInfo> reservationInfos = getExceptRoomnum(roomtype, name, arrivingdt1,
					arrivingdt2);
			if(reservationInfos != null) {
				result.addAll(reservationInfos);
			}
			return result;
		}

		return result;
	}

	/**
	 * private functions
	 */
	private ReservationInfo getByRRNum(String rsrvnum, String roomnum) {
		ReservationRecord reservationRecord = reservationRecordDao.findByRRNum(
				rsrvnum, roomnum);

		if(reservationRecord == null) {
			return null;
		}
		
		ReservationInfo reservationInfo = transferEntityToModel(reservationRecord);
		return reservationInfo;
	}

	private List<ReservationInfo> getByRsrvnum(String rsrvnum) {
		List<ReservationRecord> reservationRecords = reservationRecordDao
				.findByRsrvnum(rsrvnum);
		List<ReservationInfo> reservationInfos = new ArrayList<ReservationInfo>();

		if (reservationRecords == null) {
			return null;
		}

		int size = reservationRecords.size();
		ReservationRecord reservationRecord = new ReservationRecord();
		ReservationInfo reservationInfo = new ReservationInfo();
		for (int i = 0; i < size; i++) {
			reservationRecord = reservationRecords.get(i);
			reservationInfo = transferEntityToModel(reservationRecord);
			reservationInfos.add(reservationInfo);
		}

		return reservationInfos;
	}

	private List<ReservationInfo> getByRoomnum(String roomnum) {
		List<ReservationRecord> reservationRecords = reservationRecordDao
				.findByRoomnum(roomnum);
		List<ReservationInfo> reservationInfos = new ArrayList<ReservationInfo>();

		if (reservationRecords == null) {
			return null;
		}

		int size = reservationRecords.size();
		ReservationRecord reservationRecord = new ReservationRecord();
		ReservationInfo reservationInfo = new ReservationInfo();
		for (int i = 0; i < size; i++) {
			reservationRecord = reservationRecords.get(i);
			reservationInfo = transferEntityToModel(reservationRecord);
			reservationInfos.add(reservationInfo);
		}

		return reservationInfos;
	}

	private List<ReservationInfo> getByRoomType(String roomtype) {
		List<RoomType> roomTypes = roomTypeDao.findByTypename(roomtype);
		List<Integer> typeids = new ArrayList<Integer>();
		
		if(roomTypes == null) {
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
			rooms.addAll(subRooms);
		}

		List<String> roomnums = new ArrayList<String>();
		size = rooms.size();
		for (int i = 0; i < size; i++) {
			String roomnum = rooms.get(i).getRoomnum();
			roomnums.add(roomnum);
		}

		List<ReservationInfo> reservationInfos = new ArrayList<ReservationInfo>();
		for (int i = 0; i < size; i++) {
			List<ReservationInfo> subReservationInfos = getByRoomnum(roomnums.get(i));
			if(subReservationInfos != null) {
				reservationInfos.addAll(subReservationInfos);
			}
		}

		return reservationInfos;
	}

	private List<ReservationInfo> getByName(String name) {
		List<ReservationRecord> reservationRecords = reservationRecordDao
				.findByName(name);
		List<ReservationInfo> reservationInfos = new ArrayList<ReservationInfo>();

		if (reservationRecords == null) {
			return null;
		}

		int size = reservationRecords.size();
		ReservationRecord reservationRecord = new ReservationRecord();
		ReservationInfo reservationInfo = new ReservationInfo();
		for (int i = 0; i < size; i++) {
			reservationRecord = reservationRecords.get(i);
			reservationInfo = transferEntityToModel(reservationRecord);
			reservationInfos.add(reservationInfo);
		}

		return reservationInfos;
	}

	private List<ReservationInfo> getByArrivingdt(String arrivingdt1,
			String arrivingdt2) {
		List<ReservationRecord> reservationRecords = reservationRecordDao
				.findByArrivingdt(arrivingdt1, arrivingdt2);
		List<ReservationInfo> reservationInfos = new ArrayList<ReservationInfo>();

		if (reservationRecords == null) {
			return null;
		}

		int size = reservationRecords.size();
		ReservationRecord reservationRecord = new ReservationRecord();
		ReservationInfo reservationInfo = new ReservationInfo();
		for (int i = 0; i < size; i++) {
			reservationRecord = reservationRecords.get(i);
			reservationInfo = transferEntityToModel(reservationRecord);
			reservationInfos.add(reservationInfo);
		}

		return reservationInfos;
	}

	private List<ReservationInfo> getByRoomnumName(String roomnum, String name) {
		List<ReservationInfo> reservationInfos1 = getByRoomnum(roomnum);
		List<ReservationInfo> reservationInfos2 = getByName(name);

		if (reservationInfos1 != null && reservationInfos2 != null) {
			reservationInfos1.retainAll(reservationInfos2);
			return reservationInfos1;
		}

		return null;
	}

	private List<ReservationInfo> getByRoomnumArrivingdt(String roomnum,
			String arrivingdt1, String arrivingdt2) {
		List<ReservationInfo> reservationInfos1 = getByRoomnum(roomnum);
		List<ReservationInfo> reservationInfos2 = getByArrivingdt(arrivingdt1,
				arrivingdt2);
		
		if (reservationInfos1 != null && reservationInfos2 != null) {
			reservationInfos1.retainAll(reservationInfos2);
			return reservationInfos1;
		}

		return null;
	}

	private List<ReservationInfo> getByRoomtypeName(String roomtype, String name) {
		List<ReservationInfo> reservationInfos1 = getByRoomType(roomtype);
		List<ReservationInfo> reservationInfos2 = getByName(name);

		if (reservationInfos1 != null && reservationInfos2 != null) {
			reservationInfos1.retainAll(reservationInfos2);
			return reservationInfos1;
		}

		return null;
	}

	private List<ReservationInfo> getByRoomtypeArrivingdt(String roomtype,
			String arrivingdt1, String arrivingdt2) {
		List<ReservationInfo> reservationInfos1 = getByRoomType(roomtype);
		List<ReservationInfo> reservationInfos2 = getByArrivingdt(arrivingdt1,
				arrivingdt2);

		if (reservationInfos1 != null && reservationInfos2 != null) {
			reservationInfos1.retainAll(reservationInfos2);
			return reservationInfos1;
		}

		return null;
	}

	private List<ReservationInfo> getByNameArrivingdt(String name,
			String arrivingdt1, String arrivingdt2) {
		List<ReservationInfo> reservationInfos1 = getByName(name);
		List<ReservationInfo> reservationInfos2 = getByArrivingdt(arrivingdt1,
				arrivingdt2);

		if (reservationInfos1 != null && reservationInfos2 != null) {
			reservationInfos1.retainAll(reservationInfos2);
			return reservationInfos1;
		}

		return null;
	}

	private List<ReservationInfo> getExceptRoomnum(String roomtype,
			String name, String arrivingdt1, String arrivingdt2) {
		List<ReservationInfo> reservationInfos1 = getByRoomtypeName(roomtype,
				name);
		List<ReservationInfo> reservationInfos2 = getByArrivingdt(arrivingdt1,
				arrivingdt2);

		if (reservationInfos1 != null && reservationInfos2 != null) {
			reservationInfos1.retainAll(reservationInfos2);
			return reservationInfos1;
		}

		return null;
	}

	private List<ReservationInfo> getExceptRoomtype(String roomnum,
			String name, String arrivingdt1, String arrivingdt2) {
		List<ReservationInfo> reservationInfos1 = getByRoomnumName(roomnum,
				name);
		List<ReservationInfo> reservationInfos2 = getByArrivingdt(arrivingdt1,
				arrivingdt2);

		if (reservationInfos1 != null && reservationInfos2 != null) {
			reservationInfos1.retainAll(reservationInfos2);
			return reservationInfos1;
		}

		return null;
	}

	/**
	 * ½«Entity×ª»»ÎªModel
	 */
	private ReservationInfo transferEntityToModel(
			ReservationRecord reservationRecord) {
		int id = reservationRecord.getId();
		String rsrvnum = reservationRecord.getRsrvnum();
		String roomnum = reservationRecord.getRoomnum();
		String name = reservationRecord.getName();
		int idtype = reservationRecord.getIdtype();
		String idnum = reservationRecord.getIdnum();
		String telnum = reservationRecord.getTelnum();
		String arrivingdt = reservationRecord.getArrivingdt();
		String departuredt = reservationRecord.getDeparturedt();
		String staffid = reservationRecord.getStaffid();
		String memberid = reservationRecord.getMemberid();
		int rsrvstate = reservationRecord.getRsrvstate();
		String remarks = reservationRecord.getRemarks();

		Room room = roomDao.findByRoomnum(roomnum);
		int typeid = room.getTypeid();
		RoomType roomType = roomTypeDao.findById(typeid);
		int numOfGuest = roomType.getNumofadult();
		String typename = roomType.getTypename();
		double stdprice = roomType.getStdprice();
		double discprice = roomType.getDiscprice();
		double mprice;

		Member member = memberDao.findBymemberid(memberid);
		int rank = member.getRank();
		if (rank == 0) {
			mprice = roomType.getRmprice();
		} else {
			mprice = roomType.getVmprice();
		}

		Staff staff = staffDao.findByStaffId(staffid);
		String staffname = staff.getStaffname();

		ReservationInfo reservationInfo = new ReservationInfo();
		reservationInfo.setArrivingdt(arrivingdt);
		reservationInfo.setRsrvnum(rsrvnum);
		reservationInfo.setDeparturedt(departuredt);
		reservationInfo.setDiscprice(discprice);
		reservationInfo.setId(id);
		reservationInfo.setIdnum(idnum);
		reservationInfo.setIdtype(idtype);
		reservationInfo.setMemberid(memberid);
		reservationInfo.setMprice(mprice);
		reservationInfo.setName(name);
		reservationInfo.setNumOfGuest(numOfGuest);
		reservationInfo.setRemarks(remarks);
		reservationInfo.setRoomnum(roomnum);
		reservationInfo.setTypename(typename);
		reservationInfo.setStaffname(staffname);
		reservationInfo.setStdprice(stdprice);
		reservationInfo.setRsrvstate(rsrvstate);
		reservationInfo.setTelnum(telnum);

		return reservationInfo;
	}

	/**
	 * getter and setter
	 */
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
}
