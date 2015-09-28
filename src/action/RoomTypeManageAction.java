package action;

import java.util.List;

import model.RoomTypeInfo;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.stereotype.Component;

import service.RoomTypeService;


@ParentPackage(value="json-default")
@Results({@Result(name="success", location="/jsp/RoomTypeManage.jsp"),
	@Result(name="fail", location="/jsp/RoomTypeManage.jsp")})
@Component
public class RoomTypeManageAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private RoomTypeInfo roomType;
	
	private RoomTypeService roomTypeService;	
	
	
	@Action(value = "/roomtypesearch")//19
	public String searchRoomType() throws Exception{
		super.execute();
		String keyword=request.getParameter("keyword");
		if(roomTypeService.searchRoomType(keyword)!=null){
			List<RoomTypeInfo> list=roomTypeService.searchRoomType(keyword);
			request.setAttribute("roomtypelist", list);
			return "success";
		}
		else{
			request.setAttribute("roomtypelist", null);
			return "fail";
		}
	}
	
	@Action(value ="/add")//83
	public String createRoomType() throws Exception{
		super.execute();
		RoomTypeInfo info=new RoomTypeInfo();
		info.setTypename(request.getParameter("typename"));
		info.setNumofadult(Integer.parseInt(request.getParameter("numofadult")));
		info.setNumofkid(Integer.parseInt(request.getParameter("numofkid")));
		info.setBedtype(Integer.parseInt(request.getParameter("bedtype")));
		info.setStdprice(Integer.parseInt(request.getParameter("stdprice")));
		info.setDiscprice(Integer.parseInt(request.getParameter("discprice")));
		info.setRmprice(Integer.parseInt(request.getParameter("rmprice")));
		info.setVmprice(Integer.parseInt(request.getParameter("vmprice")));
		info.setRemarks(request.getParameter("remarks"));
		if(roomTypeService.addNewRoomType(info)==true){
			return "success";
		}
		else
			return "fail";
	}
	
	@Action(value ="/update")//171
	public String modifyRoomType() throws Exception{
		super.execute();
		RoomTypeInfo info=new RoomTypeInfo();
		info.setId(Integer.parseInt(request.getParameter("id")));
		info.setTypename(request.getParameter("typename"));
		info.setNumofadult(Integer.parseInt(request.getParameter("numofadult")));
		info.setNumofkid(Integer.parseInt(request.getParameter("numofkid")));
		info.setBedtype(Integer.parseInt(request.getParameter("bedtype")));
		info.setStdprice(Integer.parseInt(request.getParameter("stdprice")));
		info.setDiscprice(Integer.parseInt(request.getParameter("discprice")));
		info.setRmprice(Integer.parseInt(request.getParameter("rmprice")));
		info.setVmprice(Integer.parseInt(request.getParameter("vmprice")));
		info.setRemarks(request.getParameter("remarks"));
		roomTypeService.modifyRoomTypeInfo(info);
		return "success";
	}
	
	@Action(value ="/delete")
	public String deleteRoomType() throws Exception{
		super.execute();
		RoomTypeInfo info=new RoomTypeInfo();
		info.setId(Integer.parseInt(request.getParameter("id")));
		info.setTypename(request.getParameter("typename"));
		info.setNumofadult(Integer.parseInt(request.getParameter("numofadult")));
		info.setNumofkid(Integer.parseInt(request.getParameter("numofkid")));
		info.setBedtype(Integer.parseInt(request.getParameter("bedtype")));
		info.setStdprice(Integer.parseInt(request.getParameter("stdprice")));
		info.setDiscprice(Integer.parseInt(request.getParameter("discprice")));
		info.setRmprice(Integer.parseInt(request.getParameter("rmprice")));
		info.setVmprice(Integer.parseInt(request.getParameter("vmprice")));
		info.setRemarks(request.getParameter("remarks"));
		if(roomTypeService.deleteRoomType(info)==true){
			return "success";
		}
		else{
			return "fail";
		}
	}

	public RoomTypeInfo getRoomType() {
		return roomType;
	}

	public void setRoomType(RoomTypeInfo roomType) {
		this.roomType = roomType;
	}

	public RoomTypeService getRoomTypeService() {
		return roomTypeService;
	}

	public void setRoomTypeService(RoomTypeService roomTypeService) {
		this.roomTypeService = roomTypeService;
	}
}
