package service;

import java.util.List;

import model.GoodInfo;

public interface GoodService {
	/*
	 * �鿴������Ʒ��Ϣ
	 */
    public List<GoodInfo> getAllGoods(); 
    
    /*
     *��ѯ��Ʒ����µ�������Ʒ 
     */
    public List<GoodInfo> searchGoodByType(List<String> typecodelist);
    
    public List<GoodInfo> searchGoodByTypecode(String typecode);
    
    public List<GoodInfo> searchGoodByTypename(String typename);
    
    public GoodInfo searchByName(String goodname);
    
    public List<GoodInfo> searchByUnitprice(double price);
    
    public int judgeKeyword(String keyword);
    
    public List<GoodInfo> searchByKeywordTypename(int keywordtype,String keyword,String typename);
    
    /*
     * ͨ����Ʒ��������Ʒ��Ϣ
     */
    public GoodInfo getGoodByCode(String goodcode);
	
    /*
     * �����µ���Ʒ
     */
	public boolean addNewGood(GoodInfo goodinfo);
	
	/*
	 * �޸���Ʒ��Ϣ
	 */
	public void modifyGoodInfo(GoodInfo goodinfo);
	
	/*
	 * �����޸���Ʒ����Ʒ���ͨ����ɾ����Ʒ���ʱ���ã�
	 */
	public void modifyGoodsType(List<GoodInfo> goodlist, String typecode);
	
	/*
	 * ɾ����Ʒ
	 */
	public void deleteGood(GoodInfo goodinfo);
	
	/*
	 * ����ɾ����Ʒ
	 */
	public void deleteGoods(List<GoodInfo> goodlist);
	
	
}