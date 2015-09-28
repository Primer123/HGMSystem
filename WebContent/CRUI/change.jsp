<%@ page language="java" contentType="text/html; charset=gb2312"
   pageEncoding="gb2312"  import="java.sql.*" errorPage="" %>
<%@page import="java.util.List"%>
<%@page import="sheet.ReservationGuestSheet"%>

<!DOCTYPE html>
<!--[if lt IE 7 ]><html class="ie ie6" lang="en"> <![endif]-->
<!--[if IE 7 ]><html class="ie ie7" lang="en"> <![endif]-->
<!--[if IE 8 ]><html class="ie ie8" lang="en"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!-->
<html lang="en">
    <!--<![endif]-->
    <head>
        <title>修改订单信息</title>

        <!-- Meta tags -->
        <meta charset="gb2312">
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

    </head>
    <body>
        
        <!-- Background Image -->
        <img src="images/bg1.jpg" class="bg" alt="" />
        
        <!-- Root Container -->
        <div id="root-container" class="container">
            <div id="wrapper" class="sixteen columns">
                
                <!-- Banner -->
                <div id="sub-banner">
                    
                    <img src="images/banner/sub-banner5.jpg" alt="" />
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
                            <a href="rooms.jsp">酒店客房</a>
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
                            <a href="searchReserve.jsp"  class=active>查询订单</a>
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
                                <h2 class="blog">客人信息</h2>
                                <br>
                       	<div>
  <% List reservationguestsheet = (List)request.getAttribute("reservationguestsheet");
    	if(reservationguestsheet != null) {
	 		for (Object object : reservationguestsheet) { 
	 			ReservationGuestSheet reservationguestSheet = (ReservationGuestSheet)object;
	 %>	
		 	 
		 	 	
		 			<p>123<%=reservationguestSheet.getName() %></p>
					<p>123<%=reservationguestSheet.getRsrvnum() %></p>
					</div>
	 <%
	 		}
    	}
	 %>
                            <p><a href="reservation.jsp" class="small gray button">修改</a>
                                </p>
                            </div>
                            
                            <div class="blog-item">
                                <h2 class="blog">预订信息</h2>
                                <br>
                                <table class="table">
                                   
                                   <tr>入住时间</tr>
                                   <br>
                                   <br> 
                                   <tr>退房时间</tr>
                                   <br>
                                   <br>
                                   <tr>房间数</tr>
                                   <br>
                                   <br>
                                   <tr>
                                   </tr>
                                </table>
                               
                                <p>
                                    <a href="changeDetail.jsp" class="small gray button">修改</a>
                                </p>
                                
                                </div>
                            <div class="blog-item">
                                <h2 class="blog">如果确认放弃房间的预订，请取消订单</h2>
                                 <a href="cancel.jsp" class="small gray button">取消订单</a>
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
                                        <<img src="images/offers-item2.jpg" alt="" />Duis aute irure
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
        <script type="text/javascript" src="scripts/jquery-1.7.2.min.js"></script>
        <script type="text/javascript" src="scripts/jquery.easing.1.3.js"></script>
        <script type="text/javascript" src="scripts/jquery.flexslider-min.js"></script>
        <script type="text/javascript" src="scripts/jquery.hoverIntent.minified.js"></script>
        <script type="text/javascript" src="scripts/superfish.js"></script>
        <script type="text/javascript" src="scripts/jquery.cycle.lite.js"></script>
        <script type="text/javascript" src="scripts/jquery.fancybox-1.3.4.pack.js"></script>
        <script type="text/javascript" src="scripts/lamoon.js"></script>

    
</body>
</html>
