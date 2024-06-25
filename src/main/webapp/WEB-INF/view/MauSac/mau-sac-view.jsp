<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href=" https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">

</head>
<body  class="container">
<form action="/hien-thi/mau-sac/add" method="post">
    Id: <input type="text" name="id" value="">
    <br>
    Ma: <input type="text" name="ma" value="">
    <br>
    Ten: <input type="text" name="ten" value="">
    <br>
    <button type="submit">Add</button>
</form>
<table class="table">
    <thead>
    <tr>
        <th>STT</th>
        <th>Ma</th>
        <th>Ten</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listMauSac}" var="i">
        <tr>
            <td>${i.id}</td>
            <td>${i.ma}</td>
            <td>${i.ten}</td>
            <td>
                <a href="/hien-thi/mau-sac/view-update/${i.id}"><button class="btn btn-primary">Update</button></a>
                <a href="/hien-thi/mau-sac/delete/${i.id}"><button class="btn btn-danger">Remove</button></a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</html>