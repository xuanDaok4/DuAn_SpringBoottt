<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href=" https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">

</head>
<body  class="container">
<form action="/hien-thi/cua-hang/update" method="post">
    Id: <input type="text" name="id" value="${cuaHang.id}" readonly>
    <br>
    Ma: <input type="text" name="ma" value="${cuaHang.ma}">
    <br>
    Ten: <input type="text" name="ten" value="${cuaHang.ten}">
    <br>
    DiaChi: <input type="text" name="diaChi" value="${cuaHang.diaChi}">
    <br>
    ThanhPho: <input type="text" name="thanhPho" value="${cuaHang.thanhPho}">
    <br>
    QUocGia: <input type="text" name="quocGia" value="${cuaHang.quocGia}">
    <br>
    <button type="submit">Update</button>
</form>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</html>