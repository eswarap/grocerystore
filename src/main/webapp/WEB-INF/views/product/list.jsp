<%@ include file="../header.jsp" %>
<c:url var="editUrl" value="/products/edit"/>
<c:url var="deleteUrl" value="/products/delete"/>
<c:url var="deleteImg" value="/resources/delete.jpg" />

<div class="bs-component">
    <table class="table table-striped table-hover ">
        <thead>
        <tr>
            <th>Product</th>
            <th>Description</th>
            <th>Category Name</th>
            <th>Category description</th>     
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
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
        <div class="pagination">
            <c:forEach begin="${startpage}" end="${endpage}" var="p">
                <a href="<c:url value="/products/list" >
                    <c:param name="page" value="${p}"/>${p}</c:url>">${p}
                </a>
            </c:forEach>
        </div>
        </tbody>
    </table>
</div>
<%@ include file="../footer.jsp" %>