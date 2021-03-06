package service;

import java.io.OutputStream;

import model.CheckinInfo;
import model.CheckoutInfo;

public interface CheckoutService {
	/*
	 * 办理退房，生成退房账单
	 */
	public CheckoutInfo checkout(CheckinInfo checkinInfo, String staffid);

	/*
	 * 用户确认签字后保存退房账单
	 */
	public void saveCheckoutRecord(CheckoutInfo checkoutInfo, String staffid);
	
	/*
	 * 打印退房账单
	 */
	public void printCheckoutBill(OutputStream os, CheckoutInfo checkoutInfo);

	/*
	 * 计算房费（选择性调用，即房价可手动输入亦可有系统根据规则计算）
	 */
	public double calcuRoomRate(String checkindt, String checkoutdt,
			String roomnum, String memberid);
	
}
