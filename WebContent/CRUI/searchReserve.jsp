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
        <title>搜索预订订单</title>

        <!-- Meta tags -->
        <meta charset="utf-8">
        <!--[if ie]><meta content='IE=8' http-equiv='X-UA-Compatible'/><![endif]-->
       
        <!-- Stylesheets -->
        <link rel="stylesheet" href="css/base.css" />
        <link rel="stylesheet" href="css/skeleton.css" />
        <link rel="stylesheet" href="css/flexslider.css" />
        <link rel="stylesheet" href="css/jquery.fancybox-1.3.4.css" />
        <link rel="stylesheet" href="css/validationEngine.jquery.css" />
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
                <div id="content" class="contact">
                    
                    <div id="intro">
                        <h1><span>查找您的预订记录</span></h1>
                    </div>
                   
                    <div class="container section">
                         <div class="one-third column">
                           &nbsp;
                        </div>
                        
                        <div class="two-third column last">

                            <form id="contact-form" class="validate">
                                
                                <p>
                                    <label for="name" class="required label">姓名:</label>
                                    <input id="name" class="validate[required]" type="text" name="name" />
                                </p>
                               
                                <p>
                                    <label for="subject" class="required label">订单号:</label>
                                    <input id="subject" class="validate[required]" type="text" name="subject" />
                                </p>
                                
                                <p>
                                    <label></label>
                                    <input class="medium gray button" id="submit-button" type="submit" name="Submit" value="提交" onClick="order_submit_onclick()" />
                                    <br>
                                   
                                </p>
                            </form>
                           
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
        <script type="text/javascript" src="scripts/jquery.validationEngine.js"></script>
        <script type="text/javascript" src="scripts/jquery.validationEngine-en.js"></script>
       
    
</body>
</html>
