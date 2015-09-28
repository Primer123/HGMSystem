package service;

import java.util.List;

import model.FloorInfo;

public interface FloorService {

    public List<FloorInfo> getAllInfo(); 
	
	public boolean addNewFloor(FloorInfo floorinfo);
	
	public void modifyFloorInfo(FloorInfo floorinfo);
	
	public boolean deleteFloor(FloorInfo floorinfo);
	
	public boolean deleteFloors(List<FloorInfo> floorlist);
	
	public FloorInfo searchByFloorname(String floor);
}
