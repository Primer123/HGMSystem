package service.impl;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.RoomInfo;
import dao.CheckinRecordDao;
import dao.ReservationRecordDao;
import dao.RoomDao;
import dao.RoomTypeDao;
import entity.CheckinRecord;
import entity.ReservationRecord;
import entity.Room;
import entity.RoomType;
import service.RoomService;

public class RoomServiceImpl implements RoomService {
	private RoomDao roomDao;
	private RoomTypeDao roomTypeDao;
	private CheckinRecordDao checkinRecordDao;
	private ReservationRecordDao reservationRecordDao;

	@Override
	public List<RoomInfo> getTargetRooms(String checkinDate,
			String checkoutDate, int typeid, String floorname,
			List<String> properties) {
		// List<Room> roomlist=roomDao.findByTypeid(typeid);
		// System.out.println(roomlist.size()); //7
		// List<Room> roombyfloor=roomDao.findByFloorname(floorname);
		// System.out.println(roombyfloor.size()); //5
		List<Room> roombypro = roomDao.findByProperties(properties);
		List<Room> roomlist = new ArrayList<Room>();
		for (int x = 0; x < roombypro.size(); x++) {
			if ((roombypro.get(x).getTypeid() == typeid)
					&& (roombypro.get(x).getFloorname().equals(floorname))) {
				roomlist.add(roombypro.get(x));
			}
		}

		System.out.println(roomlist.size());// 2
		// roomlist.retainAll(roombyfloor);
		// roomlist.retainAll(roombypro);

		// 得到这些房间已有的入住和预订列表
		int i, j;
		List<CheckinRecord> inbyroom = new ArrayList<CheckinRecord>();
		List<ReservationRecord> rsrvbyroom = new ArrayList<ReservationRecord>();
		for (i = 0; i < roomlist.size(); i++) {
			String roomnum = roomlist.get(i).getRoomnum();
			System.out.println(roomnum);
			if (checkinRecordDao.findByRoomNum(roomnum) != null) {
				inbyroom.addAll(checkinRecordDao.findByRoomNum(roomlist.get(i)
						.getRoomnum()));
			}
			if (reservationRecordDao.findByRoomnum(roomnum) != null) {
				rsrvbyroom.addAll(reservationRecordDao.findByRoomnum(roomlist
						.get(i).getRoomnum()));
			}
		}
		System.out.println(inbyroom.size() + "    " + rsrvbyroom.size());

		String checkindt = checkinDate + " 11:00:00";
		String checkoutdt = checkoutDate + " 13:00:00";
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date indate = formatter.parse(checkindt, new ParsePosition(0));
		Date outdate = formatter.parse(checkoutdt, new ParsePosition(0));
		// 去除因“已入住”而无法预订的房间
		for (i = 0; i < inbyroom.size(); i++) {
			CheckinRecord in = inbyroom.get(i);
			Date startdate = formatter.parse(in.getArrivingdt(),
					new ParsePosition(0));
			Date enddate = formatter.parse(in.getDeparturedt(),
					new ParsePosition(0));
			boolean judge = (enddate.before(indate))
					|| (startdate.after(outdate));
			if (!judge) {
				for (j = 0; j < roomlist.size(); j++) {
					if (roomlist.get(j).getRoomnum().equals(in.getRoomnum())) {
						roomlist.remove(j);
						break;
					}
				}
			}

		}
		// 去除因“已预订”而无法预订的房间
		for (i = 0; i < rsrvbyroom.size(); i++) {
			ReservationRecord rsrv = rsrvbyroom.get(i);
			Date startdate = formatter.parse(rsrv.getArrivingdt(),
					new ParsePosition(0));
			Date enddate = formatter.parse(rsrv.getDeparturedt(),
					new ParsePosition(0));
			boolean judge = (enddate.before(indate))
					|| (startdate.after(outdate));
			if (!judge) {
				for (j = 0; j < roomlist.size(); j++) {
					if (roomlist.get(j).getRoomnum().equals(rsrv.getRoomnum())) {
						roomlist.remove(j);
						break;
					}
				}
			}
		}

		List<RoomInfo> infolist = new ArrayList<RoomInfo>();
		for (i = 0; i < roomlist.size(); i++) {
			infolist.add(convertEntity(roomlist.get(i)));
		}
		return infolist;
	}

	@Override
	public List<RoomInfo> getEmptyRoom(String date) {
		// TODO Auto-generated method stub
		List<Room> rooms = new ArrayList<Room>();
		List<RoomInfo> roomInfos = new ArrayList<RoomInfo>();
		SimpleDateFormat sdt = new SimpleDateFormat("yyyy-MM-dd");

		Date now = new Date();
		String now_date = sdt.format(now);
		if (date.equals(now_date)) {
			rooms = roomDao.findByRoomstate(0);
			
			for (int i = 0; i < rooms.size(); i++) {
				RoomInfo roomInfo = convertEntity(rooms.get(i));
				roomInfos.add(roomInfo);
			}
			return roomInfos;
		}

		String[] dateList = date.split("-");
		int year = Integer.parseInt(dateList[0]);
		int month = Integer.parseInt(dateList[1]);
		int day = Integer.parseInt(dateList[2]);

		String[] now_dateList = now_date.split("-");
		int now_year = Integer.parseInt(now_dateList[0]);
		int now_month = Integer.parseInt(now_dateList[1]);
		int now_day = Integer.parseInt(now_dateList[2]);
		if (now_year < year || (now_year == year && now_month < month)
				|| (now_year == year && now_month == month && now_day < day)) {
			List<String> roomnums = new ArrayList<String>();
			
			List<ReservationRecord> reservationRecords = reservationRecordDao
					.findByParticularDay(date);
			for(int i = 0;i < reservationRecords.size(); i++) {
				String roomnum = reservationRecords.get(i).getRoomnum();
				if(!roomnums.contains(roomnum)) {
					roomnums.add(roomnum);
				}
			}
			
			List<CheckinRecord> checkinRecords = checkinRecordDao
					.findByParticularDay(date);
			for(int i = 0;i < checkinRecords.size(); i++) {
				String roomnum = checkinRecords.get(i).getRoomnum();
				if(!roomnums.contains(roomnum)) {
					roomnums.add(roomnum);
				}
			}
			
			for(int i = 0; i < roomnums.size(); i++) {
				Room room = roomDao.findByRoomnum(roomnums.get(i));
				rooms.add(room);
			}
			
			for (int i = 0; i < rooms.size(); i++) {
				RoomInfo roomInfo = convertEntity(rooms.get(i));
				roomInfos.add(roomInfo);
			}
			return roomInfos;
		}
		
		return roomInfos;
	}

	@Override
	public void autoSetRoomState() {
		// TODO Auto-generated method stub
		Date now = new Date();
		SimpleDateFormat sdt = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdt.format(now);

		List<ReservationRecord> reservationRecords = reservationRecordDao
				.findByArrivingDate(date);
		if (reservationRecords != null) {
			int size = reservationRecords.size();
			for (int i = 0; i < size; i++) {
				ReservationRecord reservationRecord = reservationRecords.get(i);
				String roomnum = reservationRecord.getRoomnum();

				Room room = roomDao.findByRoomnum(roomnum);
				room.setRoomstate(1);
				roomDao.modify(room);
			}
		}
	}

	@Override
	public String newRoomNum(int floor) {
		String floorname = floor + "楼";
		int room = 1;
		if (roomDao.findByFloorname(floorname) != null) {
			room = roomDao.findByFloorname(floor + "楼").size() + 1;
		}
		String num = "";
		if (room < 10)
			num = "0" + room;
		else
			num = "" + room;
		String roomnum = "8";
		if (floor < 10) {
			roomnum = roomnum + "0" + floor + num;
		} else {
			roomnum = roomnum + floor + num;
		}
		return roomnum;
	}

	private boolean roomExisted(String roomnum) {
		Room room = roomDao.findByRoomnum(roomnum);
		if (room != null)
			return true;
		else
			return false;
	}

	@Override
	public boolean addNewRoom(RoomInfo roominfo) {
		if (!roomExisted(roominfo.getRoomnum())) {
			Room roomentity = convertInfo(roominfo);
			roomDao.create(roomentity);
			return true;
		}
		return false;
	}

	@Override
	public void modifyRoomInfo(RoomInfo roominfo) {
		Room roomentity = convertInfo(roominfo);
		roomDao.modify(roomentity);
	}

	@Override
	public void deleteRoom(RoomInfo roominfo) {
		Room roomentity = convertInfo(roominfo);
		roomDao.delete(roomentity);
	}

	@Override
	public void deleteRooms(List<RoomInfo> roomlist) {
		List<Room> entitylist = new ArrayList<Room>();
		for (int i = 0; i < roomlist.size(); i++) {
			Room roomentity = convertInfo(roomlist.get(i));
			entitylist.add(roomentity);
		}
		roomDao.delete(entitylist);
	}

	@Override
	public List<RoomInfo> searchRoom(String keyword) {
		List<RoomInfo> result=new ArrayList<RoomInfo>();
		
		switch (judgeKeyword(keyword)) {
		case "roomnum":
			if(roomDao.findByRoomnum(keyword)!=null){
				result.add(convertEntity(roomDao.findByRoomnum(keyword)));
			}
			break;
        case "roomtype":
			if(roomTypeDao.findByTypename(keyword)!=null){
				List<RoomType> typelist=roomTypeDao.findByTypename(keyword);
				List<Room> roomlist=new ArrayList<Room>();
				for(int i=0;i<typelist.size();i++){
					if(roomDao.findByTypeid(typelist.get(i).getId())!=null){
						roomlist.addAll(roomDao.findByTypeid(typelist.get(i).getId()));
						for(int j=0;j<roomlist.size();j++){
							result.add(convertEntity(roomlist.get(j)));
						}
					}	
					roomlist.clear();
				}
			}
			break;
        case "roomstate":
        	int state=0;
        	if(keyword.equals("空房")){
        	   state=0;	
        	}
        	else if(keyword.equals("预定")){
        		state=1;
        	}
        	else{
        		state=2;
        	}
			if(roomDao.findByRoomstate(state)!=null){
				List<Room> templist=roomDao.findByRoomstate(state);
				for(int i=0;i<templist.size();i++){
					result.add(convertEntity(templist.get(i)));
				}
			}
			break;
        case "floorname":
        	if(roomDao.findByFloorname(keyword)!=null){
				List<Room> templist=roomDao.findByFloorname(keyword);
				for(int i=0;i<templist.size();i++){
					result.add(convertEntity(templist.get(i)));
				}
			}
			break;
        case "properties1":
			List<String> pro=new ArrayList<String>();
			pro.add(keyword);
			pro.add("有Wifi");
			List<Room> list=new ArrayList<Room>();
			if(roomDao.findByProperties(pro)!=null){
				list.addAll(roomDao.findByProperties(pro));
			}
			pro.remove("有Wifi");
			pro.add("无Wifi");
			if(roomDao.findByProperties(pro)!=null){
				list.addAll(roomDao.findByProperties(pro));
			}
			for(int i=0;i<list.size();i++){
				result.add(convertEntity(list.get(i)));
			}
			break;
        case "properties2":
        	List<String> properties=new ArrayList<String>();
        	properties.add("无烟");
        	properties.add(keyword);
			List<Room> tlist=new ArrayList<Room>();
			if(roomDao.findByProperties(properties)!=null){
				tlist.addAll(roomDao.findByProperties(properties));
			}
			properties.remove("无烟");
			properties.add(0, "有烟");
			if(roomDao.findByProperties(properties)!=null){
				tlist.addAll(roomDao.findByProperties(properties));
			}
			for(int i=0;i<tlist.size();i++){
				result.add(convertEntity(tlist.get(i)));
			}
			break;
        case "remarks":        	
			break;
		default:
			break;
		}
		
		return result;
	}
	
	private String judgeKeyword(String keyword){
		String judge="";
		
		boolean temp=true;
		if(keyword.length()==5&&keyword.charAt(0)=='8'){
			for(int i=1;i<5;i++){
				if(keyword.charAt(i)>'9'||keyword.charAt(i)<'0'){
					temp=false;
					break;
				}
			}
		}
		
		if(temp){
			judge="roomnum";
		}
		else if(keyword.substring(1).equals("楼")){
			char c=keyword.charAt(0);
			if(c>='1'&&c<='9'){
				judge="floorname";
			}
		}
		else if(keyword.substring(2).equals("楼")){
			char c1=keyword.charAt(0);
			char c2=keyword.charAt(1);
			if(c1>='1'&&c1<='9'){
				if(c2>='0'&&c2<='9'){
					judge="floorname";
				}
			}
		}
		else{
			switch (keyword) {
			case "普通客房":
				judge="roomtype";
				break;   
			case "精品客房":
				judge="roomtype";
				break;
			case "豪华客房":	
				judge="roomtype";
				break;
			case "超豪华客房":	
				judge="roomtype";
				break;			
	        case "空房":
	        	judge="roomstate";
				break;   
			case "预定":
				judge="roomstate";
				break;
			case "入住":	
				judge="roomstate";
				break;
			case "无烟":	
		        judge="properties1";
				break;
            case "有烟":
            	judge="properties1";
				break;
            case "无Wifi":
            	judge="properties2";
				break;
            case "有Wifi":
            	judge="properties2";
				break;
			default:
				judge="remarks";
				break;
			}
		}		
		
		return judge;
	}
	
	@Override
	public List<RoomInfo> findAll() {
		List<Room> entitylist=roomDao.findAll();
		List<RoomInfo> infolist=new ArrayList<RoomInfo>();
		if(entitylist!=null){
			for(int i=0;i<entitylist.size();i++){
				infolist.add(convertEntity(entitylist.get(i)));
			}
		}
		
		return infolist;
	}
	
	private Room convertInfo(RoomInfo info) {
		Room roomentity = new Room();
		int typeid = info.getTypeid();
		roomentity.setId(info.getId());
		roomentity.setRoomnum(info.getRoomnum());
		roomentity.setTypeid(typeid);
		roomentity.setRoomstate(info.getRoomstate());
		roomentity.setFloorname(info.getFloorname());
		roomentity.setProperties(info.getProperties());
		roomentity.setRemarks(info.getRemarks());
		return roomentity;
	}

	private RoomInfo convertEntity(Room entity) {
		RoomInfo info = new RoomInfo();
		info.setId(entity.getId());
		info.setRoomnum(entity.getRoomnum());
		info.setTypeid(entity.getTypeid());
		info.setRoomstate(entity.getRoomstate());
		info.setFloorname(entity.getFloorname());
		info.setProperties(entity.getProperties());
		info.setRemarks(entity.getRemarks());
		return info;
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

	public CheckinRecordDao getCheckinRecordDao() {
		return checkinRecordDao;
	}

	public void setCheckinRecordDao(CheckinRecordDao checkinRecordDao) {
		this.checkinRecordDao = checkinRecordDao;
	}

	public ReservationRecordDao getReservationRecordDao() {
		return reservationRecordDao;
	}

	public void setReservationRecordDao(
			ReservationRecordDao reservationRecordDao) {
		this.reservationRecordDao = reservationRecordDao;
	}
	
}
