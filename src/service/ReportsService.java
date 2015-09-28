package service;

import java.util.List;

import sheet.*;

public interface ReportsService {

	/*
	 * 生成并打印预定客人报表
	 */
	public List<ReservationGuestSheet> getRsrvSheetByRoomnum(String roomnum);
	
	public List<ReservationGuestSheet> getRsrvSheetByArrivingdt(
			String arrivingdt1, String arrivingdt2);
	
	public List<ReservationGuestSheet> getRsrvSheetByDtRNum(
			String arrivingdt1,String arrivingdt2,String roomnum);

	/*
	 * 生成并打印入住客人报表
	 */
	public List<CheckinGuestSheet> getCheckinSheetByRoomnum(String roomnum);

	public List<CheckinGuestSheet> getCheckinSheetByArrivingdt(
			String arrivingdt1, String arrivingdt2);
	
	public List<CheckinGuestSheet> getCheckinSheetByDtRNum(
			String arrivingdt1,String arrivingdt2,String roomnum);

	/*
	 * 生成并打印离店客人报表
	 */
	public List<CheckoutGuestSheet> getCheckoutSheetByRoomnum(String roomnum);
	
	public List<CheckoutGuestSheet> getCheckoutSheetByDeparturedt(
			String departuredt1, String departuredt2);
	
	public List<CheckoutGuestSheet> getCheckoutSheetByDtRNum(
			String departuredt1, String departuredt2,String roomnum);

	/*
	 * 生成并打印财务进账报表
	 */
	public List<FinancialSheet> getFinancialSheetByRoomnum(String roomnum);

	public List<FinancialSheet> getFinancialSheetByDt(String startdt, String enddt);
	
	public List<FinancialSheet> getFinancialSheetByDtRNum(String startdt, String enddt,String roomnum);
}
