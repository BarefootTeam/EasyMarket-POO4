<%@page import="java.util.List"%>
<%@page import="model.Estoque"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="controlEstoque" class="control.EstoqueController" />
<jsp:useBean id="controlProduto" class="control.ProdutoController" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setLocale value="pt_BR" />

<%@ include file="../includes/header.jsp" %>

<%
	List<Estoque> estoqueGeral = controlEstoque.obterEstoqueAtual();
%>

<div class="content">
	<div class="header">
		<i class="fa fa-bar-chart"></i>
		<span class="title">Estoque de Produtos</span>
		<span class="subtitle">Listagem de quantidade de produtos no estoque do sistema</span>				
	</div>
	<div class="box">
		<div class="row">
			<div class="col s12">
				<table class="striped bordered">
					<thead>
						<tr>
							<td>Produto</td>
							<td width="450" style="text-align: center">Quantidade Disponivel</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="i" items="<%=estoqueGeral%>">
							<tr>
								<td>${i.produto.nome}</td>
								<td style="text-align: center">${i.quantidadeComprada - i.quantidadeVendida > 0 ? i.quantidadeComprada - i.quantidadeVendida : 0}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>
<%@ include file="../includes/footer.jsp" %>