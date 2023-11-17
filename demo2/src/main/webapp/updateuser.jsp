<jsp:include page="include/header.jsp"></jsp:include>

<h1>ADD USERS</h1>
<form action="<%=request.getContextPath()%>/Site" method="post">
User name: <input type="text" name="user_name" value="${param.username}" required="required"><br/>
Email    : <input type="email" name="email_id" value="${param.emailid}" required="required"><br/>
<input type="hidden" name="form" value="updateUseroperation">
<input type="hidden" name="userid" value="${param.user_id}">
<input type="submit" value="update user">
</form>

<jsp:include page="include/footer.jsp"></jsp:include>