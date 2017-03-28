<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<c:url var="addUrl" value="/products/add"/>
<center>
 <h3>Welcome, Enter The Product Details</h3>
        <form:form method="POST" action="${addUrl}" modelAttribute="product">
             <table>
                <tr>
                    <td><form:label path="productName">Product Name</form:label></td>
                    <td><form:input path="productName"/></td>
                </tr>
                <tr>
                    <td><form:label path="description">Description</form:label></td>
                    <td><form:input path="description"/></td>
                </tr>
                <tr>
                    <td>Cateogry:</td>
                    <td><form:select path="category.categoryId">
                            <form:options  items="${categoryList}" itemValue="categoryId" itemLabel="categoryName"/>
                        </form:select>
                    </td>
                </tr>
                <tr>
                    <td><input type="submit" value="Submit"/></td>
                </tr>
            </table>
        </form:form>
</center>
<%@ include file="../footer.jsp" %>