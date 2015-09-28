package service.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import entity.CommodityDisc;
import service.CommodityDiscService;

public class CommodityDiscServiceImplTest {
	ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
			"applicationContext.xml");
	CommodityDiscService commodityDiscService = (CommodityDiscService) ctx
			.getBean("CommodityDiscService");

//	@Test
//	public void testGetAllCommodityDisc() {
//		List<CommodityDisc> discounts = commodityDiscService
//				.getAllCommodityDisc();
//		assertEquals(discounts.size(), 3);
//		for (int i = 0; i < discounts.size(); i++) {
//			System.out.println(discounts.get(i).getStatus() + ":"
//					+ discounts.get(i).getDiscount());
//		}
//	}

//	 @Test
//	 public void testModifyCommodityDisc() {
//		 List<CommodityDisc> discounts = commodityDiscService
//					.getAllCommodityDisc();
//		 
//		 discounts.get(0).setDiscount(0.99);
//		 discounts.get(1).setDiscount(0.95);
//		 discounts.get(2).setDiscount(0.9);
//		 
//		 commodityDiscService.modifyCommodityDisc(discounts);
//	 }
	
//	 @Test
//	 public void testDeleteCommodityDisc() {
//		 List<CommodityDisc> discounts = commodityDiscService
//					.getAllCommodityDisc();
//		 commodityDiscService.deleteCommodityDisc(discounts.get(0));
//	 }
	
	 @Test
	 public void testAddCommodityDisc() {
		 CommodityDisc commodityDisc = new CommodityDisc();
		 commodityDisc.setStatus("∑«ª·‘±");
		 commodityDisc.setDiscount(0.99);
		 List<CommodityDisc> commodityDiscs = new ArrayList<CommodityDisc>();
		 commodityDiscs.add(commodityDisc);
		 
		 commodityDiscService.addCommodityDisc(commodityDiscs);
	 }
}
