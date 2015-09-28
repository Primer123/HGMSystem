<%@page import="sheet.ReservationGuestSheet"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>总经理-预订客人报表界面</title>
<%@ include file="common/CommonManagerHead.jsp" %>

</head>
<body onload="MM_preloadImages('image/ydkrbb1.jpg','image/rzkrbb1.jpg','image/drydbb1.jpg','image/drrzbb1.jpg','image/drldbb1.jpg','image/drcwjz1.jpg')">
<!-- header -->
<%@ include file="common/CommonHeader.jsp" %>

<!-- content -->
<div id="content">
<div class="maincontent">
<div class="worklist">
<div id="alltable">
<div id="search">
    <form id="record_form" class="searchInfo" name="record_form" method="post" action="recordFormSearch">
      <label for="label3" >开始日期</label>
      <input name="arrivingdt1" type="text" id="textfield" size="10"  onFocus="c.showMoreDay = false;c.show(this);" />
      <label for="label4">结束日期</label>
      <input name="arrivingdt2" type="text" id="label4" size="10" onFocus="c.showMoreDay = false;c.show(this);"/><br />
      <label for="textfield">指定客房编号：</label>
      <input name="roomnum" type="text" id="textfield" size="20" />
      <input type="submit"  class="searchroom"name="searchbtn" id="searchbtn" value="搜索" />
    </form>
    </div>
<div id="worklist">
  
  <a href="RecordForm.jsp" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('recordform','','/HGMSystem/image/ydkrbb1.jpg',1)"><img src="/HGMSystem/image/ydkrbb.jpg" alt="预订客人报表" name="recordform" width="250" height="80" border="0" id="recordform" /></a>
  <a href="CheckinForm.jsp" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('reservationform','','/HGMSystem/image/rzkrbb1.jpg',1)"><img src="/HGMSystem/image/rzkrbb.jpg" alt="入住客人报表" name="reservationform" width="250" height="80" border="0" id="reservationform" /></a>
  <a href="TrecordForm.jsp" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Trecordform','','/HGMSystem/image/drydbb1.jpg',1)"><img src="/HGMSystem/image/drydbb.jpg" alt="当日预订报表" name="Trecordform" width="250" height="80" border="0" id="Trecordform" /></a>
  <a href="TreservationForm.jsp" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Treservationform','','/HGMSystem/image/drrzbb1.jpg',1)"><img src="/HGMSystem/image/drrzbb.jpg" alt="当日入住报表" name="Treservationform" width="250" height="80" border="0" id="Treservationform" /></a>
  <a href="TcheckoutForm.jsp" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Tcheckoutform','','/HGMSystem/image/drldbb1.jpg',1)"><img src="/HGMSystem/image/drldbb.jpg" alt="当日离店报表" name="Tcheckoutform" width="250" height="80" border="0" id="Tcheckoutform" /></a>
  <a href="TfinanceForm.jsp" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Tfinanceform','','/HGMSystem/image/drcwjz1.jpg',1)"><img src="/HGMSystem/image/drcwjz.jpg" alt="当日财务进账" name="Tfinanceform" width="250" height="80" border="0" id="Tfinanceform" /></a>
 
  </div>
 <div id="allroomtable">
    <table width="740"  class="formtable"  border="1px">
      <tr>
	<th width="90">预定单号</th>
	<th width="90">客房编号</th>
	<th width="90">客房类型</th>	
	<th width="100">预订人</th>
	<th width="90">会员编号</th>
	<th width="90">抵店时间</th>
	<th width="90">离店时间</th>
	<th width="100">联系电话</th>
</tr>


<!-- <tr>
    <td>201504268010201</td>
    <td>80102</td>
     <td>普通客房</td>
    <td>麦克</td>
     <td></td>
    <td>2015-04-27 11:00:00</td>
     <td>2015-05-03 13:00:00</td>
    <td>13000000000</td> 
  </tr>

<tr>
    <td>201504278010102</td>
    <td>80101</td>
     <td>普通客房</td>
    <td>乔恩</td>
     <td></td>
    <td>2015-04-30 11:00:00</td>
     <td>2015-05-05 13:00:00</td>
    <td>15000000000</td> 
  </tr>


 -->








<% List reservationguestsheet = (List)request.getAttribute("reservationguestsheet");
    	if(reservationguestsheet != null) {
	 		for (Object object : reservationguestsheet) { 
	 			ReservationGuestSheet reservationguestSheet = (ReservationGuestSheet)object;
	 %>	
		 	 	<tr>
		 			<th width="90"><%=reservationguestSheet.getRsrvnum() %></th>
					<th width="90"><%=reservationguestSheet.getRoomnum() %></th>
					<th width="90"><%=reservationguestSheet.getRoomtype()%></th>
					<th width="100"><%=reservationguestSheet.getName() %></th>
					<th width="90"><%=reservationguestSheet.getMemberid() %></th>
					<th width="90"><%=reservationguestSheet.getArrivingdt()%></th>
					<th width="90"><%=reservationguestSheet.getDeparturedt() %></th>
					<th width="100"><%=reservationguestSheet.getTelnum() %></th>
					
		 		</tr>
	 <%
	 		}
    	}
	 %>

<!-- <tr>
	<td>201502111</td><td>B1234</td><td>大床房</td><td>李云轩</td><td>123</td><td>2015/04/11</td><td>2015/04/12</td><td>18551664744</td>
</tr> -->

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
<script type="text/JavaScript" src="/HGMSystem/js/recordForm.js"></script>
</body>
</html>
