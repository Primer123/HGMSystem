package service;

import java.util.List;

import model.RoomInfo;

public interface RoomService {
	/*
	 * 办理入住、预定客房、换房时用于定位具体客房
	 */
	public List<RoomInfo> getTargetRooms(String checkinDate,
			String checkoutDate, int typeid, String floorname,
			List<String> properties);

	/*
	 * 获得某日的所有空房
	 */
	public List<RoomInfo> getEmptyRoom(String date);
	
	/*
	 * 每日定时执行的方法：将被预订的房间的状态设置为“预定”
	 */
	public void autoSetRoomState();
	
	/*
	 * 以下为客房管理
	 */
	public String newRoomNum(int floor);

	public boolean addNewRoom(RoomInfo roominfo);

	public void modifyRoomInfo(RoomInfo roominfo);

	public void deleteRoom(RoomInfo roominfo);

	public void deleteRooms(List<RoomInfo> roomlist);
	
	public List<RoomInfo> searchRoom(String keyword);
	
	public List<RoomInfo> findAll();
}
