<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="model.Preco"%>

<jsp:useBean id="controlPreco" class="control.PrecoController" />
<jsp:useBean id="controlUsuario" class="control.UsuarioController" />
<jsp:useBean id="controlProduto" class="control.ProdutoController" />

<%@ include file="../includes/header.jsp"%>

<div class="content">
	<%	
		DateFormat fmtData = new SimpleDateFormat("dd/MM/yyyy");
		String dataInicio = request.getParameter("data-inicio");
		String dataFinal = request.getParameter("data-final");
	
		Preco preco = new Preco();		
		preco.setDataInicio(new Date(fmtData.parse(dataInicio).getTime()));
		
		if(dataFinal != null && dataFinal != ""){
			preco.setDataFinal(new Date(fmtData.parse(dataFinal).getTime()));			
		}
		
		preco.setValor(Float.parseFloat(request.getParameter("valor")));
		preco.setProduto(controlProduto.buscarPorId(Long.parseLong(request.getParameter("produto"))));
		preco.setDataCadastro(new Date());
		preco.setUsuario(controlUsuario.buscarPorId(3L));	
		if (controlPreco.persistir(preco)) { 
	%>

	<div class="header">
		<i class="fa fa-check-circle"></i> <span class="title">Valor Cadastrado com sucesso!</span>
	</div>
	
	<%
		}else{
	%>
	
	<div class="header">
		<i class="fa fa-ban"></i> <span class="title">Erro ao cadastrar valor</span>
	</div>
	
	<%
		} 
	%>
	
</div>

<%@ include file="../includes/footer.jsp"%>