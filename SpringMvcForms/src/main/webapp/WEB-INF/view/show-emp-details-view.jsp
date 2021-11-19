<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>

</head>
<body>
    <h2>Dear Employee, You're welcome! </h2>

    <br><br>
    Your name: ${employee.name}
    <br><br>
    Your surname: ${employee.surname}
    <br><br>
    Your salary: ${employee.salary}
    <br><br>
    Your department: ${employee.department}
    <br><br>
    Your car: ${employee.carBrand}
    <br><br>
    Language(s):
    <ul>
        <c:forEach var="lang" items="${employee.languages}">
            <li> ${lang} </li>
        </c:forEach>
    </ul>
    <br><br>
    Your phone: ${employee.phoneNumber}
    <br><br>
    Your email: ${employee.email}

</body>
</html>