package service.impl;

import java.util.ArrayList;
import java.util.List;

import model.CheckinInfo;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.CheckinRcdSearchService;

public class CheckinRcdSearchServiceImplTest {
	ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
			"applicationContext.xml");
	CheckinRcdSearchService checkinRcdSearchService = (CheckinRcdSearchService) ctx
			.getBean("CheckinRcdSearchService");

	@Test
	public void testSearchCheckinInfo() {
		List<CheckinInfo> checkinInfos = new ArrayList<CheckinInfo>();
//
//		checkinInfos = checkinRcdSearchService.searchCheckinInfo("", "", "",
//				"", "", "");
//		assertEquals(checkinInfos.size(), 0);
//
//		checkinInfos = checkinRcdSearchService.searchCheckinInfo(
//				"201502038010101", "", "", "", "", "");
//		assertEquals(checkinInfos.get(0).getRoomnum(), "80101");
//		
//		checkinInfos = checkinRcdSearchService.searchCheckinInfo(
//				"201502048010201", "", "80101", "", "", "");
//		assertEquals(checkinInfos.size(), 0);
//		
//		checkinInfos = checkinRcdSearchService.searchCheckinInfo(
//				"201502048010201", "", "80102", "", "", "");
//		assertEquals(checkinInfos.size(), 1);
//		
//		checkinInfos = checkinRcdSearchService.searchCheckinInfo(
//				"", "普通客房", "", "", "", "");
//		assertEquals(checkinInfos.size(), 6); 
//		
//		checkinInfos = checkinRcdSearchService.searchCheckinInfo(
//				"", "", "", "徐玉立", "", "");
//		assertEquals(checkinInfos.size(), 1); 
//		
//		checkinInfos = checkinRcdSearchService.searchCheckinInfo(
//				"", "", "", "", "2015-02-02 16:36:24", "2015-02-02 12:36:48");
//		assertEquals(checkinInfos.size(), 0); 
		
//		checkinInfos = checkinRcdSearchService.searchCheckinInfo(
//				"", "", "80301", "徐立立", "2015-04-19 11:30:40", "2015-04-19 13:00:00");
//		assertEquals(checkinInfos.size(), 0);
	}

}
