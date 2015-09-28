package dao;

import java.util.List;

import entity.Room;

public interface RoomDao {
    public void create(Room room);
	
	public void modify(Room room);
	
	public void delete(Room room);	
	
	public void delete(List<Room> roomlist);
	
	public Room findById(int roomId);
	
	public Room findByRoomnum(String roomNum);	
	
	public List<Room> findByTypeid(int typeid);
	
	public List<Room> findByRoomstate(int roomState);
	
	public List<Room> findByFloorname(String floorName);
	
	public List<Room> findByProperties(List<String> properties);
	
	public List<Room> findAll();
}
