<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href=" https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">

</head>
<body  class="container">
<form action="/hien-thi/khach-hang/add" method="post">
    Id: <input type="text" name="id" value="">
    <br>
    Ma: <input type="text" name="ma" value="">
    <br>
    Ten: <input type="text" name="ten" value="">
    <br>
    tenDem: <input type="text" name="tenDem" value="">
    <br>
    Ho: <input type="text" name="ho" value="">
    <br>
    SDT: <input type="number" name="sdt" value="">
    <br>
    DiaChi: <input type="text" name="diaChi" value="">
    <br>
    <button type="submit">Add</button>
</form>
<table class="table">
    <thead>
    <tr>
        <th>STT</th>
        <th>Ma</th>
        <th>Ten</th>
        <th>TenDem</th>
        <th>Ho</th>
        <th>NgaySinh</th>
        <th>SDT</th>
        <th>DiaChi</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listKhachHang}" var="i">
        <tr>
            <td>${i.id}</td>
            <td>${i.ma}</td>
            <td>${i.ten}</td>
            <td>${i.tenDem}</td>
            <td>${i.ho}</td>
            <td>${i.ngaySinh}</td>
            <td>${i.sdt}</td>
            <td>${i.diaChi}</td>
            <td>
                <a href="/hien-thi/khach-hang/view-update/${i.id}"><button class="btn btn-primary">Update</button></a>
                <a href="/hien-thi/khach-hang/delete/${i.id}"><button class="btn btn-danger">Remove</button></a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</html>