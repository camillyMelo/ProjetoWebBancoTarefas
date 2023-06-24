<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Erro login</title>
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
<title>Insert title here</title>
</head>
<body>

<div class="page">
<form action="<%=request.getContextPath() %>/login_erro" method=get>
<nav>
    <table class="menu">
           <tr>
           <td> <a href = "/agendaPessoal/login">Login</a>
           </td>
            <td> <a href = "/agendaPessoal/register">Cadastrar-se</a>
            </td>
             </tr>
    </table>
   
</nav>
<main><h1>O login informado não existe!</h1></main>

</form>
</div>
</body>
</html>