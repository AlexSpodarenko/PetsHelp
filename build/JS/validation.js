/**
 * 
 */
function validate_registration(){
	$(document).ready(function() {
  		$('#myForm_registration').ketchup();
	});	
}

function validate_add_staff(){
	$(document).ready(function() {
  		$('#form_add_staff').ketchup();
	});	
}

function validate_add_city(){
	
	$(document).ready(function() {
  		$('#form_add_city').ketchup();
	});	
}

function validate_add_finding_pet(){
	$(document).ready(function() {
					$('#form_add_finding_pet').ketchup();
				});
				
//	var a = /^\d{1,2}([-. /])\d{1,2}\1\d{2,4}$/;
		var inp = document.getElementById('date');
		
			if(inp.value.search(a) !== -1){
			}
			else{
				alert("Введите дату в формате dd.dd.dddd or dd.dd.dd");
			}	
}

function validate_add_pets(){
	
	$(document).ready(function() {
  		$('#form_add_pets').ketchup();
	});	
}

function validate_in(){
	/*$(document).ready(function() {
  		$('#form_in').ketchup();
	});	*/
	
	var a = /^\w+/;
	var login = document.getElementById('login');
	var password = document.getElementById('password');
	if((login.value.search(a) !== -1)&&(password.value.search(a) !== -1)){
		document.forms["form_in"].submit();
		document.getElementById('wind').style.display='none';
			}
			else{
				alert("Проверьте введенные данные");
			}	
	/*document.getElementById('wind').style.display='none';*/
}

function validate_in_2(){
	/*$(document).ready(function() {
  		$('#form_in').ketchup();
	});	*/
	
	var a = /^\w+/;
	var login = document.getElementById('login_2');
	var password = document.getElementById('password_2');
	if((login.value.search(a) !== -1)&&(password.value.search(a) !== -1)){
		document.forms["form_in_2"].submit();
		document.getElementById('wind').style.display='none';
			}
			else{
				alert("Проверьте введенные данные");
			}	
	/*document.getElementById('wind').style.display='none';*/
}

function validate_add_statement(){
	$(document).ready(function() {
  		$('#form_add_statement').ketchup();
	});	
	
}