
<%@page import="org.apache.axis.utils.Admin"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@page import="web.WebConstruction"%>
<html xml:lang="en" xmlns="http://www.w3.org/1999/xhtml" lang="en"><head>
<script type="text/javascript" src="JS/onClickMore.js"></script>
<title>Название сайта</title>
<meta http-equiv="Content-Type" content="text/xhtml; charset=UTF-8">
<link rel="stylesheet" href="style.css" type="text/css" charset="UTF-8">

<link rel="stylesheet" type="text/css" media="screen" href="css/jquery.ketchup.css" />
<script type="text/javascript" src="JS/jquery.min.js"></script>
<script type="text/javascript" src="JS/jquery.ketchup.js"></script>
<script type="text/javascript" src="JS/jquery.ketchup.messages.js"></script>
<script type="text/javascript" src="JS/jquery.ketchup.validations.basic.js"></script>
<script type="text/javascript" src="JS/My_script.js"></script>
<script type="text/javascript" src="JS/SublistCity.js"></script>



</head><body>


<div style="position: absolute; left: -3072px; top: 0pt;"><div class="width=100% height=100% align-left"></div><div class="align-left" width="1"></div><a href="http://sexmamba.ru/">знакомства</a> <!-- div --><!-- div end --> <a href="http://tutlove.ru/">секс</a> <!-- div --><!-- div end --> <a href="http://unishablon.com/">html php</a> <a href="http://amurplanet.ru/">сайт знакомств</a></div>

<div id="wrapper">
	<div align="right">	<%=WebConstruction.getAutorizationMessage(request)%></div>
  	<div id="header">
  	<div align="right"></div>
    <h1>Служба поиска домашних животных
</h1> 
    <div id="nav-top">
      <ul>
        <li id="tab-faq">
          <div><!--<a href="index.jsp">Вход</a>-->
          <a href="#" onclick="document.getElementById('wind').style.display='block'; return false;" title="Всплывающее окно">Вход</a>
          <div id="wind" >
          <form  NAME="form_in" id="form_in" action="Login" method="get">
          <label>Login</label>
          <input name="login" id="login" type="text" class="validate(required, username)"><br>
          <label>Password</label>
          <input name="password" type="password" id="password" class="validate(required)"><br>
          <button type="button" value="Отмена" onclick="document.getElementById('wind').style.display='none'; return false;">
Отмена</button>
		  <input type="submit" value="Войти" />
		</form>
		
		</div>
          
          </div>
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
        <li><a href="registration.jsp">Регистрация</a></li><li><!--<a href="index.html">Вход</a>-->
        
        <a href="#" onclick="document.getElementById('wind').style.display='block'; return false;" title="Всплывающее окно">Вход</a>
        </li>
      </ul>
    </div>
  </div>
  <div id="content">
    <div class="left-col">
      <div id="welcome">
        <h2>Welcome</h2>
        <p>С целью реорганизации существующей в Украине системы 
обращения с домашними животными, по закону Украины "О защите животных от
 жестокого поведения", на основании ст. 26 и руководствуясь ст. 59 
Закона Украины "О местном самоуправлении в Украине",  городским советам 
крупных городов рекомендовано разработать и утвердить "Программу 
обращения с домашними животными и регуляции их численности в городе на 
2007-2012 г. г."</p>
        <p>Этот сайт является одним из способов выполнения этого закона. И предназначен для...</p>
        <p><a href="news.jsp">more...</a></p>
      </div>
      <h2>Our Animals Gallery...</h2>
      <div id="gallery">
        <div class="box">
          <h3>01</h3>
          <img src="images/pic_1.jpg" alt="Pic 1" height="84" width="119">
          <p>This is just a place holder so you can see how the site would look like. DOGS DOGS</p>
          <p class="more"><input type="button" value="setFunc" onclick="setFunc()"/></p>
        </div>
        <div class="box box-lit">
          <h3>02</h3>
          <img src="images/pic_2.jpg" alt="Pic 2" height="84" width="119">
          <p>This is just a place holder so you can see how the site would look like. CATS CATS</p>
          <p class="more"><input type="button" id="testMore"/></p>
        </div>
        <div class="box">
          <h3>03</h3>
          <img src="images/pic_3.jpg" alt="Pic 3" height="84" width="119">
          <p>This is just a place holder so you can see how the site would look like. OTHER OTHER</p>
          <p class="more"><a href="other_animals.jsp">more</a></p>
        </div>
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
      <div class="left-col">
        <div class="box" id="later-b1"> <img src="images/pic_4.jpg" alt="Pic 4" height="175" width="92"> </div>
        <div class="box" id="later-b2">
          <h2>Поиск...</h2>
          <p>This is just a place holder so you can see how the site 
would look like.This is just a place holder so you can see how the site 
would look like.</p>
          <p class="more"><a href="search.jsp">more...</a></p>
        </div>
        <div class="box" id="later-b3">
          <h2>В добрые руки</h2>
          <p>This is just a place holder so you can see how the site 
would look like. This is just a place holder so you can see how the site
 would look like.</p>
          <p class="more"><a href="good_hands.jsp">more...</a></p>
        </div>
        <div class="box" id="later-b4"> <img src="images/pic_5.jpg" alt="Pic 5" height="166" width="137"> </div>
        <div class="clear"> </div>
      </div>
      <div class="right-col">
        <h2>Новости</h2>
        <p>рекомендовано разработать и утвердить "Программу обращения с 
домашними животными и регуляции их численности в городе на 2007-2012 г. 
г."</p>
        <p class="more"><a href="news.jsp">more...</a></p>
      </div>
      <div class="clear"> </div>
    </div>
  </div>
  <div class="clear" id="footc"> </div>

  <div id="footer"> Copyright 2011 Служба поиска домашних животных <br>@@@vlpascal@@@

<script type="text/javascript">
  document.getElementById('wind').style.display='none';
</script>

</div></div></body></html>