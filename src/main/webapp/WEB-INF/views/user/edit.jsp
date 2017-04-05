<%@ include file="../header.jsp" %>
<c:url var="updateUrl" value="/user/update"/>
   <div id="userForm" >	
		 <form:form  cssClass="form-horizontal" method="POST" action="${updateUrl}" modelAttribute="user">
		     <form:hidden path="userId"/>
             <table>
                <tr>
                    <td><form:label path="userName">User Name</form:label></td>
                    <td><form:input path="userName"/></td>
                </tr>
                <tr>
                    <td>Role:</td>
                    <td><form:select multiple="true" path="role.roleId">
                            <form:options  items="${roleList}" itemValue="roleId" itemLabel="roleName"/>
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