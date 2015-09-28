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
import sheet.FinancialSheet;

@ParentPackage(value="json-default")
@Results({@Result(name="success", location="/jsp/TfinanceForm.jsp"),
	@Result(name="fail", location="/jsp/TfinanceForm.jsp")})
@Component
public class TfinanceFormAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private FinancialSheet sheet;
	
	@Resource
	private ReportsService reportsService;
	
	public ReportsService getReportsService() {
		return reportsService;
	}

	public void setReportsService(ReportsService reportsService) {
		this.reportsService = reportsService;
	}


	public FinancialSheet getSheet() {
		return sheet;
	}

	public void setSheet(FinancialSheet sheet) {
		this.sheet = sheet;
	}	
	
	@Action(value = "/TfinanceFormSearch")//19
	public String searchTFinancialSheet() throws Exception {
		super.execute();
		Date now=new Date();
		SimpleDateFormat formater=new SimpleDateFormat("yyyy-MM-dd");		
		String startdt=formater.format(now)+" 00:00:00";
		String enddt=formater.format(now)+" 23:59:59";
		if(reportsService.getFinancialSheetByDt(startdt, enddt)!=null){
			List<FinancialSheet> sheetlist=reportsService.getFinancialSheetByDt(startdt, enddt);
			request.setAttribute("financialsheet", sheetlist);					
			return "success";	
		}
		else{
			request.setAttribute("financialsheet", null);					
			return "fail";	
		}
		
	}
	

}
