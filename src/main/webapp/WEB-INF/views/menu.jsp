<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<c:url var="listPUrl" value="/products/getall"/>
<c:url var="enterPUrl" value="/products/enter"/>
<c:url var="listCUrl" value="/categories/getall"/>
<c:url var="enterCUrl" value="/categories/enter"/>

<a href="${listPUrl}">Product List</a><br/>
<a href="${enterPUrl}">Add Product </a><br/>
<a href="${listCUrl}">Category List</a><br/>
<a href="${enterCUrl}">Add Category </a>
