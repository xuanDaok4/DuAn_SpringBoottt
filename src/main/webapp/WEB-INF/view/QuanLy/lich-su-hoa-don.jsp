
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
        <h2 class="text-center">Lịch Sử Hoá Đơn</h2>
        <table class="table">
            <thead>
            <tr>
                <td>ID</td>
                <td>Id Hoa Don</td>
                <td>Ngay Thanh Toan</td>
                <td>Tong tien</td>
                <td>Trang Thai</td>
                <td>Chuc nang</td>
            </tr>
            </thead>
            <c:forEach items="${listLSHD}" var="hd" varStatus="i">
                <tbody>
                <tr>
                    <td>${i.index+1}</td>
                    <td>${hd.hoaDon.id}</td>
                    <td>${hd.ngayTao}</td>
                    <td>${hd.tongTien}</td>
                    <td>${hd.trangThai}</td>
                    <td>
                        <a href="/hien-thi/ban-hang" class="btn btn-info">Về Home</a>
                    </td>
                </tr>
                </tbody>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>