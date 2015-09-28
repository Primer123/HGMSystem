package action;

import com.opensymphony.xwork2.ActionSupport;


public class WaiterLoginAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String password;

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public WaiterLoginAction() {
		super();
	}
	public WaiterLoginAction(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}
	
	public String excute() {
		System.out.println(name + "===========" + password);
		return SUCCESS;
	}
}
