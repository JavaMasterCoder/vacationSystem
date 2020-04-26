<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="employeesVacationsForm" type="gregor.melikhov.vacation.system.web.forms.EmployeesVacationsForm" scope="request"/>
<html>
<head>
    <title>Employee's vacations</title>
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
<table>
    <c:choose>
        <c:when test="${not empty employeesVacationsForm.vacations}">
            <tr>
                <th colspan="2">Отпуска сотрудника ${not empty employeesVacationsForm.employee ? employeesVacationsForm.employee : ""}</th>
            </tr>
            <tr>
                <th>Дата начала отпуска</th>
                <th>Дата окончания отпуска</th>
            </tr>
            <c:forEach var="vacation" items="${employeesVacationsForm.vacations}">
                <tr>
                    <td><fmt:formatDate value="${vacation.vacationStartDate}" pattern="dd.MM.yyyy"/></td>
                    <td><fmt:formatDate value="${vacation.vacationEndDate}" pattern="dd.MM.yyyy"/></td>
                </tr>
            </c:forEach>
        </c:when>
        <c:otherwise>
            <p>У сотрудника нет зарегистрированных отпусков</p>
        </c:otherwise>
    </c:choose>
</table>
<a href="/vacationSystem/employee/all" title="Вернуться к общему списку всех сотрудников">Вернуться к общему списку всех сотрудников</a>
</body>
</html>
