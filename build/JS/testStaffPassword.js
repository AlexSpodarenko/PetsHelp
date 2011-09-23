/**
 * 
 */
var request=null;

function testStaffPassword()
{
	$(document).ready(function() {
  		$('#form_add_staff').ketchup();
	});


var	Name_staff=document.getElementById('Name_staff').value;
var age=document.getElementById('age').value;
var salary=document.getElementById('salary').value;
var login=document.getElementById('login').value;
var password=document.getElementById('Password').value;
var repPas=document.getElementById('RepeatPassword').value;
if(password!=repPas)
	{
	document.getElementById('erorrMessageDiv').innerHTML="пароль и повторение пароля не совпадают"
	return;
	}
var params="Name_staff="+Name_staff+"&age="+age+"&salary="+salary+"&login="+login+"&Password="+password+"&RepeatPassword="+repPas;
createRequest();

var url="AddStaff?"+params;		
requ.open("GET", url, true);

requ.onreadystatechange = getResultAddStaff;

requ.send(null);
}

function getResultAddStaff()
{	
	if(requ.readyState == 4) {
		var resp = requ.responseText;
		if(resp=="already exist")
			{
			document.getElementById('erorrMessageDiv').innerHTML = "пользователь с таким логином уже существует, выберите другой логин";
			}
		else
			{
			location="index.jsp";
			}
		}
}



