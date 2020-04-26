<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="allEmployees" class="gregor.melikhov.vacation.system.web.forms.AllEmployeesForm" scope="request"/>
<html>
<head>
    <title>All employees</title>
</head>
<body>
<table>
    <c:choose>
        <c:when test="${not empty allEmployees}">
            <tr>
                <th>ФИО сотрудника</th>
                <th>Логин</th>
                <th></th>
            </tr>
            <c:forEach items="${allEmployees.employees}" var="employee">
                <tr>
                    <td><a href="/vacationSystem/vacations/employee?login=${employee.login}">${employee.FIO}</a></td>
                    <td>${employee.login}</td>
                    <td><a href="/vacationSystem/employee/edit?login=${employee.login}">Редактировать</a></td>
                </tr>
            </c:forEach>
        </c:when>
        <c:otherwise>
            <p>Таблица сотрудников пуста</p>
        </c:otherwise>
    </c:choose>
</table>
<p>
    <a href="/vacationSystem/vacations/all" title="К списку всех отпусков">К списку всех отпусков</a>
</p>
</body>
</html>