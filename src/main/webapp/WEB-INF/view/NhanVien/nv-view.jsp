<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href=" https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">

</head>
<body class="container">
<form action="/hien-thi/nhan-vien/add" method="post">
    Id: <input type="text" name="id" value="">
    <br>
    Ma: <input type="text" name="ma" value="">
    <br>
    Ten: <input type="text" name="ten" value="">
    <br>
    GioiTinh: <input type="radio" name="gioiTinh" value="Nam"> Nam
              <input type="radio" name="gioiTinh" value="Nu"> Nu
    <br>
    DiaChi: <input type="text" name="diaChi" value="">
    <br>
    TrangThai: <input type="radio" name="trangThai" value="1"> Hoat Dong
    <input type="radio" name="trangThai" value="0"> Ngưng Hoat Dong
    <br>
    <button type="submit">Add</button>
</form>
<table class="table">
    <thead>
    <tr>
        <th>STT</th>
        <th>Ma</th>
        <th>Ten</th>
        <th>GioiTinh</th>
        <th>NgaySinh</th>
        <th>DiaChi</th>
        <th>TrangThai</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listNhanVien}" var="i">
        <tr>
            <td>${i.id}</td>
            <td>${i.ma}</td>
            <td>${i.ten}</td>
            <td>${i.gioiTinh}</td>
            <td>${i.ngaySinh}</td>
            <td>${i.diaChi}</td>
<%--            <td>${i.matKhau}</td>--%>
            <td>${i.trangThai}</td>
            <td>
                <a href="/hien-thi/nhan-vien/view-update/${i.id}"><button class="btn btn-primary">Update</button></a>
                <a href="/hien-thi/nhan-vien/delete/${i.id}"><button class="btn btn-danger">Remove</button></a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</html>