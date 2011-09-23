/**
 * 
 */


var requ=null;
	
function getCitySublist2()
{	
	var par=document.getElementById('regionMenu2').value;
	if(par=="non set")
		{
		document.getElementById('cityDiv2').innerHTML="";	
		return;
		}
	var params = "region="+par;
	createRequest();
	var url="GetCitySublist?"+params;		
	
	requ.open("GET", url, true);

	requ.onreadystatechange = updatePageCity2;
	//Отправить запрос
	requ.send(null);
}

function updatePageCity2() {
	if(requ.readyState == 4) {
	var resp = "Город"+requ.responseText;
	document.getElementById('cityDiv2').innerHTML = "\'"+resp+"\'";
	}
}


	function getCitySublist()
	{	
		var par=document.getElementById('regionMenu').value;
		if(par=="non set")
			{
			document.getElementById('cityDiv').innerHTML="";	
			return;
			}
		var params = "region="+par;
		createRequest();
		var url="GetCitySublist?"+params;		
		
		requ.open("GET", url, true);

		requ.onreadystatechange = updatePageCity;
		//Отправить запрос
		requ.send(null);
	}
 
	function updatePageCity() {
		if(requ.readyState == 4) {
		var resp = "Город"+requ.responseText;
		document.getElementById('cityDiv').innerHTML = "\'"+resp+"\'";
		}
	}
	

	
