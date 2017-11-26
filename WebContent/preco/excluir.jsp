<%@page import="model.Preco"%>
<%@ include file="../includes/header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:useBean id="controlPreco" class="control.PrecoController" />

<div class="content">
	<%
		Preco preco = controlPreco.buscarPorId(Long.parseLong(request.getParameter("id")));
		if(request.getMethod().equals("POST")) {
			if(controlPreco.deletar(preco)) {
	%>
	<div class="header">
		<i class="fa fa-check-circle"></i>
		<span class="title">Preço excluido com sucesso!</span>
	</div>
	<%
			} else {
	%>
	<div class="header">
		<i class="fa fa-ban"></i>
		<span class="title">Erro ao excluir o preço do Produto</span>
	</div>
	<%
			}
		} else {
	%>
	<div class="box">
		<div class="row">
			<form method="POST" class="col s9">
				<h4 class="header">Deseja mesmo excluir o preço do produto : <%=preco.getProduto().getNome()%> ? </h4>
				<div class="col s3 right">
					<button type="submit" class="btn waves-effect waves-light right">Sim</button>
					<button type="reset" class="btn waves-effect waves-light">Não</button>
				</div>
			</form>
		</div>
	</div>
	<%
		}
	%>
</div>
<%@ include file="../includes/footer.jsp" %>