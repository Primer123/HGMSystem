<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>ϵͳ����Ա��¼����</title>
<link href="/HGMSystem/css/login.css" rel="stylesheet" type="text/css"/>
</head>

<body>

<div id="hotelflash">
<div class="adminlogin">
              
  </div>


</div>
<div id="login">
<div id="logintop">ϵͳ����Ա</div>
<div id="logintext">
	<s:form  action="adminlogin" method="post"> 
	    <label for="textfield">�û�ID:</label>
	    <input name="waiter.name" class="textstyle"type="text" id="textfield" size="20" maxlength="20" />
	    <label for="label"><br />
	    <br />
	    ���룺</label>
	    <input name="waiter.password"  class="textstyle"type="password" id="label" size="20" maxlength="20" />
	    <p> 
	      <input type="submit" class="btnstyle" name="Submit" value="��¼" id="Submit" onclick="window.location.href='FloorManage.jsp'" />
		  
	    </p>
	</s:form>
  </div>
</div>
</body>
</html>
