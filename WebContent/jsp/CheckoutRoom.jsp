<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<title>退房结账管理</title>
<%@ include file="common/CommonWaiterHead.jsp" %>
</head>
<body onload="MM_preloadImages('/HGMSystem/image/kfyd1.jpg','/HGMSystem/image/ydxx1.jpg','/HGMSystem/image/djrz1.jpg','/HGMSystem/image/hfgl1.jpg','/HGMSystem/image/tfjz1.jpg','/HGMSystem/image/ydzrz1.jpg')">
<!-- header -->
<%@ include file="common/CommonHeader.jsp" %>

<!-- content -->
<div id="content">
<div class="maincontent">
<div class="worklist">
<div id="allroom">
  <div id="search">
  
    <form id="form1" class="searchcheckoutroom" name="form1" method="post" action="roomsearch">
      <label for="textfield">入住单号</label>
      <input name="CheckInNumtextfield" type="text" id="CheckInNumtextfield" tabindex="6位数字" size="10" maxlength="10" />
      <label for="label">房间类型</label>
      <select name="select2" id="label">
        <option>单人间</option>
        <option>双人间</option>
        <option>大床房</option>
        <option>钟点房</option>
      </select>
      <label for="label2">客房编号</label>
      <input name="RoomNumtextfield" type="text" id="label2" size="10" maxlength="8" />
      <br />
      <label for="label3">入住人</label>
      <input name="Nametextfield" type="text" id="label3" size="10" maxlength="8" />
 	  <label for="textfield" >入住时间</label>
      <input name="textfield" type="text" id="textfield" size="10"  onFocus="c.showMoreDay = false;c.show(this);" />
      <label for="label4">退房时间</label>
      <input name="textfield2" type="text" id="label4" size="10" onFocus="c.showMoreDay = false;c.show(this);"/>
      <input type="submit" name="searchroom" value="&#25628;&#32034;&#25151;&#38388;" id="searchroom" />
      
        
        <!-- 退房信息单 -->
       <input type="button"  class="checkoutSheet pull-right" name="checkoutSheet" value="退房信息单" />  
        
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
	<th width="100" >客房编号</th>
	<th width="100">房间类型</th>
	<th width="100">房间楼层</th>
	<th width="100">房间状态</th>
	<th width="240">备注</th>
	<th width="100">退房</th>
</tr>

</table>
  </div>
</div>
</div>
</div>


<!--Begin of CheckoutSheet Modal  -->
<div class="modal fade" id="CheckoutSheetModal" tabindex="-1" role="dialog" aria-labelledby="CheckoutRoomLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">退房对账单</h4>
      </div>
      <div class="modal-body form-horizontal content">
  		<div>
		    <form id="form2" name="form2" method="post" action="checkoutroom">
		    	
		    	<div class="form-group">
				    <label class="col-sm-2 control-label">入住单号</label>
				    <div class="col-sm-10">
				    	<input class="form-control" name="checkinnum"  />
				    </div>
				    </div>
				    
				    
				    <div class="form-group">
				    <label class="col-sm-2 control-label">客房编号</label>
				    <div class="col-sm-10">
				    	<input class="form-control" name="checkinnum"  />
				    </div>
				    </div>
				    
   <div class="form-group">
				    <label class="col-sm-2 control-label">房费</label>
				    <div class="col-sm-10">
				    	<input class="form-control" name="checkinnum"  />
				    </div>
				    </div>
				    
				    
  <div class="form-group">
				    <label class="col-sm-2 control-label">商品折扣</label>
				    <div class="col-sm-10">
				    	<input class="form-control" name="checkinnum"  />
				    </div>
				    </div>
				    
				  <div class="form-group">
				    <label class="col-sm-2 control-label">折后消费</label>
				    <div class="col-sm-10">
				    	<input class="form-control" name="checkinnum"  />
				    </div>
				    </div>
				    
				    <div class="form-group">
				    <label class="col-sm-2 control-label">餐费</label>
				    <div class="col-sm-10">
				    	<input class="form-control" name="checkinnum"  />
				    </div>
				    </div>
				    
				    <div class="form-group">
				    <label class="col-sm-2 control-label">电话费</label>
				    <div class="col-sm-10">
				    	<input class="form-control" name="checkinnum"  />
				    </div>
				    </div>
				 
    
			    
				    
				    
     <div class="form-group">
				    <label class="col-sm-2 control-label">应收</label>
				    <div class="col-sm-10">
				    	<input class="form-control" name="idnum"  />
				    </div>
				    </div>
				    
	   <div class="form-group">
				    <label class="col-sm-2 control-label">付款方式</label>
				    <div class="col-sm-10">
				    	<select name="idtype" id="select">
					        <option>现金</option>
					        <option>刷卡</option>
					      </select>
					      </div>
			    </div>
		 <div class="form-group">
				    <label class="col-sm-2 control-label">实收</label>
				    <div class="col-sm-10">
				    	<input class="form-control" name="idnum"  />
				    </div>
				    </div>
					      
	<div class="form-group">
				    <label class="col-sm-2 control-label">找零</label>
				    <div class="col-sm-10">
				    	<input class="form-control" name="idnum"  />
				    </div>
				    </div>
				    
				    
				    
   
	<div class="form-group">
				    <label class="col-sm-2 control-label">操作员</label>
				    <div class="col-sm-10">
				    	<input class="form-control" name="note"  />
				    </div>
				    </div> 
     
		    </form>
		  </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary btn-right">打&nbsp;印</button>
        <button type="button" class="btn btn-default btn-left" data-dismiss="modal">返回</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div>
<!--End of Add New Floor Modal  -->


</div>

<!-- footer -->
<%@ include file="common/CommonJs.jsp" %>
<script type="text/JavaScript" src="/HGMSystem/js/dist/Calendar.js"></script>
<script type="text/JavaScript" src="/HGMSystem/js/checkout.js"></script>
<script type="text/JavaScript" src="/HGMSystem/js/commonCalendar.js"></script>
<script type="text/JavaScript" src="/HGMSystem/js/checkoutRoom.js"></script>
</body>
</html>