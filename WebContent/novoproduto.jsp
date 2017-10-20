<%@ include file="includes/header.jsp" %>
<div class="content">
	<div class="header">
		<i class="fa fa-bar-chart"></i>
		<span class="title">Cadastro Produto</span>
	</div>
	<div class="box">
		<div class="row">
			<div class="col s12">
				<form method="POST" action="submitproduto.jsp" enctype="multipart/form-data">
					<div class="input-field col s12">
						<input type="text" id="nome" name="nome" />
						<label for="nome">Nome</label>
					</div>
					<div class="file-field input-field col s8">
						<div class="btn">
							<span>Imagem</span>
							<input type="file" name="imagem" />
						</div>
						<div class="file-path-wrapper">
							<input class="file-path" type="text" placeholder="Insira aqui uma imagem do produto" />
						</div>
					</div>
					<div class="input-field col s4">
						<input type="text" id="codigo" name="codigo" />
						<label for="codigo">Código</label>
					</div>
					<div class="input-field col s12">
						<textarea id="descricao" name="descricao" class="materialize-textarea"></textarea>
						<label for="descricao">Descrição</label>
					</div>
					<div class="col s12">
						<input type="submit" class="waves-effect waves-light btn right" value="Cadastrar" />
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
<%@ include file="includes/footer.jsp" %>