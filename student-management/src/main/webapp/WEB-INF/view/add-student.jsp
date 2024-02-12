<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Add Student</title>
</head>
<body>
    <div align="center">
        <form:form action="save-student" modelAttribute="student" method="POST"> 
            <form:hidden path="id"/>
            
            <label>ID:</label>
            <form:input path="id" value="${student.id}" readonly="true"/>
            <br/>

            <label>Name:</label>
            <form:input path="name" value="${student.name}"/>
            <br/>

            <label>Number:</label>
            <form:input path="mobile" value="${student.mobile}"/>
            <br/>

            <label>Country:</label>
            <form:input path="country" value="${student.country}"/>
            <br/>

            <input type="submit" value="Submit">
        </form:form>
    </div>
</body>
</html>
