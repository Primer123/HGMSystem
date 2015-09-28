package service.impl;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.CheckinRecordDao;
import dao.ReservationRecordDao;
import dao.RoomDao;
import dao.RoomTypeDao;
import entity.CheckinRecord;
import entity.ReservationRecord;
import entity.Room;
import entity.RoomType;
import model.RoomTypeInfo;
import service.RoomTypeService;

public class RoomTypeServiceImpl implements RoomTypeService {
	private RoomTypeDao roomTypeDao;
	private RoomDao roomDao;
	private CheckinRecordDao checkinRecordDao;
	private ReservationRecordDao reservationRecordDao;

	@Override
	public Map<String, List<RoomTypeInfo>> getTargetRoomType(
			String checkinDate, String checkoutDate, int numofadult,
			int numofkid) {
		
		Map<String,List<RoomTypeInfo>> resultmap=new HashMap<String,List<RoomTypeInfo>>();
		//得到符合条件的房间类型列表
		List<RoomType> typelist=roomTypeDao.findByAdultKid(numofadult, numofkid);
		//得到符合类型条件的房间列表
		List<Room> roomlist=new ArrayList<Room>();//也用于存储最终可以预订的房间
		int i,j;
		for(i=0;i<typelist.size();i++){
			if(roomDao.findByTypeid(typelist.get(i).getId())!=null){
				roomlist.addAll(roomDao.findByTypeid(typelist.get(i).getId()));
			}			
		}		
		//得到这些房间已有的入住和预订列表
		List<CheckinRecord> inbyroom=new ArrayList<CheckinRecord>();
		List<ReservationRecord> rsrvbyroom=new ArrayList<ReservationRecord>();
		for(i=0;i<roomlist.size();i++){
			if(checkinRecordDao.findByRoomNum(roomlist.get(i).getRoomnum())!=null){
				inbyroom.addAll(checkinRecordDao.findByRoomNum(roomlist.get(i).getRoomnum()));
			}
			if(reservationRecordDao.findByRoomnum(roomlist.get(i).getRoomnum())!=null){
				rsrvbyroom.addAll(reservationRecordDao.findByRoomnum(roomlist.get(i).getRoomnum()));
			}			
		}
		System.out.println("kkkkkkkkk"+roomlist.size());
		String checkindt=checkinDate+" 11:00:00";
		String checkoutdt=checkoutDate+" 13:00:00";
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date indate=formatter.parse(checkindt, new ParsePosition(0));
		Date outdate=formatter.parse(checkoutdt, new ParsePosition(0));
		//去除因“已入住”而无法预订的房间
		for(i=0;i<inbyroom.size();i++){
			CheckinRecord in=inbyroom.get(i);			
			Date startdate=formatter.parse(in.getArrivingdt(), new ParsePosition(0));
			Date enddate=formatter.parse(in.getDeparturedt(), new ParsePosition(0));			
			boolean judge=(enddate.before(indate))||(startdate.after(outdate));
			if(!judge){
				for(j=0;j<roomlist.size();j++){
					if(roomlist.get(j).getRoomnum().equals(in.getRoomnum())){
						roomlist.remove(j);
						break;
					}
				}
			}		
			
		}
		//去除因“已预订”而无法预订的房间
        for(i=0;i<rsrvbyroom.size();i++){
			ReservationRecord rsrv=rsrvbyroom.get(i);
			Date startdate=formatter.parse(rsrv.getArrivingdt(), new ParsePosition(0));
			Date enddate=formatter.parse(rsrv.getDeparturedt(), new ParsePosition(0));	
			boolean judge=(enddate.before(indate))||(startdate.after(outdate));
			if(!judge){
				for(j=0;j<roomlist.size();j++){
					if(roomlist.get(j).getRoomnum().equals(rsrv.getRoomnum())){
						roomlist.remove(j);
						break;
					}
				}
			}		
		}       
		
        //用roomtypelist存放可以预订的房间的类型，且保证内容不重复
        List<RoomTypeInfo> roomtypelist=new ArrayList<RoomTypeInfo>();
        int tempjudge=0;
        for(i=0;i<roomlist.size();i++){
        	RoomType typeentity=roomTypeDao.findById(roomlist.get(i).getTypeid());
        	for(j=0;j<roomtypelist.size();j++){
        		if(roomtypelist.get(j).getId()==typeentity.getId()){
        			tempjudge=1;
        			break;
        		}
        	}
        	if(tempjudge==0){
        		roomtypelist.add(convertEntity(typeentity));
        	}
        	tempjudge=0;
        }
        System.out.println("aaaaaaaaaaaaa"+roomtypelist.size());
        List<RoomTypeInfo> infolist1=new ArrayList<RoomTypeInfo>();
        List<RoomTypeInfo> infolist2=new ArrayList<RoomTypeInfo>();
        List<RoomTypeInfo> infolist3=new ArrayList<RoomTypeInfo>();
        List<RoomTypeInfo> infolist4=new ArrayList<RoomTypeInfo>();
        for(i=0;i<roomtypelist.size();i++){
        	if(roomtypelist.get(i).getTypename().equals("普通客房")){
        		infolist1.add(roomtypelist.get(i));
        	}
        	else if(roomtypelist.get(i).getTypename().equals("精品客房")){
        		infolist2.add(roomtypelist.get(i));
        	}
        	else if(roomtypelist.get(i).getTypename().equals("豪华客房")){
        		infolist3.add(roomtypelist.get(i));
        	}
        	else if(roomtypelist.get(i).getTypename().equals("超豪华客房")){
        		infolist4.add(roomtypelist.get(i));
        	}
        }        
        resultmap.put("普通客房", infolist1);
        resultmap.put("精品客房", infolist2);
        resultmap.put("豪华客房", infolist3);
        resultmap.put("超豪华客房", infolist4);
        
		return resultmap;
	}

	@Override
	public int getTargetRoomType(String checkinDate, String checkoutDate,
			int numofadult, int numofkid, String typename, int bedtype) {
		List<RoomType> typebynum=roomTypeDao.findByAdultKid(numofadult, numofkid);
		List<RoomType> roomtypelist=new ArrayList<RoomType>();
		for(int x=0;x<typebynum.size();x++){
			RoomType roomtype=typebynum.get(x);
			if(roomtype.getTypename().equals(typename)&&roomtype.getBedtype()==bedtype){
				roomtypelist.add(roomtype);
			}
		}
		System.out.println("hhhhhhhhhhhhhhhhhh"+roomtypelist.size());//1
		System.out.println("hhhhhhhhhhhhhhhhhh"+roomtypelist.get(0).getId());//1
		List<Room> roomlist=new ArrayList<Room>();//也用于存储最终可以预订的房间
		int i,j;
		for(i=0;i<roomtypelist.size();i++){
			System.out.println(roomtypelist.get(i).getId());
			List<Room> temprooms=roomDao.findByTypeid(roomtypelist.get(i).getId());
			if(temprooms!=null)			    
				roomlist.addAll(temprooms);
		}		
		
		//得到这些房间已有的入住和预订列表
		List<CheckinRecord> inbyroom=new ArrayList<CheckinRecord>();
		List<ReservationRecord> rsrvbyroom=new ArrayList<ReservationRecord>();
		for(i=0;i<roomlist.size();i++){
			String roomnum=roomlist.get(i).getRoomnum();
			System.out.println(roomnum);			
			if(checkinRecordDao.findByRoomNum(roomnum)!=null){
				inbyroom.addAll(checkinRecordDao.findByRoomNum(roomlist.get(i).getRoomnum()));
			}	
			if(reservationRecordDao.findByRoomnum(roomnum)!=null){
				rsrvbyroom.addAll(reservationRecordDao.findByRoomnum(roomlist.get(i).getRoomnum()));
			}
		}
		
		String checkindt=checkinDate+" 11:00:00";
		String checkoutdt=checkoutDate+" 13:00:00";		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date indate=formatter.parse(checkindt, new ParsePosition(0));
		Date outdate=formatter.parse(checkoutdt, new ParsePosition(0));
		//去除因“已入住”而无法预订的房间
		for(i=0;i<inbyroom.size();i++){
			CheckinRecord in=inbyroom.get(i);			
			Date startdate=formatter.parse(in.getArrivingdt(), new ParsePosition(0));
			Date enddate=formatter.parse(in.getDeparturedt(), new ParsePosition(0));			
			boolean judge=(enddate.before(indate))||(startdate.after(outdate));
			if(!judge){
				for(j=0;j<roomlist.size();j++){
					if(roomlist.get(j).getRoomnum().equals(in.getRoomnum())){
						roomlist.remove(j);
					break;
					}
				}
			}		
				
		}
		//去除因“已预订”而无法预订的房间
		for(i=0;i<rsrvbyroom.size();i++){
			ReservationRecord rsrv=rsrvbyroom.get(i);
			Date startdate=formatter.parse(rsrv.getArrivingdt(), new ParsePosition(0));
			Date enddate=formatter.parse(rsrv.getDeparturedt(), new ParsePosition(0));	
			boolean judge=(enddate.before(indate))||(startdate.after(outdate));
			if(!judge){
				for(j=0;j<roomlist.size();j++){
					if(roomlist.get(j).getRoomnum().equals(rsrv.getRoomnum())){
						roomlist.remove(j);
						break;
					}
				}
			}		
		}		
		
		System.out.println(roomlist.size());
		
		if(roomlist.size()>0){
			return roomlist.get(0).getTypeid();
		}
		
		return -1;
	}
	
	@Override
	public RoomTypeInfo getTargetRoomType(String roomnum) {
		// TODO Auto-generated method stub
		RoomTypeInfo roomTypeInfo = new RoomTypeInfo();
		Room room = roomDao.findByRoomnum(roomnum);
		if(room != null) {
			int typeid = room.getTypeid();
			RoomType roomType = roomTypeDao.findById(typeid);
			roomTypeInfo = convertEntity(roomType);
			return roomTypeInfo;
		}
		else{
			return null;
		}
		
	}
	
	@Override
	public List<RoomTypeInfo> getRoomTypeList() {
		List<RoomType> RTentity=roomTypeDao.findAll();
		List<RoomTypeInfo> RTinfo=new ArrayList<RoomTypeInfo>();		
		for(int i=0;i<RTentity.size();i++){
			RTinfo.add(convertEntity(RTentity.get(i)));
		}
		return RTinfo;
	}
	
	@Override
	public boolean addNewRoomType(RoomTypeInfo roomType) {
		if(!typeExisted(roomType)){
			RoomType RTentity=convertInfo(roomType);
			roomTypeDao.create(RTentity);
			return true;
		}
		else{
			return false;
		}		
	}

	@Override
	public void modifyRoomTypeInfo(RoomTypeInfo roomType) {
		RoomType RTentity=convertInfo(roomType);
		roomTypeDao.modify(RTentity);
	}

	@Override
	public boolean deleteRoomType(RoomTypeInfo roomType) {
		if(!hasRoom(roomType)){
			RoomType RTentity=convertInfo(roomType);
			roomTypeDao.delete(RTentity);
			return true;
		}
		else {
			return false;
		}
		
	}
	
	@Override
	public List<RoomTypeInfo> searchRoomType(String keyword) {
		List<RoomTypeInfo> result=new ArrayList<RoomTypeInfo>();
		switch (judgeKeyword(keyword)) {
		case "typename":
			if(roomTypeDao.findByTypename(keyword)!=null){
				List<RoomType> entitylist=roomTypeDao.findByTypename(keyword);
				for(int i=0;i<entitylist.size();i++){
					result.add(convertEntity(entitylist.get(i)));
				}
			}			
			break; 
		case "0":
			if(roomTypeDao.findByBedType(0)!=null){
				List<RoomType> entitylist=roomTypeDao.findByBedType(0);
				for(int i=0;i<entitylist.size();i++){
					result.add(convertEntity(entitylist.get(i)));
				}
			}	
			break;
		case "1":	
			if(roomTypeDao.findByBedType(1)!=null){
				List<RoomType> entitylist=roomTypeDao.findByBedType(0);
				for(int i=0;i<entitylist.size();i++){
					result.add(convertEntity(entitylist.get(i)));
				}
			}	
			break;
		case "2":	
			if(roomTypeDao.findByBedType(2)!=null){
				List<RoomType> entitylist=roomTypeDao.findByBedType(0);
				for(int i=0;i<entitylist.size();i++){
					result.add(convertEntity(entitylist.get(i)));
				}
			}	
			break;
		default:
			break;
		}
		return result;
	}
	
	private String judgeKeyword(String keyword){
		String judge="";
		switch (keyword) {
		case "普通客房":
		    judge="typename";
			break;
        case "精品客房":
        	judge="typename";
			break;
        case "豪华客房":
        	judge="typename";
			break;
        case "超豪华客房":
        	judge="typename";
			break;
        case "大床":
        	judge="0";
			break;
        case "双床":
        	judge="1";
			break;
        case "套房":
        	judge="2";
			break;
		default:
			break;
		}
		return judge;
	}
	
	private boolean hasRoom(RoomTypeInfo type){
		List<Room> list=roomDao.findByTypeid(type.getId());
		if(list!=null){
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean typeExisted(RoomTypeInfo info){
		List<RoomType> list=roomTypeDao.findByTypename(info.getTypename());
		for(int i=0;i<list.size();i++){
			RoomType type=list.get(i);
			boolean judge=(type.getNumofadult()==info.getNumofadult())
					    &&(type.getNumofkid()==info.getNumofkid())
					    &&(type.getBedtype()==info.getBedtype());
			if(judge==true){
				return true;
			}			
		}		
		return false;
	}
	
	private RoomType convertInfo(RoomTypeInfo info){
		RoomType RTentity=new RoomType();
		RTentity.setId(info.getId());
		RTentity.setTypename(info.getTypename());
		RTentity.setNumofadult(info.getNumofadult());
		RTentity.setNumofkid(info.getNumofkid());
		RTentity.setBedtype(info.getBedtype());
		RTentity.setStdprice(info.getStdprice());
		RTentity.setDiscprice(info.getDiscprice());
		RTentity.setRmprice(info.getRmprice());
		RTentity.setVmprice(info.getVmprice());
		RTentity.setRemarks(info.getRemarks());
		return RTentity;
	}
	
	private RoomTypeInfo convertEntity(RoomType RTentity){
		RoomTypeInfo temp=new RoomTypeInfo();
		temp.setId(RTentity.getId());
		temp.setTypename(RTentity.getTypename());
		temp.setNumofadult(RTentity.getNumofadult());
		temp.setNumofkid(RTentity.getNumofkid());
		temp.setBedtype(RTentity.getBedtype());
		temp.setStdprice(RTentity.getStdprice());
		temp.setDiscprice(RTentity.getDiscprice());
		temp.setRmprice(RTentity.getRmprice());
		temp.setVmprice(RTentity.getVmprice());
		temp.setRemarks(RTentity.getRemarks());
		return temp;
	}

	public RoomTypeDao getRoomTypeDao() {
		return roomTypeDao;
	}
	public void setRoomTypeDao(RoomTypeDao roomTypeDao) {
		this.roomTypeDao = roomTypeDao;
	}
	public RoomDao getRoomDao() {
		return roomDao;
	}
	public void setRoomDao(RoomDao roomDao) {
		this.roomDao = roomDao;
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

	public void setReservationRecordDao(ReservationRecordDao reservationRecordDao) {
		this.reservationRecordDao = reservationRecordDao;
	}	
	
}
