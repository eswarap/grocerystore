<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<c:url var="addUrl" value="/categories/add"/>
<center>
 <h3>Welcome, Enter The category Details</h3>
        <form:form cssClass="form-horizontal" method="POST" action="${addUrl}" modelAttribute="category">
             <table>
                <tr>
                    <td><form:label path="categoryName">category Name</form:label></td>
                    <td><form:input path="categoryName"/></td>
                </tr>
                <tr>
                    <td><form:label path="description">Description</form:label></td>
                    <td><form:input path="description"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Submit"/></td>
                </tr>
            </table>
        </form:form>
</center>
<%@ include file="../footer.jsp" %>