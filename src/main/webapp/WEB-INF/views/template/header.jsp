<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html>
<html>

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<script src="../../../resources/vendor/jquery/jquery.min.js"></script>


<title>관리자 페이지</title>

<!-- Custom fonts for this template-->
<link href="../../../resources/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">

<!-- Page level plugin CSS-->
<link href="../../../resources/vendor/datatables/dataTables.bootstrap4.css"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="../../../resources/css/sb-admin.css" rel="stylesheet">
<style>
#category_list ul{

color:white;
display:none;  /* 평상시에는 서브메뉴가 안보이게 하기 */
list-style-type:none;
text-decoration:none;
}
#category_list ul>li>a{
text-decoration:none;
color:white;
}
#category_list:hover ul{
display:block;
}


</style>
</head>

<body id="page-top">

	<!-- 상단의 bar -->
	<nav class="navbar navbar-dark bg-dark static-top">
		<a class="navbar-brand mr-1" href="/">관리자 페이지</a>
		<div>
			<form class="form-inline" action="/customLogout" method="post">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			<button type="submit" class="btn btn-primary float-right" >Logout</button>
			</form>
		</div>
	</nav>
	
	<div id="wrapper">

	<!-- Sidebar -->
	<ul class="sidebar navbar-nav">
		<li class="nav-item"><a class="nav-link" href="/"> <i
				class="fas fa-fw fa-tachometer-alt"></i> <span>메인 페이지</span>
		</a></li>
		<!-- 카테고리 관리 -->
		<li class="nav-item dropdown" id="category_list">
		<a class="nav-link dropdown-toggle"	href="/category/listAll" id="pagesDropdown" role="button" aria-haspopup="true" aria-expanded="false"> <i
				class="fas fa-fw fa-folder"></i> <span>카테고리 관리</span>
		</a>
			<!-- <ul style="color:white;">
				<li><a href="/category/auto_classify">자동분류</a></li>
				<li><a href="/category/listAll">수동분류</a></li>
				<li><a>유적지삭제</a></li>
			</ul>
			 -->
		</li>

		<!-- 에디터 추천코스  관리 -->
		<li class="nav-item dropdown">
		<a class="nav-link dropdown-toggle" href="/editor/listAll" id="pagesDropdown" role="button"  aria-haspopup="true" aria-expanded="false"> 
			<i class="fas fa-fw fa-folder"></i> <span>에디터 추천코스</span>
		</a>
			</li>
			
				<!-- 공지사항  관리 -->
		<li class="nav-item dropdown">
		<a class="nav-link dropdown-toggle" href="/notice/list" id="pagesDropdown" role="button"  aria-haspopup="true" aria-expanded="false"> 
			<i class="fas fa-fw fa-folder"></i> <span>공지사항 관리</span>
		</a>
			</li>
		
						
		<li class="nav-item dropdown" id="category_list">
		<a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button"  aria-haspopup="true" aria-expanded="false"> 
			<i class="fas fa-fw fa-folder"></i> <span>댓글 관리</span>
		</a>
			<ul>
				<li><a href="/reply/historic_list">유적지</a></li>
				<li><a href="/reply/editor_list">에디터 추천코스</a></li>
			</ul>
		</li>		
	</ul>