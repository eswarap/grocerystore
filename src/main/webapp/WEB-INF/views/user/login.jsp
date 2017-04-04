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
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<form method="POST" action="${contextPath}/login" >
    <h2 class="form-heading">Log in</h2>
    
    <c:if test="${not empty error}">
		<div class="error">${error}</div>
	</c:if>
	<c:if test="${not empty msg}">
		<div class="msg">${msg}</div>
	</c:if>

    <div class="form-group ${error != null ? 'has-error' : ''}">
        <span>${message}</span>
        <input name="userName" type="text" class="form-control" placeholder="Username"
               autofocus="true"/>
        <input name="password" type="password" class="form-control" placeholder="Password"/>
        <span>${error}</span>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

        <button class="btn btn-lg btn-primary btn-block" type="submit">Log In</button>
        <h4 class="text-center"><a href="${contextPath}/user/registration">Create an account</a></h4>
    </div>
</form>
<%@ include file="../footer.jsp" %>
