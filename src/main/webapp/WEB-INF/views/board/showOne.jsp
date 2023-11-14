<%@ page contentType="text/html; charset=UTF-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>${board.id}번 게시글</title>
    <meta charset="UTF-8">
</head>
<body>
<h3>제목 : ${board.title} <br/><br/></h3>
작성자 : ${board.nickname} <br/><br/>
작성시간 : ${board.entryDate} <br/><br/>
수정시간 : ${board.modifyDate} <br/><br/>
내용 : ${board.content} <br/> <br/><br/>

<h3>댓글 창</h3>


<c:forEach var="comment" items="${comments}">
    <p>댓글 내용 : ${comment.content}</p>
    <p>닉네임: ${comment.nickname}</p>
    <p>작성시간: ${comment.entryDate}</p>
    <hr/>
</c:forEach>
<form action="/board/addComment/${board.id}" method="post">
    <textarea name="commentContent" rows="4" cols="50"></textarea><br/>
    <input type="submit" value="댓글 작성">
</form>
<br/><br/>
<c:if test="${board.writerId eq logIn.id}">
    <a href="/board/update/${board.id}">수정하기</a>
    <a href="/board/delete/${board.id}">삭제하기</a> <br/>
</c:if>
<br/>
<a href="/board/showAll">글 목록으로</a>
</body>
</html>
