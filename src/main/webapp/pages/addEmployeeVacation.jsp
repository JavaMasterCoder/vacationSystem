<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="addVacationForm" class="gregor.melikhov.vacation.system.web.forms.AddVacationForm" scope="request"/>
<html>
<head>
    <title>Add employee vacation</title>
</head>
<body>
<form action="/vacationSystem/vacation/employee/addVacation?login=${addVacationForm.login}" method="post">
    <c:if test="${addVacationForm.error}">
        <p>Дата начала отпуска должна быть меньше даты окончания отпуска</p>
    </c:if>
    <p>
        <label>
            Дата начала отпуска:
            <input type="date" name="vacationStartDate" value="${addVacationForm.vacationStartDate}">
        </label>
    </p>

    <p>
        <label>
            Дата окончания отпуска:
            <input type="date" name="vacationEndDate" value="${addVacationForm.vacationEndDate}">
        </label>
    </p>

    <input type="submit" value="Добавить">
</form>
</body>
</html>
