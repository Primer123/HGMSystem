package action;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.stereotype.Component;

import service.FloorService;
import model.FloorInfo;

@ParentPackage(value="json-default")
@Results({@Result(name="success", location="/jsp/FloorManage.jsp"),
	@Result(name="fail", location="/jsp/FloorManage.jsp")})
@Component
public class FloorManageAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private FloorInfo floor;

	@Resource
	private FloorService floorService;		

	public FloorInfo getFloor() {
		return floor;
	}

	public void setFloor(FloorInfo floor) {
		this.floor = floor;
	}

	public FloorService getFloorService() {
		return floorService;
	}

	public void setFloorService(FloorService floorService) {
		this.floorService = floorService;
	}

	@Action(value = "/floorsearch")//20
    public String searchFloor() throws Exception {
		super.execute();
		boolean judge=true;
		int floor=0;
		String keyword=request.getParameter("keyword");
		char array[]=keyword.toCharArray();	
		if(keyword.equals("0")||keyword.equals("00")){
			judge=false;
		}
		else if(keyword.length()>2){
			judge=false;
		}
		else{			
			for(int i=0;i<array.length;i++){
				if(array[i]>'9'||array[i]<'0'){
					judge=false;
					break;
				}
			}
		}		
		
		if(judge){	
			if(array[0]=='0'){
				floor=(int)array[1];
			}
			else{
				floor=Integer.parseInt(keyword);
			}
			
			if(floorService.searchByFloorname(floor+"¥")!=null){
				FloorInfo floorinfo=floorService.searchByFloorname(floor+"¥");
				request.setAttribute("floorresult", floorinfo);
				return "success";
			}
		}
		
		request.setAttribute("floorresult", null);
		return "fail";		
	}	
	
	@Action(value= "/add")//60
	public String createFloor() throws Exception {
		super.execute();
		FloorInfo floorinfo=new FloorInfo();
		floorinfo.setFloorname(request.getParameter("floorname"));
		floorinfo.setRemarks(request.getParameter("remarks"));
		if(floorService.addNewFloor(floorinfo)){
			return "success";			
		}
		else{
			return "fail";
		}
	} 
	
    @Action(value="/update")
    public String modifyFloor() throws Exception {
    	super.execute();
    	FloorInfo floorinfo=new FloorInfo();
    	floorinfo.setId(Integer.parseInt(request.getParameter("id")));
		floorinfo.setFloorname(request.getParameter("floorname"));
		floorinfo.setRemarks(request.getParameter("remarks"));
		floorService.modifyFloorInfo(floorinfo);
		return "success";
	}
    
	@Action(value="/delete")
    public String deleteFloor() throws Exception {
		super.execute();
		FloorInfo floorinfo=new FloorInfo();
    	floorinfo.setId(Integer.parseInt(request.getParameter("id")));
		floorinfo.setFloorname(request.getParameter("floorname"));
		floorinfo.setRemarks(request.getParameter("remarks"));
		if(floorService.deleteFloor(floorinfo)){
			return "success";
		}
		else{
			return "fail";
		}
	}
}
