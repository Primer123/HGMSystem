package action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.stereotype.Component;

import service.ReportsService;
import sheet.ReservationGuestSheet;

@ParentPackage(value="json-default")
@Results({@Result(name="success", location="/jsp/RecordForm.jsp"),
	@Result(name="fail", location="/jsp/RecordForm.jsp")})
@Component
public class RecordFormAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ReservationGuestSheet sheet;
	
	@Resource
	private ReportsService reportsService;
	
	public ReportsService getReportsService() {
		return reportsService;
	}

	public void setReportsService(ReportsService reportsService) {
		this.reportsService = reportsService;
	}

	public ReservationGuestSheet getSheet() {
		return sheet;
	}

	public void setSheet(ReservationGuestSheet sheet) {
		this.sheet = sheet;
	}
	
	@Action(value = "/recordFormSearch")//19
	public String searchRsrvGuestSheet() throws Exception {
		super.execute();
		String roomnum=request.getParameter("roomnum");
		String arrivingdt1=request.getParameter("arrivingdt1");
		String arrivingdt2=request.getParameter("arrivingdt2");
		if(roomnum==null){
			if(reportsService.getRsrvSheetByArrivingdt(arrivingdt1, arrivingdt2)!=null){
				List<ReservationGuestSheet> sheetlist=reportsService.getRsrvSheetByArrivingdt(arrivingdt1, arrivingdt2);
				request.setAttribute("reservationguestsheet", sheetlist);
				return "success";
			}
			else{
				request.setAttribute("reservationguestsheet", null);
				return "fail";
			}			
		}
		else{
			if(reportsService.getRsrvSheetByDtRNum(arrivingdt1, arrivingdt2, roomnum)!=null){
				List<ReservationGuestSheet> sheetlist=reportsService.getRsrvSheetByDtRNum(arrivingdt1, arrivingdt2, roomnum);
				request.setAttribute("reservationguestsheet", sheetlist);
				return "success";
			}
			else{
				request.setAttribute("reservationguestsheet", null);
				return "fail";
			}			
		}		
	}
}
