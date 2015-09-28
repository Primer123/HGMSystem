package action;

import java.text.SimpleDateFormat;
import java.util.Date;
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
@Results({@Result(name="success", location="/jsp/TrecordForm.jsp"), 
	 @Result(name="fail", location="/jsp/TrecordForm.jsp")})
@Component
public class TrecordFormAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ReservationGuestSheet rsrvsheet;
	@Resource
	private ReportsService reportsService;
	
	@Action(value = "/TrecordFormSearch")//21
	public String searchTReservationGuestSheet() throws Exception {
		super.execute();
		Date now=new Date();
		SimpleDateFormat formater=new SimpleDateFormat("yyyy-MM-dd");		
		String arrivingdt1=formater.format(now);
		String arrivingdt2=formater.format(now);
		if(reportsService.getRsrvSheetByArrivingdt(arrivingdt1, arrivingdt2)!=null){
			List<ReservationGuestSheet> sheetlist=reportsService.getRsrvSheetByArrivingdt(arrivingdt1, arrivingdt2);
			request.setAttribute("treservationguestsheet", sheetlist);					
			return "success";
		}
		else{
			request.setAttribute("treservationguestsheet", null);					
			return "fail";
		}		
	}
	

	public ReservationGuestSheet getRsrvsheet() {
		return rsrvsheet;
	}

	public void setRsrvsheet(ReservationGuestSheet rsrvsheet) {
		this.rsrvsheet = rsrvsheet;
	}

	public ReportsService getReportsService() {
		return reportsService;
	}

	public void setReportsService(ReportsService reportsService) {
		this.reportsService = reportsService;
	}	

}
