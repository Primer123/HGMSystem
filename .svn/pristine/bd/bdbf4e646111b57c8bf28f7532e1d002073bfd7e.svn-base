package dao;

import java.util.List;

import entity.Room;
import entity.RoomType;

public interface RoomTypeDao {

	public void create(RoomType roomType);

	public void modify(RoomType roomType);

	public void delete(RoomType roomType);

	public RoomType findById(int id);

	public List<RoomType> findByTypename(String typename);

	public List<RoomType> findByAdult(int num);

	public List<RoomType> findByKid(int num);
	
	public List<RoomType> findByAdultKid(int numofadult, int numofkid);
	
	public List<RoomType> findByBedType(int bedtype);

	public List<Room> findByStdprice(double min, double max);

	public List<Room> findByDiscprice(double min, double max);

	public List<Room> findByRmprice(double min, double max);

	public List<Room> findByVmprice(double min, double max);

	public List<RoomType> findAll();
}
