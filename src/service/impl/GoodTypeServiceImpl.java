package service.impl;

import java.util.ArrayList;
import java.util.List;

import model.GoodTypeInfo;
import dao.GoodDao;
import dao.GoodTypeDao;
import entity.Good;
import entity.GoodType;
import service.GoodTypeService;

public class GoodTypeServiceImpl implements GoodTypeService {
	private GoodTypeDao goodTypeDao;
	private GoodDao goodDao;
	
	@Override
	public List<GoodTypeInfo> getAllInfo() {
		List<GoodType> entitylist=goodTypeDao.findAll();
		List<GoodTypeInfo> infolist=new ArrayList<GoodTypeInfo>();
		for(int i=0;i<entitylist.size();i++){
			infolist.add(convertEntity(entitylist.get(i)));
		}
		return infolist;
	}
	
	@Override
	public int judgeKeyword(String keyword) {
		char array[]=keyword.toCharArray();
		int judge=0;//0 is typecode, 1 is typename
		if(keyword.equals("0")||keyword.equals("00")){
			judge=1;
		}
		for(int i=0;i<keyword.length();i++){
			if(array[i]<'0'&&array[i]>'9'){
				judge=1;
				break;
			}
		}
		if(keyword.length()>2){
			judge=1;
		}
			
		return judge;
	}	
	
	private boolean goodTypeExisted(String typename) {
		GoodType type=goodTypeDao.findByTypename(typename);
		if(type!=null)
			return true;
		else
		    return false;
	}

	private String newGoodTypeCode() {
		List<GoodType> entitylist=goodTypeDao.findAll();
		int account=entitylist.size();
		account++;		
		String typecode="";
		if(account<10){
			typecode+="0"+account;
		}
		else{
			typecode+=account;
		}
		return typecode;
	}
	
	@Override
	public boolean addNewGoodType(GoodTypeInfo goodtypeinfo) {
		if(!goodTypeExisted(goodtypeinfo.getTypename())){
			GoodType entity=convertInfo(goodtypeinfo);
			entity.setTypecode(newGoodTypeCode());
			goodTypeDao.create(entity);
			return true;
		}
		return false;
	}
	
	@Override
	public void modifyGoodTypeInfo(GoodTypeInfo goodtypeinfo) {
		GoodType entity=convertInfo(goodtypeinfo);
		goodTypeDao.modify(entity);
	}
	
	@Override
	public boolean hasGood(GoodTypeInfo goodtypeinfo) {
		List<Good> goodlist=goodDao.findByTypecode(goodtypeinfo.getTypecode());
		if(goodlist!=null)
			return true;
		else
			return false;
	}
	
	@Override
	public void deleteGoodType(GoodTypeInfo goodtypeinfo) {
		GoodType entity=convertInfo(goodtypeinfo);
		goodTypeDao.delete(entity);
	}
	
	@Override
	public GoodTypeInfo searchByTypecode(String typecode) {
		GoodType type=goodTypeDao.findByTypecode(typecode);
		if(type!=null){
			GoodTypeInfo info=convertEntity(type);
			return info;
		}
		return null;
	}
	
	@Override
	public GoodTypeInfo searchByTypename(String typename) {
		GoodType type=goodTypeDao.findByTypename(typename);
		if(type!=null){
			GoodTypeInfo info=convertEntity(type);
			return info;
		}
		return null;
	}
	
	private GoodTypeInfo convertEntity(GoodType entity){
		GoodTypeInfo info=new GoodTypeInfo();
		info.setId(entity.getId());
		info.setTypecode(entity.getTypecode());
		info.setTypename(entity.getTypename());
		info.setRemarks(entity.getRemarks());
		return info;
	}
	
	private GoodType convertInfo(GoodTypeInfo info){
		GoodType entity=new GoodType();
		entity.setId(info.getId());
		entity.setTypecode(info.getTypecode());
		entity.setTypename(info.getTypename());
		entity.setRemarks(info.getRemarks());
		return entity;
	}
	
	public GoodTypeDao getGoodTypeDao() {
		return goodTypeDao;
	}
	public void setGoodTypeDao(GoodTypeDao goodTypeDao) {
		this.goodTypeDao = goodTypeDao;
	}
	public GoodDao getGoodDao() {
		return goodDao;
	}
	public void setGoodDao(GoodDao goodDao) {
		this.goodDao = goodDao;
	}



}
