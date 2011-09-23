/**
 * 
 */
var requ=null;
var textcom=null;
function hideCommentWindow()
{
 	document.getElementById('commentBlock').style.display='none';
	document.getElementById('commentText').value="";
}

function addComment()
{	
	 textcom=document.getElementById('commentText').value;
	 
	if(textcom.length==0)
	{	hideCommentWindow();
		return;
	}
	createRequest();
	var params="commentText="+textcom+"&idForComment="+document.getElementById('idForComment').value;
	var url="AddComment?"+params;
	
	requ.open("GET", url, true);
	requ.onreadystatechange = AddCommentRet;
	requ.send(null);
}

function AddCommentRet()
{	if(requ.readyState == 4) {
		var resp = requ.responseText;
		var newCom="<div class=\"comment\" ><br><p>"+resp+" написал:</p>"+"<p>"+textcom+"</p></div>";
		//newCom+="<p> <input type=\"button\" value=\"удалить\" "
		document.getElementById('comments').innerHTML=document.getElementById('comments').innerHTML+newCom;
		hideCommentWindow();
}
}
