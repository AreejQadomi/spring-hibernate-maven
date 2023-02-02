<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <title>Confirmation Student!</title>
</head>
<body>
<h1>Student Confirmation!</h1>

<p>spring form</p>
<h3>Student confirmed: ${studentModel.firstName} ${studentModel.lastName}</h3>
<br><br>
<h3>Student's age: ${studentModel.age}</h3>
<br><br>
<h3>Student's country: ${studentModel.country} </h3>
<br><br>
<h3>Postal code: ${studentModel.postalCode}</h3>
<br><br>
<h3>Favorite language: ${studentModel.language}</h3>
<br><br>
<c:if test="${not empty studentModel.operatingSystem}">
    <h3>Operating system:</h3>
    <ul>
        <c:forEach items="${studentModel.operatingSystem}" var="os">
            <li>${os}</li>
        </c:forEach>
    </ul>
</c:if>
<h3>Course code: ${studentModel.courseCode}</h3>
<br><br>


<br><br>
<a href="/">Home</a>
</body>
</html>