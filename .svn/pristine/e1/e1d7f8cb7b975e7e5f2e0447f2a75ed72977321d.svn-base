package service.impl;

import java.util.List;
import java.util.Map;

import junit.framework.TestCase;
import model.RoomTypeInfo;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.RoomTypeService;

public class RoomTypeServiceImplTest extends TestCase {

	ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
			"applicationContext.xml");
	RoomTypeService roomtypeService = (RoomTypeService) ctx.getBean("RoomTypeService");
	
//	@Test
//	public void testGetTargetRoomTypeMap() {
//		Map<String,List<RoomTypeInfo>> map=roomtypeService.getTargetRoomType(
//				"2015-04-28","2015-05-01",2,1);
//	    List<RoomTypeInfo> list1=map.get("普通客房");
//	    List<RoomTypeInfo> list2=map.get("精品客房");
//	    List<RoomTypeInfo> list3=map.get("豪华客房");
//	    List<RoomTypeInfo> list4=map.get("超豪华客房");
//	    assertEquals(list2.size(),3);
//	    assertEquals(list4.size(),0);
//	    assertEquals(list1.size(),5);
//	    assertEquals(list3.size(),2);
//	}
	
//	@Test
//	public void testGetTargetRoomTypeInt1() {
//		int typeid=roomtypeService.getTargetRoomType("2015-04-28","2015-05-01",2,1,"豪华客房",1);
//	    assertEquals(typeid,-1);
//	}
//	
//	@Test
//	public void testGetTargetRoomTypeInt2() {
//		int typeid=roomtypeService.getTargetRoomType("2015-04-28","2015-05-01",2,1,"普通客房",1);
//	    assertEquals(typeid,1);
//	}
//	
//	@Test
//	public void testGetTargetRoomType(){
//		RoomTypeInfo info=roomtypeService.getTargetRoomType("80201");
//		assertEquals(info.getId(), 2);
//		assertEquals(info.getNumofadult(), 3);
//	}
	
//	@Test
//	public void testGetRoomTypeList() {
//		List<RoomTypeInfo> list=roomtypeService.getRoomTypeList();
//		System.out.println(list.size());
//		assertEquals(list.get(1).getId(),2);
//	}
	
//	@Test
//	public void testAddNewRoomType() {
//		RoomTypeInfo info=new RoomTypeInfo();
//		info.setTypename("超豪华客房");
//		info.setNumofadult(2);
//		info.setNumofkid(1);
//		info.setBedtype(2);
//		info.setStdprice(1000);
//		info.setDiscprice(1000);
//		info.setRmprice(1000);
//		info.setVmprice(1000);
//		roomtypeService.addNewRoomType(info);
//	}
	
//	@Test
//	public void testModifyRoomTypeInfo() {
//		RoomTypeInfo info=new RoomTypeInfo();
//		info.setId(15);
//		info.setTypename("超豪华客房");
//		info.setNumofadult(2);
//		info.setNumofkid(1);
//		info.setBedtype(2);
//		info.setStdprice(1000);
//		info.setDiscprice(1000);
//		info.setRmprice(1000);
//		info.setVmprice(999);
//		roomtypeService.modifyRoomTypeInfo(info);		
//	}
	
//	@Test
//	public void testDeleteRoomType1() {
//		RoomTypeInfo info=new RoomTypeInfo();
//		info.setId(15);
//		info.setTypename("超豪华客房");
//		info.setNumofadult(2);
//		info.setNumofkid(1);
//		info.setBedtype(2);
//		info.setStdprice(1000);
//		info.setDiscprice(1000);
//		info.setRmprice(1000);
//		info.setVmprice(999);
//		assertEquals(roomtypeService.deleteRoomType(info),true);		
//	}
//	
	@Test
	public void testDeleteRoomType2() {
		RoomTypeInfo info=new RoomTypeInfo();
		info.setId(1);
		assertEquals(roomtypeService.deleteRoomType(info),false);		
	}	

}
