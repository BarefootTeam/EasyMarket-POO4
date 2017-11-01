<%@page import="java.util.List"%>
<%@page import="model.Produto"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="controlProduto" class="control.ProdutoController" />

<%@ include file="../includes/header.jsp" %>

<div class="content">
	<div class="header">
		<i class="fa fa-bar-chart"></i>
		<span class="title">Produtos</span>
		<span class="subtitle">Listagem de produtos cadastrados no sistema</span>				
		<a href="novo.jsp" class="waves-effect waves-light btn">NOVO PRODUTO</a>
	</div>
	<div class="box">
		<div class="row">
			<div class="col s12">
				<table class="striped bordered">
					<thead>
						<tr>
							<td width="100">Cód</td>
							<td>Titulo</td>
							<td width="110">Opções</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="i" items="${controlProduto.buscarTodos()}">
							<tr>
								<td>${i.codigo}</td>
								<td>${i.nome}</td>
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