<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@page import="dao.ImplJPA.DaoFactory"%>
<%@page import="web.WebConstruction" %>
<%@page import="Idao.*" %>
<%@page import="dto.*" %>
<%@page import="javax.persistence.PersistenceException" %>
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

<script type="text/javascript" src="JS/createRequest.js"></script>
<script type="text/javascript" src="JS/SublistSpecies.js"></script>
<script type="text/javascript" src="JS/SublistCity.js"></script>
<script type="text/javascript" src="JS/addComment.js"></script>
<script type="text/javascript" src="JS/map.js"></script>
<script src="http://api-maps.yandex.ru/1.1/index.xml?key=ANpUFEkBAAAAf7jmJwMAHGZHrcKNDsbEqEVjEUtCmufxQMwAAAAAAAAAAAAvVrubVT4btztbduoIgTLAeFILaQ==" type="text/javascript"></script>
<script type="text/javascript">
var requ=null;

function setVisibleFormFindingPet()
{	
document.getElementById('formForChangeFindingPet').style.display='block';
document.getElementById('idF').style.display='none';
}

function showCommentBlock()
{	
document.getElementById('commentBlock').style.display='block';
document.getElementById('idForComment').style.display='none';
}

function setVisibleFormStatemate()
{	
document.getElementById('formForChangeStatemate').style.display='block';
document.getElementById('idS').style.display='none';
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

function deleteComent()
{	
	var id=this.getAttribute('id');	
	var cont="Container"+id;
	document.getElementById(cont).innerHTML="";
	createRequest();
	var url="DeleteComment?";
	var param="id="+id;
	url+=param;
	requ.open("GET", url, true);
	requ.onreadystatechange = DeleteCommentRet;
	requ.send(null);
}

function DeleteCommentRet()
{	//if(requ.readyState == 4) {
	//	var resp = requ.responseText;
	return;
	
}



var map, geoResult;

// Создание обработчика для события window.onLoad
YMaps.jQuery(function () {
    // Создание экземпляра карты и его привязка к созданному контейнеру
   
    map = new YMaps.Map(YMaps.jQuery("#YMapsID")[0]);
   
    // Установка для карты ее центра и масштаба
    map.setCenter(new YMaps.GeoPoint(37.64, 55.76), 10);
   
    // Добавление элементов управления
    map.addControl(new YMaps.TypeControl());
});

// Функция для отображения результата геокодирования
// Параметр value - адрес объекта для поиска
function showAddress (value) {
	
	map = new YMaps.Map(YMaps.jQuery("#YMapsID")[0]);
    // Установка для карты ее центра и масштаба
    map.setCenter(new YMaps.GeoPoint(37.64, 55.76), 10);
    // Добавление элементов управления
    map.addControl(new YMaps.TypeControl());
    // Удаление предыдущего результата поиска
    map.removeOverlay(geoResult);
    // Запуск процесса геокодирования
    var geocoder = new YMaps.Geocoder(value, {results: 1, boundedBy: map.getBounds()});
    // Создание обработчика для успешного завершения геокодирования
    YMaps.Events.observe(geocoder, geocoder.Events.Load, function () {
        // Если объект был найден, то добавляем его на карту
        // и центрируем карту по области обзора найденного объекта
        if (this.length()) {
            geoResult = this.get(0);
            map.addOverlay(geoResult);
            map.setBounds(geoResult.getBounds());
        }else {
            alert("Ничего не найдено")
        }
    });

    // Процесс геокодирования завершен неудачно
    YMaps.Events.observe(geocoder, geocoder.Events.Fault, function (geocoder, error) {
        alert("Произошла ошибка: " + error);
    })
    document.getElementById('YMapsID').style.display='block';
}


</script>

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
      <h2>Выбранное животное</h2>
      <div class="elem_all">
      <%=WebConstruction.getInfoForPageElem(request)%>
     
      	</div>
      	      	
      	<div id="commentBlock">
      	<form method="get" accept-charset="UTF-8">
      	<input id="idForComment" name="idForComment"/>
      	<textarea rows="10" cols="40" name="commentText" id="commentText"></textarea>
      	<p>
      	<input type="button" onclick="hideCommentWindow()" value="отмена"/>
      	<input type="button" value="добавить" onclick="addComment()"/>
      	</p>
      	</form>
      	
      	
      	</div>
      	
      	
      	
      	<div id="formForChangeFindingPet">
      	
      	<FORM name="form_add_finding_pet" id="form_add_finding_pet" method="post" action="EditFindingPet" enctype="multipart/form-data" accept-charset="UTF-8">
		<p><B>Область:</B><br />
		<div id="regionDiv" style="width:290px"><%=WebConstruction.getlistBox(DaoFactory.getCityDao().getAllRegion(),1,"regionMenu","getCitySublist()","regionMenu") %></div></p>
		<div id="cityDiv" style="width:290px;"></div>
		<p><B>Тип Животного:</B><br />
		<div id="petTypeDiv" style="width:290px"><%=WebConstruction.getlistBox(DaoFactory.getPetDao().getAllPetType(),1,"petTypeMenu","getSpeciesSublist()","petTypeMenu") %></div></p>		
		<div id="petSpeciesDiv" style="width:290px;"></div>
		
		<input id="idF" name="idF"/>
		 <p><B>Введите место где сейчас находиться животное:</B><br />
		 <input name="where_placed" type="text"  size="30" />
		</p>
		<p><B>Введите дату находки:</B><br />
		<INPUT TYPE="text" NAME="data" id="date" SIZE=30/></p>
		<P><B>Фото:</B><br />
		<INPUT TYPE="file" NAME="foto_f" SIZE=30/>
		<P>
		 <p><B>Описание животного:</B><br />
		<textarea rows="10" cols="40" name="specialFiture"></textarea>
			<INPUT TYPE="submit" VALUE="Добавить найденое животное" NAME="add_finding_petButton" onclick="validate_add_finding_pet()">
		</P>
	</FORM>
	</div>
	<div id="formForChangeStatemate" >
	 <FORM name="form_add_statemate" id="form_add_statement" method="post" action="EditStatemate" enctype="multipart/form-data">
		<input id="idS" name="idS"/>
		<p><B>Область:</B><br />
		<div id="regionDiv2" style="width:290px"><%=WebConstruction.getlistBox(DaoFactory.getCityDao().getAllRegion(),1,"regionMenu2","getCitySublist2()","regionMenu") %></div></p>
		<div id="cityDiv2" style="width:290px;"></div>
		<p><B>Тип Животного:</B><br />
		<div id="petTypeDiv2" style="width:290px"><%=WebConstruction.getlistBox(DaoFactory.getPetDao().getAllPetType(),1,"petTypeMenu2","getSpeciesSublist2()","petTypeMenu") %></div></p>		
		<div id="petSpeciesDiv2" style="width:290px;"></div>
		
		 <p><B>имя животного:</B><br />
		 <input name="petName" type="text"  size="30" />
		</p>
		<p><B>приблизительный вес животного:</B><br />
		<INPUT TYPE="text" NAME="weight"  SIZE=30/></p>
		<P><B>Фото:</B><br />
		<INPUT TYPE="file" NAME="foto_f" SIZE=30/>
		<P>
		<p><B>Описание животного:</B><br />
		<textarea rows="10" cols="40" name="specialFiture" ></textarea>
			<INPUT TYPE="submit" VALUE="Добавить найденое животное" NAME="add_finding_petButton" onclick="validate_add_statement()">
		</P>
	</FORM>
      	
      	</div>
      	
      	<%String id=request.getParameter("id"); 
      	boolean isStat=false;  
      	if(id.substring(0,1).equals("S"))
      		isStat=true;
      	Integer idNum=Integer.parseInt(id.substring(1,id.length()));
      	%>
      	<div id="commentsList">
      	<%=WebConstruction.getCommentsList(idNum,isStat,request) %>
      	</div>
      	<div id="comments"></div>
      	
     </div>
    <p><div id="YMapsID" style="width:600px;height:400px"></div>
      	</p>
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

<script type="text/javascript">
	document.getElementById('formForChangeStatemate').style.display='none';
	document.getElementById('formForChangeFindingPet').style.display='none';
	var fullId=getVariable("id");
	var numId=fullId.substring(1,fullId.length);
	document.getElementById('idF').value=numId;
 	document.getElementById('idS').value=numId;
 	document.getElementById('commentBlock').style.display='none';
 	document.getElementById('idForComment').value=fullId;	
 	document.getElementById('YMapsID').style.display='none';
 	var arrElem=document.getElementsByName('commentDeleteButton');
	var i=0;
	for(i=0; i<arrElem.length;i++)
		{
		arrElem[i].onclick=deleteComent;
		}
 	
</script>

  <div id="footer"> Copyright 2011 vlpascal>Название сайта< 

</div></div></body></html>