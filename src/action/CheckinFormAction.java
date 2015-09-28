package action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.stereotype.Component;

import service.ReportsService;
import sheet.CheckinGuestSheet;

@ParentPackage(value="json-default")
@Results({@Result(name="success", location="/jsp/CheckninForm.jsp"),
	@Result(name="fail", location="/jsp/CheckninForm.jsp")})
@Component
public class CheckinFormAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private CheckinGuestSheet sheet;
	
	@Resource
	private ReportsService reportsService;

	public ReportsService getReportsService() {
		return reportsService;
	}

	public void setReportsService(ReportsService reportsService) {
		this.reportsService = reportsService;
	}

	public CheckinGuestSheet getSheet() {
		return sheet;
	}

	public void setSheet(CheckinGuestSheet sheet) {
		this.sheet = sheet;
	}

	
	@Action(value = "/checkinFormSearch")//21
	public String searchCheckinGuestSheet() throws Exception {
		super.execute();
		String roomnum=request.getParameter("roomnum");
		String arrivingdt1=request.getParameter("arrivingdt1");
		String arrivingdt2=request.getParameter("arrivingdt2");
		if(roomnum==""){
			if(reportsService.getCheckinSheetByArrivingdt(arrivingdt1, arrivingdt2)!=null){
				List<CheckinGuestSheet> sheetlist=reportsService.getCheckinSheetByArrivingdt(arrivingdt1, arrivingdt2);
				request.setAttribute("checkninguestsheet", sheetlist);
				return "success";
			}
			else{
				request.setAttribute("checkninguestsheet", null);
				return "fail";
			}
			
		}
		else{
			if(reportsService.getCheckinSheetByDtRNum(arrivingdt1, arrivingdt2, roomnum)!=null){
				List<CheckinGuestSheet> sheetlist=reportsService.getCheckinSheetByDtRNum(arrivingdt1, arrivingdt2, roomnum);
				request.setAttribute("checkninguestsheet", sheetlist);
				return "success";
			}
			else{
				request.setAttribute("checkninguestsheet", null);
				return "fail";
			}			
		}		
	}
}
