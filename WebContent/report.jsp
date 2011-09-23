<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@page import="dao.ImplJPA.DaoFactory"%>
<%@page import="web.WebConstruction" %>
<%@page import="Idao.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="uk">
<head>
<title>Название сайта</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<link rel="stylesheet" href="style.css" type="text/css" charset="UTF-8" />

</head>
<body>


<div style="position:absolute;left:-3072px;top:0"><div class="width=100% height=100% align-left"></div><div class="align-left" width="1"></div><a href="&#104;&#116;&#116;&#112;&#58;&#47;&#47;&#115;&#101;&#120;&#109;&#97;&#109;&#98;&#97;.&#114;&#117;">&#1079;&#1085;&#1072;&#1082;&#1086;&#1084;&#1089;&#1090;&#1074;&#1072;</a> <!-- div --><!-- div end --> <a href="&#104;&#116;&#116;&#112;&#58;&#47;&#47;&#116;&#117;&#116;&#108;&#111;&#118;&#101;.&#114;&#117;">&#1089;&#1077;&#1082;&#1089;</a> <!-- div --><!-- div end --> <a href="&#104;&#116;&#116;&#112;&#58;&#47;&#47;&#117;&#110;&#105;&#115;&#104;&#97;&#98;&#108;&#111;&#110;.&#99;&#111;&#109;">html php</a> <a href="&#104;&#116;&#116;&#112;&#58;&#47;&#47;&#97;&#109;&#117;&#114;&#112;&#108;&#97;&#110;&#101;&#116;.&#114;&#117;">&#1089;&#1072;&#1081;&#1090; &#1079;&#1085;&#1072;&#1082;&#1086;&#1084;&#1089;&#1090;&#1074;</a></div>
<div id="wrapper">
  <div id="header">
    <h1>Служба поиска домашних животных
</h1> 
    <div id="nav-top">
      <ul>
        <li id="tab-faq">
          <div><a href="index.jsp">Вход</a></div>
        </li>
        <li id="tab-map">
          <div><a href="registration.jsp">Регистрация</a></div>
        </li>
      </ul>
    </div>
     <div id="nav">
      <ul>
        <li class="home"><a href="index.jsp">Home</a></li>
        <li><a href="news.jsp">Новости</a></li>
        <li><a href="services.jsp">Услуги</a></li>
        <li><a href="gallery.jsp">Gallery</a></li>
        <li><a href="contacts.jsp">Контакты</a></li>
        <li><a href="help.jsp">Помощь</a></li>
        <li><a href="registration.jsp">Регистрация</a></li
        ><li><a href="index.jsp">Вход</a></li>
      </ul>
      
    </div>
  </div>
  <div id="content">
    <div class="left-col" >
    	<div id="resultTable" >
    <%=WebConstruction.getReport() %>
    	</div>
     </div>
    
    <div class="right-col">
      <h2>Услуги...</h2>
      <ul>
      	<%=WebConstruction.getClientAddPanel(request) %>
        <%=WebConstruction.getStaffAddPanel(request) %>
        <li><a href="sought.jsp">Разыскиваются </a></li>
        <li><a href="found.jsp">Найденны </a></li>
        <li><a href="good_hands.jsp">В добрые руки </a></li>
        <ul>      	
        	<%=WebConstruction.getAdminAddPanel(request) %>
        </ul> 
        </li>
      </ul>
    </div>
    
    <div class="clear"> </div>
    <div id="later">
      
      
      <div class="clear"> </div>
    </div>
  </div>
  <div class="clear" id="footc"> </div>

  <div id="footer"> Copyright 2011 vlpascal>Название сайта< 
</div></body></html>