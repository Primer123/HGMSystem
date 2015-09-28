package service;

import java.util.List;

import model.RoomInfo;

public interface RoomService {
	/*
	 * ������ס��Ԥ���ͷ�������ʱ���ڶ�λ����ͷ�
	 */
	public List<RoomInfo> getTargetRooms(String checkinDate,
			String checkoutDate, int typeid, String floorname,
			List<String> properties);

	/*
	 * ���ĳ�յ����пշ�
	 */
	public List<RoomInfo> getEmptyRoom(String date);
	
	/*
	 * ÿ�ն�ʱִ�еķ���������Ԥ���ķ����״̬����Ϊ��Ԥ����
	 */
	public void autoSetRoomState();
	
	/*
	 * ����Ϊ�ͷ�����
	 */
	public String newRoomNum(int floor);

	public boolean addNewRoom(RoomInfo roominfo);

	public void modifyRoomInfo(RoomInfo roominfo);

	public void deleteRoom(RoomInfo roominfo);

	public void deleteRooms(List<RoomInfo> roomlist);
	
	public List<RoomInfo> searchRoom(String keyword);
	
	public List<RoomInfo> findAll();
}