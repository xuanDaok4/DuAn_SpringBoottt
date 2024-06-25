<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src=""></script>
    <style>
        .table{
            background: black;
        }
        .row{
            background: black;
            color: white;
        }
    </style>
</head>
<body>
<div class="row">
    <div class="col-5">
        <h2 class="text-center">Tạo hoá đơn</h2>
<%--        <div>--%>
<%--            <div>--%>
<%--                <label class="mb-3 col-3">Số điện thoại</label>--%>
<%--                <input type="text" class="col-7">--%>
<%--            </div>--%>
<%--            <button  class="btn btn-primary">Search</button>--%>
<%--        </div>--%>
        <form action="/hien-thi/tao-hao-don" method="post">
            <div class="row">
                <div class="mb-3">
                    <label class="col-3">Ten Khach hang</label>
                    <input type="text" class="col-7" readonly value="${hoaDon.khachHang.ten}">
                </div>
                <div class="mb-3">
                    <label class="col-3">NV Tạo HoaDon</label>
                    <input type="text" class="col-7" readonly value="${hoaDon.nhanVien.ten}">
                </div>
                <div class="mb-3">
                    <label class="col-3">ID Hoa don</label>
                    <input type="text" class="col-7" readonly name="idHoaDon" value="${hoaDon.id}">
                </div>
                <div class="mb-3">
                    <label class="col-3">Tong tien</label>
                    <input type="text" class="col-7" name="tongTien" readonly value="${tongTien}">
                </div>
                <div>
<%--                  <a href="/tao-hoa-don?idHoaDon=${hoaDon.id}" class="btn btn-primary">Tạo hoá đơn</a>--%>
                    <button type="submit" class="btn btn-danger">Tạo hoa don</button>
                    <%--                <a href="/hoa-don-chi-tiet/thanhToan?idHD=${listDetail.id}" onclick="handleClick()">--%>
                    <button class="btn btn-primary" type="submit" >Thanh toán</button>

<%--                </a>--%>
                </div>

            </div>
        </form>
        <a href="/hien-thi/ban-hang"><button class="btn btn-danger">Resert</button></a>
        <a href="/hien-thi/view/gio-hang" class="btn btn-primary">Xem Giỏ Hàng</a>
    </div>

    <div class="col-7">
        <h2 class="text-center">Danh sách hoá đơn</h2>
        <table class="table">
            <thead>
            <tr>
                <td>STT</td>
                <td>ID</td>
                <td>Ten khach hang</td>
                <td>Ten nhan vien</td>
                <td>Ngay tao</td>
                <td>Trang Thai</td>
                <td>Chuc nang</td>
            </tr>
            </thead>
            <c:forEach items="${listHD}" var="hoaDon" varStatus="i">
                <tbody>
                <tr>
                    <td>${i.index+1}</td>
                    <td>${hoaDon.id}</td>
                    <td>${hoaDon.khachHang.ten}</td>
                    <td>${hoaDon.nhanVien.ten}</td>
                    <td>${hoaDon.ngayTao}</td>
                    <td>${hoaDon.tinhTrang}</td>
                    <td>
                        <a href="/hien-thi/detail/hoa-don/${hoaDon.id}" class="btn btn-info">Chọn</a>
                        <a href="/hien-thi/view/hoa-don" class="btn btn-danger">Lich Sử HD</a>
                    </td>
                </tr>
                </tbody>
           </c:forEach>
        </table>
        <h2 class="text-center">Danh sách hoá đơn chi tiết</h2>

        <table class="table">
            <thead>
            <tr>
                <td>STT</td>
                <td>ID</td>
                <td>Ten san pham</td>
                <td>So luong</td>
                <td>Gia ban</td>
                <td>Tong tien</td>
                <td>Chuc nang</td>
            </tr>
            </thead>
<%--     <c:if test="${not empty listHDCT || empty listHDCT} ">--%>
           <c:forEach items="${listHDCT}" var="s" varStatus="i">
                <tbody>
                <tr>
                    <td>${i.index +1}</td>
                    <td>${s.id}</td>
                    <td>${s.chiTietSP.sanPham.ten}</td>
                    <td>${s.soLuong}</td>
                    <td>${s.donGia}</td>
                    <td>${s.tongTien}</td>
                    <td>
<%--                        <a href="/hien-thi/ban-hang/add/soLuong/${i.id}" class="btn btn-info">+</a>--%>
                        <a href="/hien-thi/xoaHDCT/${s.id}" class="btn btn-danger">Remove HD</a>

                    </td>
                </tr>
                </tbody>
            </c:forEach>
<%--     </c:if>--%>
        </table>
    </div>
</div>
<div>
    <h2>Danh sách sản phẩm</h2>
    <table class="table">
        <thead>
        <tr>
            <td>STT</td>
            <td>ID CTSP</td>
            <td>Ten san pham</td>
            <td>Mau sac</td>
            <td>NamSX</td>
            <td>Gia ban</td>
            <td>So luong ton</td>
            <td>Mo Ta</td>
            <td>Chuc nang</td>
        </tr>
        </thead>
       <c:forEach items="${listCTSP}" var="i" varStatus="s">
            <tbody>
            <tr>
                <td>${s.index + 1}</td>
                <td>${i.id}</td>
                <td>${i.sanPham.ten}</td>
                <td>${i.mauSac.ten}</td>
                <td>${i.nsx.ten}</td>
                <td>${i.giaBan}</td>
                <td>${i.soLuongTon}</td>
                <td>${i.moTa}</td>
                <td>
                    <a href="/hien-thi/ban-hang/add/soLuong/${i.id}" class="btn btn-secondary">+</a>
                    <a href="/hien-thi/ban-hang/add/${i.id}" class="btn btn-primary">Mua</a>
                    <a href="/hien-thi/gio-hang/add/${i.id}" class="btn btn-danger">Giỏ hàng</a>
                    <a href="/hien-thi/ban-hang/delete/soLuong/${i.id}" class="btn btn-secondary">-</a>
                </td>
            </tr>
            </tbody>
    </c:forEach>
    </table>
</div>
</body>
</html>