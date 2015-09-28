package dao;

import java.util.List;

import entity.GoodType;

public interface GoodTypeDao {
	public void create(GoodType goodType);
	
	public void modify(GoodType goodType);
	
	public void delete(GoodType goodType);
	
	public void delete(List<GoodType> goodTypes);
	
	public GoodType findById(int id);
	
	public GoodType findByTypecode(String typecode);
	
	public GoodType findByTypename(String typename);
	
	public List<GoodType> findAll();
}
