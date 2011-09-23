<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@page import="web.WebConstruction" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<title>Название сайта</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<link rel="stylesheet" href="style.css" type="text/css" charset="UTF-8" />

<script type="text/javascript" src="JS/jquery.min.js"></script>
<script type="text/javascript" src="JS/jquery.ketchup.js"></script>
<script type="text/javascript" src="JS/jquery.ketchup.messages.js"></script>
<script type="text/javascript" src="JS/jquery.ketchup.validations.basic.js"></script>
<script type="text/javascript" src="JS/createRequest.js"></script>
<script type="text/javascript" src="JS/validation.js"></script>
<script type="text/javascript" src="JS/testClientLogin.js"></script>

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
        <li><a href="index.jsp">Home</a></li>
        <li><a href="news.jsp">Новости</a></li>
        <li><a href="services.jsp">Услуги</a></li>
        <li><a href="gallery.jsp">Gallery</a></li>
        <li><a href="contacts.jsp">Контакты</a></li>
        <li><a href="help.jsp">Помощь</a></li>
        <li class="home"><a href="registration.jsp">Регистрация</a></li
        ><li><a href="index.jsp">Вход</a></li>
      </ul>
    </div>
  </div>
  <div id="content">
    <div class="left-col">
      <h2>Регистрация</h2>
      
<FORM NAME="myForm" id="myForm_registration" class="registration">
      <div>
 		<p><B>Введите имя:</B><br />
		  <input name="FirstName" id="FirstName" type="text" class="validate(required, username)"  SIZE=30 />
		</p>
        </div>       
		<p><B>Введите логин:</B><br />
		<INPUT TYPE="text" NAME="login" id="login"  class="validate(required, username)" SIZE=30></p>
		<P><B>Пароль:</B><br />
		<INPUT TYPE="password" NAME="Password" id="Password" class="validate(required)" SIZE=30></P>
		<P><B>Повторите пароль:</B><br />
		<INPUT TYPE="password" NAME="RepPassword" id="RepPassword" class="validate(required, match(#password))" SIZE=30></P>
        <P><B>Введите email:</B><br />
		<INPUT TYPE="email" NAME="Mail" id="Mail" class="email" SIZE=30></P>
		<P><B>Телефон:</B><br />
		<INPUT TYPE="text" NAME="phone" id="phone" class="validate(required, digits, rangelength(5,20))" SIZE=30></P>
		<P>
			<INPUT TYPE="button" VALUE="Отмена" NAME="upperButton" onclick="location.href='index.jsp'" style="width:187px">
			<INPUT TYPE="button" VALUE="Регистрация" NAME="lowerButton" 
		onclick="testClientLogin()" style="width:187px">
		</P>
		<div id="errorMessageDiv">
		</div>
	</FORM>
                                                
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


</body></html>