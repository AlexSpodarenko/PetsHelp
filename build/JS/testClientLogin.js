/**
 * 
 */
var requ=null;
function testClientLogin()
{	
	validate_registration();
	var	FirstName=document.getElementById('FirstName').value;
	var pass=document.getElementById('Password').value;
	var repPass=document.getElementById('RepPassword').value;
	var login=document.getElementById('login').value;
	var mail=document.getElementById('Mail').value;
	var phone=document.getElementById('phone').value;
	if(pass!=repPass)
		{
		document.getElementById('errorMessageDiv').innerHTML="пароль и повторение пароля не совпадают"
		return;
		}
	var params="FirstName="+FirstName+"&Password="+pass+"&Mail="+mail+"&login="+login+"&phone="+phone;
	createRequest();

	var url="Registration?"+params;		
	requ.open("GET", url, true);
	requ.onreadystatechange = returnTestClienLogin;

	requ.send(null);
}

function returnTestClienLogin()
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
	errorMessageDiv
}