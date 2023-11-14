<%@ page contentType="text/html; charset=UTF-8" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>게시글 수정</title>
    <meta charset="UTF-8">
</head>
<body>
<h2>게시글 수정</h2>

<form action="/board/update" method="post">
    <input type="hidden" name="id" value="${board.id}">
    <label for="title">제목:</label>
    <input type="text" id="title" name="title" value="${board.title}" required><br><br>

    <label for="content">내용:</label>
    <textarea id="content" name="content" rows="5" required>${board.content}</textarea><br><br>

    <input type="submit" value="수정">
</form>

<br><br>
<a href="/board/showOne/${board.id}">돌아가기</a>
</body>
</html>
