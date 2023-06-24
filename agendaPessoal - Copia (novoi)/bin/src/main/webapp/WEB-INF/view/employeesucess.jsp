<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
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
<title>Cadastro concluído</title>
</head>
<body>
<div class="page">
<form action="<%=request.getContextPath() %>/employeesucess" method=get>
<nav>
    <div class="menu">
            <a href = "/agendaPessoal/login">Login</a>
    </div>
</nav>
<main><h1> O cadastro foi realizado com sucesso</h1></main>
</form>
</div>

</body>
</html>