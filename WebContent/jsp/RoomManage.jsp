<%@page import="entity.Room"%>
<%@page import="entity.Member"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>�Ƶ�ͷ�����ϵͳ-�ͷ���Ϣ��������</title>
<%@ include file="common/CommonAdminHead.jsp" %>

</head>
<body onload="MM_preloadImages('image/bg_sub_sidebar_bottom_she_����.jpg','image/splbgl1.jpg','image/spxxgl1.jpg','image/kflxgl1.jpg','image/kfxxgl1.jpg','image/lcgl1.jpg','image/yhgl1.jpg','image/rzgl1.jpg','image/hygl1.jpg')">    
<!-- header -->
<%@ include file="common/CommonHeader.jsp" %>

<!-- content -->
<div id="content">
<div class="maincontent">
<div class="worklist">
<div id="alltable">
  <div id="search">
    <form id="form1" class="pull-left" name="form1" method="post" action="roomsearch">
      <input name="textfield" type="text" class="searchtext" id="textfield" size="20" maxlength="30" />
      </span>
      <label for="Submit"><span class="message">�ͷ���Ϣ�ؼ���</span></label>
      <span class="message">
      <input type="button"  class="adminsearch"name="adminsearch" id="adminsearch" value="�� ��" />
      </span>
    </form>
    <input type="button"  class="adminAdd pull-right"name="adminAdd" value="����" />
  </div>
  <div id="worklist">
    <p class="roommanage"><img src="/HGMSystem/image/kfgl.jpg" alt="�ͷ�����" width="200px" height="80px"/><a href="FloorManage.jsp" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('lcgl','','/HGMSystem/image/lcgl1.jpg',1)"><img src="/HGMSystem/image/lcgl.jpg" alt="¥�����" name="lcgl" width="200" height="30" border="0" id="lcgl" /></a><a href="RoomTypeManage.jsp" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('roomtypemanage','','/HGMSystem/image/kflxgl1.jpg',0)"><img src="/HGMSystem/image/kflxgl.jpg" alt="�ͷ����͹���" name="roomtypemanage" width="200" height="30" border="0" id="roomtypemanage" /></a><a href="roomtypemanage.html"></a><a href="RoomManage.jsp" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('roommanage','','/HGMSystem/image/kfxxgl1.jpg',1)"><img src="/HGMSystem/image/kfxxgl.jpg" alt="�ͷ���Ϣ����" name="roommanage" width="200" height="30" border="0" id="roommanage" /></a><a href="roommanage.html" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('roominformationmanage','','image//HGMSystem/kflxgl1.jpg',1)"></a><a href="roommanage.html"></a></p>
    <p class="systemmanage"><img src="/HGMSystem/image/xtgl.jpg" alt="ϵͳ����" width="200px" height="80px"/><a href="UserManage.jsp" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('yhgl','','/HGMSystem/image/yhgl1.jpg',1)"><img src="/HGMSystem/image/yhgl.jpg" alt="�û�����" name="yhgl" width="200" height="30" border="0" id="yhgl" /></a><a href="MemberManage.jsp" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('membermanage','','/HGMSystem/image/hygl1.jpg',0)"><img src="/HGMSystem/image/hygl.jpg" alt="��Ա����" name="membermanage" width="200" height="30" border="0" id="membermanage" /></a><a href="membermanage.html" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('usermanage','','/HGMSystem/image/hygl1.jpg',1)"></a><a href="membermanage.html"></a><a href="BlogManage.jsp" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('blogmanage','','/HGMSystem/image/rzgl1.jpg',1)"><img src="/HGMSystem/image/rzgl.jpg" alt="��־����" name="blogmanage" width="200" height="30" border="0" id="blogmanage" /></a><a href="blogmanage.html"></a></p>
    <p class="goodmanage"><img src="/HGMSystem/image/spgl.jpg" alt="��Ʒ����" width="200px" height="80px"/><a href="#" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('1','','/HGMSystem/image/bg_sub_sidebar_bottom_she_����.jpg',1)"></a><a href="GoodTypeManage.jsp" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('splbgl','','/HGMSystem/image/splbgl1.jpg',1)"><img src="/HGMSystem/image/splbgl.jpg" alt="��Ʒ������" name="splbgl" width="200" height="30" border="0" id="splbgl" /></a><a href="GoodManage.jsp" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('spxxgl','','/HGMSystem/image/spxxgl1.jpg',1)"><img src="/HGMSystem/image/spxxgl.jpg" alt="��Ʒ��Ϣ����" name="spxxgl" width="200" height="30" border="0" id="spxxgl" /></a></p>
  </div>
  <div id="allttable">
    <table width="740"  class="formtable"  border="1px">
      <tr>
		<th width="150"> �ͷ����</th>
		<th width="150">����</th>
		<th width="60">¥��</th>
		<th width="260">��ע</th>
		<th width="60">�޸�</th>
		<th width="60">ɾ��</th>
	  </tr>
	 
	 <% List<Room> rooms = new ArrayList();
 		for(int i=0; i<1; i++) {
 	  		Room room = new Room();
 	        room.setId(i);
 	        room.setFloorname("floorName" + i);
 	        room.setTypeid(i);
 	        room.setRemarks("remarks" + i);
 	    	rooms.add(room);	
 		}
  
	 	for (Room room : rooms) { 
	 %>	
	 	 	<tr>
	 			<th width="150"><%=room.getId() %></th>
				<th width="150"><%=room.getTypeid() %></th>
				<th width="60"><%=room.getFloorname() %></th>
				<th width="260"><%=room.getRemarks() %></th>
				<th width="60"><a href="">�޸�</a></th>
				<th width="60"><a href="">ɾ��</a></th>
	 		</tr>
	 <%
	 	}
	 %>
</table>

  </div>
  </div>
</div>
</div>
</div>

<!--Begin of Add New Room Modal  -->
<div class="modal fade" id="AddRoomModal" tabindex="-1" role="dialog" aria-labelledby="AddRoomLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">�����ͷ�</h4>
      </div>
      <div class="modal-body form-horizontal content">
  		<div>
		    <form id="form2" name="form2" method="post" action="add">
		    	<div class="form-group">
				    <label class="col-sm-2 control-label">�ͷ����</label>
				    <div class="col-sm-10">
				    	<input class="form-control" name="number" />
				    </div>
			    </div>
			    <div class="form-group">
				    <label class="col-sm-2 control-label">�ͷ�����</label>
				    <div class="col-sm-10">
				    	<select name="name" id="select">
					        <option>��ͨ�ͷ�</option>
					        <option>��Ʒ�ͷ�</option>
					        <option>�����ͷ�</option>
					        <option>�������ͷ�</option>
					     </select>
				    </div>
			    </div>
			    <div class="form-group">
				    <label class="col-sm-2 control-label">������</label>
				    <div class="col-sm-10">
				    	<select name="adultNum" id="select">
					        <option>1</option>
					        <option>2</option>
					        <option>3</option>
					     </select>
				    </div>
			    </div>
			    <div class="form-group">
				    <label class="col-sm-2 control-label">��ͯ��</label>
				    <div class="col-sm-10">
				    	<select name="childNum" id="select">
					        <option>1</option>
					        <option>2</option>
					        <option>3</option>
					     </select>
				    </div>
			    </div>
			    <div class="form-group">
				    <label class="col-sm-2 control-label">����</label>
				    <div class="col-sm-10">
				    	<select name="bedStyle" id="select">
					        <option>��</option>
					        <option>˫��</option>
					        <option>�׷�</option>
					     </select>
				    </div>
			    </div>
			    <div class="form-group">
				    <label class="col-sm-2 control-label">¥��</label>
				    <div class="col-sm-10">
				    	<select name="layer" id="select">
					        <option>1</option>
					        <option>2</option>
					        <option>3</option>
					        <option>4</option>
					        <option>5</option>
					     </select>
				    </div>
			    </div>
			    <div class="form-group">
				    <label class="col-sm-2 control-label">����Ҫ��</label>
				    <div class="col-sm-10">
				    	      <input type="checkbox" name="smoke" value="checkbox" id="checkbox" />
						      <label for="checkbox">���̷�</label>
						      <input type="checkbox" name="wifi" value="checkbox" id="checkbox2" />
						      <label for="checkbox2">��WIFI</label>
				    </div>
			    </div>
		        <div class="form-group">
				    <label class="col-sm-2 control-label">��ע</label>
				    <div class="col-sm-10">
				    	<textarea class="form-control" name="note" rows="3" ></textarea>
				    </div>
			    </div>
		    </form>
		  </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary btn-right">��&nbsp;&nbsp;��</button>
        <button type="button" class="btn btn-default btn-left" data-dismiss="modal">��&nbsp;&nbsp;��</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div>
<!--End of Add New Room Modal  -->

<!--Begin of Update Room Modal  -->
<div class="modal fade" id="UpdateRoomModal" tabindex="-1" role="dialog" aria-labelledby="UpdateRoomLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">�޸Ŀͷ�</h4>
      </div>
      <div class="modal-body form-horizontal content">
  		<div>
		    		    <form id="form2" name="form2" method="post" action="update">
		    	<div class="form-group">
				    <label class="col-sm-2 control-label">�ͷ����</label>
				    <div class="col-sm-10">
				    	<input class="form-control" name="number" />
				    </div>
			    </div>
			    <div class="form-group">
				    <label class="col-sm-2 control-label">�ͷ�����</label>
				    <div class="col-sm-10">
				    	<select name="name" id="select">
					        <option>��ͨ�ͷ�</option>
					        <option>��Ʒ�ͷ�</option>
					        <option>�����ͷ�</option>
					        <option>�������ͷ�</option>
					     </select>
				    </div>
			    </div>
			    <div class="form-group">
				    <label class="col-sm-2 control-label">������</label>
				    <div class="col-sm-10">
				    	<select name="adultNum" id="select">
					        <option>1</option>
					        <option>2</option>
					        <option>3</option>
					     </select>
				    </div>
			    </div>
			    <div class="form-group">
				    <label class="col-sm-2 control-label">��ͯ��</label>
				    <div class="col-sm-10">
				    	<select name="childNum" id="select">
					        <option>1</option>
					        <option>2</option>
					        <option>3</option>
					     </select>
				    </div>
			    </div>
			    <div class="form-group">
				    <label class="col-sm-2 control-label">����</label>
				    <div class="col-sm-10">
				    	<select name="bedStyle" id="select">
					        <option>��</option>
					        <option>˫��</option>
					        <option>�׷�</option>
					     </select>
				    </div>
			    </div>
			    <div class="form-group">
				    <label class="col-sm-2 control-label">¥��</label>
				    <div class="col-sm-10">
				    	<select name="layer" id="select">
					        <option>1</option>
					        <option>2</option>
					        <option>3</option>
					        <option>4</option>
					        <option>5</option>
					     </select>
				    </div>
			    </div>
			    <div class="form-group">
				    <label class="col-sm-2 control-label">����Ҫ��</label>
				    <div class="col-sm-10">
				    	      <input type="checkbox" name="smoke" value="checkbox" id="checkbox" />
						      <label for="checkbox">���̷�</label>
						      <input type="checkbox" name="wifi" value="checkbox" id="checkbox2" />
						      <label for="checkbox2">��WIFI</label>
				    </div>
			    </div>
		        <div class="form-group">
				    <label class="col-sm-2 control-label">��ע</label>
				    <div class="col-sm-10">
				    	<textarea class="form-control" name="note" rows="3" ></textarea>
				    </div>
			    </div>
		    </form>
		  </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary btn-right">��&nbsp;&nbsp;��</button>
        <button type="button" class="btn btn-default btn-left" data-dismiss="modal">��&nbsp;&nbsp;��</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div>
<!--End of Update Room Modal  -->
<!-- footer -->
<%@ include file="common/CommonJs.jsp" %>
<script type="text/JavaScript" src="/HGMSystem/js/roomManage.js"></script>
</body>
</html>