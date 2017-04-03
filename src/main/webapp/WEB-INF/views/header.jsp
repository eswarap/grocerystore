<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
  <head><title>Neighbourhood store</title>
  <meta http-equiv="Content-Type"  content="text/html; charset=UTF-8" />
   <link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet" >
  </head>
  <body> 
  <div class="container">
  <header>
   <h1>Neighbourhood Store</h1>
</header>
<c:url value="/j_spring_security_logout" var="logoutUrl" />

	<!-- csrt for log out-->
	<form action="${logoutUrl}" method="post" id="logoutForm">
	  <input type="hidden"
		name="${_csrf.parameterName}"
		value="${_csrf.token}" />
	</form>
     <%@ include file="menu.jsp" %>
