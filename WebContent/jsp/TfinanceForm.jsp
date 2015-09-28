<%@page import="sheet.FinancialSheet"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<title>�ܾ���-���ղ��񱨱�</title>
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
    <form id="tfinance_form" name="tfinance_form"class="searchInfo"  method="post" action="TfinanceFormSearch">
    <!--   <label for="label3" >��ʼ����</label>
      <input name="startdt" type="text" id="textfield" size="10"  onFocus="c.showMoreDay = false;c.show(this);" />
      <label for="label4">��������</label>
      <input name="enddt" type="text" id="label4" size="10" onFocus="c.showMoreDay = false;c.show(this);"/><br />
      <label for="textfield">ָ���ͷ���ţ�</label>
      <input name="roomnum" type="text" id="textfield" size="20" /> -->
      <input type="submit"  class="searchroom"name="searchbtn" id="searchbtn" value="����"  />
    </form>
    </div>
<div id="worklist">
  <p class="recordform"><span class="recordform"><a href="recordform.html"></a></span>
  <a href="RecordForm.jsp" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('recordform','','/HGMSystem/image/ydkrbb1.jpg',1)"><img src="/HGMSystem/image/ydkrbb.jpg" alt="Ԥ�����˱���" name="recordform" width="250" height="80" border="0" id="recordform" /></a>
  <a href="CheckinForm.jsp" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('checkinform','','/HGMSystem/image/rzkrbb1.jpg',1)"><img src="/HGMSystem/image/rzkrbb.jpg" alt="��ס���˱���" name="checkinform" width="250" height="80" border="0" id="checkinform" /></a>
  <a href="TrecordForm.jsp" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Trecordform','','/HGMSystem/image/drydbb1.jpg',1)"><img src="/HGMSystem/image/drydbb.jpg" alt="����Ԥ������" name="Trecordform" width="250" height="80" border="0" id="Trecordform" /></a>
  <a href="TcheckinForm.jsp" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Tcheckinform','','/HGMSystem/image/drrzbb1.jpg',1)"><img src="/HGMSystem/image/drrzbb.jpg" alt="������ס����" name="Tcheckinform" width="250" height="80" border="0" id="Tcheckinform" /></a>
  <a href="TcheckoutForm.jsp" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Tcheckoutform','','/HGMSystem/image/drldbb1.jpg',1)"><img src="/HGMSystem/image/drldbb.jpg" alt="������걨��" name="Tcheckoutform" width="250" height="80" border="0" id="Tcheckoutform" /></a>
  <a href="TfinanceForm.jsp" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Tfinanceform','','/HGMSystem/image/drcwjz1.jpg',1)"><img src="/HGMSystem/image/drcwjz.jpg" alt="���ղ������" name="Tfinanceform" width="250" height="80" border="0" id="Tfinanceform" /></a></p>
  <p class="Tfinanceform"><span class="Tfinanceform"><a href="TfinanceForm.html"></a></span></p>
  </div>
 <div id="allroomtable">
    <table width="740"  class="formtable"  border="1px">
      <tr>
	<th width="90">��ס����</th>
	<th width="90">�ͷ����</th>
	<th width="80">�ͷ�����</th>	
	<th width="80">��ס��</th>
	<th width="80">��Ա���</th>
	<th width="80">������</th>
	<th width="80">���˷�ʽ</th>
	<th width="80">����ʱ��</th>
	
</tr>
<% List financialsheet = (List)request.getAttribute("financialsheet");
    	if(financialsheet != null) {
	 		for (Object object : financialsheet) { 
	 			FinancialSheet financialsheets = (FinancialSheet)object;
	 %>	
		 	 	<tr>
		 			<th width="90"><%=financialsheets.getCheckinnum() %></th>
					<th width="90"><%=financialsheets.getRoomnum() %></th>
					<th width="80"><%=financialsheets.getRoomtype()%></th>
					<th width="80"><%=financialsheets.getName() %></th>
					<th width="80"><%=financialsheets.getMemberid() %></th>
					<th width="80"><%=financialsheets.getPaymeth()%></th>
					<th width="80"><%=financialsheets.getFnctype() %></th>
					<th width="80"><%=financialsheets.getFncdt() %></th>
					
					
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
<script type="text/JavaScript" src="/HGMSystem/js/tfinanceForm.js"></script>
</body>
</html>