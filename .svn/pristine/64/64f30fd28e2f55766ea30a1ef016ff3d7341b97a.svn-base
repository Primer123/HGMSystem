package action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import model.ReservationInfo;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.stereotype.Component;

import service.ReservationService;
import entity.ReservationRecord;

@ParentPackage(value="json-default")
@Results({@Result(name="success", location="/jsp/RoomRecord.jsp"), 
	@Result(name="input", location="/jsp/RoomRecord.jsp")})
@Component
public class RoomRecordAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ReservationInfo reservation;

	@Resource
	private ReservationService reservationService;
	

	public ReservationInfo getReservation() {
		return reservation;
	}

	public void setReservation(ReservationInfo reservation) {
		this.reservation = reservation;
	}



	@Action(value = "/add")
	public String createReservation() throws Exception {
		super.execute();
		
		String memberId = null;
				//memberService.addNewMember(member);

		List<ReservationInfo> ReservationInfos = null;
				//memberService.searchByName("member");
		if (ReservationInfos == null) {
			ReservationInfos = new ArrayList<ReservationInfo>();
		}
		
		for (int i = 0; i < 4; i++) {
			ReservationInfo ReservationInfo = new ReservationInfo();
			ReservationInfo.setId(i);
			//ReservationInfo.setGender(1);
			ReservationInfo.setName("name" + i);
			ReservationInfo.setRemarks("remarks" + i);
			ReservationInfos.add(ReservationInfo);
		}
		
		request.setAttribute("ReservationInfos", ReservationInfos);
		
		if (memberId == null) {
			request.setAttribute("msg", 0);
			return "input";
		}

		return "success";
	}
	
	@Action(value = "/delete")
	public String deleteMember() throws Exception {
		super.execute();
		String memberId = request.getParameter("id");
		System.out.println("===id: " + memberId);
		//memberService.deleteMember(member);

		List<ReservationInfo> ReservationInfos = null;
				//memberService.searchByName("member");
		if (ReservationInfos == null) {
			ReservationInfos = new ArrayList<ReservationInfo>();
		}
		
		for (int i = 0; i < 3; i++) {
			ReservationInfo ReservationInfo = new ReservationInfo();
			ReservationInfo.setId(i);
	
			ReservationInfo.setName("name" + i);
			ReservationInfo.setRemarks("remarks" + i);
			ReservationInfos.add(ReservationInfo);
		}
		
		request.setAttribute("ReservationInfos", ReservationInfos);
		
		return "success";
	}
	
	@Action(value = "/getInfo")
	public String getReservationInfo() throws Exception {
		super.execute();
		String memberId = request.getParameter("id");
		ReservationInfo ReservationInfo = new ReservationInfo();
				//memberService.searchByMemberid(memberId);
		ReservationInfo.setId(0);
		
		ReservationInfo.setName("name");
		ReservationInfo.setRemarks("remarks");
	
		request.setAttribute("singleMember", ReservationInfo);
		
		return "input";
	}
}
