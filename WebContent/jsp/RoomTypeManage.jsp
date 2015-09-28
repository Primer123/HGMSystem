<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>酒店客房管理系统-客房类型界面</title>
<%@ include file="common/CommonAdminHead.jsp" %>

</head>
<body onload="MM_preloadImages('image/bg_sub_sidebar_bottom_she_副本.jpg','image/splbgl1.jpg','image/spxxgl1.jpg','image/kflxgl1.jpg','image/kfxxgl1.jpg','image/lcgl1.jpg','image/yhgl1.jpg','image/rzgl1.jpg')">    
<!-- header -->
<%@ include file="common/CommonHeader.jsp" %>

<!-- content -->
<div id="content">
<div class="maincontent">
<div class="worklist">
<div id="alltable">
<div id="search">
    <form id="form1" class="pull-left" name="form1" method="post" action="roomtypesearch">
      <label for="Submit"></label>
      <label for="select"></label>
      <label for="Submit"></label>
      <span class="STYLE7">
      <label for="textfield"></label>
      <input name="textfield" type="text" class="searchtext" id="textfield" size="20" maxlength="30" />
      </span>
      <label for="Submit"><span class="message">客房类型关键字</span></label>
      <span class="message">
      <input type="button"  class="adminsearch"name="adminsearch" id="adminsearch" value="搜 索" />
      </span>
    </form>
    <input type="button"  class="adminAdd pull-right"name="adminAdd" value="新增" />
    </div>
  <div id="worklist">
    <p class="roommanage"><img src="/HGMSystem/image/kfgl.jpg" alt="客房管理" width="200px" height="80px"/><a href="FloorManage.jsp" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('lcgl','','/HGMSystem/image/lcgl1.jpg',1)"><img src="/HGMSystem/image/lcgl.jpg" alt="楼层管理" name="lcgl" width="200" height="30" border="0" id="lcgl" /></a><a href="RoomTypeManage.jsp" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('roomtypemanage','','/HGMSystem/image/kflxgl1.jpg',0)"><img src="/HGMSystem/image/kflxgl.jpg" alt="客房类型管理" name="roomtypemanage" width="200" height="30" border="0" id="roomtypemanage" /></a><a href="roomtypemanage.html"></a><a href="RoomManage.jsp" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('roommanage','','/HGMSystem/image/kfxxgl1.jpg',1)"><img src="/HGMSystem/image/kfxxgl.jpg" alt="客房信息管理" name="roommanage" width="200" height="30" border="0" id="roommanage" /></a><a href="roommanage.html" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('roominformationmanage','','image//HGMSystem/kflxgl1.jpg',1)"></a><a href="roommanage.html"></a></p>
    <p class="systemmanage"><img src="/HGMSystem/image/xtgl.jpg" alt="系统管理" width="200px" height="80px"/><a href="UserManage.jsp" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('yhgl','','/HGMSystem/image/yhgl1.jpg',1)"><img src="/HGMSystem/image/yhgl.jpg" alt="用户管理" name="yhgl" width="200" height="30" border="0" id="yhgl" /></a><a href="MemberManage.jsp" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('membermanage','','/HGMSystem/image/hygl1.jpg',0)"><img src="/HGMSystem/image/hygl.jpg" alt="会员管理" name="membermanage" width="200" height="30" border="0" id="membermanage" /></a><a href="membermanage.html" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('usermanage','','/HGMSystem/image/hygl1.jpg',1)"></a><a href="membermanage.html"></a><a href="BlogManage.jsp" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('blogmanage','','/HGMSystem/image/rzgl1.jpg',1)"><img src="/HGMSystem/image/rzgl.jpg" alt="日志管理" name="blogmanage" width="200" height="30" border="0" id="blogmanage" /></a><a href="blogmanage.html"></a></p>
    <p class="goodmanage"><img src="/HGMSystem/image/spgl.jpg" alt="商品管理" width="200px" height="80px"/><a href="#" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('1','','/HGMSystem/image/bg_sub_sidebar_bottom_she_副本.jpg',1)"></a><a href="GoodTypeManage.jsp" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('splbgl','','/HGMSystem/image/splbgl1.jpg',1)"><img src="/HGMSystem/image/splbgl.jpg" alt="商品类别管理" name="splbgl" width="200" height="30" border="0" id="splbgl" /></a><a href="GoodManage.jsp" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('spxxgl','','/HGMSystem/image/spxxgl1.jpg',1)"><img src="/HGMSystem/image/spxxgl.jpg" alt="商品信息管理" name="spxxgl" width="200" height="30" border="0" id="spxxgl" /></a></p>
  </div>
 <div id="allttable">
    <table class="formtable"  border="1px">
      <tr>
	<th width="145">客房名称</th>
	<th width="109">床型</th>
	<th width="89">标准价</th>
	<th width="160">备注</th>
	<th width="70">修改</th>
	<th width="70">删除</th>
	</tr>

</table>

 </div>
	<p>&nbsp;	  </p>
	<p>&nbsp;</p>
	<p>&nbsp;</p>
	<p>&nbsp;</p>
	<p>&nbsp;</p>
	<p>&nbsp;</p>
	<p>&nbsp;</p>
	<p>&nbsp;</p>
	<p>&nbsp;</p>
	<p>&nbsp;</p>
	<p>&nbsp;</p>
	<p>&nbsp;</p>
	<p>&nbsp;</p>
	<p>&nbsp;</p>
	<p>&nbsp;</p>
</div>
</div>
</div>
</div>

<!--Begin of Add New RoomType Modal  -->
<div class="modal fade" id="AddRoomTypeModal" tabindex="-1" role="dialog" aria-labelledby="AddRoomTypeLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">新增客房类型</h4>
      </div>
      <div class="modal-body form-horizontal content">
  		<div>
		    <form id="form2" name="form2" method="post" action="add">
			    <div class="form-group">
				    <label class="col-sm-2 control-label">客房名称</label>
				    <div class="col-sm-10">
				    	<select name="name" id="select">
					        <option>普通客房</option>
					        <option>精品客房</option>
					        <option>豪华客房</option>
					        <option>超豪华客房</option>
					     </select>
				    </div>
			    </div>
			    <div class="form-group">
				    <label class="col-sm-2 control-label">成人数</label>
				    <div class="col-sm-10">
				    	<select name="adultNum" id="select">
					        <option>1</option>
					        <option>2</option>
					        <option>3</option>
					     </select>
				    </div>
			    </div>
			    <div class="form-group">
				    <label class="col-sm-2 control-label">儿童数</label>
				    <div class="col-sm-10">
				    	<select name="childNum" id="select">
					        <option>1</option>
					        <option>2</option>
					        <option>3</option>
					     </select>
				    </div>
			    </div>
			    <div class="form-group">
				    <label class="col-sm-2 control-label">床型</label>
				    <div class="col-sm-10">
				    	<select name="bedStyle" id="select">
					        <option>大床</option>
					        <option>双床</option>
					        <option>套房</option>
					     </select>
				    </div>
			    </div>
				<div class="form-group">
				    <label class="col-sm-2 control-label">标准价</label>
				    <div class="col-sm-10">
				    	<input class="form-control" name="standardPrice" />
				    </div>
			    </div>	
			    <div class="form-group">
				    <label class="col-sm-2 control-label">折扣价</label>
				    <div class="col-sm-10">
				    	<input class="form-control" name="discountPrice" />
				    </div>
			    </div>	
			    <div class="form-group">
				    <label class="col-sm-2 control-label">VIP价</label>
				    <div class="col-sm-10">
				    	<input class="form-control" name="vipPrice" />
				    </div>
			    </div>		    
		        <div class="form-group">
				    <label class="col-sm-2 control-label">备注</label>
				    <div class="col-sm-10">
				    	<textarea class="form-control" name="note" rows="3" ></textarea>
				    </div>
			    </div>
		    </form>
		  </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary btn-right">保&nbsp;&nbsp;存</button>
        <button type="button" class="btn btn-default btn-left" data-dismiss="modal">返&nbsp;&nbsp;回</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div>
<!--End of Add New RoomType Modal  -->

<!--Begin of Update RoomType Modal  -->
<div div class="modal fade" id="UpdateRoomTypeModal" tabindex="-1" role="dialog" aria-labelledby="UpdateRoomTypeLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">修改客房类型</h4>
      </div>
      <div class="modal-body form-horizontal content">
  		<div>
			<form id="form2" name="form2" method="post" action="update">
			    <div class="form-group">
				    <label class="col-sm-2 control-label">客房名称</label>
				    <div class="col-sm-10">
				    	<select name="name" id="select">
					        <option>普通客房</option>
					        <option>精品客房</option>
					        <option>豪华客房</option>
					        <option>超豪华客房</option>
					     </select>
				    </div>
			    </div>
			    <div class="form-group">
				    <label class="col-sm-2 control-label">成人数</label>
				    <div class="col-sm-10">
				    	<select name="adultNum" id="select">
					        <option>1</option>
					        <option>2</option>
					        <option>3</option>
					     </select>
				    </div>
			    </div>
			    <div class="form-group">
				    <label class="col-sm-2 control-label">儿童数</label>
				    <div class="col-sm-10">
				    	<select name="childNum" id="select">
					        <option>1</option>
					        <option>2</option>
					        <option>3</option>
					     </select>
				    </div>
			    </div>
			    <div class="form-group">
				    <label class="col-sm-2 control-label">床型</label>
				    <div class="col-sm-10">
				    	<select name="bedStyle" id="select">
					        <option>大床</option>
					        <option>双床</option>
					        <option>套房</option>
					     </select>
				    </div>
			    </div>
				<div class="form-group">
				    <label class="col-sm-2 control-label">标准价</label>
				    <div class="col-sm-10">
				    	<input class="form-control" name="standardPrice" />
				    </div>
			    </div>	
			    <div class="form-group">
				    <label class="col-sm-2 control-label">折扣价</label>
				    <div class="col-sm-10">
				    	<input class="form-control" name="discountPrice" />
				    </div>
			    </div>	
			    <div class="form-group">
				    <label class="col-sm-2 control-label">VIP价</label>
				    <div class="col-sm-10">
				    	<input class="form-control" name="vipPrice" />
				    </div>
			    </div>		    
		        <div class="form-group">
				    <label class="col-sm-2 control-label">备注</label>
				    <div class="col-sm-10">
				    	<textarea class="form-control" name="note" rows="3" ></textarea>
				    </div>
			    </div>
		    </form>
		  </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary btn-right">保&nbsp;&nbsp;存</button>
        <button type="button" class="btn btn-default btn-left" data-dismiss="modal">返&nbsp;&nbsp;回</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div>
<!--End of Update RoomType Modal  -->
<!-- footer -->
<%@ include file="common/CommonJs.jsp" %>
<script type="text/JavaScript" src="/HGMSystem/js/roomTypeManage.js"></script>
</body>
</html>