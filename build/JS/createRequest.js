/**
 * 
 */

function getVariable(varName)
{                   
	var arg=location.search.substring(1).split('&')
	var variable=""
	var i
	for(i=0;i<arg.length;i++)
	{
	if(arg[i].split('=')[0]==varName)
	{
	if(arg[i].split('=').length>1)
	{
	variable=arg[i].split('=')[1]
	}
	return variable
	}
	}
	return ""
}

	function createRequest () {
	try {	
			requ = new XMLHttpRequest();
			} catch (trymicrosoft) {
				try {
					requ = new ActiveXOblect("Msxml2.request");
						} catch (othermicrosoft) {
							try {
								requ = new ActiveXObject("Microsoft.request");
							} catch (failed) {
							requ = null;
								}
			}
		}
		if (requ == null) alert("Ошибка создания XMLHttpRequest объекта!");
	}