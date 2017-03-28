<%@ include file="../header.jsp" %>
<c:url var="editUrl" value="/products/edit"/>
<c:url var="deleteUrl" value="/products/delete"/>
<c:url var="deleteImg" value="/resources/delete.jpg" />

    <h2>Store products</h2>
    <div>
    <table class="table table-striped table-hover ">
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
                <td >
                    <form id="deleteProduct" action="${deleteUrl}" method="POST">
                        <input id="productId" name="productId" type="hidden" value="${product.productId}"/>
                        <input class="delete" type="image" src="${deleteImg}"" value="delete" onClick="return confirm('sure?')"/>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
    </div>
<%@ include file="../footer.jsp" %>