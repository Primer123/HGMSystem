package service;

import java.io.OutputStream;
import java.util.List;

import entity.Guest;
import model.CheckinInfo;
import model.ReservationInfo;

public interface CheckinService {
	
	/*
	 * �ֶ�������סʱ���ã��磺��ס�������ȣ���������ס�Ǽǵ�
	 */
	public CheckinInfo checkin(CheckinInfo checkinInfo, String staffid);

	/*
	 * Ԥ��ת��סʱ���ã�������ס��Ϣֱ�Ӵ�Ԥ����Ϣ���
	 */
	public List<CheckinInfo> checkin(List<ReservationInfo> reservationInfos);

	/*
	 * �û�ȷ��ǩ�ֺ󱣴���ס�Ǽǵ�
	 */
	public void saveCheckinRecord(CheckinInfo checkinInfo, List<Guest> guests,
			String staffid);

	/*
	 * ��ӡ��ס��
	 */
	public void printCheckinBill(OutputStream os, CheckinInfo checkinInfo,
			List<Guest> guests);

}