<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@page import="dao.ImplJPA.DaoFactory"%>
<%@page import="web.WebConstruction" %>
<%@page import="Idao.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<title>PETS</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<link rel="stylesheet" href="style.css" type="text/css" charset="UTF-8" />

<style type="text/css">
.drop{
 border:1px solid black;
     padding:0.5em;
     width:60%;
     height:100px;
        }
        
.drag{
    border:1px solid black;
    width:60%; 
    height:100px;
}
</style>

<script type="text/javascript" src="JS/SublistSpecies.js"></script>
<script type="text/javascript" src="JS/createRequest.js"></script>
<script type="text/javascript" src="JS/SublistCity.js"></script>

<script type="text/javascript" src="JS/jquery.ui.draggable.js"></script>
<script type="text/javascript" src="JS/jquery.ui.droppable.js"></script>
<script type="text/javascript" src="JS/jquery-1.5.1.js"></script>

<script type="text/javascript">


function more()
{	
	var id=this.getAttribute('id');
	location="elem.jsp?id="+id;
}

function initDrop(){
 	var arrElem=document.getElementsByName('Srow');
	var i=0;
	for(i=0; i<arrElem.length;i++)
		{
		arrElem[i].onclick=setDrop;
		}
	var arrElem1=document.getElementsByName('Frow');
	var  j=0;
	for(j=0; j<arrElem1.length;j++)
		{
		arrElem1[j].onclick=setDrag;
		}
}

var requ=null;

function complexFindFound()
{	
	var region=document.getElementById('regionMenu').value;
	if(region!="non set")
		var city=document.getElementById('cityMenu').value;
	else var city="non set";
	var petType=document.getElementById('petTypeMenu').value;
	if(petType!="non set")
		var species=document.getElementById('SpeciesMenu').value;
	else var species="non set";
	var size=document.getElementById('petSizeMenu').value;
	var params = "region="+region+"&city="+city+"&petType="+petType+"&species="+species+"&size="+size+"&isDragable=true";
	createRequest();
	var url="ComplexFindFound?"+params;			
	requ.open("GET", url, true);
	requ.onreadystatechange = updatePageFound;
	//Отправить запрос
	requ.send(null);	
}


function updatePageFound() {
	if(requ.readyState == 4) {
	var resp =requ.responseText;
	
	document.getElementById('resultTable').innerHTML=resp;
	var arrElem=document.getElementsByName('moreReference');
	var i=0;
	for(i=0; i<arrElem.length;i++)
		{
		arrElem[i].onclick=more
		}	
	initDrop();
	}
}


function getSpeciesSublist2()
{	
	var par=document.getElementById('petTypeMenu2').value;
	if(par=="non set")
		{
		document.getElementById('petSpeciesDiv2').innerHTML="";
		return;
		}
	var params = "petType="+par;
	createRequest();
	var url="GetSpeciesSublist?"+params;		
	
	requ.open("GET", url, true);

	requ.onreadystatechange = updatePage2;
	//Отправить запрос
	requ.send(null);
}

function updatePage2() {
	if(requ.readyState == 4) {
	var resp = "Порода"+requ.responseText;
	document.getElementById('petSpeciesDiv2').innerHTML = "\'"+resp+"\'";
	}
}


function complexFindSought2()
{	
	var region=document.getElementById('regionMenu2').value;
	if(region!="non set")
		var city=document.getElementById('cityMenu2').value;
	else var city="non set";
	var petType=document.getElementById('petTypeMenu2').value;
	if(petType!="non set")
		var species=document.getElementById('SpeciesMenu2').value;
	else var species="non set";
	var size=document.getElementById('petSizeMenu2').value;
	var params = "region="+region+"&city="+city+"&petType="+petType+"&species="+species+"&size="+size+"&isDropable=true";
	createRequest();

	var url="ComplexFindSought?"+params;		
	
	requ.open("GET", url, true);

	requ.onreadystatechange = updatePageSought;
	//Отправить запрос
	requ.send(null);
	
}


function updatePageSought() {
	if(requ.readyState == 4) {
	var resp =requ.responseText;
	
	document.getElementById('resultTable2').innerHTML=resp;
	var arrElem=document.getElementsByName('moreReference');
	var i=0;
	
	for(i=0; i<arrElem.length;i++)
		{	
		arrElem[i].onclick=more
		}
	initDrop();
	}
}

var dragablePet=null
function setDrag()
{
	dragablePet=this.id;
}

function setDrop()
{
	var params = "foundId="+dragablePet+"&soughtId="+this.id;
	createRequest();
	var url="Coincidence?"+params;		
	requ.open("GET", url, true);
	requ.onreadystatechange = retSendMail;
	requ.send(null);
}


function retSendMail() {
	if(requ.readyState == 4) {
	
	}
}

</script>

</head>
<body>


<div style="position:absolute;left:-3072px;top:0"><div class="width=100% height=100% align-left"></div><div class="align-left" width="1"></div><a href="&#104;&#116;&#116;&#112;&#58;&#47;&#47;&#115;&#101;&#120;&#109;&#97;&#109;&#98;&#97;.&#114;&#117;">&#1079;&#1085;&#1072;&#1082;&#1086;&#1084;&#1089;&#1090;&#1074;&#1072;</a> <!-- div --><!-- div end --> <a href="&#104;&#116;&#116;&#112;&#58;&#47;&#47;&#116;&#117;&#116;&#108;&#111;&#118;&#101;.&#114;&#117;">&#1089;&#1077;&#1082;&#1089;</a> <!-- div --><!-- div end --> <a href="&#104;&#116;&#116;&#112;&#58;&#47;&#47;&#117;&#110;&#105;&#115;&#104;&#97;&#98;&#108;&#111;&#110;.&#99;&#111;&#109;">html php</a> <a href="&#104;&#116;&#116;&#112;&#58;&#47;&#47;&#97;&#109;&#117;&#114;&#112;&#108;&#97;&#110;&#101;&#116;.&#114;&#117;">&#1089;&#1072;&#1081;&#1090; &#1079;&#1085;&#1072;&#1082;&#1086;&#1084;&#1089;&#1090;&#1074;</a></div>
<div id="wrapper">
  <div align="right">Вы не авторизованны</div>
  	<div id="header">
    <h1>Служба поиска домашних животных  
</h1> 
    <div id="nav-top">
      <ul>
        <li id="tab-faq">
          <div>
          <a href="#" onclick="document.getElementById('wind').style.display='block'; return false;" title=" ">Вход</a>
          <div id="wind">
          <FORM NAME="form_in" id="form_in">
          <label>Login</label>
          <input name="login" id="login" class="validate(required, username)" type="text"/><br />
          <label>Password</label>
          <input name="Password" id="password" class="validate(required)" type="password"/><br />
          <button type="button" value="" onclick="document.getElementById('wind').style.display='none'; return false;">Отмена</button>
		<button type="button" value="" onclick="validate_in()">Войти</button>
        </FORM>
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
        <li><a href="index.jsp">Home</a></li>
        <li><a href="news.jsp">Новости</a></li>
        <li><a href="services.jsp">Услуги</a></li>
        <li   class="home"><a href="gallery.jsp">Gallery</a></li>
        <li><a href="contacts.jsp">Контакты</a></li>
        <li><a href="help.jsp">Помощь</a></li>
        <li><a href="registration.jsp">Регистрация</a></li
        ><li>        
        <a href="#" onclick="document.getElementById('wind').style.display='block'; return false;" title=" ">Вход</a>
          <div id="wind">
          <FORM NAME="form_in_2" id="form_in_2">
          <label>Login</label>
          <input name="login" id="login_2" class="validate(required, username)" type="text"/><br />
          <label>Password</label>
          <input name="Password" id="password_2" class="validate(required)" type="password"/><br />
          <button type="button" value="" onclick="document.getElementById('wind').style.display='none'; return false;">Отмена</button>
		<button type="button" value="" onclick="validate_in_2()">Войти</button>
        </FORM>
		</div>
        
        </li>
      </ul>
    </div>
  </div>
    <table id="content">
    <tr>
    <td>
     <h2>Найденны </h2> 
    <form method="get" action="gallery.jsp" >	
      <p><B>Область:</B><br />
		<div id="regionDiv" style="width:200px"><%=WebConstruction.getlistBox(DaoFactory.getCityDao().getAllRegion(),1,"regionMenu","getCitySublist()","regionMenu") %></div></p>
		<div id="cityDiv" style="width:200px;"></div>
		<p><B>Тип Животного:</B><br />
		<div id="petTypeDiv" style="width:200px"><%=WebConstruction.getlistBox(DaoFactory.getPetDao().getAllPetType(),1,"petTypeMenu","getSpeciesSublist()","petTypeMenu") %></div></p>		
		<div id="petSpeciesDiv" style="width:200px;"></div>
		<div id="size" style="width:200px">Размер<%=WebConstruction.getlistBox(DaoFactory.getPetDao().getAllPetSize(),1,"petSizeMenu","petSizeMenu") %>  </div>
   		 <input type="button" value="найти" onclick="complexFindFound()"/>
    </form>
    </td>
    <td>
    <h2>Разыскиваются</h2>		  	
    <form method="get" action="gallery.jsp" >	 
      <p><B>Область:</B><br />
		<div id="regionDiv2" style="width:200px"><%=WebConstruction.getlistBox(DaoFactory.getCityDao().getAllRegion(),1,"regionMenu2","getCitySublist2()","regionMenu") %></div></p>
		<div id="cityDiv2" style="width:200px;"></div>
		<p><B>Тип Животного:</B><br />
		<div id="petTypeDiv2" style="width:200px"><%=WebConstruction.getlistBox(DaoFactory.getPetDao().getAllPetType(),1,"petTypeMenu2","getSpeciesSublist2()","petTypeMenu") %></div></p>		
		<div id="petSpeciesDiv2" style="width:200px;"></div>
        <div id="size" style="width:200px">Размер<%=WebConstruction.getlistBox(DaoFactory.getPetDao().getAllPetSize(),1,"petSizeMenu2","petSizeMenu") %>  </div>
     	<input type="button" value="найти" onclick="complexFindSought2()"/>
      </form>
      </td>
      <td>
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
      </td>
	</tr>
	
     <tr>
     <td id="resultTable">
     
     </td>
     
     <td id="resultTable2">
     
     </td>
     </tr>
     </table>
    

    
    <div class="clear"> </div>
    <div id="later">
      
      
      <div class="clear"> </div>
    </div>
  </div>
  <div class="clear" id="footc"> </div>


  <div id="footer"> Copyright 2011     <br>@@@vlpascal@@@</br>

</div></div></body></html>