<html>
<head>
<title>Register</title>
<script type="text/javascript">
function check()
{
var name=document.f.fname.value;
var p1=document.f.p1.value;
var p2=document.f.p2.value;
var add=document.f.add.value;
var e1=document.f.email.value;
var ph=document.f.num.value;
var atpos=e1.indexOf("@");
var dotpos=e1.lastIndexOf(".");
if(name.length==0||p1.length==0||p2.length==0||add.length==0||e1.length==0||ph.length==0)
{alert("Enter all compulsory fields");return false;}
if(atpos<1||dotpos<1||dotpos<atpos+2)
{
    alert("Invalid emailid");return false;
}
else 
    if(!e1.match(/\b(^(\S+@)((\gmail)|(\ymail)|(\hotmail)|(\yahoo))+((\.com)|(\.net)|(\..{2,2}))$)\b/gi)
)
{
alert("Invalid email");
return false;
}
if(p1!=p2)
{
    alert("Passwords do not match");return false;
}
else if(p1.length<6)
{
    alert("Too short password");return false;
}
if((!(/^-?\d+(\.\d+)?$/.test(ph)))||ph.length<10)
{
    alert("Invalid phone number");return false;
}
}
function pass(p1)
{
var s1="strong";
var s2="weak";
if(p1.length>6)
    document.getElementById("passworddes").innerHTML=s1;
else
    document.getElementById("passworddes").innerHTML=s2;
}
</script>
</head>
<body bgcolor = "grey">
    <CENTER><br><h1>DALLAS CITY LIBRARY</h1>
<form name="f" onsubmit="return check()" action="register_db.jsp" method="post"/>
<b>
<h2 align="center">Register Here</h2>
<center><strong>ENTER ALL THE FIELDS MARKED *</strong></center>
<table cellpadding="10%" align="center">
<tr>
<td><font color="black">First name*</font></td>
<td><input type="text" length=30 name="fname"></td>
</tr>
<tr>
<td><font color="black">Last name</font></td>
<td><input type="text" length=30 name="lname"></td>
</tr>
<tr>
<td><font color="black">Address* </font></td>
<td><input type="text"  name="address"></td>
</tr>
<tr>
<td><font color="black">City </font></td>
<td><input type="text"  name="city"></td>
</tr>
<tr>
<td><font color="black">State </font></td>
<td><input type="text"  name="state"></td>
</tr>
<tr>
<td><font color="black">Email id*(this will be used to contact you)</font></td>
<td><input type="text"  name="email"></td>
</tr>
<tr>
<td><font color="black">Password*(minimum six characters)</font></td>
<td><input type="password" length=30 name="p1" onkeydown="pass(this.value)"></td>
</tr>
<tr>
<td><font color="black">Retype password*</font></td>
<td><input type="password" length=30 name="p2"></td>
<td>
<label id="passworddes"><font color="grey">password not entered</font></label></td></tr>
</tr>
<tr>
<td><font color="black">Phone*</font></td>
<td><input type="number" length=30 name="num"></td>
</tr>
<tr>
<td><input type="submit" value="Submit" ></td>
<td><input type="Reset"  ></td>
</tr>
</font>
</b>
    </center>
</body>
</html>