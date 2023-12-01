<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 01/12/2023
  Time: 11:03 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <style>
        /* Add your custom styles here */

        /* Adjust form layout */
        .form-container {
            max-width: 400px;
            margin: auto;
        }

        /* Adjust spacing for form elements */
        .form-group {
            margin-bottom: 15px;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="form-container">
        <form:form action="/add-comfim" method="post" modelAttribute="student">
            <div class="form-group">
                <h1>Form Add</h1>
            </div>
            <div class="form-group">
                <p>Name:</p>
                <form:input class="form-control" type="text" path="name"/>
            </div>
            <div class="form-group">
                <p>Address:</p>
                <form:input class="form-control" type="text" path="address"/>
            </div>
            <div class="form-group">
                <p>Birthdate</p>
                <form:input class="form-control" type="date" path="birthdate"/>
            </div>
            <div class="form-group">
                <p>Sex:</p>
                <form:radiobutton class="form-check-input" value="true" path="sex" name="sex"/>
                <span class="form-check-label">Nam</span>
                <form:radiobutton class="form-check-input" value="false" path="sex" name="sex"/>
                <span class="form-check-label">Nữ</span>
            </div>
            <div class="form-group">
                <button class="btn btn-primary" type="submit">Add Student</button>
            </div>
        </form:form>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
</html>
