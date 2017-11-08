<%@page import="model.Usuario"%>
<%@ include file="../includes/header.jsp" %>

<<jsp:useBean id="controlUsuario" class="control.UsuarioController" />

<%
	Usuario usuario = controlUsuario.buscarPorId(Long.parseLong(request.getParameter("id")));
%>

<div class="content">
	<div class="header">
		<i class="fa fa-users"></i>
		<span class="title">Editar usuário</span>
	</div>
	<div class="box">
		<div class="row">
			<div class="col s12">
				<form method="POST" action="update.jsp">
					
					<input type="hidden" name="id" value="<%=usuario.getId()%>" />
				
					<div class="input-field col s10">
						<input type="text" id="nome" name="nome" value="<%=usuario.getNome()%>" required />
						<label for="nome">Nome</label>
					</div>
					<div class="input-field col s2">
						<input type="text" id="cpf" name="cpf" class="cpf" value="<%=usuario.getCpf()%>" required />
						<label for="cpf">Cpf</label>
					</div>
					<div class="input-field col s4">
						<input type="text" id="login" name="login" value="<%=usuario.getLogin()%>" required />
						<label for="login">Login</label>
					</div>
					<div class="input-field col s4">
						<input type="password" id="senha" name="senha" value="<%=usuario.getSenha()%>" required />
						<label for="senha">Senha</label>
					</div>
					<div class="input-field col s4">
						<select id="tipo" name="tipo" required>
							<option value="">Selecione</option>
							<option value="1" <% if(usuario.getTipo() == 1) { out.print("selected"); } %> >Administrador</option>
							<option value="2" <% if(usuario.getTipo() == 2) { out.print("selected"); } %> >Funcionário</option>
						</select>
						<label for="tipo">Tipo</label>
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