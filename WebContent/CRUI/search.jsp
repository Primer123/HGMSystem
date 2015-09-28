<%@ page language="java" contentType="text/html; charset=gb2312"
   pageEncoding="gb2312"  import="java.sql.*" errorPage="" %>
<%@page import="java.util.List"%>

<!DOCTYPE html>

<html>
    <!--<![endif]-->
    <head>
        <title>修改预订信息</title>

        <!-- Meta tags -->
        <meta charset="utf-8">
        <!--[if ie]><meta content='IE=8' http-equiv='X-UA-Compatible'/><![endif]-->
        

        <!-- Stylesheets -->
        <link rel="stylesheet" href="css/base.css" />
        <link rel="stylesheet" href="css/skeleton.css" />
        <link rel="stylesheet" href="css/flexslider.css" />
        <link rel="stylesheet" href="css/jquery.fancybox-1.3.4.css" />
        <link rel="stylesheet" href="css/lamoon.css" />
        

        <!--[if IE 9]>
        <link href="css/ie9.css" rel="stylesheet" type="text/css" />
        <![endif]-->

        <!--[if IE 8]>
        <link href="css/ie8.css" rel="stylesheet" type="text/css" />
        <![endif]-->

        <!--[if lt IE 9]>
        <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->

     
 <script language="JavaScript" type="text/javascript">
     var child=[
     ["0","1","2"],
     ["0","1"],
     ["0"]
     ];

     function getChild(a,c){
    var sltAdult=document.getElementById(a);
    var sltChild=document.getElementById(c);         
    var adultChild=child[sltAdult.selectedIndex - 1];
 
         sltChild.length=1;
         for(var i=0;i<adultChild.length;i++){
             sltChild[i+1]=new Option(adultChild[i],adultChild[i]);
         }
     }
             
           
 </script>
      
    
    </head>
    <body>
        
        <!-- Background Image -->
        <img src="images/bg1.jpg" class="bg" alt="" />
        
        <!-- Root Container -->
        <div id="root-container" class="container">
            <div id="wrapper" class="sixteen columns">
                
                <!-- Banner -->
                <div id="sub-banner">
                    
                    <img src="images/banner/sub-banner2.jpg" alt="" />
                </div>
                
              <!-- Main Menu -->
                 <div id="menu" class="page">
                    
                    <ul id="root-menu" class="sf-menu">
                        <li>
                            <a href="index.jsp">首页</a>
                        </li>
                        <li>
                            <a href="about.jsp">酒店简介</a>
                        </li>
                        <li>
                            <a href="rooms.jsp" class="active">酒店客房</a>
                            <ul>
                                <li>
                                    <a href="rooms.jsp"><span>&nbsp;&nbsp;&nbsp;- </span>标准间和套房</a>
                                </li>
                               
                                <li>
                                    <a href="search.jsp"><span>&nbsp;&nbsp;&nbsp;- </span>预订客房</a>
                                </li>
                            </ul>
                        </li>
  
                        <li>
                            <a href="facilities.jsp">配套设施</a>
                        </li>
                        <li>
                            <a href="searchReserve.jsp">查询订单</a>
                        </li>
                         <li>
                            <a href="gallery.jsp">精彩瞬间</a>
                        </li>
                     
                    </ul>
                </div>
                
                
                <!-- Content -->
                <div id="content">
                    <div id="blog" class="container section">
                        <div id="blog-content" class="two-third column float-right last">
                            <div class="blog-item">
                                <h2 class="blog">新预订</h2>
                                
                                 <form method="POST" action="roomsearch" name="form1">
        
      <label for="textfield" >入住时间</label>
      <input id="arrivingdt" name="arrivingdt" type="text" id="textfield" size="10"  onFocus="c.showMoreDay = false;c.show(this);" />
      <label for="label4">退房时间</label>
      <input name="textfield2" type="text" id="label4" size="10" onFocus="c.showMoreDay = false;c.show(this);"/>                      
                           
                             
                 <span><input type="button" class="small gray button" value="增加房间" onClick="addRoom('roomNum');"></span>
                                     
                                <div id="roomNum">
                                                                                                                              房间 1<br>
                                   <span>成人：</span>
                                   <SELECT id="adult" onChange="getChild('adult','child')" style="width:100px">
                                     <OPTION VALUE="0">成人数 </OPTION>
                                     <OPTION VALUE="1">1</OPTION>
                                     <OPTION VALUE="2">2</OPTION>
                                     <OPTION VALUE="3">3</OPTION>
                                    </SELECT>
                                  
                                  <span>儿童：</span>
                                  <SELECT id="child" style="width:100px">
                                     <OPTION VALUE="0">儿童数 </OPTION>
                                  </SELECT>
                                  </div>
                    </br>                
           <input type="button"  class="small gray button" id="searchRoom" name="searchRoom" value="搜索" /> 
                                 </form>
                            </div>
                            
                            <div class="blog-item">
                                <h2 class="blog">搜索结果</h2>
                                <br>
                                <table id="list" class="table table-hover">
                                   <tr>
                                    <th>客房类型</th>
                                    <th>床型</th>
                                    <th>价格</th>
                                    <th>预订</th>
                                    <tr>
                                </table>
</div>
                          
                        </div>
                        <div id="sidebar-content" class="one-third column first">
                           
                            
                            <div class="sidebar-item">
                                <h3 class="nobg">Latest Events</h3>
                                <ul id="latest-events" class="square">
                                    <li>
                                        <img src="images/offers-item1.jpg" alt="" />Sed ut perspiciatis aute
                                        <span>12 Jun 2012</span>
                                    </li>
                                    <li>
                                        <img src="images/offers-item2.jpg" alt="" />Duis aute irure
                                        <span>9 Jun 2012</span>
                                    </li>
                                    <li>
                                        <img src="images/offers-item3.jpg" alt="" />Excepteur sint occaecat
                                        <span>29 May 2012</span>
                                    </li>
                                </ul>
                            </div>
                            <div class="sidebar-item">
                                <h3 class="nobg">Custom Text</h3>
                                <p>
                                    At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident, similique sunt in culpa qui officia deserunt mollitia animi, id est laborum et dolorum fuga. Et harum quidem rerum facilis est et expedita distinctio.
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
                
               <!-- Copyright and Social Icons -->
                <div id="copyright">
                    <div class="container section end">
                    <span id="text">&copy; Copyright &copy; 2015.Company name All rights reserved.</span>
</div>
                </div>
            </div>
        </div>

        <!-- JavaScript Files -->
        <script type="text/JavaScript" src="/HGMSystem/js/dist/Calendar.js"></script>
        <script type="text/JavaScript" src="/HGMSystem/js/commonCalendar.js"></script>
        <script type="text/javascript" src="scripts/jquery-1.7.2.min.js"></script>
        <script type="text/javascript" src="scripts/jquery.easing.1.3.js"></script>
        <script type="text/javascript" src="scripts/jquery.flexslider-min.js"></script>
        <script type="text/javascript" src="scripts/jquery.hoverIntent.minified.js"></script>
        <script type="text/javascript" src="scripts/superfish.js"></script>
        <script type="text/javascript" src="scripts/jquery.cycle.lite.js"></script>
        <script type="text/javascript" src="scripts/jquery.fancybox-1.3.4.pack.js"></script>
        <script type="text/javascript" src="scripts/lamoon.js"></script>
             <script type="text/javascript" src="scripts/addRoom.js"></script>
             <script type="text/javascript">
             	$('#searchRoom').click(function () {
             		var checkindate = $("#arrivingdt").attr("value");
             		var adult = $("#adult").attr("value");
             		var child = $("#child").attr("value");
             		alert(adult);
             		alert(child);
             		console.debug(checkindate);
             		var param = {
             				"checkindate": checkindate
             		};
             	
             		$.post("searchroom", param, function(data) {
             			var adata = eval("("+ data +")");
             			$("#list").append("<tr><th>1</th><th>2</th><th>3</th><th>4</th></tr>")
             		});
             	});
             </script>
    
</body>
</html>