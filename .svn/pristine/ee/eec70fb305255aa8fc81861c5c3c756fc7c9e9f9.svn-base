package service.impl;

import static org.junit.Assert.*;

import java.util.List;

import model.StaffInfo;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.StaffService;

public class StaffServiceImplTest {

	ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
			"applicationContext.xml");
	StaffService staffService = (StaffService) ctx.getBean("StaffService");

	@Test
	public void testGetStaffList() {
		List<StaffInfo> staffList = staffService.getStaffList();
		
		assertEquals(staffList.get(0).getStaffid(), "A0001");
	}
	
	 @Test
	 public void testSearchStaffByName() {
		 List<StaffInfo> staffList = staffService.searchStaffByName("李云轩");
		 
		 StaffInfo staff = staffList.get(0);
		 assertEquals(staff.getStaffid(), "A0001");
	 }
	
	 @Test
	 public void testSearchStaffByProposition() {
		 List<StaffInfo> staffList = staffService.searchStaffByProposition("管理员");
		 
		 assertEquals(staffList.size(), 2);
	 }
	
	 @Test
	 public void testSearchStaffByStaffid() {
	 	StaffInfo staff = staffService.searchStaffByStaffid("A0002");
	 	assertEquals(staff.getStaffname(), "徐玉立");
	 	
	 	staff = staffService.searchStaffByStaffid("ss");
	 	assertEquals(staff.getStaffname(), null);
	 }
	
	 @Test
	 public void testAddNewStaff() {
		StaffInfo staffInfo = new StaffInfo();
		staffInfo.setPosition("前台");
		staffInfo.setStaffname("大白");
		staffInfo.setPassword("ilovenju");
		staffInfo.setRemarks("我是大白！");
//		staffService.addNewStaff(staffInfo);
	 }
	
	 @Test
	 public void testModifyStaffInfo() {
	 	StaffInfo staffInfo = staffService.searchStaffByStaffid("S0002");
	 	staffInfo.setPassword("ilovenju");
	 	
	 	staffService.modifyStaffInfo(staffInfo);
	 }
	
	 @Test
	 public void testDeleteStaff() {
		 StaffInfo staffInfo = staffService.searchStaffByStaffid("C0006");
		 
		 staffService.deleteStaff(staffInfo);
	 }
	
	 @Test
	 public void testLogin() {
	 	assertEquals(staffService.login("aa", "12"), false);
	 	assertEquals(staffService.login("A0001", "12"), false);
	 	assertEquals(staffService.login("A0001", "123456"), true);
	 }

}
