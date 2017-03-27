<%@ include file="../header.jsp" %>
<c:url var="editUrl" value="/categories/edit"/>
<c:url var="deleteUrl" value="/resources/delete.jpg" />
<center>
    <h2>Store categories</h2>
    <div>
    <table border="1">
        <tr>
            <th>Category</th>
            <th>Description</th>     
            <th>Action</th>
        </tr>
        <c:forEach items="${categories}" var="category">
            <tr>
                <td><a href="${editUrl}/${category.categoryId}"/>${category.categoryName}</a></td>
                <td>${category.description}</td>
                <td><div class="portrait"><img style="max-width:100%;height:auto;" src="${deleteUrl}"/></div></td>
            </tr>
        </c:forEach>
    </table>
    </div>
</center>
<%@ include file="../footer.jsp" %>