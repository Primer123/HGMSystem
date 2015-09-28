package service;

import java.io.OutputStream;

import model.CheckinInfo;
import model.CheckoutInfo;

public interface CheckoutService {
	/*
	 * �����˷��������˷��˵�
	 */
	public CheckoutInfo checkout(CheckinInfo checkinInfo, String staffid);

	/*
	 * �û�ȷ��ǩ�ֺ󱣴��˷��˵�
	 */
	public void saveCheckoutRecord(CheckoutInfo checkoutInfo, String staffid);
	
	/*
	 * ��ӡ�˷��˵�
	 */
	public void printCheckoutBill(OutputStream os, CheckoutInfo checkoutInfo);

	/*
	 * ���㷿�ѣ�ѡ���Ե��ã������ۿ��ֶ����������ϵͳ���ݹ�����㣩
	 */
	public double calcuRoomRate(String checkindt, String checkoutdt,
			String roomnum, String memberid);
	
}