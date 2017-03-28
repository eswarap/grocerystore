<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
  <head><title>Hello :: Spring Application</title>
  <meta http-equiv="Content-Type"  content="text/html; charset=UTF-8" />
  <link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet" >
  <link href="https://maxcdn.bootstrapcdn.com/bootswatch/3.3.7/paper/bootstrap.min.css" rel="stylesheet" >
  </head>
  <body> 
  <div class="jumbotron">
      <%@ include file="menu.jsp" %>
    </div>