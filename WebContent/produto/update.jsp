<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.BufferedInputStream"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.util.Date"%>
<%@page import="model.Produto"%>
<%@page import="java.io.File"%>
<%@page import="org.apache.tomcat.util.http.fileupload.FileItem"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload"%>

<jsp:useBean id="controlProduto" class="control.ProdutoController" />
<jsp:useBean id="controlUsuario" class="control.UsuarioController" />

<%@ include file="../includes/header.jsp" %>

<div class="content">
	<%
	
		request.setCharacterEncoding("UTF-8");
	
		ServletFileUpload upload = new ServletFileUpload(new DiskFileItemFactory());
		Map<String, List<FileItem>> parameters = upload.parseParameterMap(request);
		
		String path = application.getRealPath("/");
		File dir = new File(path, "public/uploads");
		if(!dir.exists()) dir.mkdir();
		
		Long id = Long.parseLong(parameters.get("id").get(0).getString());
		Produto produto = controlProduto.buscarPorId(id);
		produto.setNome(parameters.get("nome").get(0).getString());
		produto.setCodigo(parameters.get("codigo").get(0).getString());
		produto.setDescricao(parameters.get("descricao").get(0).getString());
		
		FileItem imagem = parameters.get("imagem").get(0);
		
		if(imagem.getSize() > 0) {
			
			String filename = imagem.getName();
			File file = new File(dir, filename);
			
			InputStream is = imagem.getInputStream();
			
			BufferedInputStream input = new BufferedInputStream(is);
			OutputStream output = new FileOutputStream(file);
			
			byte[] buffer = new byte[1024];
			int bufferLength = 0;
			
			while((bufferLength = is.read(buffer)) > 0) {
				output.write(buffer, 0, bufferLength);
			}
			
			output.flush();
			output.close();
			input.close();
			
			produto.setImagem(filename);

		}
		
		if(controlProduto.persistir(produto)) {
	%>
	
	<div class="header">
		<i class="fa fa-check-circle"></i>
		<span class="title">Produto atualizado com sucesso!</span>
	</div>
	
	<%
		} else {
	%>
	<div class="header">
		<i class="fa fa-ban"></i>
		<span class="title">Erro ao atualizar produto</span>
	</div>
	<%
		}
	%>
</div>

<%@ include file="../includes/footer.jsp" %>