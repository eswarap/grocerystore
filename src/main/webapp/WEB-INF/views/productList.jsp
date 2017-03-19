<%@ include file="header.jsp" %>
<center>
    <h2>Store products</h2>
 
    <table border="1">
        <tr>
            <th>Product</th>
            <th>Description</th>
            <th>Category Name</th>
            <th>Category description</th>            
        </tr>
        <c:forEach items="${products}" var="product">
            <tr>
                <td>${product.productName}</td>
                <td>${product.description}</td>
                <td>${product.category.categoryName}</td>
                <td>${product.category.description}</td>
            </tr>
        </c:forEach>
    </table>
 
</center>
<%@ include file="footer.jsp" %>