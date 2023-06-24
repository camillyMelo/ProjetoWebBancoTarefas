<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Alerta</title>
<style>
body {
    font-family: 'Inter', sans-serif;
    margin: 0;
    padding: 0;
    color: #023047
}

h1{
	text-align: left;
}
.page {
    display: flex;
    flex-direction: column;
    align-items: center;
    align-content: center;
    justify-content: center;
    
    width: 100%;
    height: 100vh;
    background-color: #dea7a8;
}

main{
background-color: #ffd9d9;
padding: 40px;
margin: 40px 10px;
border-radius:5px;
}
.btn:hover {
    transform: scale(1.05);
    background-color: #faa9a6;
    

}
  
.menu {
background-color: #faa9a6;
    float: left;
border-radius:5px;
}

.menu a {
    display: block;
    text-align: center;
    padding: 14px 16px;
    color:white;
    text-decoration: none;
}
</style>
</head>
<body>
<div class="page">
	<nav>
	    <ul class="menu">
	        <li class="borda_right">
	            <a href = "/agendaPessoal/login">Login</a>
	        </li>
	    </ul>
	</nav>
	<h1>Logout!</h1>
	</div>
</body>
</html>