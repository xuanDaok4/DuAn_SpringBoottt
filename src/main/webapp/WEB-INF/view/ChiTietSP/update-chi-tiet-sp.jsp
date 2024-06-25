<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href=" https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
</head>
<body class="container">
<form  method="post" action="/hien-thi/chi-tiet-sp/update" >
    Id: <input type="text" name="id" value="${chiTiet.id}">
    <br>

    Ma Khach Hang: <select class="form-select" aria-label="Default select example" name="sanPham">
    <c:forEach items="${listSP}" var="i" >
        <option value="${i.id}"
                <c:if test="${chiTiet.sanPham.ten  == i.ten}">selected</c:if>
        >${i.ten}</option>
    </c:forEach>
</select>
    <br>

    Ma Nhan Vien: <select class="form-select" aria-label="Default select example" name="nsx">
    <c:forEach items="${listNSX}" var="i" >
        <option value="${i.id}"
                <c:if test="${chiTiet.nsx.ten  == i.ten}">selected</c:if>
        >${i.ten}</option>
    </c:forEach>
</select>
    <br>

    Ma Khach Hang: <select class="form-select" aria-label="Default select example" name="mauSac">
    <c:forEach items="${listMauSac}" var="i" >
        <option value="${i.id}"
                <c:if test="${chiTiet.mauSac.ten  == i.ten}">selected</c:if>
        >${i.ten}</option>
    </c:forEach>
</select>
    <br>

    Ma Nhan Vien: <select class="form-select" aria-label="Default select example" name="dongSP">
    <c:forEach items="${listDongSP}" var="i" >
        <option value="${i.id}"
                <c:if test="${chiTiet.dongSP.ten  == i.ten}">selected</c:if>
        >${i.ten}</option>
    </c:forEach>
</select>

    <br>
    NamBH: <input type="text" name="namBH" value="${chiTiet.namBH}"/>
    <br>

    SoLuongTon: <input type="text" name="soLuongTon" value="${chiTiet.soLuongTon}"/>
    <br>

    MoTa: <input type="text" name="moTa" value="${chiTiet.moTa}"/>
    <br>

    GiaNhap: <input type="text" name="giaNhap" value="${chiTiet.giaNhap}"/>
    <br>

    GiaBan: <input type="text" name="giaBan" value="${chiTiet.giaBan}"/>
    <br>

    <button type="submit">Update</button>
</form>

</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</html>