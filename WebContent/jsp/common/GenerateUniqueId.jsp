<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.security.MessageDigest"%>
<%@page import="java.text.DateFormat"%>
<%
	String checkInOrderId = null;
	//MD5 generate unique id
	String now = System.currentTimeMillis() + "";
	MessageDigest md = MessageDigest.getInstance("MD5");
	byte[] thedigest = md.digest(now.getBytes());
	
	//get date
	DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
	Date date = new Date();
	
	//joint id
	checkInOrderId = dateFormat.format(date) + thedigest.toString().substring(3);
%>
<p><%=checkInOrderId %></p>