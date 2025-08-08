<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>회원가입</title>
  <link rel="stylesheet" href="join.css">
</head>
<body>
  <div class="container">
    <h2>회원가입</h2>
    
    <%
    	String error = (String) request.getAttribute("error");
    	if(error != null) {
    %>
    <p style="color:red;"><%= error %></p>
    <%
    	}
    %>
    <form action="join" method="post">
      아이디 : <input type="text" name="userId" placeholder="아이디" required>
      비밀번호 : <input type="password" name="userPw" placeholder="비밀번호" required>
      이름 : <input type="text" name="userName" placeholder="이름" required>
      이메일 : <input type="email" name="userEmail" placeholder="이메일" required>
      <button type="submit">가입하기</button>
    </form>
  </div>
</body>
</html>
