<%@ page contentType="text/html; charset=UTF-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>글 쓰기</title>
    <meta charset="UTF-8">

</head>
<body>
    <form action="/board/write" method="post">
        제목 : <input type="text" name="title"> <br/>
        내용 : <textarea name="content"></textarea> <br/>
        <button type="submit">작성하기</button>

    </form>
    <br/>
    <a href="/board/showAll">목록</a>
</body>
</html>