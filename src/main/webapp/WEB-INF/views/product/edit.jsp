<%@ include file="../header.jsp" %>
<c:url var="updateUrl" value="/products/update"/>
   <div id="productForm" >	
		 <form:form  cssClass="form-horizontal" method="POST" action="${updateUrl}" modelAttribute="product">
		     <form:hidden path="productId"/>
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
                    <td><input  class="btn btn-primary" type="submit" value="Submit"/></td>
                </tr>
            </table>
        </form:form>
	</div>			
<%@ include file="../footer.jsp" %>