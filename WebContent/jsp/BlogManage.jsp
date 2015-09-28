<%@page import="model.LogFileInfo"%>
<%@page import="entity.LogFile"%>
<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>酒店客房管理系统-日志管理界面</title>
<%@ include file="common/CommonAdminHead.jsp" %>

</head>
<body onload="MM_preloadImages('image/bg_sub_sidebar_bottom_she_副本.jpg','image/splbgl1.jpg','image/spxxgl1.jpg','image/kflxgl1.jpg','image/kfxxgl1.jpg','image/lcgl1.jpg','image/yhgl1.jpg','image/rzgl1.jpg')">    
<!-- header -->
<%@ include file="common/CommonHeader.jsp" %>

<!-- frame -->

<!-- content -->
<div id="content">
<div class="maincontent">
<div class="worklist">
<p class="roomInformation"><a href=""><span class="recordInformation"></span></a><span class="recordInformation"><a href=""><span class="checkIn"></span></a><span class="checkIn"><a href=""><span class="changeRoom"></span></a></span></span></p>

<p class="recordInformation"><span class="roomInformation"><a href=""></a><a href=""><span class="checkIn"></span></a></span></p>

<div id="alltable">
<div id="search">
   <form id="blog_form"  class="pull-left" name="blog_form" method="post" action="blogsearch">
    <label for="label3">员工编号</label>
      <input name="staffid" type="text" id="label3" size="10" maxlength="8" />
      
     <label for="textfield" >开始时间</label>
      <input name="startdt" type="text" id="textfield" size="10"  onFocus="c.showMoreDay = false;c.show(this);" />
      
      <label for="label4">结束时间</label>
      <input name="enddt" type="text" id="label4" size="10" onFocus="c.showMoreDay = false;c.show(this);"/>
      
      <span class="message">
    <!--   <input type="button"  class="adminsearch"  name="blogsearch" id="blogsearch" value="搜 索" onclick="blogsearch()"/> -->
      <input type="submit"  class="adminsearch"  name="blogsearch" id="blogsearch" value="搜 索" />
      </span>
    </form>
    </div>
  <div id="worklist">
    <p class="roommanage"><img src="/HGMSystem/image/kfgl.jpg" alt="客房管理" width="200px" height="80px"/><a href="FloorManage.jsp" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('lcgl','','/HGMSystem/image/lcgl1.jpg',1)"><img src="/HGMSystem/image/lcgl.jpg" alt="楼层管理" name="lcgl" width="200" height="30" border="0" id="lcgl" /></a><a href="RoomTypeManage.jsp" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('roomtypemanage','','/HGMSystem/image/kflxgl1.jpg',0)"><img src="/HGMSystem/image/kflxgl.jpg" alt="客房类型管理" name="roomtypemanage" width="200" height="30" border="0" id="roomtypemanage" /></a><a href="roomtypemanage.html"></a><a href="RoomManage.jsp" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('roommanage','','/HGMSystem/image/kfxxgl1.jpg',1)"><img src="/HGMSystem/image/kfxxgl.jpg" alt="客房信息管理" name="roommanage" width="200" height="30" border="0" id="roommanage" /></a><a href="roommanage.html" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('roominformationmanage','','image//HGMSystem/kflxgl1.jpg',1)"></a><a href="roommanage.html"></a></p>
    <p class="systemmanage"><img src="/HGMSystem/image/xtgl.jpg" alt="系统管理" width="200px" height="80px"/><a href="UserManage.jsp" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('yhgl','','/HGMSystem/image/yhgl1.jpg',1)"><img src="/HGMSystem/image/yhgl.jpg" alt="用户管理" name="yhgl" width="200" height="30" border="0" id="yhgl" /></a><a href="MemberManage.jsp" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('membermanage','','/HGMSystem/image/hygl1.jpg',0)"><img src="/HGMSystem/image/hygl.jpg" alt="会员管理" name="membermanage" width="200" height="30" border="0" id="membermanage" /></a><a href="membermanage.html" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('usermanage','','/HGMSystem/image/hygl1.jpg',1)"></a><a href="membermanage.html"></a><a href="BlogManage.jsp" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('blogmanage','','/HGMSystem/image/rzgl1.jpg',1)"><img src="/HGMSystem/image/rzgl.jpg" alt="日志管理" name="blogmanage" width="200" height="30" border="0" id="blogmanage" /></a><a href="blogmanage.html"></a></p>
    <p class="goodmanage"><img src="/HGMSystem/image/spgl.jpg" alt="商品管理" width="200px" height="80px"/><a href="#" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('1','','/HGMSystem/image/bg_sub_sidebar_bottom_she_副本.jpg',1)"></a><a href="GoodTypeManage.jsp" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('splbgl','','/HGMSystem/image/splbgl1.jpg',1)"><img src="/HGMSystem/image/splbgl.jpg" alt="商品类别管理" name="splbgl" width="200" height="30" border="0" id="splbgl" /></a><a href="GoodManage.jsp" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('spxxgl','','/HGMSystem/image/spxxgl1.jpg',1)"><img src="/HGMSystem/image/spxxgl.jpg" alt="商品信息管理" name="spxxgl" width="200" height="30" border="0" id="spxxgl" /></a></p>
  </div>
 <div id="allttable">
    <table  class="formtable"  border="1px">
    <tr>
	<th width="100">操作员</th>
	<th width="100">操作</th>
	<th width="100">操作时间</th>
	<th width="340">备注</th>
	<th width="100">删除</th>
	
	
	<!-- <tr>
    <td>C0002</td>
    <td>添加预订</td>
    <td>2015-05-06 15:28:42</td>
    <td>预订单号：2015050713b82f2</td>
    <td><button type="button">删除</button></td>
  </tr> -->
	
	
	
	<% List logfilelist = (List)request.getAttribute("logfilelist");
    	if(logfilelist != null) {
	 		for (Object object : logfilelist) { 
	 			LogFileInfo logfilelists = (LogFileInfo)object;
	 %>	
		 	 	<tr>
		 			<th width="100"><%=logfilelists.getStaffid() %></th>
					<th width="100"><%=logfilelists.getOperation() %></th>
					<th width="100"><%=logfilelists.getDatetime() %></th>
					<th width="340"><%=logfilelists.getRemarks() %></th>
					<th width="100"><a href="<s:url action="delete"><s:param name="id"><%=logfilelists.getStaffid() %></s:param></s:url>"/>删除</a></th>
		 		</tr>
	 <%
	 		}
    	}
	 %>
	
</tr>

</table>

  </div>
</div>
</div>
</div>
</div>

<%@ include file="common/CommonJs.jsp" %>
<script type="text/JavaScript" src="/HGMSystem/js/dist/Calendar.js"></script>
<script type="text/JavaScript" src="/HGMSystem/js/commonCalendar.js"></script>
<script type="text/JavaScript" src="/HGMSystem/js/blogManage.js"></script>
</body>
</html>