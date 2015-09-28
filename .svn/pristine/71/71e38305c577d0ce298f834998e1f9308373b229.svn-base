package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.sun.javafx.collections.MappingChange.Map;

public class BaseAction extends ActionSupport implements SessionAware, 
	ServletRequestAware, ServletResponseAware {

	private static final long serialVersionUID = 1L;

	public HttpServletRequest request;
	public HttpServletResponse response;
	public Map session;
	
	public void setSession(Map session) {
		this.session = session;
	}
	
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	@Override
	public void setSession(java.util.Map<String, Object> arg0) {
		// TODO Auto-generated method stub
	}
}
