<%@ page contentType="text/html; charset=gb2312" language="java" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>ǰ̨�Ǽ���ס����</title>
<%@ include file="common/CommonWaiterHead.jsp" %>
</head>
<body onload="MM_preloadImages('/HGMSystem/image/djrz1.jpg','/HGMSystem/image/hfgl1.jpg','/HGMSystem/image/tfjz1.jpg','/HGMSystem/image/ydxx1.jpg','/HGMSystem/image/ydzrz1.jpg')">
<!-- header -->
<%@ include file="common/CommonHeader.jsp" %>

<!-- content -->
<div id="content">
<div class="maincontent">
<div class="worklist">
<div id="allroom">

<div id="search">

	<!-- generate unique ID -->
	<div class="checkInId"><%@ include file="common/GenerateUniqueId.jsp" %></div>
	
    <form  method="post" enctype="multipart/form-data" name="room_form" id="room_form" action="roomsearch">
      <label for="textfield" >��סʱ��</label>
      <input name="arrivingdt" type="text" id="textfield" size="10"  onFocus="c.showMoreDay = false;c.show(this);" />
      <label for="label4">�˷�ʱ��</label>
      <input name="textfield2" type="text" id="label4" size="10" onFocus="c.showMoreDay = false;c.show(this);"/>
      <label for="select">������</label>
      <select name="select" id="select">
        <option>1</option>
        <option>2</option>
        <option>3</option>
      </select>
      <label for="textfield"></label> 
      <label for="file"></label>
      <br />
      <label for="label2">��������</label>
      <select name="select3" id="label2">
        <option>��׼��</option>
        <option>������</option>
      </select>
      <label for="label2"></label>
      <input type="radio" name="radiobutton" value="radiobutton" id="radiobutton" />
      <label for="radiobutton">���̷�</label>
      <input type="radio" name="radiobutton" value="radiobutton" id="radio" />
      <label for="radio">���̷�</label>
      <input type="submit" name="searchroom" value="&#25628;&#32034;&#25151;&#38388;" id="searchroom" />
      
        
       <!--  ���ԵǼ���ס��-->
        <input type="button"  class="waiterCheckin pull-right" name="waiterCheckin" value="�Ǽ���ס��" /> 
        
    </form>
   
    </div>
 <div id="allroomlayer">
  
  <a href="RoomRecord.jsp" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('roomrecord','','/HGMSystem/image/kfyd1.jpg',1)"><img src="/HGMSystem/image/kfyd.jpg" name="roomrecord" width="250" height="80" border="0" id="roomrecord" /></a>
  <a href="RecordManage.jsp" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('recordmanage','','/HGMSystem/image/ydxx1.jpg',1)"><img src="/HGMSystem/image/ydxx.jpg" name="recordmanage" width="250" height="80" border="0" id="recordmanage" /></a>
  <a href="RecordCheckin.jsp" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('recordcheckin','','/HGMSystem/image/ydzrz1.jpg',1)"><img src="/HGMSystem/image/ydzrz.jpg" name="recordcheckin" width="250" height="80" border="0" id="recordcheckin" /></a>
  <a href="CheckinRoom.jsp" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('checkinRoom','','/HGMSystem/image/djrz1.jpg',1)"><img src="/HGMSystem/image/djrz.jpg" name="checkinRoom" width="250" height="80" border="0" id="checkinRoom" /></a>
  <a href="ChangeRoom.jsp" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('changeRoom','','/HGMSystem/image/hfgl1.jpg',1)"><img src="/HGMSystem/image/hfgl.jpg" name="changeRoom" width="250" height="80" border="0" id="changeRoom" /></a>
  <a href="Consumption.jsp" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('consumption','','/HGMSystem/image/xfgl1.jpg',1)"><img src="/HGMSystem/image/xfgl.jpg" name="consumption" width="250" height="80" border="0" id="consumption" /></a>
  <a href="CheckoutRoom.jsp" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('checkoutRoom','','/HGMSystem/image/tfjz1.jpg',1)"><img src="/HGMSystem/image/tfjz.jpg" name="checkoutRoom" width="250" height="80" border="0" id="checkoutRoom" /></a>
  
  </div>
  <div id="allroomtable" class="STYLE6">
    <table width="740"  class="roomtable"  border="1px">
      <tr>
	<th width="100" >�ͷ����</th>
	<th width="100">��������</th>
	<th width="100">����¥��</th>
	<th width="100">����״̬</th>
	<th width="240">��ע</th>
	<th width="100">������ס</th>
</tr>

</table>
  </div>
</div>
</div>
</div>
</div>

<!-- ֱ�Ӱ�����ס��Ϣ�� -->
<div class="modal fade" id="CheckinRoomModal" tabindex="-1" role="dialog" aria-labelledby="CheckinRoomLabel" aria-hidden="true">
 <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">�Ǽ���ס��Ϣ��</h4>
      </div>
      <div class="modal-body form-horizontal content">
  		<div>
               <form id="form1" name="checkinRoom" method="post" action="checkinroom">
  
	   <div class="form-group">
				    <label class="col-sm-2 control-label">��ס����</label>
				    <div class="col-sm-10">
				    	<input class="form-control" name="checkinnum"  />
				    </div>
				    </div>
      <div class="form-group">
				    <label class="col-sm-2 control-label">�ͷ����</label>
				    <div class="col-sm-10">
				    	<input class="form-control" name="roomnum"  />
				    </div>
				    </div>
	  <div class="form-group">
				    <label class="col-sm-2 control-label">�ͷ�����</label>
				    <div class="col-sm-10">
				    	<input class="form-control" name="roomtype" />
				    </div>
				    </div>
      
    <div class="form-group">
				    <label class="col-sm-2 control-label">��׼��</label>
				    <div class="col-sm-10">
				    	<input class="form-control" name="stdprice" />
				    </div>
				    </div>
      <div class="form-group">
				    <label class="col-sm-2 control-label">�ۺ��</label>
				    <div class="col-sm-10">
				    	<input class="form-control" name="discprice"  />
				    </div>
				    </div>
    <div class="form-group">
				    <label class="col-sm-2 control-label">Ѻ��</label>
				    <div class="col-sm-10">
				    	<input class="form-control" name="deposit"  />
				    </div>
				    </div>
    <div class="form-group">
				    <label class="col-sm-2 control-label">��ס��</label>
				    <div class="col-sm-10">
				    	<input class="form-control" name="checkinname"  />
				    </div>
				    </div>
				    
				    
     <div class="form-group">
				    <label class="col-sm-2 control-label">֤�����</label>
				    <div class="col-sm-10">
				    	<select name="idtype" id="select">
					        <option>����֤</option>
					        <option>����</option>
					        <option>����֤</option>
					     </select>
				    </div>
			    </div>
			    
				    
				    
     <div class="form-group">
				    <label class="col-sm-2 control-label">֤������</label>
				    <div class="col-sm-10">
				    	<input class="form-control" name="idnum"  />
				    </div>
				    </div>
    <div class="form-group">
				    <label class="col-sm-2 control-label">��ϵ�绰</label>
				    <div class="col-sm-10">
				    	<input class="form-control" name="telnum"  />
				    </div>
				    </div>
     <div class="form-group">
				    <label class="col-sm-2 control-label">�ֵ�ʱ��</label>
				    <div class="col-sm-10">
				    	<input class="form-control" name="arrivingdt"  />
				    </div>
				    </div>
      <div class="form-group">
				    <label class="col-sm-2 control-label">���ʱ��</label>
				    <div class="col-sm-10">
				    	<input class="form-control" name="departuredt" />
				    </div>
				    </div>      
	 <!-- <div class="form-group">
				    <label class="col-sm-2 control-label">��ס����</label>
				    <div class="col-sm-10">
				    	<input class="form-control" name="note"  />
				    </div>
				    </div> -->
      <div class="form-group">
				    <label class="col-sm-2 control-label">����Ա</label>
				    <div class="col-sm-10">
				    	<input class="form-control" name="staffid"  />
				    </div>
				    </div>
    <div class="form-group">
				    <label class="col-sm-2 control-label">��Ա���</label>
				    <div class="col-sm-10">
				    	<input class="form-control" name="numid"  />
				    </div>
				    </div>
      <div class="form-group">
				    <label class="col-sm-2 control-label">��Ա�۸�</label>
				    <div class="col-sm-10">
				    	<input class="form-control" name="vmprice"  />
				    </div>
				    </div>
      <div class="form-group">
				    <label class="col-sm-2 control-label">�ṩ���</label>
				    <div class="col-sm-10">
				    	<input class="form-control" name="breakfast"  />
				    </div>
				    </div>
      <div class="form-group">
				    <label class="col-sm-2 control-label">��ʱ����</label>
				    <div class="col-sm-10">
				    	<input class="form-control" name="wakeup"  />
				    </div>
				    </div>
      <div class="form-group">
				    <label class="col-sm-2 control-label">��ע</label>
				    <div class="col-sm-10">
				    	<input class="form-control" name="remarks"  />
				    </div>
				    </div>
		    </form>
		  </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary btn-right" >��&nbsp;ӡ</button>
        <button type="button" class="btn btn-default btn-left" data-dismiss="modal">��&nbsp;��</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div>
<!--End of Add New Floor Modal  -->




<!-- footer -->
<%@ include file="common/CommonJs.jsp" %>
<script type="text/JavaScript" src="/HGMSystem/js/dist/Calendar.js"></script>
<script type="text/JavaScript" src="/HGMSystem/js/checkinRoom.js"></script>
<script type="text/JavaScript" src="/HGMSystem/js/commonCalendar.js"></script>
</body>
</html>