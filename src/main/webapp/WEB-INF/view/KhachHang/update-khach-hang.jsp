<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href=" https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">

</head>
<body  class="container">
<form action="/hien-thi/khach-hang/update" method="post">
    Id: <input type="text" name="id" value="${khachHang.id}" readonly>
    <br>
    Ma: <input type="text" name="ma" value="${khachHang.ma}">
    <br>
    Ten: <input type="text" name="ten" value="${khachHang.ten}">
    <br>
    tenDem: <input type="text" name="tenDem" value="${khachHang.tenDem}">
    <br>
    Ho: <input type="text" name="ho" value="${khachHang.ho}">
    <br>
    SDT: <input type="number" name="sdt" value="${khachHang.sdt}">
    <br>
    DiaChi: <input type="text" name="diaChi" value="${khachHang.diaChi}">
    <br>
    <button type="submit">Update</button>
</form>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</html>