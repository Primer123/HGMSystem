package service;

import java.util.List;
import java.util.Map;

import model.RoomTypeInfo;

public interface RoomTypeService {

	/*
	 * ����Ԥ���ͷ�ʱ���� keyΪ�ͷ���������valueΪ��Ӧ�ľ���ͷ�����
	 */
	public Map<String, List<RoomTypeInfo>> getTargetRoomType(
			String checkinDate, String checkoutDate, int numofadult,
			int numofkid);

	/*
	 * ǰ̨Ԥ���ͷ��������סʱ���� ���ط�������id
	 */
	public int getTargetRoomType(String checkinDate, String checkoutDate,
			int numofadult, int numofkid, String typename, int bedtype);
	
	/*
	 * ͨ������Ż�ȡ��Ӧ����������Ϣ
	 */
	public RoomTypeInfo getTargetRoomType(String roomnum);

	/*
	 * ����Ϊ�ͷ����͹���
	 */
	public List<RoomTypeInfo> getRoomTypeList();
    
	public boolean addNewRoomType(RoomTypeInfo roomType);

	public void modifyRoomTypeInfo(RoomTypeInfo roomType);

	public boolean deleteRoomType(RoomTypeInfo roomType);
	
	public List<RoomTypeInfo> searchRoomType(String keyword);
}
