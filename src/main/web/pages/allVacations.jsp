<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="allVacationsForm" type="gregor.melikhov.vacation.system.web.forms.AllVacationsForm" scope="request"/>
<html>
<head>
    <title>All vacations</title>
</head>
<body>
<c:choose>
    <c:when test="${not empty allVacationsForm}">
        <table>
            <tr>
                <th>ФИО сотрудника</th>
                <th>Начало отпуска</th>
                <th>Конец отпуска</th>
            </tr>
        <c:forEach var="vacation" items="${allVacationsForm.allVacations}">
            <tr>
                <td>${vacation.employee.FIO}</td>
                <td><input type="date" value="${vacation.vacationStartDate}"></td>
                <td><input type="date" value="${vacation.vacationEndDate}"></td>
            </tr>
        </c:forEach>
        </table>
        <form action="vacations/all?sortBy=employees" method="get">
            <input type="submit" value="Сортировать по сотрудникам">
        </form>
        <form action="vacations/all?sortBy=period" method="get">
            <input type="submit" value="Сортировать по периоду">
        </form>
        <form action="" method="get">
            <input type="text" placeholder="ФИО сотрудника" value="">
            <input type="submit" value="Сортировать по сотруднику">
        </form>
        <form action="" method="get">
            <label>
                Дата начала отпусков:
                <input type="date" value="">
            </label>

            <label>
                Дата окончания отпусков:
                <input type="date" value="">
            </label>
            <input type="submit" value="Сортировать по отпускам в ограниченном диапазоне">
        </form>
    </c:when>
    <c:otherwise>
        <p>Таблица отпусков пуста</p>
    </c:otherwise>
</c:choose>
<a href="/vacationSystem/employee/all" title="К списку всех сотрудников">К списку всех сотрудников</a>
</body>
</html>
