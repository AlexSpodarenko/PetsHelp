<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@page import="dao.ImplJPA.DaoFactory"%>
<%@page import="web.WebConstruction" %>
<%@page import="Idao.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<title>Название сайта</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<link rel="stylesheet" href="style.css" type="text/css" charset="UTF-8" />
<link rel="stylesheet" type="text/css" media="screen" href="css/jquery.ketchup.css" charset="UTF-8"/>

<script type="text/javascript" src="JS/jquery.min.js"></script>
<script type="text/javascript" src="JS/jquery.ketchup.js"></script>
<script type="text/javascript" src="JS/jquery.ketchup.messages.js"></script>
<script type="text/javascript" src="JS/jquery.ketchup.validations.basic.js"></script>
<script type="text/javascript" src="JS/validation.js"></script>

<script type="text/javascript" src="JS/SublistSpecies.js"></script>
<script type="text/javascript" src="JS/SublistCity.js"></script>
<script type="text/javascript" src="JS/createRequest.js"></script>
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
    <div class="left-col">
    	

<h2>Добавить заявление о пропаже животного</h2>
      	<div align="center">
      <FORM name="form_add_statemate" id="form_add_statement" method="post" action="AddStatemate" enctype="multipart/form-data">
		<p><B>Область:</B><br />
		<div id="regionDiv" style="width:290px"><%=WebConstruction.getlistBox(DaoFactory.getCityDao().getAllRegion(),1,"regionMenu","getCitySublist()","regionMenu") %></div></p>
		<div id="cityDiv" style="width:290px;"></div>
		<p><B>Тип Животного:</B><br />
		<div id="petTypeDiv" style="width:290px"><%=WebConstruction.getlistBox(DaoFactory.getPetDao().getAllPetType(),1,"petTypeMenu","getSpeciesSublist()","petTypeMenu") %></div></p>		
		<div id="petSpeciesDiv" style="width:290px;"></div>
		
		 <p><B>имя животного:</B><br />
		 <input name="petName" type="text" class="validate(required, username)" size="30" />
		</p>
		<p><B>приблизительный вес животного:</B><br />
		<INPUT TYPE="text" NAME="weight" class="validate(required, number)" SIZE=30/></p>
		<P><B>Фото:</B><br />
		<INPUT TYPE="file" NAME="foto_f" SIZE=30/>
		<P>
		<p><B>Описание животного:</B><br />
		<textarea rows="10" cols="40" name="specialFiture" ></textarea>
			<INPUT TYPE="submit" VALUE="Добавить найденое животное" NAME="add_finding_petButton" onclick="validate_add_statement()">
		</P>
	</FORM>
	
	
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


  <div id="footer"> </div>
  </div>
  </body>
  </html>
