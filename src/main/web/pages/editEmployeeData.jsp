<%@ page contentType="text/html;charset=UTF-8" %>
<jsp:useBean id="form" type="gregor.melikhov.vacation.system.web.forms.EditEmployeeForm" scope="request"/>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Edit employee data</title>
</head>
<body>
    <form action="/vacationSystem/employee/edit?id=${form.id}" method="post" enctype="application/x-www-form-urlencoded">
        <p>
            <label>
                ФИО:
                <input type="text" name="FIO" value="${form.FIO}">
            </label>
        </p>
        <p>
            <label>
                Дата рождения:
                <input type="date" name="birthDate" value="${form.birthDate}">
            </label>
        </p>
        <p>
            <label>
                Табельный номер:
                <input type="text" name="personalNumber" value="${form.personalNumber}">
            </label>
        </p>
        <p>
            <label>
                Должность:
                <input type="text" name="post" value="${form.post}">
            </label>
        </p>
        <p>
            <label>
                Дата начала работы:
                <input type="date" name="dateOfStartWorking" value="${form.dateOfStartWorking}">
            </label>
        </p>
        <p>
            <label>
                Логин:
                <input type="text" name="login" value="${form.login}">
            </label>
        </p>
        <p>
            <label>
                Пароль:
                <input type="text" name="password" value="${form.password}">
            </label>
        </p>
        <p>
            <input type="submit">
        </p>
    </form>
    <form action="/vacationSystem/employee/all" method="get">
        <input type="submit" value="Отменить">
    </form>
</body>
</html>
