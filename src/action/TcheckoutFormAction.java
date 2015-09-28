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
import sheet.CheckoutGuestSheet;

@ParentPackage(value="json-default")
@Results({@Result(name="success", location="/jsp/TchecknoutForm.jsp"),
	@Result(name="fail", location="/jsp/TchecknoutForm.jsp")})
@Component
public class TcheckoutFormAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    private CheckoutGuestSheet sheet;
	
	@Resource
	private ReportsService reportsService;
	public ReportsService getReportsService() {
		return reportsService;
	}

	public void setReportsService(ReportsService reportsService) {
		this.reportsService = reportsService;
	}

	public CheckoutGuestSheet getSheet() {
		return sheet;
	}

	public void setSheet(CheckoutGuestSheet sheet) {
		this.sheet = sheet;
	}
	
	@Action(value = "/TcheckoutFormSearch")//22
	public String searchTCheckoutGuestSheet() throws Exception {
		super.execute();
		Date now=new Date();
		SimpleDateFormat formater=new SimpleDateFormat("yyyy-MM-dd");		
		String departuredt1=formater.format(now)+" 00:00:00";
		String departuredt2=formater.format(now)+" 23:59:59";
		if(reportsService.getCheckoutSheetByDeparturedt(departuredt1, departuredt2)!=null){
			List<CheckoutGuestSheet> sheetlist=reportsService.getCheckoutSheetByDeparturedt(departuredt1, departuredt2);
			request.setAttribute("tchecknoutguestsheet", sheetlist);					
			return "success";
		}
		else{
			request.setAttribute("tchecknoutguestsheet", null);					
			return "fail";
		}		
	}

}
