<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.List"%>
<%@page import="model.Venda"%>
<%@page import="java.util.ArrayList"%>
<jsp:useBean id="controlVenda" class="control.VendaController" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setLocale value="pt_BR" /> 

<%@ include file="../includes/header.jsp" %>

<%
	Venda venda = controlVenda.buscarPorId(Long.parseLong(request.getParameter("id")));	
%>

<div class="content">
	<div class="header">
		<i class="fa fa-bar-chart"></i>
		<span class="title">Detalhes Venda <%=venda.getCliente() != null ?  "cliente : " + venda.getCliente().getNome() : " : Sem Cliente"%></span>
		<span class="subtitle">Listagem dos itens da compra efetuada para o estoque</span>				
		<a href="index.jsp" class="waves-effect waves-light btn">Voltar</a>
	</div>
	<div class="box">
		<div class="row">
			<div class="col s12">
				<table class="striped bordered">
					<thead>
						<tr>
							<td>Produto Vendido</td>
							<td width="350" style="text-align: center;">Quantidade</td>		
							<td width="250">Valor Unit�rio</td>
							<td width="150">Valor Total</td>									
						</tr>
					</thead>
					<tbody>
						<c:forEach var="i" items="<%=venda.getItens()%>">
							<tr>
								<td>${i.produto.nome}</td>									
								<td style="text-align: center;">${i.quantidade}</td>	
								<td>R$ <fmt:formatNumber value="${i.valorUnitario}" minFractionDigits="2" maxFractionDigits="2"/></td>								
								<td>R$ <fmt:formatNumber value="${i.valorUnitario * i.quantidade}" minFractionDigits="2" maxFractionDigits="2"/></td>													
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>
<%@ include file="../includes/footer.jsp" %>