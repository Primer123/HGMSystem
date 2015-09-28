package service.impl;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.ConsumptionInfo;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import entity.CommodityDisc;
import service.CommodityDiscService;
import service.ConsumptionService;

public class ConsumptionServiceImplTest {

	ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
			"applicationContext.xml");
	ConsumptionService consumptionService = (ConsumptionService) ctx
			.getBean("ConsumptionService");
	CommodityDiscService commodityDiscService = (CommodityDiscService) ctx
			.getBean("CommodityDiscService");

	// @Test
	// public void testSearchConsumByCRNum() {
	// List<ConsumptionInfo> consumptions = consumptionService
	// .searchConsumptionByCRNum("20150418001", "80301");
	// assertEquals(consumptions.size(), 0);
	// }

	// @Test
	// public void testPrintConsumptionBill() {
	// }

	// @Test
	// public void testCalcuTotalConsumption() {
	// List<ConsumptionInfo> consumptions = consumptionService
	// .searchConsumptionByCRNum("20150418001", "80301");
	// double discount = commodityDiscService.getCommodityDisc("1234");
	//
	// double totalConsumption = consumptionService.calcuTotalConsumption(
	// discount, consumptions);
	// System.out.println("discount:" + discount);
	// System.out.println("totalConsumption:" + totalConsumption);
	// }

	// @Test
	// public void testAddNewConsumptionItem() {
	// ConsumptionInfo consumptionInfo1 = new ConsumptionInfo();
	// consumptionInfo1.setCheckinnum("20150418001");
	// consumptionInfo1.setRoomnum("80301");
	// consumptionInfo1.setGoodname("Íú×ÐÅ£ÄÌ");
	// consumptionInfo1.setAmount(3);
	// consumptionInfo1.setUnitprice(3.5);
	// consumptionInfo1.setUnitSymbol("Ìý");
	// consumptionInfo1.setSubtotal(10.5);
	// consumptionInfo1.setStaffname("Â·ÈË¼×");
	// consumptionInfo1.setDatetime("2015-4-29 09:18:11");
	// consumptionInfo1.setRemarks("");
	//
	// ConsumptionInfo consumptionInfo2 = new ConsumptionInfo();
	// consumptionInfo2.setCheckinnum("20150418001");
	// consumptionInfo2.setRoomnum("80301");
	// consumptionInfo2.setGoodname("µÂÜ½Å£ÄÌÇÉ¿ËÁ¦");
	// consumptionInfo2.setAmount(2);
	// consumptionInfo2.setUnitprice(6.9);
	// consumptionInfo2.setUnitSymbol("´ü");
	// consumptionInfo2.setSubtotal(13.8);
	// consumptionInfo2.setStaffname("Â·ÈË¼×");
	// consumptionInfo2.setDatetime("2015-4-29 09:18:11");
	// consumptionInfo2.setRemarks("");
	//
	// List<ConsumptionInfo> consumptions = new ArrayList<ConsumptionInfo>();
	// consumptions.add(consumptionInfo1);
	// consumptions.add(consumptionInfo2);
	//
	// consumptionService.addNewConsumptionItem(consumptions, "C0001");
	// }

//	@Test
//	public void testModifyConsumptionInfo() {
//		List<ConsumptionInfo> consumptions = consumptionService
//				.searchConsumptionByCRNum("20150418001", "80301");
//		ConsumptionInfo consumptionInfo1 = consumptions.get(0);
//		ConsumptionInfo consumptionInfo2 = consumptions.get(1);
//		consumptionInfo1.setAmount(2);
//		consumptionInfo1.setUnitprice(3.5);
//		consumptionInfo1.setSubtotal(7);
//		
//		consumptionInfo2.setAmount(3);
//		consumptionInfo2.setUnitprice(6.9);
//		consumptionInfo2.setSubtotal(20.7);
//		
//		consumptionService.modifyConsumptionInfo(consumptions, "C0002");
//	}
	
	 @Test
	 public void testDeleteConsumption() {
		 List<ConsumptionInfo> consumptions = consumptionService
					.searchConsumptionByCRNum("20150418001", "80301");
		 ConsumptionInfo consumptionInfo = consumptions.get(0);
		 
		 consumptionService.deleteConsumption(consumptionInfo, "C0001");
	 }
}
