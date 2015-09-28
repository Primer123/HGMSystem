<%@ page contentType="text/html; charset=gb2312" language="java"
	import="java.sql.*" errorPage=""%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@page import="java.util.List"%>
<%@page import="model.GoodInfo"%>
<head>
<title>酒店客房管理系统-商品信息管理界面</title>
<%@ include file="common/CommonAdminHead.jsp"%>

</head>
<body
	onload="MM_preloadImages('/HGMSystem/image/bg_sub_sidebar_bottom_she_副本.jpg','/HGMSystem/image/splbgl1.jpg','/HGMSystem/image/spxxgl1.jpg','/HGMSystem/image/kflxgl1.jpg','/HGMSystem/image/kfxxgl1.jpg','image/lcgl1.jpg','/HGMSystem/image/yhgl1.jpg','image/rzgl1.jpg')">
	<!-- header -->
	<%@ include file="common/CommonHeader.jsp"%>

	<!-- content -->
	<div id="content">
		<div class="maincontent">
			<div class="worklist">
				<div id="alltable">
					<div id="search">
						<form id="form1" class="pull-left" name="form1" method="post"
							action="goodsearch">
							<label for="label5"><span class="message">商品类别</span></label> <label
								for="textfield"></label> <input name="typename" type="text"
								class="searchtext" id="textfield" size="20" maxlength="30" /> <br />
							<label for="label5"><span class="message">商品关键字</span></label> <label
								for="textfield"></label> <input name="keyword" type="text"
								class="searchtext" id="textfield" size="20" maxlength="30" /> <span
								class="message"> <input type="submit" class="adminsearch"
								name="adminsearch" id="adminsearch" value="搜 索" />
							</span>
						</form>


						<input type="button" class="adminAdd pull-right" name="adminAdd"
							value="新增" />
					</div>

					<div id="worklist">
						<p class="roommanage">
							<img src="/HGMSystem/image/kfgl.jpg" alt="客房管理" width="200px"
								height="80px" /><a href="FloorManage.jsp"
								onmouseout="MM_swapImgRestore()"
								onmouseover="MM_swapImage('lcgl','','/HGMSystem/image/lcgl1.jpg',1)"><img
								src="/HGMSystem/image/lcgl.jpg" alt="楼层管理" name="lcgl"
								width="200" height="30" border="0" id="lcgl" /></a><a
								href="RoomTypeManage.jsp" onmouseout="MM_swapImgRestore()"
								onmouseover="MM_swapImage('roomtypemanage','','/HGMSystem/image/kflxgl1.jpg',0)"><img
								src="/HGMSystem/image/kflxgl.jpg" alt="客房类型管理"
								name="roomtypemanage" width="200" height="30" border="0"
								id="roomtypemanage" /></a><a href="roomtypemanage.html"></a><a
								href="RoomManage.jsp" onmouseout="MM_swapImgRestore()"
								onmouseover="MM_swapImage('roommanage','','/HGMSystem/image/kfxxgl1.jpg',1)"><img
								src="/HGMSystem/image/kfxxgl.jpg" alt="客房信息管理" name="roommanage"
								width="200" height="30" border="0" id="roommanage" /></a><a
								href="roommanage.html" onmouseout="MM_swapImgRestore()"
								onmouseover="MM_swapImage('roominformationmanage','','image//HGMSystem/kflxgl1.jpg',1)"></a><a
								href="roommanage.html"></a>
						</p>
						<p class="systemmanage">
							<img src="/HGMSystem/image/xtgl.jpg" alt="系统管理" width="200px"
								height="80px" /><a href="UserManage.jsp"
								onmouseout="MM_swapImgRestore()"
								onmouseover="MM_swapImage('yhgl','','/HGMSystem/image/yhgl1.jpg',1)"><img
								src="/HGMSystem/image/yhgl.jpg" alt="用户管理" name="yhgl"
								width="200" height="30" border="0" id="yhgl" /></a><a
								href="MemberManage.jsp" onmouseout="MM_swapImgRestore()"
								onmouseover="MM_swapImage('membermanage','','/HGMSystem/image/hygl1.jpg',0)"><img
								src="/HGMSystem/image/hygl.jpg" alt="会员管理" name="membermanage"
								width="200" height="30" border="0" id="membermanage" /></a><a
								href="membermanage.html" onmouseout="MM_swapImgRestore()"
								onmouseover="MM_swapImage('usermanage','','/HGMSystem/image/hygl1.jpg',1)"></a><a
								href="membermanage.html"></a><a href="BlogManage.jsp"
								onmouseout="MM_swapImgRestore()"
								onmouseover="MM_swapImage('blogmanage','','/HGMSystem/image/rzgl1.jpg',1)"><img
								src="/HGMSystem/image/rzgl.jpg" alt="日志管理" name="blogmanage"
								width="200" height="30" border="0" id="blogmanage" /></a><a
								href="blogmanage.html"></a>
						</p>
						<p class="goodmanage">
							<img src="/HGMSystem/image/spgl.jpg" alt="商品管理" width="200px"
								height="80px" /><a href="#" onmouseout="MM_swapImgRestore()"
								onmouseover="MM_swapImage('1','','/HGMSystem/image/bg_sub_sidebar_bottom_she_副本.jpg',1)"></a><a
								href="GoodTypeManage.jsp" onmouseout="MM_swapImgRestore()"
								onmouseover="MM_swapImage('splbgl','','/HGMSystem/image/splbgl1.jpg',1)"><img
								src="/HGMSystem/image/splbgl.jpg" alt="商品类别管理" name="splbgl"
								width="200" height="30" border="0" id="splbgl" /></a><a
								href="GoodManage.jsp" onmouseout="MM_swapImgRestore()"
								onmouseover="MM_swapImage('spxxgl','','/HGMSystem/image/spxxgl1.jpg',1)"><img
								src="/HGMSystem/image/spxxgl.jpg" alt="商品信息管理" name="spxxgl"
								width="200" height="30" border="0" id="spxxgl" /></a>
						</p>
					</div>
					<div id="allttable">
						<table width="740" class="formtable" border="1px">
							<tr>
								<th width="200">商品名称</th>
								<th width="200">商品类别</th>
								<th width="200">备注</th>
								<th width="70">修改</th>
								<th width="70">删除</th>
							</tr>

						</table>
	<% List goodresult = (List)request.getAttribute("goodresult");
    	if(goodresult != null) {
	 		for (Object object : goodresult) { 
	 			GoodInfo goodInfos = (GoodInfo)object;
	 %>	
	 	 	<tr>
	 			<th width="200"><%=goodInfos.getGoodname()%></th>
				<th width="200"><%=goodInfos.getTypename() %></th>
				<th width="200"><%=goodInfos.getRemarks() %></th>
				<th width="70"><a
									href="<s:url action="update"><s:param name="id"><%=goodInfos.getGoodname()%></s:param></s:url>" />修改</a></th>
								<th width="70"><a
									href="<s:url action="delete"><s:param name="id"><%=goodInfos.getGoodname()%></s:param></s:url>" />删除</a></th>
							</tr>
	 		</tr>
	  <%}
	 		}
	 		%>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!--Begin of Add New Good Modal  -->
	<div class="modal fade" id="AddGoodModal" tabindex="-1" role="dialog"
		aria-labelledby="AddGoodLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">新增商品</h4>
				</div>
				<div class="modal-body form-horizontal content">
					<div>
						<form id="form2" name="form2" method="post" action="add">
							<div class="form-group">
								<label class="col-sm-2 control-label">商品名称</label>
								<div class="col-sm-10">
									<input class="form-control" name="name" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">商品类别</label>
								<div class="col-sm-10">
									<select name="type" id="select"></select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">单价</label>
								<div class="col-sm-10">
									<input class="form-control" name="price" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">单位</label>
								<div class="col-sm-10">
									<input class="form-control" name="unit" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">备注</label>
								<div class="col-sm-10">
									<textarea class="form-control" name="note" rows="3"></textarea>
								</div>
							</div>
						</form>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary btn-right">保&nbsp;&nbsp;存</button>
					<button type="button" class="btn btn-default btn-left"
						data-dismiss="modal">返&nbsp;&nbsp;回</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!--End of Add New Good Modal  -->

	<!--Begin of Update Good Modal  -->
	<div class="modal fade" id="UpdateGoodModal" tabindex="-1"
		role="dialog" aria-labelledby="updateGoodLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">修改商品信息</h4>
				</div>
				<div class="modal-body">
					<div id="addtext" class="addtext">
						<form id="form2" name="form2" method="post" action="update">
							<div class="form-group">
								<label class="col-sm-2 control-label">商品名称</label>
								<div class="col-sm-10">
									<input class="form-control" name="name" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">商品类别</label>
								<div class="col-sm-10">
									<select name="type" id="select"></select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">单价</label>
								<div class="col-sm-10">
									<input class="form-control" name="price" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">单位</label>
								<div class="col-sm-10">
									<input class="form-control" name="unit" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">备注</label>
								<div class="col-sm-10">
									<textarea class="form-control" name="note" rows="3"></textarea>
								</div>
							</div>
						</form>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary btn-right">保&nbsp;&nbsp;存</button>
					<button type="button" class="btn btn-default btn-left"
						data-dismiss="modal">返&nbsp;&nbsp;回</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!--End of Update Good Modal  -->

	<!-- footer -->
	<%@ include file="common/CommonJs.jsp"%>
	<script type="text/JavaScript" src="/HGMSystem/js/goodManage.js"></script>
</body>
</html>