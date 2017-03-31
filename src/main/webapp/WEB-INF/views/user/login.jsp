<%@ include file="../header.jsp" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<form method="POST" action="${contextPath}/user/login" class="form-signin">
    <h2 class="form-heading">Log in</h2>

    <div class="form-group ${error != null ? 'has-error' : ''}">
        <span>${message}</span>
        <input name="username" type="text" class="form-control" placeholder="Username"
               autofocus="true"/>
        <input name="password" type="password" class="form-control" placeholder="Password"/>
        <span>${error}</span>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

        <button class="btn btn-lg btn-primary btn-block" type="submit">Log In</button>
        <h4 class="text-center"><a href="${contextPath}/user/registration">Create an account</a></h4>
    </div>
</form>
<%@ include file="../footer.jsp" %>
