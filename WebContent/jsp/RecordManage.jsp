<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<title>ǰ̨Ԥ����Ϣ����</title>

<%@ include file="common/CommonWaiterHead.jsp" %>
</head>
<body onload="MM_preloadImages('image/ydxx1.jpg','image/djrz1.jpg','image/hfgl1.jpg','image/tfjz1.jpg','image/ydzrz1.jpg')">
<!-- header -->
<%@ include file="common/CommonHeader.jsp" %>

<!-- frame -->

<!-- content -->
<div id="content">
<div class="maincontent">
<div class="worklist">
<div id="allroom">
<div id="search">
    <form id="form1" name="form1" method="post" action="roomsearch">
      <label for="Submit"></label>
      <label for="textfield">Ԥ������</label>
      <input name="textfield" type="text" id="textfield" size="18" maxlength="20" />
      <label for="label">Ԥ����</label>
      <input name="textfield2" type="text" id="label" size="18" maxlength="20" />
      <label for="select"></label>
      <label for="label2"></label>
       <label for="label3"></label>
       <label for="label2">�ͷ����</label>
       <input name="textfield3" type="text" id="label2" size="18" maxlength="20" /><br />
       <label for="select">�ͷ�����</label>
       <select name="select" id="select">
         <option>��ͨ�󴲷�</option>
         <option>�����󴲷�</option>
       </select>
       <label for="label3"></label>
       <input type="button" name="searchroom" value="&#25628;&#32034;&#25151;&#38388;" id="searchroom" />
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
	<th width="188" height="55">Ԥ������</th>
	<th width="188">Ԥ����</th>
	<th width="188">Ԥ��״̬</th>
	<th width="62">¥��</th>
	<th width="62">�޸�</th>
	<th width="62">ɾ��</th>
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
        <h4 class="modal-title">�޸�Ԥ����Ϣ��</h4>
      </div>
      <div class="modal-body form-horizontal content">
        <div>
		    <form id="form2" name="form2" method="post" action="update">
		    	
		      <div class="form-group">
				    <label class="col-sm-2 control-label">Ԥ������</label>
				    <div class="col-sm-10">
				    	<input class="form-control" name="rsrvnum" />
				    </div>
			    </div>
			    
			     <div class="form-group">
				    <label class="col-sm-2 control-label">�ͷ����</label>
				    <div class="col-sm-10">
				    	<input class="form-control" name="roomnum" />
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
				    	<input class="form-control" name="discprice" />
				    </div>
			    </div>
			    
			        <div class="form-group">
				    <label class="col-sm-2 control-label">Ѻ��</label>
				    <div class="col-sm-10">
				    	<input class="form-control" name="deposit" />
				    </div>
			    </div>
			    
			        <div class="form-group">
				    <label class="col-sm-2 control-label">Ԥ����</label>
				    <div class="col-sm-10">
				    	<input class="form-control" name="resname" />
				    </div>
			    </div>
			    
			      <div class="form-group">
				    <label class="col-sm-2 control-label">֤�����</label>
				    <div class="col-sm-10">
				    	<select name="idtype" id="select">
					        <option>���֤</option>
					        <option>����</option>
					        <option>����֤</option>
					     </select>
				    </div>
			    </div>
			    
			     <div class="form-group">
				    <label class="col-sm-2 control-label">֤������</label>
				    <div class="col-sm-10">
				    	<input class="form-control" name="idnum" />
				    </div>
			    </div>
			    
			        <div class="form-group">
				    <label class="col-sm-2 control-label">��ϵ�绰</label>
				    <div class="col-sm-10">
				    	<input class="form-control" name="telnum" />
				    </div>
			    </div>
			    
			     <div class="form-group">
				    <label class="col-sm-2 control-label">��סʱ��</label>
				    <div class="col-sm-10">
				    	<input class="form-control" name="arrivingdt" />
				    </div>
			    </div>
			    
			     <div class="form-group">
				    <label class="col-sm-2 control-label">�˷�ʱ��</label>
				    <div class="col-sm-10">
				    	<input class="form-control" name="departuredt" />
				    </div>
			    </div>
			    
			    <!--  <div class="form-group">
				    <label class="col-sm-2 control-label">��ס����</label>
				    <div class="col-sm-10">
				    	<input class="form-control" name="reservation." />
				    </div>
			    </div> -->
			    
			     <div class="form-group">
				    <label class="col-sm-2 control-label">����Ա</label>
				    <div class="col-sm-10">
				    	<input class="form-control" name="staffid" />
				    </div>
			    </div>
			    
			      <div class="form-group">
				    <label class="col-sm-2 control-label">��Ա���</label>
				    <div class="col-sm-10">
				    	<input class="form-control" name="numid" />
				    </div>
			    </div>
			    
			     <div class="form-group">
				    <label class="col-sm-2 control-label">��Ա��</label>
				    <div class="col-sm-10">
				    	<input class="form-control" name="vmprice" />
				    </div>
			    </div>
			       <div class="form-group">
				    <label class="col-sm-2 control-label">��ע</label>
				    <div class="col-sm-10">
				    	<input class="form-control" name="remarks" />
				    </div>
			    </div>
			    
			    <div class="form-group">
				    <button type="submit" class="btn btn-primary btn-right">��&nbsp;&nbsp;��</button>
        			<button type="button" class="btn btn-default btn-left" data-dismiss="modal">��&nbsp;&nbsp;��</button>
			    </div>
		    </form>
		  </div>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div>


<%@ include file="common/CommonJs.jsp" %>
<script type="text/JavaScript" src="/HGMSystem/js/recordManage.js"></script>
</body>
</html>