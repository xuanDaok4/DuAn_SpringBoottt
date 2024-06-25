<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href=" https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">

</head>
<body  class="container">
<form:form action="/hien-thi/chuc-vu/add" modelAttribute="chucVu" method="post">
    Id: <input path="id" type="text" name="id" value="" readonly>
    <br>
    Ma: <form:input path="ma" type="text" name="ma" value=""/>
    <form:errors path="ma" cssStyle="color: red"/>
    <br>
    Ten: <form:input path="ten" type="text" name="ten" value=""/>
    <form:errors path="ten" cssStyle="color: red"/>
    <br>
    <button type="submit">Add</button>
</form:form>
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
    <c:forEach items="${listChucVu}" var="i">
        <tr>
            <td>${i.id}</td>
            <td>${i.ma}</td>
            <td>${i.ten}</td>
            <td>
                <a href="/hien-thi/chuc-vu/view-update/${i.id}"><button class="btn btn-primary">Update</button></a>
                <a href="/hien-thi/chuc-vu/delete/${i.id}"><button class="btn btn-danger">Remove</button></a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</html>