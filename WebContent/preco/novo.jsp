<%@ include file="../includes/header.jsp" %>
<%@page import="java.util.List"%>
<%@page import="model.Preco"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="controlPreco" class="control.PrecoController" />
<jsp:useBean id="controlProduto" class="control.ProdutoController" />

<div class="content">
	<div class="header">
		<i class="fa fa-bar-chart"></i>
		<span class="title">Cadastro Valor</span>
	</div>
	<div class="box">
		<div class="row">
			<div class="col s12">
				<form method="POST" action="submit.jsp">
					<div class="input-field col s6">
						<select id="produto" name="produto" required>
						<option value="">Selecione o Produto</option>
							<c:forEach var="i" items="${controlProduto.buscarTodos()}">							
								<option value="${i.id}">${i.nome}</option>							
							</c:forEach>	
						</select>											
						<label for="produto">Produto</label>
					</div>
					<div class="file-field input-field col s6">
						<input type="number" id="valor" name="valor" />
						<label for="valor">Valor</label>						
					</div>
					<div class="input-field col s6">
						<input type="text" id="data-inicio" name="data-inicio" class="datepicker" />
						<label for="data-inicio">Data Inicial</label>
					</div>
					<div class="input-field col s6">
						<input type="text" id="data-final" name="data-final" class="datepicker"/>
						<label for="data-final">Data Final</label>
					</div>
					<div class="col s12">
						<input type="submit" class="waves-effect waves-light btn right" value="Cadastrar" />
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
<%@ include file="../includes/footer.jsp" %>
