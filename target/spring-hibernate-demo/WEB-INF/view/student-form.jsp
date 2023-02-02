<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <title>Student Form!</title>
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>
<h1>Student Form!</h1>

<p>spring form</p>
<p>Please fill out the for. Asterisk (*) means required.</p>
<form:form action="processForm" modelAttribute="studentModel">
    First name: <form:input path="firstName"/> *
    <form:errors path="firstName" cssClass="error"/>
    <br><br>
    Last name: <form:input path="lastName"/>
    <br><br>
    Age: <form:input path="age"/> *
    <form:errors path="age" cssClass="error"/>
    <br><br>
    Postal code: <form:input path="postalCode"/>
    <form:errors path="postalCode" cssClass="error"/>
    <br><br>
    Language: <br>
     <form:radiobutton path="language" value="Java"/> Java
     <form:radiobutton path="language" value="C#"/> C#
     <form:radiobutton path="language" value="PHP"/> PHP
    <br><br>
    Operating system: <br>
    <form:checkbox path="operatingSystem" value="Windows"/> Windows
    <form:checkbox path="operatingSystem" value="Linux"/> Linux
    <form:checkbox path="operatingSystem" value="Mac"/> Mac

    <br><br>

    Course code: <form:input path="courseCode"/>
    <form:errors path="courseCode" cssClass="error"/>
    <br><br>

    <input type="submit" value="Submit"/>
</form:form>
<br><br>
<a href="/">Home</a>
</body>
</html>