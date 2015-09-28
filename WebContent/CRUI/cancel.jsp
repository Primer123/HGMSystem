<%@ page language="java" contentType="text/html; charset=gb2312"
   pageEncoding="gb2312"  import="java.sql.*" errorPage="" %>
<%@page import="java.util.List"%>


<!DOCTYPE html>
<!--[if lt IE 7 ]><html class="ie ie6" lang="en"> <![endif]-->
<!--[if IE 7 ]><html class="ie ie7" lang="en"> <![endif]-->
<!--[if IE 8 ]><html class="ie ie8" lang="en"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!-->
<html>
    <!--<![endif]-->
    <head>
        <title>ȡ������</title>

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
                            <a href="index.jsp">��ҳ</a>
                        </li>
                        <li>
                            <a href="about.jsp">�Ƶ���</a>
                        </li>
                        <li>
                            <a href="rooms.jsp">�Ƶ�ͷ�</a>
                            <ul>
                                <li>
                                    <a href="rooms.jsp"><span>&nbsp;&nbsp;&nbsp;- </span>��׼����׷�</a>
                                </li>
                               
                                <li>
                                    <a href="search.jsp"><span>&nbsp;&nbsp;&nbsp;- </span>Ԥ���ͷ�</a>
                                </li>
                            </ul>
                        </li>
  
                        <li>
                            <a href="facilities.jsp">������ʩ</a>
                        </li>
                        <li>
                            <a href="searchReserve.jsp" class="active">��ѯ����</a>
                        </li>
                         <li>
                            <a href="gallery.jsp">����˲��</a>
                        </li>
                        
                    </ul>
                </div>

                <!-- Content -->
                <div id="content" class="contact">
                    <div id="intro">
                        <h1><span>��ϵ ����</span></h1>
                    </div>
                   
                    <div class="container section">
                        <div class="one-third column">
                            <h3 class="nobg">ע������</h3>
                            <p>
                             ��Ԥ���������ÿ����������������ÿ�������֧��Ѻ�𣬷���Ԥ����Ϊ���������ִﵱ������4ʱ���Ƶ굱��ʱ�䣩�����ڵִﵱ������4ʱ���Ƶ굱��ʱ�䣩ǰ24Сʱ��ȡ������Ԥ�����Ƶ꽫��ȡһ���ѡ� 
                            </p>
                            <hr>
                            <p><strong>�������⣬����������ϵ</strong></p>
                            <ul class="square">
                                
                                <li>
                                    �绰: +123-456-789
                                </li>
                                <li>
                                    ����: +123-456-007
                                </li>
                                <li>
                                    ����: <a href="mailto:#">hotel@software.nju.cn</a>                 
                                </li>
                            </ul>
                        </div>
                        <div class="two-third column last">

                           <br><br>
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            ȡ��ԭ��<select>
                            <option value="0">��ѡ��</option>
                            <option value="1">�������ڱ��</option>
                            <option value="2">Ԥ�����ͼ۸�Ƶ�</option>
                            <option value="3">������Ԥ���۸����</option>
                            <option value="4">��Ȼ�ֺ�</option>
                            <option value="5">���ر�ԭ��</option>
</select>
                          <br><br><br>
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <p>
                                
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;       
                        <a href="change.jsp" class="small gray button">����</a><span>  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;                              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
                           
                           <form action="CancelReservation">
                                <input type="submit" id="submit" class="medium gray button" value="ȷ��ȡ��" />
                           </form>
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
        <script type="text/javascript" src="scripts/jquery.validationEngine.js"></script>
        <script type="text/javascript" src="scripts/jquery.validationEngine-en.js"></script>

</body>
</html>
