<%@ include file="header.jsp" %>
<center>
<div id="productForm" >	
				<form:form modelAttribute="productModel" action="product" method="POST">
					<table id="productTable">
						<tr>
							<td><form:label	for="name" path="name" cssErrorClass="error">Name</form:label></td>
							<td><form:input path="name" /></td>
							<td><form:errors path="name" /></td>
						</tr>
						<tr>	
							<td><form:label for="description" path="description" cssErrorClass="error">Description</form:label></td>
							<td><form:input path="description" /></td>
							<td><form:errors path="description" /></td>
						</tr>
						<tr>	
							<td><form:label for="company" path="company" cssErrorClass="error">Company</form:label></td>
							<td><form:input path="company" /></td>
							<td><form:errors path="company" /></td>
						</tr>
						<tr>
							<td>
								<p>	
									<form:hidden path="id" id="id" />
									<input id="save" type="submit" value="Save" />
								</p>
							</td>
							<td></td>
							<td></td>
						</tr>
						</table>
				</form:form>
			</div>
			
</center>
<%@ include file="footer.jsp" %>