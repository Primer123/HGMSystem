package service.impl;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;
import model.RoomInfo;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.RoomService;

public class RoomServiceImplTest extends TestCase{

	ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
			"applicationContext.xml");
	RoomService roomService = (RoomService) ctx.getBean("RoomService");
	
//	@Test
//	public void testGetTargetRooms() {
//		List<String> pro=new ArrayList<String>();
//		pro.add("无烟");
//		pro.add("无Wifi");
//		List<RoomInfo> list=roomService.getTargetRooms("2015-04-28","2015-05-01",1,"2楼",pro);
//		assertEquals(list.size(),1);
//		assertEquals(list.get(0).getRoomnum(),"80205");
//	}
//	
//	@Test
//	public void testNewRoomnum() {
//		assertEquals(roomService.newRoomNum(8),"80801");
//	}
	
//	@Test
//	public void testAddNewRoom() {
//		RoomInfo room1=new RoomInfo();
//		RoomInfo room2=new RoomInfo();
//		RoomInfo room3=new RoomInfo();
//		room1.setRoomnum("80502");
//		room1.setTypeid(1);
//		room1.setRoomstate(0);
//		room1.setFloorname("5楼");
//		room1.setProperties("有烟/有Wifi");
//		room2.setRoomnum("80503");
//		room2.setTypeid(2);
//		room2.setRoomstate(0);
//		room2.setFloorname("5楼");
//		room2.setProperties("有烟/有Wifi");
//		room3.setRoomnum("80504");
//		room3.setTypeid(3);
//		room3.setRoomstate(0);
//		room3.setFloorname("5楼");
//		room3.setProperties("有烟/有Wifi");
//		roomService.addNewRoom(room1);
//		roomService.addNewRoom(room2);
//		roomService.addNewRoom(room3);
//	}
	
//	@Test
//	public void testModifyRoomInfo() {
//		RoomInfo room1=new RoomInfo();
//		room1.setId(22);
//		room1.setRoomnum("80502");
//		room1.setTypeid(1);
//		room1.setRoomstate(0);
//		room1.setFloorname("5楼");
//		room1.setProperties("有烟/有Wifi");
//		room1.setRemarks("海景房！");
//		roomService.modifyRoomInfo(room1);
//	}
//	
	@Test
	public void testDeleteRoom() {
		RoomInfo room1=new RoomInfo();
		room1.setId(22);
		room1.setRoomnum("80502");
		room1.setTypeid(1);
		room1.setRoomstate(0);
		room1.setFloorname("5楼");
		room1.setProperties("有烟/有Wifi");
		room1.setRemarks("海景房！");
		roomService.deleteRoom(room1);
	}
	
	@Test
	public void testDeleteRooms() {
		RoomInfo room2=new RoomInfo();
		RoomInfo room3=new RoomInfo();
		room2.setId(23);
		room2.setRoomnum("80503");
		room2.setTypeid(2);
		room2.setRoomstate(0);
		room2.setFloorname("5楼");
		room2.setProperties("有烟/有Wifi");
		room3.setId(24);
		room3.setRoomnum("80504");
		room3.setTypeid(3);
		room3.setRoomstate(0);
		room3.setFloorname("5楼");
		room3.setProperties("有烟/有Wifi");
		List<RoomInfo> list=new ArrayList<RoomInfo>();
		list.add(room2);
		list.add(room3);
		roomService.deleteRooms(list);
	}
}
