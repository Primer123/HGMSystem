package action;

import java.util.List;

import javax.annotation.Resource;

import model.LogFileInfo;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.stereotype.Component;

import service.LogFileService;
import service.ReportsService;



@ParentPackage(value="json-default")
@Results({@Result(name="success", location="/jsp/BlogManage.jsp"),
	@Result(name="fail", location="/jsp/BlogManage.jsp")})
public class BlogManageAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;	
	
	private LogFileInfo logfileInfo;

	@Resource
	private LogFileService logFileService;

	public LogFileService getLogFileService() {
		return logFileService;
	}

	public void setLogFileService(LogFileService logFileService) {
		this.logFileService = logFileService;
	}

	public LogFileInfo getLogfileInfo() {
		return logfileInfo;
	}

	public void setLogfileInfo(LogFileInfo logfileInfo) {
		this.logfileInfo = logfileInfo;
	}



	@Action(value = "/blogsearch")//25
	public String searchLogfile() throws Exception {
		super.execute();
		String staffid=request.getParameter("staffid");
		String startdt=request.getParameter("startdt");
		String enddt=request.getParameter("enddt");
		
		System.out.println(logFileService == null ? "logFileService == null" : "logFileService != null");
		if(logFileService.searchLogFile(staffid, startdt, enddt)!=null){
			List<LogFileInfo> list=logFileService.searchLogFile(staffid, startdt, enddt);
			
			System.out.println(list == null ? "list == null" : "�У�" + list.size());
			request.setAttribute("logfilelist", list);
			return "success";			
		}
		else{
			request.setAttribute("logfilelist", null);
			System.out.println("aaaaaaaa");
			return "fail";
		}
		
	}

	@Action(value = "/delete")
	public String deleteLogfile() throws Exception {
		super.execute();
		LogFileInfo info=new LogFileInfo();
		info.setId(Integer.parseInt(request.getParameter("id")));
		info.setStaffid(request.getParameter("staffid"));
		info.setOperation(request.getParameter("operation"));
		info.setDatetime(request.getParameter("datetime"));
		info.setRemarks(request.getParameter("remarks"));
		logFileService.deleteLogFile(info);
		return "success";
	}

}
