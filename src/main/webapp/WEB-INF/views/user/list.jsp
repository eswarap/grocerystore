<%@ include file="../header.jsp" %>
<c:url var="editUrl" value="/user/edit"/>
<c:url var="deleteUrl" value="/user/delete"/>
<c:url var="deleteImg" value="/resources/delete.jpg" />

<div class="bs-component">
    <table class="table table-striped table-hover ">
        <thead>
        <tr>
            <th>User name</th>
            <th>Role</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${users}" var="user">
            <tr>
                <td><a href="${editUrl}/${user.userId}"/>${user.userName}</a></td>
                <c:forEach items="${roles}" var="role" varStatus="status">
                     <c:out value="${role.roleName}" />
                    <c:if test="${!status.last}">,</c:if>
                </c:forEach>
                <td >
                    <form id="deleteUser" action="${deleteUrl}" method="POST">
                        <input id="userId" name="userId" type="hidden" value="${user.userId}"/>
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