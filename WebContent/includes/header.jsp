<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" />
	<title>Easy Market</title>
	<link rel="stylesheet" href="/EasyMarket/public/css/font-awesome.min.css" />
	<link rel="stylesheet" href="/EasyMarket/public/css/materialize.min.css" />
	<link rel="stylesheet" href="/EasyMarket/public/css/app.css" />	
	<link rel="stylesheet" href="/EasyMarket/public/css/custom-pages.css" />
</head>
<body>

	<header>
		<a href="#" class="toggle-menu"><i class="fa fa-ellipsis-h"></i></a>	
		<div class="logo">
			<img src="/EasyMarket/public/images/em-icon.png" />
			<h1>EasyMarket</h1>
		</div>
		<div class="right">
			<a href="#" class="notify">
				<i class="fa fa-bell"></i>
				<span>2</span>
			</a>
			<a href="#" class="user">
				<img src="/EasyMarket/public/images/profile.jpg" />
				<i class="fa fa-angle-down"></i>
			</a>
		</div>
	</header>
	<nav>
		<ul>
			<li>
				<a href="/EasyMarket/produto">
					<i class="fa fa-list"></i>
					<span>Produtos</span>				
				</a>
			</li>
			<li>
				<a href="/EasyMarket/preco">
					<i class="fa fa-money"></i>
					<span>Valores</span>				
				</a>
			</li>
			<li>
				<a href="#">
					<i class="fa fa-shopping-cart"></i>
					<span>Compras</span>
				</a>
			</li>
			<li>
				<a href="#">
					<i class="fa fa-file-text"></i>
					<span>Vendas</span>
				</a>
			</li>
			<li>
				<a href="/EasyMarket/usuarios">
					<i class="fa fa-users"></i>
					<span>Usuários</span>
				</a>
			</li>
			<li>
				<a href="/EasyMarket/relatorio">
					<i class="fa fa-bar-chart"></i>
					<span>Relatórios</span>
				</a>
			</li>
			<li>
				<a href="/EasyMarket/relatorio">
					<i class="fa fa-archive"></i>
					<span>Estoque</span>
				</a>
			</li>		
		</ul>
	</nav>
	<div class="wrapper">