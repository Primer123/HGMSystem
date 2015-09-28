package dao;

import java.util.List;

import entity.Good;


public interface GoodDao {
	public void create(Good good);
	
	public void modify(Good good);
	
	public void delete(Good good);
	
	public void modify(List<Good> goods);
	
	public void delete(List<Good> goods);

	public Good findById(int id);
	
	public Good findByGoodCode(String goodcode);
	
	public Good findByGoodName(String goodname);
	
	public List<Good> findByTypecode(String typecode);
	
	public List<Good> findByUnitPrice(double unitprice1, double unitprice2);
	
	public List<Good> findAll();
}
