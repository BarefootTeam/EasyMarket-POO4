<%@ include file="../includes/header.jsp" %>
<div class="content">
	<div class="header">
		<i class="fa fa-users"></i>
		<span class="title">Cadastro de usuário</span>
	</div>
	<div class="box">
		<div class="row">
			<div class="col s12">
				<form method="POST" action="submit.jsp">
					<div class="input-field col s10">
						<input type="text" id="nome" name="nome" required />
						<label for="nome">Nome</label>
					</div>
					<div class="input-field col s2">
						<input type="text" id="cpf" name="cpf" class="cpf" required />
						<label for="cpf">Cpf</label>
					</div>
					<div class="input-field col s4">
						<input type="text" id="login" name="login" required />
						<label for="login">Login</label>
					</div>
					<div class="input-field col s4">
						<input type="password" id="senha" name="senha" required />
						<label for="senha">Senha</label>
					</div>
					<div class="input-field col s4">
						<select id="tipo" name="tipo" required>
							<option value="">Selecione</option>
							<option value="1">Administrador</option>
							<option value="2">Funcionário</option>
						</select>
						<label for="tipo">Tipo</label>
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