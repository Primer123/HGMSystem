package action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Struts中使用基于注解编程
 * @author soft
 *
 */
@ParentPackage(value="json-default")
@Results({@Result(name="success", location="/main.jsp"), 
	@Result(name="input", location="/login.jsp"),
	@Result(name="existUser", type="json"),
	@Result(name="notExistUser", type="json"),
	@Result(name="correct", type="json"),
	@Result(name="fail", type="json")})
public class UserAction extends ActionSupport implements ServletResponseAware {

	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		
	}

/*	private HttpServletResponse response;
	
	 * @Resource是JDK中的注解编程
	 * 这种注解的含义是在项目中按照配置的名称或者类型进行查找bean对象
	 
	@Resource
	private IUserService userService;
	private String usersValidateCode;			//用户输入的验证码
	private User user;
	private String msg;
	private String userName;
	
	public String getUsersValidateCode() {
		return usersValidateCode;
	}

	public void setUsersValidateCode(String usersValidateCode) {
		this.usersValidateCode = usersValidateCode;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	 * @Action表示链接的url，此处表示当url地址是
	 * http://localhost:28080/test/user_register时
	 * Struts框架将会调用该Action中的register()方法处理逻辑
	 
	@Action(value="/user_register")
	public String register() throws Exception {
		boolean isSuccess = userService.register(user);
		
		if(isSuccess){
			return SUCCESS;
		} else {
			msg = "注册失败，请重新填写";
			return INPUT;
		}
	}
	
	@Action(value="/user_login")
	public String login() throws Exception {
		User loginUser = userService.getUserByNameAndPass(user.getUserName(), user.getUserPassword());
		
		if(null != loginUser) {
			return SUCCESS;
		} else {
			msg = "登录失败，请重新登录";
			return INPUT;
		}
	}
	
	
	 * 验证用户输入的用户名是否可用
	 
	@Action(value="/user_validateUserName")
	public String validateUserName() throws Exception {
		User loginUser = userService.getUserByNameAndPass(this.userName);
		
		if(null != loginUser) {
			msg = "true";
			return "existUser";
		} else {
			msg = "false";
			return "notExistUser";
		}
	}
	
	
	 * 验证用户输入的验证码是否正确
	 
	@Action(value="/user_validateCode")
	public String validateCode() throws Exception {
		//获取系统会话中目前存在的验证码
		String sessionCode=(String)(ActionContext.getContext().getSession().get("sessionCode"));
		
		//判断用户输入的验证码是否正确
		if(null != sessionCode && sessionCode.equals(this.getUsersValidateCode())) {
			msg = "correct";
			return "correct";
		} else {
			msg = "fail";
			return "fail";
		}
	}
	
	@Action(value="/admin_createExcel")
	public String admin_createExcel() throws Exception {
		//设置文件的名称
		String excelName= "酒店财务报表";
		//设置相应内容的编码格式
		response.setCharacterEncoding("UTF-8");
		excelName = java.net.URLEncoder.encode(excelName,"UTF-8");
	    response.setHeader("Content-Disposition","attachment;filename="+new String(excelName.getBytes("UTF-8"),"UTF-8")+".xls");
	    //定义输出类型
	    response.setContentType("application/msexcel");
	    //调用生成excel的方法
		ExcelOperation.createExcel(response.getOutputStream());
		return null;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}*/
}
