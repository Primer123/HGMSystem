package service.impl;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

import model.CheckinInfo;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import entity.Guest;
import service.CheckinRcdSearchService;
import service.CheckinService;
import service.GuestService;

public class CheckinServiceImplTest {

	ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
			"applicationContext.xml");
	CheckinService checkinService = (CheckinService) ctx
			.getBean("CheckinService");
	CheckinRcdSearchService checkinRcdSearchService = (CheckinRcdSearchService) ctx
			.getBean("CheckinRcdSearchService");
	GuestService guestService = (GuestService) ctx.getBean("GuestService");

	// @Test
	// public void testNewCheckinnum() {
	// assertEquals(checkinService.newCheckinnum(), "20150427001");
	// }

	@Test
	public void testCheckinCheckinInfoListOfGuestString() {
		CheckinInfo checkinInfo = new CheckinInfo();
		checkinInfo.setArrivingdt("2015-04-27");
		checkinInfo.setBreakfast(2);
		checkinInfo.setCheckinnum(checkinService.newCheckinnum());
		checkinInfo.setDeparturedt("2015-04-28");
		checkinInfo.setDeposit(300);
		checkinInfo.setMemberid("2014030001");
		checkinInfo.setPaymeth(0);
		checkinInfo.setRemarks("");
		checkinInfo.setRoomnum("80101");

		checkinInfo = checkinService.checkin(checkinInfo, "C0003");

		System.out.println(checkinInfo.getArrivingdt());
		System.out.println(checkinInfo.getDeparturedt());
		System.out.println(checkinInfo.getBreakfast());
		System.out.println(checkinInfo.getCheckinnum());
		System.out.println(checkinInfo.getDeposit());
		System.out.println(checkinInfo.getDiscprice());
		System.out.println(checkinInfo.getMemberid());
		System.out.println(checkinInfo.getMprice());
		System.out.println(checkinInfo.getNumOfGuest());
		System.out.println(checkinInfo.getPaymeth());
		System.out.println(checkinInfo.getRemarks());
		System.out.println(checkinInfo.getRoomnum());
		System.out.println(checkinInfo.getStaffname());
		System.out.println(checkinInfo.getStdprice());
		System.out.println(checkinInfo.getTypename());
	}

	// @Test
	// public void testCheckinListOfReservationInfo() {
	//
	// }

	// @Test
	// public void testSaveCheckinRecord() {
	// CheckinInfo checkinInfo = new CheckinInfo();
	// checkinInfo.setArrivingdt("2015-04-27 10:36:00");
	// checkinInfo.setBreakfast(2);
	// checkinInfo.setCheckinnum(checkinService.newCheckinnum());
	// checkinInfo.setDeparturedt("2015-04-28 13:00:00");
	// checkinInfo.setDeposit(300);
	// checkinInfo.setDiscprice(180);
	// checkinInfo.setMemberid("");
	// checkinInfo.setMprice(160);
	// checkinInfo.setNumOfGuest(2);
	// checkinInfo.setPaymeth(0);
	// checkinInfo.setRemarks("");
	// checkinInfo.setRoomnum("80101");
	// checkinInfo.setStaffname("路人甲");
	// checkinInfo.setStdprice(200);
	// checkinInfo.setTypename("普通客房");
	//
	// List<Guest> guests = new ArrayList<Guest>();
	// Guest guest1 = new Guest();
	// guest1.setAddress("南京大学");
	// guest1.setCheckinnum(checkinService.newCheckinnum());
	// guest1.setRoomnum("80101");
	// guest1.setIdtype(0);
	// guest1.setIdnum("430302199307100816");
	// guest1.setName("李云轩");
	// guest1.setTelnum("13951893550");
	// guests.add(guest1);
	//
	// Guest guest2 = new Guest();
	// guest2.setAddress("南京大学");
	// guest2.setCheckinnum(checkinService.newCheckinnum());
	// guest2.setRoomnum("80101");
	// guest2.setIdtype(0);
	// guest2.setIdnum("4303011993009160816");
	// guest2.setName("李大侠");
	// guest2.setTelnum("13955553550");
	// guests.add(guest2);
	//
	// checkinService.saveCheckinRecord(checkinInfo, guests, "C0001");
	// }

	@Test
	public void testPrintCheckinBill() {
		List<CheckinInfo> checkinInfos = checkinRcdSearchService
				.searchCheckinInfo("20150203001", "", "80101", "", "", "");
		CheckinInfo checkinInfo = checkinInfos.get(0);

		List<Guest> guests = guestService.getGuestLsit("20150203001", "80101");

		OutputStream os;
		try {
			os = new FileOutputStream("a.xlsx");
			checkinService.printCheckinBill(os, checkinInfo, guests);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
