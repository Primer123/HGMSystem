package service.impl;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;
import model.GoodInfo;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.GoodService;

public class GoodServiceImplTest extends TestCase {

	ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
			"applicationContext.xml");
	GoodService goodService = (GoodService) ctx.getBean("GoodService");
	
//	@Test
//	public void testGetAllGoods() {
//		List<GoodInfo> list=goodService.getAllGoods();
//		assertEquals(list.get(5).getGoodcode(),"01001");
//	}
//	
//	@Test
//	public void testSearchByType(){
//		List<String> typelist=new ArrayList<String>();
//		typelist.add("07");
//		List<GoodInfo> list=goodService.searchGoodByType(typelist);
//		assertEquals(list.get(1).getGoodcode(),"07002");
//	}
//	
//	@Test
//	public void testAddNewGood1(){
//		GoodInfo info=new GoodInfo();
//		info.setGoodname("娃哈哈果奶");
//		info.setTypename("奶制品");
//		info.setUnitprice(2.5);
//		info.setUnitSymbol("瓶");
//		goodService.addNewGood(info);
//	}
//	
//	@Test
//	public void testAddNewGood2(){
//		GoodInfo info=new GoodInfo();
//		info.setGoodname("娃哈哈果奶");
//		info.setTypename("奶制品");
//		info.setUnitprice(2.5);
//		info.setUnitSymbol("瓶");
//		assertEquals(goodService.addNewGood(info),false);
//	}
	
//	@Test
//	public void testModifyGoodInfo(){
//		GoodInfo info=new GoodInfo();
//		info.setId(9);
//		info.setGoodname("娃哈哈果奶");
//		info.setGoodcode("08002");
//		info.setTypename("奶制品");
//		info.setUnitprice(2.0);
//		info.setUnitSymbol("瓶");
//		goodService.modifyGoodInfo(info);
//	}
	
//	@Test
//	public void testModifyGoodsType(){
//		GoodInfo info1=new GoodInfo();
//		info1.setId(2);
//		info1.setGoodcode("07001");
//		info1.setGoodname("德芙牛奶巧克力");
//		info1.setTypename("糖果");
//		info1.setUnitprice(6.9);
//		info1.setUnitSymbol("袋");
//		GoodInfo info2=new GoodInfo();
//		info2.setId(3);
//		info2.setGoodcode("07002");
//		info2.setGoodname("好时黑巧克力");
//		info2.setTypename("糖果");
//		info2.setUnitprice(7.2);
//		info2.setUnitSymbol("袋");
//		List<GoodInfo> list=new ArrayList<GoodInfo>();
//		list.add(info1);
//		list.add(info2);
//		goodService.modifyGoodsType(list,"09");
//	}
//	
	@Test
	public void testDeleteGood(){
		GoodInfo info1=new GoodInfo();
		info1.setId(9);
		info1.setGoodcode("0802");
		info1.setGoodname("挖哈哈哈果奶");
		info1.setTypename("奶制品");
		info1.setUnitprice(2);
		info1.setUnitSymbol("瓶");
		goodService.deleteGood(info1);
	}
//	
//	@Test
//	public void testDeleteGoods(){
//		GoodInfo info1=new GoodInfo();
//		info1.setId(7);
//		info1.setGoodcode("06001");
//		info1.setGoodname("开心果");
//		info1.setTypename("坚果");
//		info1.setUnitprice(15);
//		info1.setUnitSymbol("袋");
//		GoodInfo info2=new GoodInfo();
//		info2.setId(8);
//		info2.setGoodcode("06002");
//		info2.setGoodname("腰果");
//		info2.setTypename("坚果");
//		info2.setUnitprice(9.8);
//		info2.setUnitSymbol("袋");
//		List<GoodInfo> list=new ArrayList<GoodInfo>();
//		list.add(info1);
//		list.add(info2);
//		goodService.deleteGoods(list);
//	}

}
