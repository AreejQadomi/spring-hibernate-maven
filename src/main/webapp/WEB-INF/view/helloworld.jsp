<!DOCTYPE html>
<html>
<head lang="en">
    <title>Hello World!</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css">

</head>
<body>
<h1 class="formHeader">Student name: from Html param: ${param.studentName}</h1>


<h1>Student name: from the model (after processing): ${name}</h1>

<h1>Student name: from the model (after processing2): ${studentName}</h1>

<a href="/">Home</a>
</body>
</html>