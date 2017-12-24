<%--
  Created by IntelliJ IDEA.
  User: pjoshi1
  Date: 11/23/2017
  Time: 3:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="common/header.jspf"%>

<h3>Login</h3>
<form:form method="POST" action="/login" modelAttribute="userInformation">
            <form:label path="email">Name</form:label>
            <form:input path="email"/>
            <form:label path="password">Id</form:label>
            <form:input path="password"/>
            <input type="submit" value="Submit"/>
</form:form>

<%@ include file="common/footer.jspf"%>

