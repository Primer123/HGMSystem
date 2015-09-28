<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>前台换房管理</title>
<%@ include file="common/CommonWaiterHead.jsp" %>
<script type="text/JavaScript">
<!--
function MM_swapImgRestore() { //v3.0
  var i,x,a=document.MM_sr; for(i=0;a&&i<a.length&&(x=a[i])&&x.oSrc;i++) x.src=x.oSrc;
}

function MM_preloadImages() { //v3.0
  var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
    var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
    if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
}

function MM_findObj(n, d) { //v4.01
  var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
    d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
  if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
  for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
  if(!x && d.getElementById) x=d.getElementById(n); return x;
}

function MM_swapImage() { //v3.0
  var i,j=0,x,a=MM_swapImage.arguments; document.MM_sr=new Array; for(i=0;i<(a.length-2);i+=3)
   if ((x=MM_findObj(a[i]))!=null){document.MM_sr[j++]=x; if(!x.oSrc) x.oSrc=x.src; x.src=a[i+2];}
}
//-->
</script>
</head>
<body onload="MM_preloadImages('/HGMSystem/image/djrz1.jpg','/HGMSystem/image/hfgl1.jpg','/HGMSystem/image/tfjz1.jpg','/HGMSystem/image/ydxx1.jpg','/HGMSystem/image/ydzrz1.jpg')">
<!-- header -->
<%@ include file="common/CommonHeader.jsp" %>

<!-- content -->
<div id="content">
<div class="maincontent">
<div class="worklist">
<p class="roomInformation"><a href=""><span class="recordInformation"></span></a><span class="recordInformation"><a href=""><span class="checkIn"></span></a><span class="checkIn"><a href=""><span class="changeRoom"></span></a></span></span></p>

<p class="recordInformation"><span class="roomInformation"><a href=""></a><a href=""><span class="checkIn"></span></a></span></p>

<div id="allroom">
  <div id="search">
    <form id="changeroom_form" name="changerooom_form" method="post" action="roomsearch">
      <label for="Submit"></label>
      <label for="textfield">入住单号</label>
      <input name="checkinnum" type="text" id="CheckInNumtextfield" tabindex="6位数字" size="18" maxlength="10" />
      <label for="select"></label>
      <label for="label">房间类型</label>
      <select name="roomtype" id="label">
        <option>单人间</option>
        <option>双人间</option>
        <option>大床房</option>
        <option>钟点房</option>
      </select>
      <label for="label2"></label>
      <label for="label2">客房编号</label>
      <input name="roomnum" type="text" id="label2" size="10" maxlength="8" />
      <label for="label3"></label>
	  <br />
      <label for="label3">入住人</label>
      <input name="name" type="text" id="label3" size="10" maxlength="8" />
      <label for="textfield" >入住时间</label>
      <input name="arrivingdt" type="text" id="textfield" size="10"  onFocus="c.showMoreDay = false;c.show(this);" />
      <label for="label4">退房时间</label>
      <input name="departuredt" type="text" id="label4" size="10" onFocus="c.showMoreDay = false;c.show(this);"/>
      <input name="searchroom" type="submit" id="searchCheckIn" value="查询入住" />
    
      
        <!-- 测试换房 -->
         <input type="button"  class="waiterChangeRoom pull-right" name="waiterChangeRoom" value="换房" />
      
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
    <table width="740"  class="roomtable" border="1px">
      <tr>
	<th width="100" >客房编号</th>
	<th width="100">客房类型</th>
	<th width="100">客房状态</th>
	<th width="100">楼层</th>
	<th width="240">备注</th>
	<th width="100">换房</th>
</tr>

</table>
</div>
</div>
</div>
</div>
</div>

<!--换房-->

<div class="modal fade" id="RecordCheckinModal" tabindex="-1" role="dialog" aria-labelledby="RecordCheckinLabel" aria-hidden="true">
 <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">换房登记信息表</h4>
      </div>
      <div class="modal-body form-horizontal content">
  		<div>
          <form id="form1" name="changeroom" method="post" action="changeroom">
  
	   <div class="form-group">
				    <label class="col-sm-2 control-label">入住单号</label>
				    <div class="col-sm-10">
				    	<input class="form-control" name="checkinnum"  />
				    </div>
				    </div>
      <div class="form-group">
				    <label class="col-sm-2 control-label">客房编号</label>
				    <div class="col-sm-10">
				    	<input class="form-control" name="roomnum"  />
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
				    	<input class="form-control" name="discprice"  />
				    </div>
				    </div>
    <div class="form-group">
				    <label class="col-sm-2 control-label">押金</label>
				    <div class="col-sm-10">
				    	<input class="form-control" name="deposit"  />
				    </div>
				    </div>
    <div class="form-group">
				    <label class="col-sm-2 control-label">入住人</label>
				    <div class="col-sm-10">
				    	<input class="form-control" name="checkinname"  />
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
				    	<input class="form-control" name="idnum"  />
				    </div>
				    </div>
    <div class="form-group">
				    <label class="col-sm-2 control-label">联系电话</label>
				    <div class="col-sm-10">
				    	<input class="form-control" name="telnum"  />
				    </div>
				    </div>
     <div class="form-group">
				    <label class="col-sm-2 control-label">抵店时间</label>
				    <div class="col-sm-10">
				    	<input class="form-control" name="arrivingdt"  />
				    </div>
				    </div>
      <div class="form-group">
				    <label class="col-sm-2 control-label">离店时间</label>
				    <div class="col-sm-10">
				    	<input class="form-control" name="departuredt" />
				    </div>
				    </div>      
	 <!-- <div class="form-group">
				    <label class="col-sm-2 control-label">入住人数</label>
				    <div class="col-sm-10">
				    	<input class="form-control" name="note"  />
				    </div>
				    </div> -->
      <div class="form-group">
				    <label class="col-sm-2 control-label">操作员</label>
				    <div class="col-sm-10">
				    	<input class="form-control" name="staffid"  />
				    </div>
				    </div>
    <div class="form-group">
				    <label class="col-sm-2 control-label">会员编号</label>
				    <div class="col-sm-10">
				    	<input class="form-control" name="numid"  />
				    </div>
				    </div>
      <div class="form-group">
				    <label class="col-sm-2 control-label">会员价格</label>
				    <div class="col-sm-10">
				    	<input class="form-control" name="vmprice"  />
				    </div>
				    </div>
      <div class="form-group">
				    <label class="col-sm-2 control-label">提供早餐</label>
				    <div class="col-sm-10">
				    	<input class="form-control" name="breakfast"  />
				    </div>
				    </div>
      <div class="form-group">
				    <label class="col-sm-2 control-label">定时叫醒</label>
				    <div class="col-sm-10">
				    	<input class="form-control" name="wakeup"  />
				    </div>
				    </div>
      <div class="form-group">
				    <label class="col-sm-2 control-label">备注</label>
				    <div class="col-sm-10">
				    	<input class="form-control" name="remarks"  />
				    </div>
				    </div>
		    </form>
		  </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary btn-right" >打&nbsp;印</button>
        <button type="button" class="btn btn-default btn-left" data-dismiss="modal">保&nbsp;存</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div>
<!--End of Add New Floor Modal  -->



<!-- footer -->
<%@ include file="common/CommonJs.jsp" %>
<script type="text/JavaScript" src="/HGMSystem/js/dist/Calendar.js"></script>
<script type="text/JavaScript" src="/HGMSystem/js/changeRoom.js"></script>
<script type="text/JavaScript" src="/HGMSystem/js/commonCalendar.js"></script>

</body>
</html>