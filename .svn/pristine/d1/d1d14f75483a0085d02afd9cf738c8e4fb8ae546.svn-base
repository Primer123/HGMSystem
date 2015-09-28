package service.impl;

import java.util.ArrayList;
import java.util.List;

import model.GoodInfo;
import dao.GoodDao;
import dao.GoodTypeDao;
import entity.Good;
import service.GoodService;

public class GoodServiceImpl implements GoodService {
	private GoodDao goodDao;
	private GoodTypeDao goodTypeDao;

	@Override
	public List<GoodInfo> getAllGoods() {
		List<GoodInfo> infolist=new ArrayList<GoodInfo>();
		List<Good> entitylist=goodDao.findAll();
		for(int i=0;i<entitylist.size();i++){
			infolist.add(convertEntity(entitylist.get(i)));
		}
		return infolist;
	}
	
	@Override
	public List<GoodInfo> searchGoodByType(List<String> typecodelist) {
		List<Good> entitylist=new ArrayList<Good>();
		for(int i=0;i<typecodelist.size();i++){
			entitylist.addAll(goodDao.findByTypecode(typecodelist.get(i)));
		}
		List<GoodInfo> infolist=new ArrayList<GoodInfo>();
		for(int j=0;j<entitylist.size();j++){
			infolist.add(convertEntity(entitylist.get(j)));
		}
		return infolist;
	}
	
	@Override
	public List<GoodInfo> searchGoodByTypecode(String typecode) {
		List<Good> entitylist=goodDao.findByTypecode(typecode);
		List<GoodInfo> infolist=new ArrayList<GoodInfo>();
		if(entitylist!=null){			
			for(int j=0;j<entitylist.size();j++){
				infolist.add(convertEntity(entitylist.get(j)));
			}			
		}
		return infolist;
	}
	
	@Override
	public List<GoodInfo> searchGoodByTypename(String typename) {
		String typecode=goodTypeDao.findByTypename(typename).getTypecode();
		List<Good> entitylist=goodDao.findByTypecode(typecode);
		List<GoodInfo> infolist=new ArrayList<GoodInfo>();
		if(entitylist!=null){			
			for(int j=0;j<entitylist.size();j++){
				infolist.add(convertEntity(entitylist.get(j)));
			}			
		}
		return infolist;
	}

	@Override
	public GoodInfo searchByName(String goodname) {
		Good entity=goodDao.findByGoodName(goodname);
		if(entity!=null){
			GoodInfo info=convertEntity(entity);
			return info;
		}
		return null;
	}

	@Override
	public List<GoodInfo> searchByUnitprice(double price) {
		List<Good> entitylist=goodDao.findByUnitPrice(price, price);
		List<GoodInfo> infolist=new ArrayList<GoodInfo>();
		if(entitylist!=null){			
			for(int j=0;j<entitylist.size();j++){
				infolist.add(convertEntity(entitylist.get(j)));
			}			
		}
		return infolist;
	}
	
	@Override
	public int judgeKeyword(String keyword) {
		int keywordtype=0;//0 is goodcode, 1 is goodname
		char array[]=keyword.toCharArray();
		if(keyword.length()!=5){
			keywordtype=1;
		}
		else{
			for(int i=0;i<array.length;i++){
				if(array[i]>'9'||array[i]<'0'){
					keywordtype=1;
					break;
				}
			}
		}	
		
		return keywordtype;
	}
	
	@Override
	public List<GoodInfo> searchByKeywordTypename(int keywordtype ,String keyword,
			String typename) {
		List<GoodInfo> goodlist=searchGoodByTypename(typename);
		List<GoodInfo> result=new ArrayList<GoodInfo>();
		if(keywordtype==0){
			for(int i=0;i<goodlist.size();i++){
				if(goodlist.get(i).getGoodcode().equals(keyword)){
					result.add(goodlist.get(i));
				}
			}
		}
		else{
			for(int i=0;i<goodlist.size();i++){
				if(goodlist.get(i).getGoodname().equals(keyword)){
					result.add(goodlist.get(i));
				}
			}
		}
		return result;
	}
	
	@Override
	public GoodInfo getGoodByCode(String goodcode) {
		// TODO Auto-generated method stub
		Good good = goodDao.findByGoodCode(goodcode);
		if(good != null) {
			return new GoodInfo();
		}
		
		GoodInfo goodInfo = convertEntity(good);
		
		return goodInfo;
	}
	

	private boolean goodExisted(String goodname) {
		Good good=goodDao.findByGoodName(goodname);
		if(good!=null)
			return true;
		else
		    return false;
	}

	private String newGoodCode(String typename) {
		String code=goodTypeDao.findByTypename(typename).getTypecode();
     	List<Good> allgood=goodDao.findByTypecode(code);
		int num=allgood.size();
		num++;		
		if(num<10){
			code+="00"+num;
		}
		else if(100>num&&num>=10){
			code+="0"+num;
		}
		else{
			code+=num;
		}
		return code;
	}
	
	@Override
	public boolean addNewGood(GoodInfo goodinfo) {
		if(!goodExisted(goodinfo.getGoodname())){
			Good entity=convertInfo(goodinfo);
			entity.setGoodcode(newGoodCode(goodinfo.getTypename()));
			goodDao.create(entity);	
			return true;
		}
		return false;
	}
	
	@Override
	public void modifyGoodInfo(GoodInfo goodinfo) {
		Good entity=convertInfo(goodinfo);
		Good entity2=goodDao.findById(goodinfo.getId());
		if(!entity.getTypecode().equals(entity2.getTypecode())){
			entity.setGoodcode(newGoodCode(goodinfo.getTypename()));
		}
		goodDao.modify(entity);		
	}
	

	@Override
	public void modifyGoodsType(List<GoodInfo> goodlist, String typecode) {
		List<Good> entitylist=new ArrayList<Good>();
		for(int i=0;i<goodlist.size();i++){
			entitylist.add(convertInfo(goodlist.get(i)));
		}
		for(int j=0;j<entitylist.size();j++){
			entitylist.get(j).setTypecode(typecode);
		}
		goodDao.modify(entitylist);
	}
	
	@Override
	public void deleteGood(GoodInfo goodinfo) {
		Good entity=convertInfo(goodinfo);
		goodDao.delete(entity);		
	}
	
	@Override
	public void deleteGoods(List<GoodInfo> goodlist) {
		List<Good> entitylist=new ArrayList<Good>();
		for(int i=0;i<goodlist.size();i++){
			entitylist.add(convertInfo(goodlist.get(i)));
		}
		goodDao.delete(entitylist);
	}
	
	private GoodInfo convertEntity(Good entity){
		GoodInfo info=new GoodInfo();
		info.setId(entity.getId());
		info.setGoodcode(entity.getGoodcode());
		info.setGoodname(entity.getGoodname());
		String typename=goodTypeDao.findByTypecode(entity.getTypecode()).getTypename();
		info.setTypename(typename);
		info.setUnitprice(entity.getUnitprice());
		info.setUnitSymbol(entity.getUnitSymbol());
		info.setRemarks(entity.getRemarks());
		return info;
	}
	
	private Good convertInfo(GoodInfo info){
		Good entity=new Good();
		if(info.getId() != 0) {
			entity.setId(info.getId());
		}
		entity.setGoodcode(info.getGoodcode());
		entity.setGoodname(info.getGoodname());
		String typecode=goodTypeDao.findByTypename(info.getTypename()).getTypecode();
		entity.setTypecode(typecode);
		entity.setUnitprice(info.getUnitprice());
		entity.setUnitSymbol(info.getUnitSymbol());
		entity.setRemarks(info.getRemarks());
		return entity;
	}
	
	public GoodDao getGoodDao() {
		return goodDao;
	}
	public void setGoodDao(GoodDao goodDao) {
		this.goodDao = goodDao;
	}
	public GoodTypeDao getGoodTypeDao() {
		return goodTypeDao;
	}
	public void setGoodTypeDao(GoodTypeDao goodTypeDao) {
		this.goodTypeDao = goodTypeDao;
	}	
}
