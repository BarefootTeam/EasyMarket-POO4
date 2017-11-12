<%@page import="javafx.scene.input.DataFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ include file="../includes/header.jsp" %>

<%@page import="model.Preco"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="controlPreco" class="control.PrecoController" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> <!-- Tag para Formatar Data  -->

<%
	Preco preco = controlPreco.buscarPorId(Long.parseLong(request.getParameter("id")));	
%>

<div class="content">
	<div class="header">
		<i class="fa fa-bar-chart"></i>
		<span class="title">Editar Valor</span>
	</div>
	<div class="box">
		<div class="row">
			<div class="col s12">
				<form method="POST" action="update.jsp">
				
		 		<input type="hidden" name="id" value="<%=preco.getId()%>" /> 
		 		<input type="hidden" id="produto" name="produto" value="<%=preco.getProduto().getId()%>" /> 
		 		
					<div class="input-field col s6">
					<input type="text" name="produto-nome" id="produto-nome" value="<%=preco.getProduto().getNome()%>" readonly="readonly"/>										
						<label for="produto">Produto</label>
					</div>					
					<div class="input-field col s6">
						<input type="text" id="valor" name="valor" value="<%=preco.getValor()%>"/>
						<label for="valor">Valor</label>						
					</div>					
					<div class="input-field col s6">
						<input type="text" id="data-inicio" name="data-inicio" class="datepicker" value='<fmt:formatDate value="<%=preco.getDataInicio()%>"/>'/>
						<label for="data-inicio">Data Inicial</label>
					</div>
					<div class="input-field col s6">
						<input type="text" id="data-final" name="data-final" class="datepicker" value='<fmt:formatDate value="<%=preco.getDataFinal()%>"/>'/>
						<label for="data-final">Data Final</label>
					</div>
					<div class="col s12">
						<input type="submit" class="waves-effect waves-light btn right" value="Salvar" />
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
<%@ include file="../includes/footer.jsp" %>

