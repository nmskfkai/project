<%@ page contentType="text/html; charset=UTF-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>게시판</title>
    <meta charset="UTF-8">
    <style>
        body {
            text-align: center;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        th, td {
            padding: 5px;
            text-align: center;
        }

        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
<h1>게시판</h1>

<table border="1">
    <tr>
        <th>글번호</th>
        <th>제목</th>
        <th>회원번호</th>
        <th>작성일</th>
        <th>수정일</th>
    </tr>
    <c:forEach items="${list}" var="board">
        <tr>
            <td>${board.id}</td>
            <td><a href="/board/showOne/${board.id}">${board.title}</a></td>
            <td>${board.writerId}</td>
            <td>${board.entryDate}</td>
            <td>${board.modifyDate}</td>
        </tr>
    </c:forEach>
</table>

<br/><br/><br/><br/>
<a href="/board/write" style="font-size: 25px;">글 쓰기</a>

</body>
</html>
