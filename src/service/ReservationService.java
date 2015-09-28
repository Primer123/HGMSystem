package service;

import java.util.List;

import model.ReservationInfo;

public interface ReservationService {

	/*
	 * ����Ԥ��������Ԥ������
	 */
	public void addNewReservation(List<ReservationInfo> rsrvinfos,
			String staffid);

	/*
	 * �޸�Ԥ����Ϣ(���޸���ס���ڡ��˷����ڡ����ٷ�����������)
	 */
	public void modifyReservationInfo(List<ReservationInfo> rsrvinfos,
			String staffid);

	/*
	 * ȡ��Ԥ��
	 */
	public void cancelReservation(List<ReservationInfo> rsrvinfos,
			String staffid);
}
