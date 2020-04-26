<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="allVacationsForm" type="gregor.melikhov.vacation.system.web.forms.AllVacationsForm" scope="request"/>
<html>
<head>
    <title>All vacations</title>
    <style>
        table, th, td {
            border: 1px solid black;
            padding: 5px;
            border-collapse: collapse;
            text-align: center;
        }
        table {
            border-spacing: 15px;
        }
    </style>
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
                <td><fmt:formatDate value="${vacation.vacationStartDate}" pattern="dd.MM.yyyy"/></td>
                <td><fmt:formatDate value="${vacation.vacationEndDate}" pattern="dd.MM.yyyy"/></td>
            </tr>
        </c:forEach>
        </table>
        <p></p>
        <form action="/vacationSystem/vacations/all/sortByEmployees" method="post">
            <input type="submit" value="Сортировать по сотрудникам">
        </form>
        <form action="/vacationSystem/vacations/all/sortByPeriod" method="post">
            <input type="submit" value="Сортировать по периоду">
        </form>
        <form action="/vacationSystem/vacations/all/sortByEmployee" method="post">
            <input type="text" placeholder="ФИО сотрудника" name="FIO" value="">
            <input type="submit" value="Сортировать по сотруднику">
        </form>
        <form action="/vacationSystem/vacations/all/sortBySpecifiedPeriod" method="post">
            <label>
                Дата начала отпусков:
                <c:choose>
                    <c:when test="${not empty allVacationsForm.startOfPeriod}">
                        <input type="date" name="startOfPeriod" value="${allVacationsForm.startOfPeriod}">
                    </c:when>
                    <c:otherwise>
                        <input type="date" name="startOfPeriod" value="">
                    </c:otherwise>
                </c:choose>
            </label>

            <label>
                Дата окончания отпусков:
                <c:choose>
                    <c:when test="${not empty allVacationsForm.endOfPeriod}">
                        <input type="date" name="endOfPeriod" value="${allVacationsForm.endOfPeriod}">
                    </c:when>
                    <c:otherwise>
                        <input type="date" name="endOfPeriod" value="">
                    </c:otherwise>
                </c:choose>
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
