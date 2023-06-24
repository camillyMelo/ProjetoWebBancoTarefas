<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ page import="java.util.List" %>
<%@ page import="model.Tarefa" %>
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
    box-shadow: 10px 20px 40px rgba(0, 0, 0, 0.4);
    gap: 5px;
    border-spacing: 10px
}

.formLogin h1 {
    padding: 0;
    margin: 0;
    text-align:right;
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
     padding: 14px 16px;

}
a{
 background-color: #faa9a6;
    color: #ffff;
    font-size: 14px;
    font-weight: 600;
 text-decoration:none;
  border: 5px;
    transition: all linear 160ms;
    cursor: pointer;
    margin: 0 !important;
    padding: 20px 20px;
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
    
}
th {
    vertical-align: inherit;
    border-color: inherit;
    font-size: 25px;
 color: #faa9a6;
    font-weight: 600;
    border: none !important;
}</style>
<title>Lista de tarefas</title>
</head>
<body>
<div class="page">

<main>

<nav>
<table class="menu">
           <tr>
           <td> <a href = "/agendaPessoal/novatarefa">Nova Tarefa</a>
           </td>
            <td>
             <a href="/agendaPessoal/LogoutServlet">Sair</a></td>
             </tr>
    </table>
</nav>
<h1><br>Lista de tarefas</h1>
<form role="search" action="<%=request.getContextPath() %>/search" method="post" >
              <input class="form-control me-2" type="search" placeholder="Buscar" aria-label="Buscar" name="search">
              <input class="btn btn-success" type="submit" value="Buscar">
            </form>
            
<table class="formLogin">
	<tr>
		<th> Título </th>
		<th> Descrição </th>
		<th> Data de Criação</th>
		<th> Data de Conclusão</th>
		<th>Status</th>
	</tr>
	<%
List<Tarefa> tarefa = (List<Tarefa>)request.getAttribute("lista_tarefas");
if(tarefa != null && tarefa.size() != 0){
for(Tarefa t : tarefa){
%>

		<tr>
			<td>
				<%=t.getTitulo() %>
			</td>
			<td>
				<%=t.getDescricao() %>
			</td>
			<td>
				<%=t.getData_cricao() %>
			</td>
			<td>
				<%=t.getData_conclusao() %>
			</td>
			<td>
				<%=t.getStatus() %>
			</td>
			<td>
			<form action="<%= request.getContextPath() %>/listatarefa" method="post">
				<input type="hidden" name="id_excluir" value="<%=t.getId()%>" />
				<input type="submit" value="Excluir" class="btn" />
				</form>
			</td>
			<td>
				<a class="menu" href = "/agendaPessoal/tarefaedit?id_tarefa=<%=t.getId()%>">Editar</a>
			</td>
			
		</tr>
		
	<%
	}
} 
%>
</table>
</main>
</div>
</body>
</html>
