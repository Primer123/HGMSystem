package service.impl;

import junit.framework.TestCase;
import model.GoodTypeInfo;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import service.GoodTypeService;

public class GoodTypeServiceImplTest extends TestCase {

	ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
			"applicationContext.xml");
	GoodTypeService goodtypeService = (GoodTypeService) ctx.getBean("GoodTypeService");
	
//	@Test
//	public void testGetAllInfo() {
//		List<GoodTypeInfo> list=goodtypeService.getAllInfo();
//        assertEquals(list.get(5).getTypename(),"���");
//	}
//
//	@Test
//	public void testAddNewGoodType1() {
//		GoodTypeInfo type=new GoodTypeInfo();
//		type.setTypename("��ԡ��Ʒ");
//		assertEquals(goodtypeService.addNewGoodType(type),true);
//	}
//	
//	@Test
//	public void testAddNewGoodType2() {
//		GoodTypeInfo type=new GoodTypeInfo();
//		type.setTypename("��");
//		assertEquals(goodtypeService.addNewGoodType(type),false);
//	}

//	@Test
//	public void testModifyGoodTypeInfo() {
//		GoodTypeInfo type=new GoodTypeInfo();
//		type.setId(10);
//		type.setTypename("��ԡ��Ʒ");
//		type.setTypecode("10");
//		type.setRemarks("û������");
//		goodtypeService.modifyGoodTypeInfo(type);
//	}

//	@Test
//	public void testHasGood() {
//		GoodTypeInfo info=new GoodTypeInfo();
//		info.setTypecode("01");
//		assertEquals(goodtypeService.hasGood(info),true);
//	}
//
	@Test
	public void testDeleteGoodType() {
		GoodTypeInfo type=new GoodTypeInfo();
		type.setId(10);
		type.setTypename("��ԡ��Ʒ");
		type.setTypecode("09");
		type.setRemarks("û������");
		goodtypeService.deleteGoodType(type);
	}

}
