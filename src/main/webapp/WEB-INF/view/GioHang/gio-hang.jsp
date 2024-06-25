
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<div class="container">
<div class="row">
    <h2 class="text-center">Danh sách hoá đơn</h2>
    <table class="table">
        <thead>
        <tr>
            <td>STT</td>
            <td>ID</td>
            <td>Ten khach hang</td>
            <td>Ngay tao</td>
            <td>Ngay Thanh Toan</td>
            <td>Trang Thai</td>
            <td>Tong tien</td>
            <td>Chuc nang</td>
        </tr>
        </thead>
        <c:forEach items="${listGH}" var="hoaDon" varStatus="i">
            <tbody>
            <tr>
                <td>${i.index+1}</td>
                <td>${hoaDon.id}</td>
                <td>${hoaDon.khachHang.ten}</td>
                <td>${hoaDon.ngayTao}</td>
                <td>${hoaDon.ngayThanhToan}</td>
                <td>${hoaDon.tinhTrang}</td>
                <td>0.0</td>
                <td>
                    <a href="/hien-thi/detail/hoa-don/${hoaDon.id}" class="btn btn-info">Chọn</a>
                </td>
            </tr>
            </tbody>
        </c:forEach>
    </table>
</div>
<div class="row">
    <h2>Danh sách Gio Hang CHi Tiet</h2>
    <table class="table">
        <thead>
        <tr>
            <td>STT</td>
            <td>Ma Gio Hang</td>
            <td>Ten san pham</td>
            <td>So Luong</td>
            <td>Don Gia</td>
            <td>Tổng Tiền</td>
            <td>Chuc nang</td>
        </tr>
        </thead>
        <c:forEach items="${listGHCT}" var="spct">
            <tbody>
            <tr>
                <td>${spct.id}</td>
                <td>${spct.gioHang.id}</td>
                <td>${spct.chiTietSP.sanPham.ten}</td>
                <td>${spct.soLuong}</td>
                <td>${spct.donGia}</td>
                <td>${spct.tongTien}</td>
                <td>
                    <a href="" class="btn btn-primary">Chọn</a>
                </td>
            </tr>
            </tbody>
        </c:forEach>
    </table>
</div>
</div>
</body>
</html>