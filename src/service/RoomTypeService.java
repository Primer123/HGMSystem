package service;

import java.util.List;
import java.util.Map;

import model.RoomTypeInfo;

public interface RoomTypeService {

	/*
	 * 房客预订客房时调用 key为客房类型名，value为对应的具体客房类型
	 */
	public Map<String, List<RoomTypeInfo>> getTargetRoomType(
			String checkinDate, String checkoutDate, int numofadult,
			int numofkid);

	/*
	 * 前台预订客房或办理入住时调用 返回房间类型id
	 */
	public int getTargetRoomType(String checkinDate, String checkoutDate,
			int numofadult, int numofkid, String typename, int bedtype);
	
	/*
	 * 通过房间号获取相应房间类型信息
	 */
	public RoomTypeInfo getTargetRoomType(String roomnum);

	/*
	 * 以下为客房类型管理
	 */
	public List<RoomTypeInfo> getRoomTypeList();
    
	public boolean addNewRoomType(RoomTypeInfo roomType);

	public void modifyRoomTypeInfo(RoomTypeInfo roomType);

	public boolean deleteRoomType(RoomTypeInfo roomType);
	
	public List<RoomTypeInfo> searchRoomType(String keyword);
}
