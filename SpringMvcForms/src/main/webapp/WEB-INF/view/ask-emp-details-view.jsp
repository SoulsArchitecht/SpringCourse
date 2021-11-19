<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">

<body>
    <h2>Dear Employee, Please enter your details </h2>
    <br><br>

    <%--@elvariable id="employee" type=""--%>
    <form:form action = "showDetails" modelAttribute="employee">

        Name <form:input path="name"/>
        <form:errors path="name"/>
        <br><br>
        Surname <form:input path="surname"/>
        <form:errors path="surname"/>
        <br><br>
        Salary <form:input path="salary"/>
        <form:errors path="salary"/>
        <br><br>
        Department <form:select path="department">
        <%--//для хардкодед--%>
<%--        <form:option value="Information Technology" label="IT"/>
        <form:option value="Human Resourses" label="HR"/>
        <form:option value="Sales" label="Sales"/>--%>
        <%--//для софткодед--%>
        <form:options items="${employee.departments}"/>
        <br><br>
        </form:select>
        <br><br>
        Which car do you want?
        <br>
        <%--хакрдед:--%>
<%--        BMW <form:radiobutton path="carBrand" value="BMW"/>
        AUDI <form:radiobutton path="carBrand" value="Audi"/>
        MB <form:radiobutton path="carBrand" value="Mercedes-Benz"/>--%>
        <%--для софткодед--%>
        <form:radiobuttons path="carBrand" items="${employee.carBrands}"/>
        <br><br>
        Foreign Language(s)
        <%--для хардкодед:--%>
<%--        EN <form:checkbox path="languages" value="Engish"/>
        DE <form:checkbox path="languages" value="Deutch"/>
        FR <form:checkbox path="languages" value="Francois"/>--%>
        <%--для софткодед:--%>
        <form:checkboxes path="languages" items="${employee.languagesList}"/>

        <br><br>
        PhoneNumber <form:input path="phoneNumber"/>
        <form:errors path="phoneNumber"/>
        <br><br>
        email <form:input path="email"/>
        <form:errors path="email"/>
        <br><br>

        <input type="submit" value="OK">


    </form:form>
</body>
</html>