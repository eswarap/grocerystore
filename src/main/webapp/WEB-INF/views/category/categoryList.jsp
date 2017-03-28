<%@ include file="../header.jsp" %>
<c:url var="editUrl" value="/categories/edit"/>
<c:url var="deleteUrl" value="/categories/delete" />
<c:url var="deleteImg" value="/resources/delete.jpg" />
<div class="bs-component">
<table class="table table-striped table-hover ">
    <thead>
    <tr>
        <th>Category</th>
        <th>Description</th>     
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${categories}" var="category">
        <tr>
            <td><a href="${editUrl}/${category.categoryId}"/>${category.categoryName}</a></td>
            <td>${category.description}</td>
            <td >
                <form id="deleteCategory" action="${deleteUrl}" method="POST">
                    <input id="categoryId" name="categoryId" type="hidden" value="${category.categoryId}"/>
                    <input class="delete" type="image" src="${deleteImg}"" value="delete" onClick="return confirm('sure?')"/>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</div>
<%@ include file="../footer.jsp" %>