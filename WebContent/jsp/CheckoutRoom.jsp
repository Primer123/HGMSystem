<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<title>�˷����˹���</title>
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
      <label for="textfield">��ס����</label>
      <input name="CheckInNumtextfield" type="text" id="CheckInNumtextfield" tabindex="6λ����" size="10" maxlength="10" />
      <label for="label">��������</label>
      <select name="select2" id="label">
        <option>���˼�</option>
        <option>˫�˼�</option>
        <option>�󴲷�</option>
        <option>�ӵ㷿</option>
      </select>
      <label for="label2">�ͷ����</label>
      <input name="RoomNumtextfield" type="text" id="label2" size="10" maxlength="8" />
      <br />
      <label for="label3">��ס��</label>
      <input name="Nametextfield" type="text" id="label3" size="10" maxlength="8" />
 	  <label for="textfield" >��סʱ��</label>
      <input name="textfield" type="text" id="textfield" size="10"  onFocus="c.showMoreDay = false;c.show(this);" />
      <label for="label4">�˷�ʱ��</label>
      <input name="textfield2" type="text" id="label4" size="10" onFocus="c.showMoreDay = false;c.show(this);"/>
      <input type="submit" name="searchroom" value="&#25628;&#32034;&#25151;&#38388;" id="searchroom" />
      
        
        <!-- �˷���Ϣ�� -->
       <input type="button"  class="checkoutSheet pull-right" name="checkoutSheet" value="�˷���Ϣ��" />  
        
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
	<th width="100" >�ͷ����</th>
	<th width="100">��������</th>
	<th width="100">����¥��</th>
	<th width="100">����״̬</th>
	<th width="240">��ע</th>
	<th width="100">�˷�</th>
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
        <h4 class="modal-title">�˷����˵�</h4>
      </div>
      <div class="modal-body form-horizontal content">
  		<div>
		    <form id="form2" name="form2" method="post" action="checkoutroom">
		    	
		    	<div class="form-group">
				    <label class="col-sm-2 control-label">��ס����</label>
				    <div class="col-sm-10">
				    	<input class="form-control" name="checkinnum"  />
				    </div>
				    </div>
				    
				    
				    <div class="form-group">
				    <label class="col-sm-2 control-label">�ͷ����</label>
				    <div class="col-sm-10">
				    	<input class="form-control" name="checkinnum"  />
				    </div>
				    </div>
				    
   <div class="form-group">
				    <label class="col-sm-2 control-label">����</label>
				    <div class="col-sm-10">
				    	<input class="form-control" name="checkinnum"  />
				    </div>
				    </div>
				    
				    
  <div class="form-group">
				    <label class="col-sm-2 control-label">��Ʒ�ۿ�</label>
				    <div class="col-sm-10">
				    	<input class="form-control" name="checkinnum"  />
				    </div>
				    </div>
				    
				  <div class="form-group">
				    <label class="col-sm-2 control-label">�ۺ�����</label>
				    <div class="col-sm-10">
				    	<input class="form-control" name="checkinnum"  />
				    </div>
				    </div>
				    
				    <div class="form-group">
				    <label class="col-sm-2 control-label">�ͷ�</label>
				    <div class="col-sm-10">
				    	<input class="form-control" name="checkinnum"  />
				    </div>
				    </div>
				    
				    <div class="form-group">
				    <label class="col-sm-2 control-label">�绰��</label>
				    <div class="col-sm-10">
				    	<input class="form-control" name="checkinnum"  />
				    </div>
				    </div>
				 
    
			    
				    
				    
     <div class="form-group">
				    <label class="col-sm-2 control-label">Ӧ��</label>
				    <div class="col-sm-10">
				    	<input class="form-control" name="idnum"  />
				    </div>
				    </div>
				    
	   <div class="form-group">
				    <label class="col-sm-2 control-label">���ʽ</label>
				    <div class="col-sm-10">
				    	<select name="idtype" id="select">
					        <option>�ֽ�</option>
					        <option>ˢ��</option>
					      </select>
					      </div>
			    </div>
		 <div class="form-group">
				    <label class="col-sm-2 control-label">ʵ��</label>
				    <div class="col-sm-10">
				    	<input class="form-control" name="idnum"  />
				    </div>
				    </div>
					      
	<div class="form-group">
				    <label class="col-sm-2 control-label">����</label>
				    <div class="col-sm-10">
				    	<input class="form-control" name="idnum"  />
				    </div>
				    </div>
				    
				    
				    
   
	<div class="form-group">
				    <label class="col-sm-2 control-label">����Ա</label>
				    <div class="col-sm-10">
				    	<input class="form-control" name="note"  />
				    </div>
				    </div> 
     
		    </form>
		  </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary btn-right">��&nbsp;ӡ</button>
        <button type="button" class="btn btn-default btn-left" data-dismiss="modal">����</button>
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