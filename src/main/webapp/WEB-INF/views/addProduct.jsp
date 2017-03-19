<%@ include file="header.jsp" %>
<center>
 <h3>Welcome, Enter The Employee Details</h3>
        <form:form method="POST" action="/products/add" modelAttribute="product">
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
                    <td><input type="submit" value="Submit"/></td>
                </tr>
            </table>
        </form:form>
</center>
<%@ include file="footer.jsp" %>