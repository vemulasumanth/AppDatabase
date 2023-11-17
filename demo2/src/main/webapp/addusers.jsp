
<jsp:include page="include/header.jsp"></jsp:include>

<h1>ADD USERS</h1>
<form action="<%=request.getContextPath()%>/Site" method="post">
User name: <input type="text" name="username" required="required"><br/>
Email    : <input type="email" name="emailid" required="required"><br/>
<input type="hidden" name="form" value="addUseroperation">
<input type="submit" value="adduser">
</form>

<jsp:include page="include/footer.jsp"></jsp:include>
