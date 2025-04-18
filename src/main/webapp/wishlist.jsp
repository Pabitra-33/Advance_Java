<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Wish List Page</title>
</head>
<body>
   <% String user = request.getParameter("username"); %>
   <h1>Welcome <%= user %></h1>
</body>
</html>