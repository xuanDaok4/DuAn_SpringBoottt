<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href=" https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">

</head>
<body  class="container">
<form action="/hien-thi/san-pham/update" method="post">
    Id: <input type="text" name="id" value="${sanPham.id}" readonly>
    <br>
    Ma: <input type="text" name="ma" value="${sanPham.ma}">
    <br>
    Ten: <input type="text" name="ten" value="${sanPham.ten}">
    <br>
    <button type="submit">Update</button>
</form>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</html>