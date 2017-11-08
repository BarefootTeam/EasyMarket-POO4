<%@page import="model.Usuario"%>
<jsp:useBean id="controlUsuario" class="control.UsuarioController" />

<%@ include file="../includes/header.jsp" %>

<div class="content">
	<%
		Usuario usuario = controlUsuario.buscarPorId(Long.parseLong(request.getParameter("id")));
		if(request.getMethod().equals("POST")) {
			if(controlUsuario.deletar(usuario)) {
	%>
	<div class="header">
		<i class="fa fa-check-circle"></i>
		<span class="title">Usuário excluido com sucesso!</span>
	</div>
	<%
			} else {
	%>
	<div class="header">
		<i class="fa fa-ban"></i>
		<span class="title">Erro ao excluir usuário</span>
	</div>
	<%
			}
		} else {
	%>
	<div class="box">
		<div class="row">
			<form method="POST" class="col s7">
				<h4 class="header">Deseja mesmo excluir este usuário?</h4>
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
<%@ include file="../includes/footer.jsp" %>