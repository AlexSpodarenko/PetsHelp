/**
 * 
 */
var request;

function more()
{	
	var id=this.getAttribute('id');
	location="elem.jsp?id="+id;
}




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
	var params = "region="+region+"&city="+city+"&petType="+petType+"&species="+species+"&size="+size;
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
	}
}