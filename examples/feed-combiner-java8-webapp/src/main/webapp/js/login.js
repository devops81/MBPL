var attempt = 3; //Variable to count number of attempts
var loggedUser = 'Admin';

function getUserName(){
	alert(document.getElementById("username").value);
}

//Below function Executes on click of login button
function validate(){
	
	var username = document.getElementById("username").value;
	var password = document.getElementById("password").value;
	
	
	if ( username == "admin" && password == "admin"){
		window.location = "welcome.html"; //redirecting to other page
		return false;
	}
	else if(username == "" && password == "sa")
	{
		document.getElementById('error').innerHTML="User Name can not be blanked";
	}
	else if(username == "400219041" && password == "")
	{
		document.getElementById('error').innerHTML="Password can not be blanked";
	}
	
	else if(username == "" && password == "")
	{
		document.getElementById('error').innerHTML="User Name & Password can not be blanked";
	}
}
function blockSpecialChar(e){
        var k;
        document.all ? k = e.keyCode : k = e.which;
        return ((k > 64 && k < 91) || (k > 96 && k < 123) || k == 8 || k == 32 || (k >= 48 && k <= 57));
        }