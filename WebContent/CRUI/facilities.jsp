<%@ page language="java" contentType="text/html; charset=gb2312"
   pageEncoding="gb2312"  import="java.sql.*" errorPage="" %>
<%@page import="java.util.List"%>


<!DOCTYPE html>
<!--[if lt IE 7 ]><html class="ie ie6" lang="en"> <![endif]-->
<!--[if IE 7 ]><html class="ie ie7" lang="en"> <![endif]-->
<!--[if IE 8 ]><html class="ie ie8" lang="en"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!-->
<html lang="en">
    <!--<![endif]-->
    <head>
        <title>配套设施</title>

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

    </head>
    <body>
        
        <!-- Background Image -->
        <img src="images/bg1.jpg" class="bg" alt="" />
        
        <!-- Root Container -->
        <div id="root-container" class="container">
            <div id="wrapper" class="sixteen columns">
                
                <!-- Banner -->
                <div id="sub-banner">
                    
                    <img src="images/banner/sub-banner3.jpg" alt="" />
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
                            <a href="facilities.jsp" class="active">配套设施</a>
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
                    <div id="intro">
                        <h1><span>Our Facilities</span></h1>
                        <p>
                            Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque
                            laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi
                            architecto
                        </p>
                    </div>
                    <div class="container section">
                        <div class="half column center">
                            <p><img src="images/facilities/facility1.jpg" alt="" /></p>
                            <h3 class="nobg">Fitness Center</h3>
                            <p>
                                Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui.
                            </p>
                        </div>
                        <div class="half column center last">
                            <p><img src="images/facilities/facility2.jpg" alt="" /></p>
                            <h3 class="nobg">The Bar</h3>
                            <p>
                                Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui.
                            </p>
                        </div>
                    </div>
                    <div class="container section">
                        <div class="half column center">
                            <p><img src="images/facilities/facility3.jpg" alt="" /></p>
                            <h3 class="nobg">Spa &amp; Massage</h3>
                            <p>
                                Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui.
                            </p>
                        </div>
                        <div class="half column center last">
                            <p><img src="images/facilities/facility4.jpg" alt="" /></p>
                            <h3 class="nobg">Golf Club</h3>
                            <p>
                                Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui.
                            </p>
                        </div>
                    </div>
                    <div class="container section">
                        <div class="half column center">
                            <p><img src="images/facilities/facility5.jpg" alt="" /></p>
                            <h3 class="nobg">Swimming Pool</h3>
                            <p>
                                Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui.
                            </p>
                        </div>
                        <div class="half column center last">
                            <p><img src="images/facilities/facility6.jpg" alt="" /></p>
                            <h3 class="nobg">V.I.P. Restaurant</h3>
                            <p>
                                Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui.
                            </p>
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
         <script type="text/javascript" src="scripts/addRoom.js"></script>

    
</body>
</html>
