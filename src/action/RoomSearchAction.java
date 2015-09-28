package action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import model.ReservationInfo;

import org.apache.jasper.tagplugins.jstl.core.Out;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.stereotype.Component;

import service.RoomTypeService;

@ParentPackage(value="json-default")
@Results({@Result(name="success", location="/jsp/RoomRecord.jsp"), 
	@Result(name="input", location="/jsp/RoomRecord.jsp")})
@Component
public class RoomSearchAction extends BaseAction {
	
	private RoomTypeService roomTypeService;
	
	public RoomTypeService getRoomTypeService() {
		return roomTypeService;
	}



	public void setRoomTypeService(RoomTypeService roomTypeService) {
		this.roomTypeService = roomTypeService;
	}



	@Action(value = "/roomsearch")
	public String reserveRoom() throws Exception {
		System.out.println("test");
		//从表单里面获取需要的入驻信息，客户的姓名、日期、
		return "success";
	}
	
	@Action(value = "/searchroom")
	public void searchRoom() throws Exception {
		//从表单里面获取需要的入驻信息，客户的姓名、日期、
		String string = "[{name:'sda',age:12},{name:'sda',age:12},{name:'sda',age:12}]";
		PrintWriter out = response.getWriter();
		out.print(string);
	}
	
}
