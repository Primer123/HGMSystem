package service.impl;

import model.CheckinInfo;
import model.CheckoutInfo;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.CheckinRcdSearchService;
import service.CheckoutService;

public class CheckoutServiceImplTest {
	ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
			"applicationContext.xml");
	CheckoutService checkoutService = (CheckoutService) ctx
			.getBean("CheckoutService");
	CheckinRcdSearchService checkinRcdSearchService = (CheckinRcdSearchService) ctx
			.getBean("CheckinRcdSearchService");

	@Test
	public void testCheckout() {
		CheckinInfo checkinInfo = checkinRcdSearchService.searchCheckinInfo(
				"20150418001", "", "80301", "", "", "").get(0);
		CheckoutInfo checkoutInfo = checkoutService.checkout(checkinInfo,
				"C0001");

		System.out.println(checkoutInfo.getCheckinnum());
		System.out.println(checkoutInfo.getRoomnum());
		System.out.println(checkoutInfo.getDeposit());
		System.out.println(checkoutInfo.getCheckindt());
		System.out.println(checkoutInfo.getCheckoutdt());
		System.out.println(checkoutInfo.getRoomrate());
		System.out.println(checkoutInfo.getGoodsdisc());
		System.out.println(checkoutInfo.getConsumption());
		System.out.println(checkoutInfo.getMealrate());
		System.out.println(checkoutInfo.getTelrate());
		System.out.println(checkoutInfo.getAr());
		System.out.println(checkoutInfo.getPaymeth());
		System.out.println(checkoutInfo.getActualpay());
		System.out.println(checkoutInfo.getChanges());
		System.out.println(checkoutInfo.getStaffname());
		System.out.println(checkoutInfo.getRemarks());
	}

//	 @Test
//	 public void testSaveCheckoutRecord() {
//		 CheckinInfo checkinInfo = checkinRcdSearchService.searchCheckinInfo(
//					"20150311001", "", "80202", "", "", "").get(0);
//		 CheckoutInfo checkoutInfo = checkoutService.checkout(checkinInfo,
//					"C0001");
//		 checkoutService.saveCheckoutRecord(checkoutInfo, "C0001");
//		 
//		 CheckinInfo checkinInfo = checkinRcdSearchService.searchCheckinInfo(
//					"20150427001", "", "80101", "", "", "").get(0);
//		 CheckoutInfo checkoutInfo = checkoutService.checkout(checkinInfo,
//					"C0001");
//		 System.out.println(checkoutInfo.getRoomrate());
//		 checkoutService.saveCheckoutRecord(checkoutInfo, "C0001");
//	 }
}
