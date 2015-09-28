package action;

import java.util.List;

import model.RoomInfo;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.stereotype.Component;

import service.RoomService;


@ParentPackage(value="json-default")
@Results({@Result(name="success", location="/jsp/RoomManage.jsp"),
	@Result(name="fail", location="/jsp/RoomManage.jsp")})
@Component
public class RoomManageAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private RoomInfo roomInfo;
	
	private RoomService roomService;	

	@Action(value = "/roomsearch")//23
	public String searchRoom() throws Exception{
		super.execute();
		String keyword=request.getParameter("keyword");
		if(roomService.searchRoom(keyword)!=null){
			List<RoomInfo> list=roomService.searchRoom(keyword);
			request.setAttribute("roomlist", list);
			return "success";
		}
		else{
			request.setAttribute("roomlist", null);
			return "fail";
		}
	}

	@Action(value ="/add")//90
    public String createRoom() throws Exception{
		super.execute();
		RoomInfo roominfo=new RoomInfo();		
		roominfo.setTypeid(Integer.parseInt(request.getParameter("typeid")));
		roominfo.setRoomstate(0);
		int floor=Integer.parseInt(request.getParameter("floor"));
		roominfo.setFloorname(floor+"¥");
		roominfo.setProperties(request.getParameter("properties"));
		roominfo.setRemarks(request.getParameter("remarks"));		
		roominfo.setRoomnum(roomService.newRoomNum(floor));
		if(roomService.addNewRoom(roominfo)){
			List<RoomInfo> list=roomService.findAll();
			request.setAttribute("roomlist", list);
			return "success";
		}			
		else {
			return "fail";
		}
		
	}

	@Action(value ="/update")
    public String modifyRoom() throws Exception{
		super.execute();
		RoomInfo roominfo=new RoomInfo();
		roominfo.setId(Integer.parseInt(request.getParameter("id")));
		roominfo.setRoomnum(request.getParameter("roomnum"));
		roominfo.setTypeid(Integer.parseInt(request.getParameter("typeid")));
		roominfo.setRoomstate(Integer.parseInt(request.getParameter("roomstate")));
		roominfo.setFloorname(request.getParameter("floor")+"¥");
		roominfo.setProperties(request.getParameter("properties"));
		roominfo.setRemarks(request.getParameter("remarks"));
		roomService.modifyRoomInfo(roominfo);
		return "success";
		
	}

	@Action(value ="/delete")
    public String deleteRoom() throws Exception{
		super.execute();
		RoomInfo roominfo=new RoomInfo();
		roominfo.setId(Integer.parseInt(request.getParameter("id")));
		roominfo.setRoomnum(request.getParameter("roomnum"));
		roominfo.setTypeid(Integer.parseInt(request.getParameter("typeid")));
		roominfo.setRoomstate(Integer.parseInt(request.getParameter("roomstate")));
		roominfo.setFloorname(request.getParameter("floorname"));
		roominfo.setProperties(request.getParameter("properties"));
		roominfo.setRemarks(request.getParameter("remarks"));
		roomService.deleteRoom(roominfo);
		return "success";
	}
	
	public RoomInfo getRoomInfo() {
		return roomInfo;
	}

	public void setRoomInfo(RoomInfo roomInfo) {
		this.roomInfo = roomInfo;
	}	
	
	public RoomService getRoomService() {
		return roomService;
	}

	public void setRoomService(RoomService roomService) {
		this.roomService = roomService;
	}
}
