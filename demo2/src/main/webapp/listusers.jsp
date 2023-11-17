<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="org.easy.sumanth.entity.Detail"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>list users</title>
</head>
<body>
<jsp:include page="include/header.jsp"></jsp:include>

<h1>List Users</h1>
<table border="3">
<tr>
<th>User_Id</th>
<th>User_Name</th>
<th>Email_Id</th>
<th>Modification</th>
</tr>
<%

List<Detail> m=new ArrayList<Detail>();
m=(List)request.getAttribute("listUser");
for(Detail q:m)
{
	out.print("<tr>");
	out.print("<td>");
	out.print(q.getUser_id());
	out.print("</td>");
	out.print("<td>");
	out.print(q.getUser_name());
	out.print("</td>");
	out.print("<td>");
	out.print(q.getEmail_id());
	out.print("</td>");
	out.print("<td>");
	out.print("<a href="+request.getContextPath()+"/Site?page=UpdateUser&user_id="+q.getUser_id()+"&username="+q.getUser_name()+"&emailid="+q.getEmail_id()+">update</a>");
	out.print("|");
	out.print("<a href="+request.getContextPath()+"/Site?page=DeleteUser&user_id="+q.getUser_id()+">delete</a>");
	out.print("<td>");
	out.print("<tr>");
}
%>
</table>

<jsp:include page="include/footer.jsp"></jsp:include>
</body>
</html>