package service;

import java.util.List;

import model.GoodInfo;

public interface GoodService {
	/*
	 * 查看所有商品信息
	 */
    public List<GoodInfo> getAllGoods(); 
    
    /*
     *查询商品类别下的所有商品 
     */
    public List<GoodInfo> searchGoodByType(List<String> typecodelist);
    
    public List<GoodInfo> searchGoodByTypecode(String typecode);
    
    public List<GoodInfo> searchGoodByTypename(String typename);
    
    public GoodInfo searchByName(String goodname);
    
    public List<GoodInfo> searchByUnitprice(double price);
    
    public int judgeKeyword(String keyword);
    
    public List<GoodInfo> searchByKeywordTypename(int keywordtype,String keyword,String typename);
    
    /*
     * 通过商品代码获得商品信息
     */
    public GoodInfo getGoodByCode(String goodcode);
	
    /*
     * 添加新的商品
     */
	public boolean addNewGood(GoodInfo goodinfo);
	
	/*
	 * 修改商品信息
	 */
	public void modifyGoodInfo(GoodInfo goodinfo);
	
	/*
	 * 批量修改商品的商品类别（通常在删除商品类别时调用）
	 */
	public void modifyGoodsType(List<GoodInfo> goodlist, String typecode);
	
	/*
	 * 删除商品
	 */
	public void deleteGood(GoodInfo goodinfo);
	
	/*
	 * 批量删除商品
	 */
	public void deleteGoods(List<GoodInfo> goodlist);
	
	
}
