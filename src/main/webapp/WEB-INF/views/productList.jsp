<%@ include file="header.jsp" %>
<center>
    <h2>Store products</h2>
    <div>
        <form:form method="POST" action="add" modelAttribute="product">
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
    </div>
    <div>
    <table border="1">
        <tr>
            <th>Product</th>
            <th>Description</th>
            <th>Category Name</th>
            <th>Category description</th>            
        </tr>
        <c:forEach items="${products}" var="product">
            <tr>
                <td><a href="">${product.productName}</td>
                <td>${product.description}</td>
                <td>${product.category.categoryName}</td>
                <td>${product.category.description}</td>
                <td><a href="<c:url value='/edit/${product.productId}' />" >Edit</a></td>
            </tr>
        </c:forEach>
    </table>
    </div>
</center>
<%@ include file="footer.jsp" %>