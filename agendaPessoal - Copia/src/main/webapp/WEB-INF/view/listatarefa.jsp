<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
<h1>Login</h1>
  <form action="<%= request.getContextPath() %>/novatarefa" method="post">
  <%@ page import="java.util.ArrayList" %>
<%@ page import="model.Tarefa" %>
<table>
	<tr>
		<th>ID</th>
		<th>Título</th>
		<th>Descrição</th>
		<th>Data de Criação</th>
		<th>Data de Conclusão</th>
		<th>Status</th>
	</tr>
	<c:forEach items="${requestScope.lista_tarefas}" var="c">
		<tr>
			<td>
				${c.id}
			</td>
			<td>
				${c.titulo}
			</td>
			<td>
				${c.descricao}
			</td>
			<td>
				${c.data_criacao}
			</td>
			<td>
				${c.data_conclusao}
			</td>
			<td>
				${c.status}
			</td>
			<td>
				<input type="hidden" name="id_excluir" value="${c.id}" />
				<input type="submit" value="Excluir" />
			</td>
		</tr>
	</c:forEach>
</table>
</form>
</body>
</html>