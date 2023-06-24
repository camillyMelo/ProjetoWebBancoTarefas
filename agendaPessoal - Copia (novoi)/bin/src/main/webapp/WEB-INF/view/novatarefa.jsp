<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
body {
    font-family: 'Inter', sans-serif;
    margin: 0;
    padding: 0;
    color: #023047
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

.formLogin {
    display: flex;
    flex-direction: column;
    background-color: #fff;
    border-radius: 7px;
    padding: 40px;
    box-shadow: 10px 10px 40px rgba(0, 0, 0, 0.4);
    gap: 5px
}

.formLogin h1 {
    padding: 0;
    margin: 0;
    font-weight: 500;
    font-size: 2.3em;
}

.formLogin p {
    display: inline-block;
    font-size: 14px;
    color: #666;
    margin-bottom: 25px;
}

.formLogin input {
    padding: 15px;
    font-size: 14px;
    border: 1px solid #ccc;
    margin-bottom: 20px;
    margin-top: 5px;
    border-radius: 4px;
    transition: all linear 160ms;
    outline: none;
}


.formLogin input:focus {
    border: 1px solid #f72585;
}

.formLogin label {
    font-size: 14px;
    font-weight: 600;
}

.formLogin a {
    display: inline-block;
    margin-bottom: 20px;
    font-size: 13px;
    color: #555;
    transition: all linear 160ms;
}

.formLogin a:hover {
    color: #faa9a6;
}

.btn {
    background-color: #faa9a6;
    color: #fff;
    font-size: 14px;
    font-weight: 600;
    border: none !important;
    transition: all linear 160ms;
    cursor: pointer;
    margin: 0 !important;

}
main{
background-color: #ffd9d9;
padding: 20px;
margin: 20px 0;
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
}</style>
<title>Cadastro de Tarefa</title>
</head>
<body>
<div class="page">

<main>
<h1>Nova tarefa</h1>
<form action="<%=request.getContextPath()%>/novatarefa" class="formLogin"method="post">
	<table>
		<tr>
			<td>Título</td>
			<td><input type="text" name="titulo" /></td>
		</tr>
		<tr>
			<td>Descrição</td>
			<td><input type="text" name="descricao" /></td>
		</tr>
		<tr>
			<td>Data de Criação</td>
			<td><input type="date" name="data_criacao" /></td>
		</tr>
		<tr>
			<td>Data de Conclusão</td>
			<td><input type="date" name="data_conclusao" /></td>
		</tr>
		<tr>
			<td>Status</td>
			<td><input type="text" name="status" /></td>
		</tr>
	</table>
	<input type="submit" value="Enviar" />
</form></main></div>
</body>
</html>