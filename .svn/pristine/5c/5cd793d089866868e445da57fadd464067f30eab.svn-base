package service.impl;

import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.ReportsService;
import sheet.CheckinGuestSheet;
import sheet.CheckoutGuestSheet;
import sheet.FinancialSheet;
import sheet.ReservationGuestSheet;

public class ReportsServiceImplTest extends TestCase {

	ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
			"applicationContext.xml");
	ReportsService reportsService = (ReportsService) ctx.getBean("ReportsService");
	
//	@Test
//	public void testGetRsrvSheetByRoomnum() {
//		List<ReservationGuestSheet> list=reportsService.getRsrvSheetByRoomnum("80102");
//		assertEquals(list.get(0).getRsrvnum(), "201504268010201");
//	}
	
//	@Test
//	public void testGetRsrvSheetByArrivingdt() {
//		List<ReservationGuestSheet> list=reportsService.getRsrvSheetByArrivingdt("2015-04-28 11:00:00", "2015-05-01 11:00:00");
//		assertEquals(list.get(0).getRsrvnum(), "201504278010202");
//	}
	
//	@Test
//	public void testGetRsrvSheetByDtRNum() {
//		List<ReservationGuestSheet> list=reportsService.getRsrvSheetByDtRNum("2015-04-26 11:00:00", "2015-04-30 11:00:00","80102");
//		assertEquals(list.get(0).getRsrvnum(), "201504268010201");
//	}
	
//	@Test
//	public void testGetCheckinSheetByRoomnum() {
//		List<CheckinGuestSheet> list=reportsService.getCheckinSheetByRoomnum("80101");
//		assertEquals(list.get(1).getCheckinnum(), "201504268010101");
//	}
//	
//	@Test
//	public void testGetCheckinSheetByArrivingdt() {
//		List<CheckinGuestSheet> list=reportsService.getCheckinSheetByArrivingdt("2015-02-03 11:00:00", "2015-02-05 11:00:00");
//		assertEquals(list.get(1).getCheckinnum(), "201502048010201");
//	}
//	
//	@Test
//	public void testGetCheckinSheetByDtRNum() {
//		List<CheckinGuestSheet> list=reportsService.getCheckinSheetByDtRNum("2015-02-03 11:00:00", "2015-02-05 18:00:00","80103");
//		assertEquals(list.get(0).getCheckinnum(), "201502058010301");
//	}
//	
//	@Test
//	public void testGetCheckoutSheetByRoomnum() {
//		List<CheckoutGuestSheet> list=reportsService.getCheckoutSheetByRoomnum("80101");
//		assertEquals(list.get(0).getCheckinnum(), "201502038010101");
//	}
//	
//	@Test
//	public void testGetCheckoutSheetByArrivingdt() {
//		List<CheckoutGuestSheet> list=reportsService.getCheckoutSheetByDeparturedt("2015-02-05 13:00:00", "2015-02-08 13:00:00");
//		assertEquals(list.get(1).getCheckinnum(), "201502048010201");
//	}
//	
//	@Test
//	public void testGetCheckoutSheetByDtRNum() {
//		List<CheckoutGuestSheet> list=reportsService.getCheckoutSheetByDtRNum("2015-02-05 13:00:00", "2015-02-08 13:00:00","80102");
//		assertEquals(list.get(0).getCheckinnum(), "201502048010201");
//	}
//	
	@Test
	public void testGetFinancialSheetByRoomnum(){
		List<FinancialSheet> list=reportsService.getFinancialSheetByRoomnum("80101");
		assertEquals(list.get(1).getCheckinnum(),"201504268010101");
	}
	
	@Test
	public void testGetFinancialSheetByDt(){
		List<FinancialSheet> list=reportsService.getFinancialSheetByDt("2015-02-03 10:00:00","2015-02-08 23:00:00");
		assertEquals(list.get(3).getCheckinnum(),"201502038010101");
	}
	
	@Test
	public void testGetFinancialSheetByDtRNum(){
		List<FinancialSheet> list=reportsService.getFinancialSheetByDtRNum("2015-02-03 10:00:00","2015-02-08 23:00:00","80101");
		assertEquals(list.get(0).getCheckinnum(),"201502038010101");
	}

}
