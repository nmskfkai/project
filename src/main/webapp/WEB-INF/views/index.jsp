<%@ page contentType="text/html; charset=UTF-8" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Hello World!</title>
</head>
<body>

    <form action="/user/auth" method="post">
        ID: <input type="text" name="username">
        PW: <input type="password" name="password">
        <button type="submit">로그인</button>
    </form>
    <br/>
<a href="/user/register">회원 가입</a>
</body>
</html>