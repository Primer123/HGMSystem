 <%@page import="model.MemberInfo"%>
<%@ page contentType="text/html; charset=gb2312" language="java"
	import="java.sql.*" errorPage=""%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>�Ƶ�ͷ�����-��Ա�������</title>
<%@ include file="common/CommonAdminHead.jsp" %>

</head>
<body onload="MM_preloadImages('image/bg_sub_sidebar_bottom_she_����.jpg','image/kfxxgl1.jpg','image/lcgl1.jpg','image/yhgl1.jpg','image/rzgl1.jpg','image/splbgl1.jpg','image/spxxgl1.jpg')">    
<!-- header -->
<%@ include file="common/CommonHeader.jsp" %>

<!-- content -->
<div id="content">
<div class="maincontent">
<div class="worklist">
<div id="alltable">
  <div id="search">
    <form id="form1" class="pull-left" name="form1" method="post" action="membersearch">
      <input name="keyword" type="text" class="searchtext" id="textfield" size="20" maxlength="30" />
      </span>
      <label for="Submit"><span class="message">��Ա��Ϣ�ؼ���</span></label>
      <span class="message">
      <input type="submit"  class="adminsearch"name="adminsearch" id="adminsearch" value="�� ��" />
      </span>
    </form>

    <input type="button"  class="adminAdd pull-right" name="adminAdd" value="����" />
  </div>
  <div id="worklist">
    <p class="roommanage"><img src="/HGMSystem/image/kfgl.jpg" alt="�ͷ�����" width="200px" height="80px"/><a href="FloorManage.jsp" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('lcgl','','/HGMSystem/image/lcgl1.jpg',1)"><img src="/HGMSystem/image/lcgl.jpg" alt="¥�����" name="lcgl" width="200" height="30" border="0" id="lcgl" /></a><a href="RoomTypeManage.jsp" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('roomtypemanage','','/HGMSystem/image/kflxgl1.jpg',0)"><img src="/HGMSystem/image/kflxgl.jpg" alt="�ͷ����͹���" name="roomtypemanage" width="200" height="30" border="0" id="roomtypemanage" /></a><a href="roomtypemanage.html"></a><a href="RoomManage.jsp" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('roommanage','','/HGMSystem/image/kfxxgl1.jpg',1)"><img src="/HGMSystem/image/kfxxgl.jpg" alt="�ͷ���Ϣ����" name="roommanage" width="200" height="30" border="0" id="roommanage" /></a><a href="roommanage.html" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('roominformationmanage','','image//HGMSystem/kflxgl1.jpg',1)"></a><a href="roommanage.html"></a></p>
    <p class="systemmanage"><img src="/HGMSystem/image/xtgl.jpg" alt="ϵͳ����" width="200px" height="80px"/><a href="UserManage.jsp" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('yhgl','','/HGMSystem/image/yhgl1.jpg',1)"><img src="/HGMSystem/image/yhgl.jpg" alt="�û�����" name="yhgl" width="200" height="30" border="0" id="yhgl" /></a><a href="MemberManage.jsp" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('membermanage','','/HGMSystem/image/hygl1.jpg',0)"><img src="/HGMSystem/image/hygl.jpg" alt="��Ա����" name="membermanage" width="200" height="30" border="0" id="membermanage" /></a><a href="membermanage.html" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('usermanage','','/HGMSystem/image/hygl1.jpg',1)"></a><a href="membermanage.html"></a><a href="BlogManage.jsp" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('blogmanage','','/HGMSystem/image/rzgl1.jpg',1)"><img src="/HGMSystem/image/rzgl.jpg" alt="��־����" name="blogmanage" width="200" height="30" border="0" id="blogmanage" /></a><a href="blogmanage.html"></a></p>
    <p class="goodmanage"><img src="/HGMSystem/image/spgl.jpg" alt="��Ʒ����" width="200px" height="80px"/><a href="#" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('1','','/HGMSystem/image/bg_sub_sidebar_bottom_she_����.jpg',1)"></a><a href="GoodTypeManage.jsp" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('splbgl','','/HGMSystem/image/splbgl1.jpg',1)"><img src="/HGMSystem/image/splbgl.jpg" alt="��Ʒ������" name="splbgl" width="200" height="30" border="0" id="splbgl" /></a><a href="GoodManage.jsp" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('spxxgl','','/HGMSystem/image/spxxgl1.jpg',1)"><img src="/HGMSystem/image/spxxgl.jpg" alt="��Ʒ��Ϣ����" name="spxxgl" width="200" height="30" border="0" id="spxxgl" /></a></p>
  </div>
<div id="allttable">
    <table width="740"  class="formtable"  border="1px">
      <tr>
		<th width="200"> ��Ա���</th>
		<th width="200">��Ա����</th>
		<th width="200">��ע</th>
		<th width="70">�޸�</th>
		<th width="70">ɾ��</th>
	  </tr>
	 <% List memberInfos = (List)request.getAttribute("memberInfos");
    	if(memberInfos != null) {
	 		for (Object object : memberInfos) { 
	 			MemberInfo memberInfo = (MemberInfo)object;
	 %>	
		 	 	<tr>
		 			<th width="200"><%=memberInfo.getId() %></th>
					<th width="200"><%=memberInfo.getName() %></th>
					<th width="200"><%=memberInfo.getRemarks() %></th>
					<th width="70"><a href="<s:url action="getInfo"><s:param name="id"><%=memberInfo.getId() %></s:param></s:url>"/>�޸�</a></th>
					<th width="70"><a href="<s:url action="delete"><s:param name="id"><%=memberInfo.getId() %></s:param></s:url>"/>ɾ��</a></th>
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

<div class="modal fade" id="AddMemberModal" tabindex="-1" role="dialog" aria-labelledby="AddMemberLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">������Ա</h4>
      </div>
      <div class="modal-body form-horizontal content">
        <div>
		    <form id="add_form" name="add_form" method="post" action="add">
		    	
		      <div class="form-group">
				    <label class="col-sm-2 control-label">��&nbsp;&nbsp;��</label>
				    <div class="col-sm-10">
				    	<input class="form-control" name="member.name" />
				    </div>
			    </div>
			    <div class="form-group">
				    <label class="col-sm-2 control-label">��&nbsp;&nbsp;��</label>
				    <div class="col-sm-10">
				    	<select name="member.gender" id="select">
					        <option value="0">Ů</option>
					        <option value="1">��</option>
					     </select>

				    </div>
			    </div>
			    <div class="form-group">
				    <label class="col-sm-2 control-label">��&nbsp;&nbsp;��</label>
				    <div class="col-sm-10">
				    	<input class="form-control" name="member.password" />
				    </div>
			    </div>
			    <div class="form-group">
				    <label class="col-sm-2 control-label">��&nbsp;&nbsp;��</label>
				    <div class="col-sm-10">
				    	<input class="form-control" name="member.telnum" />
				    </div>
			    </div>
			    <div class="form-group">
				    <label class="col-sm-2 control-label">��&nbsp;&nbsp;ַ</label>
				    <div class="col-sm-10">
				    	<input class="form-control" name="member.address" />
				    </div>
			    </div>
				<div class="form-group">
				    <label class="col-sm-2 control-label">Email</label>
				    <div class="col-sm-10">
				    	<input class="form-control" name="member.email" />
				    </div>
			    </div>
		        <div class="form-group">
				    <label class="col-sm-2 control-label">��ע</label>
				    <div class="col-sm-10">
				    	<textarea class="form-control" name="member.remarks" rows="3" ></textarea>
				    </div>
			    </div>
			    
			    <div class="form-group">
				    <button type="submit" onclick="saveadd()"class="btn btn-primary btn-right">��&nbsp;&nbsp;��</button>
        			<button type="button" class="btn btn-default btn-left" data-dismiss="modal">��&nbsp;&nbsp;��</button>
			    </div>
		    </form>
		  </div>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div>

<%
	Object memberInfoObj = request.getAttribute("singleMember");
	if (memberInfoObj != null) {
		MemberInfo memberInfo = (MemberInfo)memberInfoObj;
%>
<div class="modal fade" id="UpdateMemberModal" tabindex="-1" role="dialog" aria-labelledby="UpdateMemberLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">�޸Ļ�Ա��Ϣ</h4>
      </div>
      <div class="modal-body form-horizontal content">
        <div>
		    <form id="update_form" name="update_form" method="post" action="update">
		    	<div class="form-group">
				    <label class="col-sm-2 control-label">��&nbsp;&nbsp;��</label>
				    <div class="col-sm-10">
				    	<input class="form-control" name="number"><%=memberInfo.getId() %></input>
				    </div>
			    </div>
		      <div class="form-group">
				    <label class="col-sm-2 control-label">��&nbsp;&nbsp;��</label>
				    <div class="col-sm-10">
				    	<input class="form-control" name="name" ><%=memberInfo.getName() %></input>
				    </div>
			    </div>
			    <div class="form-group">
				    <label class="col-sm-2 control-label">��&nbsp;&nbsp;��</label>
				    <div class="col-sm-10">
				    	<input type="radio" name="male" value="radiobutton" id="radiobutton" />
	     				 ��      
	      				<input type="radio" name="female" value="radiobutton" id="radio" />
				   		Ů
				    </div>
			    </div>
			    <div class="form-group">
				    <label class="col-sm-2 control-label">��&nbsp;&nbsp;��</label>
				    <div class="col-sm-10">
				    	<input class="form-control" name="password" />
				    </div>
			    </div>
			    <div class="form-group">
				    <label class="col-sm-2 control-label">��&nbsp;&nbsp;��</label>
				    <div class="col-sm-10">
				    	<input class="form-control" name="phone" />
				    </div>
			    </div>
			    <div class="form-group">
				    <label class="col-sm-2 control-label">��&nbsp;&nbsp;ַ</label>
				    <div class="col-sm-10">
				    	<input class="form-control" name="address" />
				    </div>
			    </div>
				<div class="form-group">
				    <label class="col-sm-2 control-label">Email</label>
				    <div class="col-sm-10">
				    	<input class="form-control" name="email" />
				    </div>
			    </div>
		        <div class="form-group">
				    <label class="col-sm-2 control-label">��ע</label>
				    <div class="col-sm-10">
				    	<textarea class="form-control" name="note" rows="3" ></textarea>
				    </div>
			    </div>
			     <div class="form-group">
				    <button type="submit" onclick="saveupdate()" class="btn btn-primary btn-right">��&nbsp;&nbsp;��</button>
        			<button type="button" class="btn btn-default btn-left" data-dismiss="modal">��&nbsp;&nbsp;��</button>
			    </div>
		    </form>
		  </div>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div>
<%
	}
%>

<!-- footer -->
<%@ include file="common/CommonJs.jsp" %>
<script type="text/JavaScript" src="/HGMSystem/js/memberManage.js"></script>

	

</body>
</html>