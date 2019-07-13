<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${user != null}">
    <%--    <%= user.password %>--%>
    <c:out value="${user.getName()}"/>
    <c:out value="${user.name}"/>
</c:if>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>ユーザー登録</title>
</head>
<body>
<h1>ユーザー登録</h1>
<form action="/users/new" method="post">
    <label>名前:</label><br>
    <input type="text" name="name"><br>

    <label>メールアドレス:</label><br>
    <input type="email" name="email"><br>

    <label>パスワード</label><br>
    <input type="password" name="password"><br>

    <input type="submit" value="送信">
</form>
</body>
</html>
