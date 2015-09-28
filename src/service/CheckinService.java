package service;

import java.io.OutputStream;
import java.util.List;

import entity.Guest;
import model.CheckinInfo;
import model.ReservationInfo;

public interface CheckinService {
	
	/*
	 * 手动办理入住时调用（如：入住、换房等），生成入住登记单
	 */
	public CheckinInfo checkin(CheckinInfo checkinInfo, String staffid);

	/*
	 * 预定转入住时调用，部分入住信息直接从预定信息获得
	 */
	public List<CheckinInfo> checkin(List<ReservationInfo> reservationInfos);

	/*
	 * 用户确认签字后保存入住登记单
	 */
	public void saveCheckinRecord(CheckinInfo checkinInfo, List<Guest> guests,
			String staffid);

	/*
	 * 打印入住单
	 */
	public void printCheckinBill(OutputStream os, CheckinInfo checkinInfo,
			List<Guest> guests);

}
