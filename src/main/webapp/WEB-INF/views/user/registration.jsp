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
<form:form method="POST" modelAttribute="userForm" class="form-signin">
    <h2 class="form-signin-heading">Create your account</h2>
    <spring:bind path="userName">
        <div class="form-group ${status.error ? 'has-error' : ''}">
            <form:input type="text" path="userName" class="form-control" placeholder="Username"
                        autofocus="true"></form:input>
            <form:errors path="userName"></form:errors>
        </div>
    </spring:bind>
    <spring:bind path="password">
        <div class="form-group ${status.error ? 'has-error' : ''}">
            <form:input type="password" path="password" class="form-control" placeholder="Password"></form:input>
            <form:errors path="password"></form:errors>
        </div>
    </spring:bind>
    <spring:bind path="passwordConfirm">
        <div class="form-group ${status.error ? 'has-error' : ''}">
            <form:input type="password" path="passwordConfirm" class="form-control"
                        placeholder="Confirm your password"></form:input>
            <form:errors path="passwordConfirm"></form:errors>
        </div>
    </spring:bind>
    <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
</form:form>
<%@ include file="../footer.jsp" %> 