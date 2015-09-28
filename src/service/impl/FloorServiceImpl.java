package service.impl;

import java.util.ArrayList;
import java.util.List;

import model.FloorInfo;
import dao.FloorDao;
import dao.RoomDao;
import entity.Floor;
import entity.Room;
import service.FloorService;

public class FloorServiceImpl implements FloorService {
	private FloorDao floorDao;
	private RoomDao roomDao;	
	
	@Override
	public List<FloorInfo> getAllInfo() {
		List<Floor> entitylist=floorDao.findAll();
		List<FloorInfo> infolist=new ArrayList<FloorInfo>();
		for(int i=0;i<entitylist.size();i++){
			infolist.add(convertEntity(entitylist.get(i)));
		}
		return infolist;
	}
	
	private boolean floorExisted(String floorname) {
		Floor floor=floorDao.findByFloorname(floorname);
		if(floor!=null)
			return true;
		else
			return false;
	}
	
	@Override
	public boolean addNewFloor(FloorInfo floorinfo) {
		if(!floorExisted(floorinfo.getFloorname())){
			Floor floor=convertInfo(floorinfo);
			floorDao.create(floor);
			return true;
		}
		return false;
	}
	
	@Override
	public void modifyFloorInfo(FloorInfo floorinfo) {
		Floor floor=convertInfo(floorinfo);
		floorDao.modify(floor);
	}
	
	@Override
	public boolean deleteFloor(FloorInfo floorinfo) {
		if(!hasRoom(floorinfo.getFloorname())){
			Floor floor=convertInfo(floorinfo);
			floorDao.delete(floor);
			return true;
		}
		else
			return false;
		
	}
	
	@Override
	public boolean deleteFloors(List<FloorInfo> floorlist) {
		List<Floor> entitylist=new ArrayList<Floor>();
		for(int i=0;i<floorlist.size();i++){
			if(hasRoom(floorlist.get(i).getFloorname())){
				return false;
			}
			entitylist.add(convertInfo(floorlist.get(i)));
		}
		floorDao.delete(entitylist);
		return true;
	}
	
	@Override
	public FloorInfo searchByFloorname(String floor) {
		String floorname=floor+"¥";
		Floor entity=floorDao.findByFloorname(floorname);
		if(entity!=null){
			FloorInfo info=convertEntity(entity);
			return info;
		}
		return null;
	}
	
	private boolean hasRoom(String floorname){
		List<Room> list=roomDao.findByFloorname(floorname);
		if(list!=null){
			return true;
		}
		else
			return false;
	}
	
	private FloorInfo convertEntity(Floor entity){
		FloorInfo info=new FloorInfo();
		info.setId(entity.getId());
		info.setFloorname(entity.getFloorname());
		info.setRemarks(entity.getRemarks());
		return info;
	}
	
	private Floor convertInfo(FloorInfo info){
		Floor entity=new Floor();
		entity.setId(info.getId());
		entity.setFloorname(info.getFloorname());
		entity.setRemarks(info.getRemarks());
		return entity;
	}
	
	public FloorDao getFloorDao() {
		return floorDao;
	}
	public void setFloorDao(FloorDao floorDao) {
		this.floorDao = floorDao;
	}
	public RoomDao getRoomDao() {
		return roomDao;
	}
	public void setRoomDao(RoomDao roomDao) {
		this.roomDao = roomDao;
	}
	
}
