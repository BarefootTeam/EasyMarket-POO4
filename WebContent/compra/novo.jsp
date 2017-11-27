<%@ include file="../includes/header.jsp" %>
<%@page import="java.util.List"%>
<%@page import="model.Compra"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="controlCompra" class="control.CompraController" />
<jsp:useBean id="controlProduto" class="control.ProdutoController" />

 <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

<%
	ArrayList<String> add = new ArrayList<String>();
 	request.getSession().setAttribute("li", add);	
	List listaSessão =	 new ArrayList<String>();
	listaSessão      =	(List) session.getAttribute("li");
	request.getSession().setAttribute("li", listaSessão);

 	 if(request.getMethod() == "[POST]"){ 		
 		add.add("é POST Maluco ");
 		listaSessão.add(add);
 		request.getSession().setAttribute("li", listaSessão);
 	}else{
 		add.add("é : " + request.getMethod() + " Doido");	
 		listaSessão.add(add);	
 		request.getSession().setAttribute("li", listaSessão);
 		
 	}
	
%>


<div class="content">
	<div class="header">
		<i class="fa fa-bar-chart"></i>
		<span class="title">Realizar Compra para o Estoque</span>
	</div>	
	<div class="row">		
		<div class="col s6">
			<div class="box">
				<form name="item" method="POST" action="novo.jsp">
					<div class="input-field col s6">
						<select id="produto" name="produto" required>
						<option value="">Selecione o Produto</option>
							<c:forEach var="i" items="${controlProduto.buscarTodos()}">							
								<option value="${i.id}">${i.nome}</option>							
							</c:forEach>	
						</select>											
						<label for="quantidade">Quantidade</label>
					</div>
					<div class="file-field input-field col s6">
						<input type="number" id="quantidade" name="quantidade" />
						<label for="quantidade">Quantidade</label>						
					</div>					
					<div class="col s12">
					<input type="submit" name="action" value="add"/>									
					<a href="#" type="submit" name="action" value="add"><i class="material-icons" style="font-size: 40px;">add_circle</i></a>
					</div>
				</form>
			</div>
		</div>	
	<form name="item" method="POST" action="index.jsp">
			<div class="col s6">
		  		 <div class="box">			
					<table class="striped bordered">
						<thead>
							<tr>
								<td> Lista de Compras </td>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="i" items="${li}">
								<tr>
									<td>${i}</td>
								</tr>
							</c:forEach>
						</tbody>
						<tfoot>
							<tr>
								<td>
									<input type="submit" name="action" value="add"/> Finalizar
								</td>
							</tr>
						</tfoot>
					</table>	
				</div>		
			</div>
		</form>	
	</div>
</div>

<%@ include file="../includes/footer.jsp" %>