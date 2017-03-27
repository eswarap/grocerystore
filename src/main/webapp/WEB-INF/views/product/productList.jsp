<%@ include file="../header.jsp" %>
<c:url var="editUrl" value="/products/edit"/>
<c:url var="deleteUrl" value="/products/delete"/>
<c:url var="deleteImg" value="/resources/delete.jpg" />
<center>
    <h2>Store products</h2>
    <div>
    <table border="1">
        <tr>
            <th>Product</th>
            <th>Description</th>
            <th>Category Name</th>
            <th>Category description</th>     
            <th>Action</th>
        </tr>
        <c:forEach items="${products}" var="product">
            <tr>
                <td><a href="${editUrl}/${product.productId}"/>${product.productName}</a></td>
                <td>${product.description}</td>
                <td>${product.category.categoryName}</td>
                <td>${product.category.description}</td>
                <td><a href="${deleteUrl}/${product.productId}" class="portrait"><img src="${deleteImg}"/></a></td>
            </tr>
        </c:forEach>
    </table>
    </div>
</center>
<%@ include file="../footer.jsp" %>