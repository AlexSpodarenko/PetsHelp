/**
 * 
 */
var requ=null;
	



	function getSpeciesSublist()
	{	
		var par=document.getElementById('petTypeMenu').value;
		if(par=="non set")
			{
			document.getElementById('petSpeciesDiv').innerHTML="";
			return;
			}
		var params = "petType="+par;
		createRequest();
		var url="GetSpeciesSublist?"+params;		
		
		requ.open("GET", url, true);

		requ.onreadystatechange = updatePage;
		//Отправить запрос
		requ.send(null);
	}
 
	function updatePage() {
		if(requ.readyState == 4) {
		var resp = "Порода"+requ.responseText;
		document.getElementById('petSpeciesDiv').innerHTML = "\'"+resp+"\'";
		}
	}
	

	

