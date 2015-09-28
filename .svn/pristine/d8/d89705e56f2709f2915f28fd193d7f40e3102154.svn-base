package service;

import java.util.List;

import model.ReservationInfo;

public interface ReservationService {

	/*
	 * 新增预定，返回预订单号
	 */
	public void addNewReservation(List<ReservationInfo> rsrvinfos,
			String staffid);

	/*
	 * 修改预定信息(可修改入住日期、退房日期、减少房间数、床型)
	 */
	public void modifyReservationInfo(List<ReservationInfo> rsrvinfos,
			String staffid);

	/*
	 * 取消预订
	 */
	public void cancelReservation(List<ReservationInfo> rsrvinfos,
			String staffid);
}
