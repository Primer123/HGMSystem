<%@page import="sheet.CheckinGuestSheet"%>
<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>总经理-入住报表界面</title>

<%@ include file="common/CommonManagerHead.jsp" %>
</head>
<body onload="MM_preloadImages('image/ydkrbb1.jpg','image/rzkrbb1.jpg','image/drydbb1.jpg','image/drrzbb1.jpg','image/drldbb1.jpg','image/drcwjz1.jpg')">
<!-- header -->
<%@ include file="common/CommonHeader.jsp" %>

<!-- content -->
<div id="content">
<div class="maincontent">
<div class="worklist">
<p class="roomInformation"><a href=""><span class="recordInformation"></span></a><span class="recordInformation"><a href=""><span class="checkIn"></span></a><span class="checkIn"><a href=""><span class="changeRoom"></span></a></span></span></p>

<div id="alltable">
<div id="search">

    <form id="checkin_form" name="checkin_form"class="searchInfo"  method="post" action="checkinFormSearch">
      <label for="label3" >开始日期</label>
      <input name="arrivingdt1" type="text" id="textfield" size="10"  onFocus="c.showMoreDay = false;c.show(this);" />
      <label for="label4">结束日期</label>
      <input name="arrivingdt2" type="text" id="label4" size="10" onFocus="c.showMoreDay = false;c.show(this);"/><br />
      <label for="textfield">指定客房编号</label>
      <input name="roomnum" type="text" id="textfield" size="20" />
      <input type="submit"  class="searchroom" name="searchbtn" id="searchbtn" value="搜索"  />
      
    </form>
    </div>
    
  <div id="worklist">
  
  <a href="RecordForm.jsp" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('recordform','','/HGMSystem/image/ydkrbb1.jpg',1)"><img src="/HGMSystem/image/ydkrbb.jpg" alt="预订客人报表" name="recordform" width="250" height="80" border="0" id="recordform" /></a>
  <a href="CheckinForm.jsp" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('checkinform','','/HGMSystem/image/rzkrbb1.jpg',1)"><img src="/HGMSystem/image/rzkrbb.jpg" alt="入住客人报表" name="checkinform" width="250" height="80" border="0" id="checkinform" /></a>
  <a href="TrecordForm.jsp" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Trecordform','','/HGMSystem/image/drydbb1.jpg',1)"><img src="/HGMSystem/image/drydbb.jpg" alt="当日预订报表" name="Trecordform" width="250" height="80" border="0" id="Trecordform" /></a>
  <a href="TcheckinForm.jsp" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Tcheckinform','','/HGMSystem/image/drrzbb1.jpg',1)"><img src="/HGMSystem/image/drrzbb.jpg" alt="当日入住报表" name="Tcheckinform" width="250" height="80" border="0" id="Tcheckinform" /></a>
  <a href="TcheckoutForm.jsp" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Tcheckoutform','','/HGMSystem/image/drldbb1.jpg',1)"><img src="/HGMSystem/image/drldbb.jpg" alt="当日离店报表" name="Tcheckoutform" width="250" height="80" border="0" id="Tcheckoutform" /></a>
  <a href="TfinanceForm.jsp" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Tfinanceform','','/HGMSystem/image/drcwjz1.jpg',1)"><img src="/HGMSystem/image/drcwjz.jpg" alt="当日财务进账" name="Tfinanceform" width="250" height="80" border="0" id="Tfinanceform" /></a></p>
  
  </div>
 <div id="allroomtable">
    <table width="740"  class="formtable"  border="1px">
      <tr>
	<th width="90">入住单号</th>
	<th width="90">客房编号</th>
	<th width="90">客房类型</th>	
	<th width="100">入住人</th>
	<th width="90">会员编号</th>
	<th width="90">抵店时间</th>
	<th width="90">离店时间</th>
	<th width="100">联系电话</th>
</tr>
 <% List checkinguestsheet = (List)request.getAttribute("checkinguesetsheet");
    	if(checkinguestsheet != null) {
	 		for (Object object : checkinguestsheet) { 
	 			CheckinGuestSheet checkinguestSheet = (CheckinGuestSheet)object;
	 %>	
		 	 	<tr>
		 			<th width="90"><%=checkinguestSheet.getCheckinnum() %></th>
					<th width="90"><%=checkinguestSheet.getRoomnum() %></th>
					<th width="90"><%=checkinguestSheet.getRoomType()%></th>
					<th width="100"><%=checkinguestSheet.getName() %></th>
					<th width="90"><%=checkinguestSheet.getMemberid() %></th>
					<th width="90"><%=checkinguestSheet.getArrivingdt()%></th>
					<th width="90"><%=checkinguestSheet.getDeparturedt() %></th>
					<th width="100"><%=checkinguestSheet.getTelnum() %></th>
					
		 		</tr>
	 <%
	 		}
    	}
	 %>
</table>

  </div>
</div>
</div>
</div>
</div>

<!-- footer -->
<%@ include file="common/CommonJs.jsp" %>
<script type="text/JavaScript" src="/HGMSystem/js/dist/Calendar.js"></script>
<script type="text/JavaScript" src="/HGMSystem/js/commonCalendar.js"></script>
<script type="text/JavaScript" src="/HGMSystem/js/checkinForm.js"></script>
</body>
</html>