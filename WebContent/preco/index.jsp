<%@page import="java.util.List"%>
<%@page import="model.Produto"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="controlPreco" class="control.PrecoController" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setLocale value="pt_BR" /> 

<%@ include file="../includes/header.jsp" %>

<div class="content">
	<div class="header">
		<i class="fa fa-bar-chart"></i>
		<span class="title">Valores</span>
		<span class="subtitle">Listagem de valores cadastrados no sistema</span>				
		<a href="novo.jsp" class="waves-effect waves-light btn">NOVO VALOR</a>
	</div>
	<div class="box">
		<div class="row">
			<div class="col s12">
				<table class="striped bordered">
					<thead>
						<tr>
							<td width="200">Valor Cadastrado</td>
							<td>Data Inicio</td>	
							<td>Data Final</td>	
						    <td>Produto</td>
							<td>Usuário</td>
							<td width="110">Opções</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="i" items="${controlPreco.buscarTodos()}">
							<tr>	
								<td>R$ <fmt:formatNumber value="${i.valor}" minFractionDigits="2" /></td>
								<td><fmt:formatDate value="${i.dataInicio}"/></td>	
						     	<td><fmt:formatDate value="${i.dataFinal}"/></td>	
							    <td>${i.produto.nome}</td>
								<td>${i.usuario.nome}</td>
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