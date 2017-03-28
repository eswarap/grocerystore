<%@ include file="../header.jsp" %>
<c:url var="updateUrl" value="/categories/update"/>
<center>
   <div id="categoryForm" class="form-group">	
		 <form:form method="POST" action="${updateUrl}" modelAttribute="category">
		     <form:hidden path="categoryId" />
             <table>
                <tr>
                    <td><form:label path="categoryName">Category Name</form:label></td>
                    <td><form:input path="categoryName"/></td>
                </tr>
                <tr>
                    <td><form:label path="description">Description</form:label></td>
                    <td><form:input path="description"/></td>
                </tr>
                <tr>
                    <td><input class="btn btn-primary" type="submit" value="Submit"/></td>
                </tr>
            </table>
        </form:form>
	</div>			
</center>
<%@ include file="../footer.jsp" %>