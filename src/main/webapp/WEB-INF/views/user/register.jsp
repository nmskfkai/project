<%@ page contentType="text/html; charset=UTF-8" %>
<html lang="en">
<head>

    <title>회원가입</title>
</head>
<body>
<form action="/user/register" method="post">
    회원 아이디 : <input type="text" name="username">
    회원 비밀번호 : <input type="password" name="password">
    회원 닉네임 : <input type="text" name="nickname">
    회원 이메일 : <input type="text" name="email">
    <button type="submit">회원 가입</button>
</form>
</body>
</html>