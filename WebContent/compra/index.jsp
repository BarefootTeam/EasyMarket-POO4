<%@page import="java.util.List"%>
<%@page import="model.Compra"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="controlCompra" class="control.CompraController" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setLocale value="pt_BR" />

<%@ include file="../includes/header.jsp" %>

<div class="content">
	<div class="header">
		<i class="fa fa-bar-chart"></i>
		<span class="title">Lista de Compras</span>
		<span class="subtitle">Listagem de compras para estoque efetuadas no sistema</span>				
		<a href="novo.jsp" class="waves-effect waves-light btn">NOVO COMPRA</a>
	</div>
	<div class="box">
		<div class="row">
			<div class="col s12">
				<table class="striped bordered">
					<thead>
						<tr>
							<td width="250">Usuário</td>
							<td width="250">Data da Compra</td>
							<td>Quantidade de Itens</td>								
							<td width="110">Opções</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="i" items="${controlCompra.buscarTodos()}">
							<tr>
								<td>${i.usuario.nome}</td>
								<td><fmt:formatDate value="${i.data}"/></td>
								<td><fmt:formatNumber value="${i.itens.size()}"/></td>
								<td>
									<a href="detalhes.jsp?id=${i.id}" class="waves-effect waves-light btn"><i class="fa fa-search"></i></a>
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