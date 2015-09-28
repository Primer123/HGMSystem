package service.impl;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;
import model.LogFileInfo;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.LogFileService;

public class LogFileServiceImplTest extends TestCase {
	
	ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
			"applicationContext.xml");
	LogFileService logfileService = (LogFileService) ctx.getBean("LogFileService");
	
//	@Test
//	public void testSearchLogFile1() {
//		List<LogFileInfo> list=logfileService.searchLogFile(null,"2015-04-24 13:00:00","2015-04-25 19:00:00");
//        assertEquals(list.size(),6);	
//        assertEquals(list.get(1).getOperation(),"test");
//	}
//	
//	@Test
//	public void testSearchLogFile2() {
//		List<LogFileInfo> list=logfileService.searchLogFile("C0001",null,null);
//        assertEquals(list.size(),2);	
//        assertEquals(list.get(0).getOperation(),"TEEST");
//        assertEquals(list.get(1).getOperation(),"TEST");
//		
//	}
//	
//	@Test
//	public void testSearchLogFile3() {
//		List<LogFileInfo> list=logfileService.searchLogFile("C0001","2015-04-25 01:00:00","2015-04-25 19:00:00");
//        assertEquals(list.size(),1);	
//        assertEquals(list.get(0).getOperation(),"TEST");
//		
//	}
	
	@Test
	public void testDeleteLogFile(){
		LogFileInfo info=new LogFileInfo();
		info.setId(10);
		info.setStaffid("S0002");
		info.setOperation("RING");
		logfileService.deleteLogFile(info);
	}
	
	@Test
	public void testDeleteLogFiles(){
		LogFileInfo info=new LogFileInfo();
		info.setId(10);
		info.setStaffid("S0002");
		info.setOperation("RING");
		LogFileInfo info2=new LogFileInfo();
		info2.setId(9);
		info2.setStaffid("S0001");
		info2.setOperation("HHHH");
		List<LogFileInfo> list=new ArrayList<LogFileInfo>();
		list.add(info);
		list.add(info2);
		logfileService.deleteLogFiles(list);
	}

}
