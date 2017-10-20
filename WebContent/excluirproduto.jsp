<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@page import="model.Produto"%>
<%@ include file="includes/header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:useBean id="controlProduto" class="control.ProdutoController" />

<div class="content">
	<%
		Produto produto = controlProduto.buscarPorId(Long.parseLong(request.getParameter("id")));
		if(request.getMethod().equals("POST")) {
			if(controlProduto.deletar(produto)) {
	%>
	<div class="header">
		<i class="fa fa-check-circle"></i>
		<span class="title">Produto excluido com sucesso!</span>
	</div>
	<%
			} else {
	%>
	<div class="header">
		<i class="fa fa-ban"></i>
		<span class="title">Erro ao excluir produto</span>
	</div>
	<%
			}
		} else {
	%>
	<div class="box">
		<div class="row">
			<form method="POST" class="col s7">
				<h4 class="header">Deseja mesmo excluir este produto?</h4>
				<div class="col s5 right">
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
<%@ include file="includes/footer.jsp" %>