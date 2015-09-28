<%@ page language="java" contentType="text/html; charset=gb2312"
   pageEncoding="gb2312"  import="java.sql.*" errorPage="" %>
<%@page import="java.util.List"%>

<!DOCTYPE html>
<!--[if lt IE 7 ]><html class="ie ie6" lang="en"> <![endif]-->
<!--[if IE 7 ]><html class="ie ie7" lang="en"> <![endif]-->
<!--[if IE 8 ]><html class="ie ie8" lang="en"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!-->

<html>
    
    <head>
        <title>�Ƶ����</title>
   
    <!-- Meta tags -->
        <meta charset="gb2312">
        <!--[if ie]><meta content='IE=8' http-equiv='X-UA-Compatible'/><![endif]-->
   
        <!-- Stylesheets -->
        <link rel="stylesheet" href="css/base.css" />
        <link rel="stylesheet" href="css/skeleton.css" />
        <link rel="stylesheet" href="css/flexslider.css" />
        <link rel="stylesheet" href="css/jquery.fancybox-1.3.4.css" />
        <link rel="stylesheet" href="css/lamoon.css" />
        
    </head>
    <body>
        
        <!-- Background Image -->
        <img src="images/bg1.jpg" class="bg" alt="" />
        
        <!-- Root Container -->
        <div id="root-container" class="container">
            <div id="wrapper" class="sixteen columns">
                
                <!-- Banner -->
                <div id="sub-banner">
                   
                    <img src="images/banner/sub-banner1.jpg" alt="" />
                </div>
                
                <!-- Main Menu -->
                 <div id="menu" class="page">
                    
                    <ul id="root-menu" class="sf-menu">
                        <li>
                            <a href="index.jsp">��ҳ</a>
                        </li>
                        <li>
                            <a href="about.jsp" class="active">�Ƶ����</a>
                        </li>
                        <li>
                            <a href="rooms.jsp">�Ƶ�ͷ�</a>
                            <ul>
                                <li>
                                    <a href="rooms.jsp"><span>&nbsp;&nbsp;&nbsp;- </span>��׼����׷�</a>
                                </li>
                                
                                <li>
                                    <a href="research.jsp"><span>&nbsp;&nbsp;&nbsp;- </span>Ԥ���ͷ�</a>
                                </li>
                            </ul>
                        </li>
  
                        <li>
                            <a href="facilities.jsp">������ʩ</a>
                        </li>
                       <li>
                            <a href="searchReserve.jsp">��ѯ����</a>
                        </li>
                         <li>
                            <a href="gallery.jsp">����˲��</a>
                        </li>
                      
                    </ul>
                </div>
                
                <!-- Content -->
                <div id="content">
                    <div id="intro">
                        <h1><span>123</span></h1>
                        <p>
                            Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque
                            laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi
                            architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas.
                        </p>
                    </div>
                    <div class="container section">
                        <div class="one-third column">
                            <h3 class="nobg">Our History</h3>
                            <p>
                                Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
                            </p>
                            <p>
                                Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
                            </p>
                        </div>
                        <div class="one-third column">
                            <h3 class="nobg">Our Vision</h3>
                            <p>
                                Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
                            </p>
                            <p>
                                Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
                            </p>
                        </div>
                        <div class="one-third column last">
                            <h3 class="nobg">Our Services</h3>
                            <p>
                                Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt.

                            </p>
                            <ul class="square">
                                <li>
                                    Consectetur adipisicing elit
                                </li>
                                <li>
                                    Sed do eiusmod tempor incididunt
                                </li>
                                <li>
                                    Duis aute irure dolor
                                </li>
                                <li>
                                    velit esse cillum dolore eu fugiat
                                </li>
                                <li>
                                    Lorem ipsum dolor sit amet
                                </li>
                            </ul>
                            <p>
                                Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat
                            </p>
                        </div>
                    </div>
                    <div class="header container section">
                        <h3><span class="left">Highlight Features</span></h3>
                    </div>
                    <div id="sub" class="container section">

                        <div class="one-fourth column">
                            <div class="one-fourth hover">
                                 <a href="gallery.jsp">
                               <p>
                                    <img src="images/sub1.jpg" alt="" />
                                     </p></a>
                            </div>
                            <p>
                                Sed ut perspiciatis unde omnis iste natus error.
                            </p>
                        </div>
                        <div class="one-fourth column">
                            <div class="one-fourth hover">
                                 <a href="gallery.jsp">
                               <p>
                                    <img src="images/sub2.jpg" alt="" />
                                     </p></a>
                            </div>
                            <p>
                                Sed ut perspiciatis unde omnis iste natus error.
                            </p>
                        </div>
                        <div class="one-fourth column">
                            <div class="one-fourth hover">
                                 <a href="gallery.jsp">
                               <p>
                                    <img src="images/sub3.jpg" alt="" />
                                     </p></a>
                            </div>
                            <p>
                                
                            </p>
                        </div>
                        <div class="one-fourth column last">
                            <div class="one-fourth hover">
                                <a href="gallery.jsp">
                               <p>
                                    <img src="images/sub4.jpg" alt="" />
                                </p></a>
                            </div>
                            <p>
                            123
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

    
</body>
</html>
