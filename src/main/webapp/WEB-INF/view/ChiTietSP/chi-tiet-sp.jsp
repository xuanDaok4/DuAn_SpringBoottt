<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href=" https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
</head>
<body class="container">
<form  method="post" action="/hien-thi/chi-tiet-sp/add" >
    Id: <input type="text" name="id" value="">
    <br>

    Ten SP: <select class="form-select" aria-label="Default select example" name="sanPham">
    <c:forEach items="${listSP}" var="i" >
        <option value="${i.id}">${i.ten}</option>
    </c:forEach>
</select>
    <br>

    Ten NSX: <select class="form-select" aria-label="Default select example" name="nsx">
    <c:forEach items="${listNSX}" var="i" >
        <option value="${i.id}">${i.ten}</option>
    </c:forEach>
</select>
    <br>

    Ten Mau: <select class="form-select" aria-label="Default select example" name="mauSac">
    <c:forEach items="${listMauSac}" var="i" >
        <option value="${i.id}">${i.ten}</option>
    </c:forEach>
</select>
    <br>

    Ten DongSP: <select class="form-select" aria-label="Default select example" name="dongSP">
    <c:forEach items="${listDongSP}" var="i" >
        <option value="${i.id}">${i.ten}</option>
    </c:forEach>
</select>

    <br>
    NamBH: <input type="text" name="namBH" value=""/>
    <br>

    SoLuongTon: <input type="text" name="soLuongTon" value=""/>
    <br>

    MoTa: <input type="text" name="moTa" value=""/>
    <br>

    GiaNhap: <input type="text" name="giaNhap" value=""/>
    <br>

    GiaBan: <input type="text" name="giaBan" value=""/>
    <br>

    <button type="submit">Add</button>
</form>
<table class="table">
    <thead>
    <tr>
        <th>STT</th>
        <th>IdSP</th>
        <th>IdNSX</th>
        <th>IdMauSac</th>
        <th>IdDongSP</th>
        <th>NamBH</th>
        <th>MoTa</th>
        <th>SoLuongTon</th>
        <th>GiaNhap</th>
        <th>GiaBan</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listChiTietSP}" var="i">
        <tr>
            <td>${i.id}</td>
            <td>${i.sanPham.ten}</td>
            <td>${i.nsx.ten}</td>
            <td>${i.mauSac.ten}</td>
            <td>${i.dongSP.ten}</td>
            <td>${i.namBH}</td>
            <td>${i.moTa}</td>
            <td>${i.soLuongTon}</td>
            <td>${i.giaNhap}</td>
            <td>${i.giaBan}</td>
            <td>
                <a href="/hien-thi/chi-tiet-sp/view-update/${i.id}"><button class="btn btn-primary">Update</button></a>
                <a href="/hien-thi/chi-tiet-sp/delete/${i.id}"><button class="btn btn-danger">Remove</button></a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</html>