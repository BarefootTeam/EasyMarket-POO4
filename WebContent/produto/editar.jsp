<%@page import="model.Produto"%>
<%@ include file="../includes/header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:useBean id="controlProduto" class="control.ProdutoController" />

<%
	Produto produto = controlProduto.buscarPorId(Long.parseLong(request.getParameter("id")));
%>

<div class="content">
	<div class="header">
		<i class="fa fa-bar-chart"></i>
		<span class="title">Editar Produto</span>
	</div>
	<div class="box">
		<div class="row">
			<div class="col s12">
				<form method="POST" action="update.jsp" enctype="multipart/form-data">
					
					<input type="hidden" name="id" value="<%=produto.getId()%>" />
				
					<div class="input-field col s12">
						<input type="text" id="nome" name="nome" value="<%=produto.getNome()%>" />
						<label for="nome">Nome</label>
					</div>
					<div class="file-field input-field col s8">
						<div class="btn">
							<span>Imagem</span>
							<input type="file" name="imagem" />
						</div>
						<div class="file-path-wrapper">
							<input class="file-path" type="text" placeholder="Insira aqui uma imagem do produto" value="<%=produto.getImagem()%>" />
						</div>
					</div>
					<div class="input-field col s4">
						<input type="text" id="codigo" name="codigo" value="<%=produto.getCodigo()%>" />
						<label for="codigo">Código</label>
					</div>
					<div class="input-field col s12">
						<textarea id="descricao" name="descricao" class="materialize-textarea"><%=produto.getDescricao()%></textarea>
						<label for="descricao">Descrição</label>
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