<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="UTF-8">
  <title>利用者情報の入力</title>
</head>
<body>
  <h1>利用者情報の入力</h1>
  
  <p>利用者情報を入力してください</p>
      <%--  postメソッドを利用  --%>
  <form action="/confirm" method="post">



    <label for="title">名前:</label>
    <input type="text" name="name"><br>

    <label for="title">利用者ID:</label>
    <input type="text" name="id"><br>

    <button type="submit">送信</button>
  </form>


</body>
</html>
