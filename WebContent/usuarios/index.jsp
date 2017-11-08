<%@page import="java.util.List"%>
<%@page import="model.Produto"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="controlUsuario" class="control.UsuarioController" />

<%@ include file="../includes/header.jsp" %>

<div class="content">
	<div class="header">
		<i class="fa fa-users"></i>
		<span class="title">Usuários</span>
		<span class="subtitle">Listagem de usuários cadastrados no sistema</span>				
		<a href="novo.jsp" class="waves-effect waves-light btn">NOVO USUÁRIO</a>
	</div>
	<div class="box">
		<div class="row">
			<div class="col s12">
				<table class="striped bordered">
					<thead>
						<tr>
							<td>Nome</td>
							<td>Cpf</td>
							<td>Login</td>
							<td width="110">Opções</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="i" items="${controlUsuario.buscarTodos()}">
							<tr>
								<td>${i.nome}</td>
								<td>${i.cpf}</td>
								<td>${i.login}</td>
								<td>
									<a href="editar.jsp?id=${i.id}" class="waves-effect waves-light btn"><i class="fa fa-pencil"></i></a>
									<a href="excluir.jsp?id=${i.id}" class="waves-effect waves-light btn"><i class="fa fa-times"></i></a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>
<%@ include file="../includes/footer.jsp" %>