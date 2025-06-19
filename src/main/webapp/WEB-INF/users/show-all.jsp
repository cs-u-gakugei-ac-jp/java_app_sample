<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="UTF-8">
  <title>showAllUsers</title>
</head>
<body>
  <h1>こちらは，show-all.jspです</h1>

  <p>データベースで全てのページを表示します</p>

  ${ users.get(0).getName() }<br>
  ${ users.get(0).getId() }<br>




</body>
</html>
