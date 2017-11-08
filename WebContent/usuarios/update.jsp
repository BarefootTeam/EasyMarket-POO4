<%@page import="java.util.Date"%>
<%@page import="model.Usuario"%>
<jsp:useBean id="controlUsuario" class="control.UsuarioController" />

<%@ include file="../includes/header.jsp" %>

<div class="content">
	<%
		Usuario usuario = controlUsuario.buscarPorId(Long.parseLong(request.getParameter("id")));
		usuario.setNome(request.getParameter("nome"));
		usuario.setCpf(request.getParameter("cpf"));
		usuario.setLogin(request.getParameter("login"));
		usuario.setSenha(request.getParameter("senha"));
		usuario.setTipo(Integer.parseInt(request.getParameter("tipo")));
		usuario.setDataCadastro(new Date());
		
		if(controlUsuario.persistir(usuario)) {
	%>
	
	<div class="header">
		<i class="fa fa-check-circle"></i>
		<span class="title">Usuário atualizado com sucesso!</span>
	</div>
	
	<%
		} else {
	%>
	<div class="header">
		<i class="fa fa-ban"></i>
		<span class="title">Erro ao atualizar usuário</span>
	</div>
	<%
		}
	%>
</div>

<%@ include file="../includes/footer.jsp" %>