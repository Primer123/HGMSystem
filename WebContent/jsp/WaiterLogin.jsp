<%@ page contentType="text/html" language="java" import="java.sql.*" errorPage="" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>前台登录界面</title>
<link href="/HGMSystem/css/login.css" rel="stylesheet" type="text/css"/>
</head>

<body>


<div id="hotelflash">
<div class="waiterlogin">

</div>


</div>
<div id="login">
<div id="logintop">前台登录</div>
<div id="logintext">
	<s:form action="login" method="post"> 
	    <label for="textfield">用户ID:</label>
	    <input name="waiter.name" class="textstyle"type="text" id="textfield" size="20" maxlength="20" />
	    <label for="label"><br />
	    <br />
	    密码：</label>
	    <input name="waiter.password"  class="textstyle"type="password" id="label" size="20" maxlength="20" />
	    <p> 
	      <input type="submit" class="btnstyle" name="Submit" value="登录" id="Submit" onclick="window.location.href='RoomRecord.jsp'"/>
		  
	    </p>
	</s:form>

  </div>
</div>

</body>
</html>
