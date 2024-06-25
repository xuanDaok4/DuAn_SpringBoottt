<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href=" https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">

</head>
<body class="container">
<form method="post" action="/hien-thi/hoa-don/add" >
    Id: <input type="text" name="id" value="">
    <br>
    Ma: <input  type="text" name="ma" />
    <br>
    Ma Khach Hang: <select class="form-select" aria-label="Default select example" name="khachHang">
    <option selected></option>
    <c:forEach items="${listKhachHang}" var="i" >
    <option value="${i.id}">${i.ma}</option>
    </c:forEach>
</select>
    <br>
    Ma Nhan Vien: <select class="form-select" aria-label="Default select example" name="nhanVien">
    <option selected></option>
    <c:forEach items="${listNhanVien}" var="i" >
        <option value="${i.id}">${i.ma}</option>
    </c:forEach>
</select>
    <br>
    TingTrang: <input type="radio" name="tinhTrang" value="1"> Chua Thanh Toan
    <input type="radio" name="tinhTrang" value="0"> Da Thanh Toan
    <br>
    <button type="submit">Add</button>
</form>
<table class="table">
    <thead>
    <tr>
        <th>STT</th>
        <th>MaKH</th>
        <th>MaNV</th>
        <th>MaHD</th>
        <th>NgaySinh</th>
        <th>TrangThai</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listHoaDon}" var="i">
        <tr>
            <td>${i.id}</td>
            <td>${i.khachHang.ma}</td>
            <td>${i.nhanVien.ma}</td>
            <td>${i.ma}</td>
            <td>${i.ngayTao}</td>
            <td>${i.tinhTrang}</td>
            <td>
                <a href="/hien-thi/hoa-don/view-update/${i.id}"><button class="btn btn-primary">Update</button></a>
                <a href="/hien-thi/hoa-don/delete/${i.id}"><button class="btn btn-danger">Remove</button></a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</html>