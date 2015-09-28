package service.impl;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;
import model.FloorInfo;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.FloorService;

public class FloorServiceImplTest extends TestCase{

	ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
			"applicationContext.xml");
	FloorService floorService = (FloorService) ctx.getBean("FloorService");
	
//	@Test
//	public void testGetAllInfo() {
//		List<FloorInfo> list=floorService.getAllInfo();
//		assertEquals(list.get(1).getFloorname(),"5Â¥");
//	}
//
//	@Test
//	public void testAddNewFloor1() {
//		FloorInfo info=new  FloorInfo();
//		info.setFloorname("15");
//		assertEquals(floorService.addNewFloor(info),true);
//	}
//	
//	@Test
//	public void testAddNewFloor2() {
//		FloorInfo info=new  FloorInfo();
//		info.setFloorname("1Â¥");
//		assertEquals(floorService.addNewFloor(info),false);
//	}
	
//	@Test
//	public void testModifyFloorInfo(){
//		FloorInfo info=new FloorInfo();
//		info.setId(13);
//		info.setFloorname("1Â¥");
//		info.setRemarks("ÓÐ»áÒéÊÒ");
//		floorService.modifyFloorInfo(info);
//	}
	
//	@Test
//	public void testDeleteFloor() {
//		FloorInfo info=new  FloorInfo();
//		info.setId(14);
//		info.setFloorname("15Â¥");
//		assertEquals(floorService.deleteFloor(info),true);
//	}
	
	@Test
	public void testDeleteFloors1(){
		FloorInfo info1=new  FloorInfo();
		info1.setId(10);
		info1.setFloorname("13Â¥");
		FloorInfo info2=new  FloorInfo();
		info2.setId(11);
		info2.setFloorname("14Â¥");
		List<FloorInfo> list=new ArrayList<FloorInfo>();
		list.add(info1);
		list.add(info2);
		assertEquals(floorService.deleteFloors(list),true);
	}
	
	@Test
	public void testDeleteFloors2(){
		FloorInfo info1=new  FloorInfo();
		info1.setId(13);
		info1.setFloorname("1Â¥");
		List<FloorInfo> list=new ArrayList<FloorInfo>();
		list.add(info1);
		assertEquals(floorService.deleteFloors(list),false);
	}
}
