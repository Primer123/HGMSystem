<%@page import="model.LogFileInfo"%>
<%@page import="entity.LogFile"%>
<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>�Ƶ�ͷ�����ϵͳ-��־��������</title>
<%@ include file="common/CommonAdminHead.jsp" %>

</head>
<body onload="MM_preloadImages('image/bg_sub_sidebar_bottom_she_����.jpg','image/splbgl1.jpg','image/spxxgl1.jpg','image/kflxgl1.jpg','image/kfxxgl1.jpg','image/lcgl1.jpg','image/yhgl1.jpg','image/rzgl1.jpg')">    
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
    <label for="label3">Ա�����</label>
      <input name="staffid" type="text" id="label3" size="10" maxlength="8" />
      
     <label for="textfield" >��ʼʱ��</label>
      <input name="startdt" type="text" id="textfield" size="10"  onFocus="c.showMoreDay = false;c.show(this);" />
      
      <label for="label4">����ʱ��</label>
      <input name="enddt" type="text" id="label4" size="10" onFocus="c.showMoreDay = false;c.show(this);"/>
      
      <span class="message">
    <!--   <input type="button"  class="adminsearch"  name="blogsearch" id="blogsearch" value="�� ��" onclick="blogsearch()"/> -->
      <input type="submit"  class="adminsearch"  name="blogsearch" id="blogsearch" value="�� ��" />
      </span>
    </form>
    </div>
  <div id="worklist">
    <p class="roommanage"><img src="/HGMSystem/image/kfgl.jpg" alt="�ͷ�����" width="200px" height="80px"/><a href="FloorManage.jsp" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('lcgl','','/HGMSystem/image/lcgl1.jpg',1)"><img src="/HGMSystem/image/lcgl.jpg" alt="¥�����" name="lcgl" width="200" height="30" border="0" id="lcgl" /></a><a href="RoomTypeManage.jsp" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('roomtypemanage','','/HGMSystem/image/kflxgl1.jpg',0)"><img src="/HGMSystem/image/kflxgl.jpg" alt="�ͷ����͹���" name="roomtypemanage" width="200" height="30" border="0" id="roomtypemanage" /></a><a href="roomtypemanage.html"></a><a href="RoomManage.jsp" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('roommanage','','/HGMSystem/image/kfxxgl1.jpg',1)"><img src="/HGMSystem/image/kfxxgl.jpg" alt="�ͷ���Ϣ����" name="roommanage" width="200" height="30" border="0" id="roommanage" /></a><a href="roommanage.html" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('roominformationmanage','','image//HGMSystem/kflxgl1.jpg',1)"></a><a href="roommanage.html"></a></p>
    <p class="systemmanage"><img src="/HGMSystem/image/xtgl.jpg" alt="ϵͳ����" width="200px" height="80px"/><a href="UserManage.jsp" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('yhgl','','/HGMSystem/image/yhgl1.jpg',1)"><img src="/HGMSystem/image/yhgl.jpg" alt="�û�����" name="yhgl" width="200" height="30" border="0" id="yhgl" /></a><a href="MemberManage.jsp" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('membermanage','','/HGMSystem/image/hygl1.jpg',0)"><img src="/HGMSystem/image/hygl.jpg" alt="��Ա����" name="membermanage" width="200" height="30" border="0" id="membermanage" /></a><a href="membermanage.html" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('usermanage','','/HGMSystem/image/hygl1.jpg',1)"></a><a href="membermanage.html"></a><a href="BlogManage.jsp" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('blogmanage','','/HGMSystem/image/rzgl1.jpg',1)"><img src="/HGMSystem/image/rzgl.jpg" alt="��־����" name="blogmanage" width="200" height="30" border="0" id="blogmanage" /></a><a href="blogmanage.html"></a></p>
    <p class="goodmanage"><img src="/HGMSystem/image/spgl.jpg" alt="��Ʒ����" width="200px" height="80px"/><a href="#" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('1','','/HGMSystem/image/bg_sub_sidebar_bottom_she_����.jpg',1)"></a><a href="GoodTypeManage.jsp" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('splbgl','','/HGMSystem/image/splbgl1.jpg',1)"><img src="/HGMSystem/image/splbgl.jpg" alt="��Ʒ������" name="splbgl" width="200" height="30" border="0" id="splbgl" /></a><a href="GoodManage.jsp" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('spxxgl','','/HGMSystem/image/spxxgl1.jpg',1)"><img src="/HGMSystem/image/spxxgl.jpg" alt="��Ʒ��Ϣ����" name="spxxgl" width="200" height="30" border="0" id="spxxgl" /></a></p>
  </div>
 <div id="allttable">
    <table  class="formtable"  border="1px">
    <tr>
	<th width="100">����Ա</th>
	<th width="100">����</th>
	<th width="100">����ʱ��</th>
	<th width="340">��ע</th>
	<th width="100">ɾ��</th>
	
	
	<!-- <tr>
    <td>C0002</td>
    <td>����Ԥ��</td>
    <td>2015-05-06 15:28:42</td>
    <td>Ԥ�����ţ�2015050713b82f2</td>
    <td><button type="button">ɾ��</button></td>
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
					<th width="100"><a href="<s:url action="delete"><s:param name="id"><%=logfilelists.getStaffid() %></s:param></s:url>"/>ɾ��</a></th>
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