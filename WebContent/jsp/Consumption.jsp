<%@page import="model.ReservationInfo"%>
<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@page import="java.util.List"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<title>前台消费管理</title>
<%@ include file="common/CommonWaiterHead.jsp" %>
</head>
<body onload="MM_preloadImages('/HGMSystem/image/kfxx1.jpg','image/ydxx1.jpg','image/hfgl1.jpg','image/tfjz1.jpg','image/kfyd1.jpg','image/ydzrz1.jpg','image/xfgl1.jpg','image/djrz1.jpg')">
<!-- header -->
<%@ include file="common/CommonHeader.jsp" %>


<!-- frame -->

<!-- content -->
<div id="content">
<div class="maincontent">
<div class="worklist">
<div id="allroom">
<div id="search">
     <form id="form1" name="form1" method="post" action="consumptionSearch">
        <label for="label1">入住单号</label>
        <input name="textfield1" type="text" id="label1" size="18" maxlength="20" />
       <label for="label2">客房编号</label>
       <input name="textfield2" type="text" id="label2" size="18" maxlength="20" />
     
       <input type="button" name="searchroom" value="搜索房间" id="searchroom" />
        <label for="Submit"></label>
    </form>
    
    
     
    
    </div>
 <div id="allroomlayer">
  <p class="roomInformation"><span class="roomInformation"></span>
 <a href="RoomRecord.jsp" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('roomrecord','','/HGMSystem/image/kfyd1.jpg',1)"><img src="/HGMSystem/image/kfyd.jpg" name="roomrecord" width="250" height="80" border="0" id="roomrecord" /></a>
  <a href="RecordManage.jsp" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('recordmanage','','/HGMSystem/image/ydxx1.jpg',1)"><img src="/HGMSystem/image/ydxx.jpg" name="recordmanage" width="250" height="80" border="0" id="recordmanage" /></a>
  <a href="RecordCheckin.jsp" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('recordcheckin','','/HGMSystem/image/ydzrz1.jpg',1)"><img src="/HGMSystem/image/ydzrz.jpg" name="recordcheckin" width="250" height="80" border="0" id="recordcheckin" /></a>
  <a href="CheckinRoom.jsp" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('checkinRoom','','/HGMSystem/image/djrz1.jpg',1)"><img src="/HGMSystem/image/djrz.jpg" name="checkinRoom" width="250" height="80" border="0" id="checkinRoom" /></a>
  <a href="ChangeRoom.jsp" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('changeRoom','','/HGMSystem/image/hfgl1.jpg',1)"><img src="/HGMSystem/image/hfgl.jpg" name="changeRoom" width="250" height="80" border="0" id="changeRoom" /></a>
  <a href="Consumption.jsp" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('consumption','','/HGMSystem/image/xfgl1.jpg',1)"><img src="/HGMSystem/image/xfgl.jpg" name="consumption" width="250" height="80" border="0" id="consumption" /></a>
  <a href="CheckoutRoom.jsp" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('checkoutRoom','','/HGMSystem/image/tfjz1.jpg',1)"><img src="/HGMSystem/image/tfjz.jpg" name="checkoutRoom" width="250" height="80" border="0" id="checkoutRoom" /></a>
  </p>
  </div>
  <div id="allroomtable" class="STYLE6">
    <table width="740"  class="roomtable"  border="1px">
      <tr>
	<th width="150" >商品代码</th>
	<th width="150">数量</th>
	<th width="150">小计</th>
	<th width="150">操作员</th>
	<th width="140">增加</th>
	<%--  <% List reservationInfos = (List)request.getAttribute("reservationInfos");
    	if(reservationInfos != null) {
	 		for (Object object : reservationInfos) { 
	 			ReservationInfo reservationInfo = (ReservationInfo)object;
	 %>	
		 	 	<tr>
		 		//	<th width="100"><%=reservationInfo.getRoomNumber() %></th>
					<th width="100"><%=reservationInfo.getTypeId() %></th>
					<th width="100"><%=reservationInfo.getFloor() %></th>
					<th width="100"><%=reservationInfo.getRoomState() %></th>
					<th width="240"><%=reservationInfo.getRemarks() %></th>
					<th width="100"><a href="<s:url action="newreservation"><s:param name="id"><%=reservationInfo.getRoomNumber() %></s:param></s:url>"/>预订</a></th>
		 		</tr>
	 <%
	 		}
    	}
	 %> --%>
</tr>

</table>
 </div>
</div>
</div>
</div>
</div>


<div class="modal fade" id="ReservationModal" tabindex="-1" role="dialog" aria-labelledby="ReservationLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">预订信息单</h4>
      </div>
      <div class="modal-body form-horizontal content">
        <div>
		    <form id="form2" name="form2" method="post" action="newReservation">
		    	
		      <div class="form-group">
				    <label class="col-sm-2 control-label">预订单号</label>
				    <div class="col-sm-10">
				    	<input class="form-control" name="rsrvnum" />
				    </div>
			    </div>
			    
			     <div class="form-group">
				    <label class="col-sm-2 control-label">客房编号</label>
				    <div class="col-sm-10">
				    	<input class="form-control" name="roomnum" />
				    </div>
			    </div>
			    
			        <div class="form-group">
				    <label class="col-sm-2 control-label">客房类型</label>
				    <div class="col-sm-10">
				    	<input class="form-control" name="roomtype" />
				    </div>
			    </div>
			    
			        <div class="form-group">
				    <label class="col-sm-2 control-label">标准价</label>
				    <div class="col-sm-10">
				    	<input class="form-control" name="stdprice" />
				    </div>
			    </div>
			    
			    
			        <div class="form-group">
				    <label class="col-sm-2 control-label">折后价</label>
				    <div class="col-sm-10">
				    	<input class="form-control" name="discprice" />
				    </div>
			    </div>
			    
			        <div class="form-group">
				    <label class="col-sm-2 control-label">押金</label>
				    <div class="col-sm-10">
				    	<input class="form-control" name="deposit" />
				    </div>
			    </div>
			    
			        <div class="form-group">
				    <label class="col-sm-2 control-label">预订人</label>
				    <div class="col-sm-10">
				    	<input class="form-control" name="resname" />
				    </div>
			    </div>
			    
			      <div class="form-group">
				    <label class="col-sm-2 control-label">证件类别</label>
				    <div class="col-sm-10">
				    	<select name="idtype" id="select">
					        <option>身份证</option>
					        <option>护照</option>
					        <option>军官证</option>
					     </select>
				    </div>
			    </div>
			    
			     <div class="form-group">
				    <label class="col-sm-2 control-label">证件号码</label>
				    <div class="col-sm-10">
				    	<input class="form-control" name="idnum" />
				    </div>
			    </div>
			    
			        <div class="form-group">
				    <label class="col-sm-2 control-label">联系电话</label>
				    <div class="col-sm-10">
				    	<input class="form-control" name="telnum" />
				    </div>
			    </div>
			    
			     <div class="form-group">
				    <label class="col-sm-2 control-label">入住时间</label>
				    <div class="col-sm-10">
				    	<input class="form-control" name="arrivingdt" />
				    </div>
			    </div>
			    
			     <div class="form-group">
				    <label class="col-sm-2 control-label">退房时间</label>
				    <div class="col-sm-10">
				    	<input class="form-control" name="departuredt" />
				    </div>
			    </div>
			    
			    <!--  <div class="form-group">
				    <label class="col-sm-2 control-label">入住人数</label>
				    <div class="col-sm-10">
				    	<input class="form-control" name="reservation." />
				    </div>
			    </div> -->
			    
			     <div class="form-group">
				    <label class="col-sm-2 control-label">操作员</label>
				    <div class="col-sm-10">
				    	<input class="form-control" name="staffid" />
				    </div>
			    </div>
			    
			      <div class="form-group">
				    <label class="col-sm-2 control-label">会员编号</label>
				    <div class="col-sm-10">
				    	<input class="form-control" name="numid" />
				    </div>
			    </div>
			    
			     <div class="form-group">
				    <label class="col-sm-2 control-label">会员价</label>
				    <div class="col-sm-10">
				    	<input class="form-control" name="vmprice" />
				    </div>
			    </div>
			       <div class="form-group">
				    <label class="col-sm-2 control-label">备注</label>
				    <div class="col-sm-10">
				    	<input class="form-control" name="remarks" />
				    </div>
			    </div>
			    
			    <div class="form-group">
				    <button type="submit" class="btn btn-primary btn-right">保&nbsp;&nbsp;存</button>
        			<button type="button" class="btn btn-default btn-left" data-dismiss="modal">返&nbsp;&nbsp;回</button>
			    </div>
		    </form>
		  </div>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div>





<%@ include file="common/CommonJs.jsp" %>
<script type="text/JavaScript" src="/HGMSystem/js/roomRecord.js"></script>
<script type="text/JavaScript" src="/HGMSystem/js/dist/Calendar.js"></script>
<script type="text/JavaScript" src="/HGMSystem/js/commonCalendar.js"></script>
</body>
</html>