<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href=" https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">

</head>
<body class="container">
<form action="/hien-thi/hoa-don/update" method="post">
    Id: <input type="text" name="id" value="${hoaDon.id}">
    <br>
    Ma: <input type="text" name="ma" value="${hoaDon.ma}">
    <br>
    Ma Khach Hang: <select class="form-select" aria-label="Default select example" name="khachHang">
    <option selected></option>
    <c:forEach items="${listKhachHang}" var="i" >
        <option value="${i.id}"
                <c:if test="${hoaDon.khachHang.ma == i.ma}" >selected</c:if>
        >${i.ma}</option>
    </c:forEach>
</select>
    <br>
    Ma Nhan Vien: <select class="form-select" aria-label="Default select example" name="nhanVien">
    <option selected></option>
    <c:forEach items="${listNhanVien}" var="i" >
        <option value="${i.id}"
                <c:if test="${hoaDon.nhanVien.ma == i.ma}" >selected</c:if>
        >${i.ma}</option>
    </c:forEach>
</select>
    <br>
    TingTrang: <input type="radio" name="tinhTrang" value="1" ${hoaDon.tinhTrang == 1 ? "checked" : ""}> Chua Thanh Toan
    <input type="radio" name="tinhTrang" value="0" ${hoaDon.tinhTrang == 0 ? "checked" : ""}> Da Thanh Toan
    <br>
    <button type="submit">Add</button>
</form>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</html>