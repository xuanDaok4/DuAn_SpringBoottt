<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href=" https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">

</head>
<body  class="container">
<form action="/hien-thi/nhan-vien/update" method="post">
    Id: <input type="text" name="id" value="${nhanVien.id}" readonly>
    <br>
    Ma: <input type="text" name="ma" value="${nhanVien.ma}">
    <br>
    Ten: <input type="text" name="ten" value="${nhanVien.ten}">
    <br>
    GioiTinh: <input type="radio" name="gioiTinh" value="Nam" ${nhanVien.gioiTinh == "Nam" ? "checked" : ""}> Nam
              <input type="radio" name="gioiTinh" value="Nu"${nhanVien.gioiTinh == "Nu" ? "checked" : ""}> Nu
    <br>
    DiaChi: <input type="text" name="diaChi" value="${nhanVien.diaChi}">
    <br>
    TrangThai: <input type="radio" name="trangThai" value="1" ${nhanVien.trangThai == 1 ? "checked" : ""}> Hoat Dong
    <input type="radio" name="trangThai" value="0" ${nhanVien.trangThai == 0 ? "checked" : ""}> Ngưng Hoat Dong
    <br>
    <button type="submit">Update</button>
</form>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</html>