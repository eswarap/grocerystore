<%@ include file="../header.jsp" %>
<c:url var="editUrl" value="/categories/edit"/>
<center>
    <h2>Store categories</h2>
    <div>
    <table border="1">
        <tr>
            <th>Category</th>
            <th>Description</th>         
        </tr>
        <c:forEach items="${categories}" var="category">
            <tr>
                <td><a href="${editUrl}/${category.categoryId}"/>${category.categoryName}</a></td>
                <td>${category.description}</td>
            </tr>
        </c:forEach>
    </table>
    </div>
</center>
<%@ include file="../footer.jsp" %>