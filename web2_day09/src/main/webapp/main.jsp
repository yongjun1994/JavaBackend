<%@ page contentType="text/html;charset=UTF-8" %>
<%
  String userName = (String) request.getAttribute("userName");
%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>메인 페이지</title>
</head>
<body>
<% if (userName != null) { %>
  <h2><%= userName %>님, 환영합니다!</h2>
<% } else { %>
  <h2>로그인이 필요합니다.</h2>
<% } %>
</body>
</html>