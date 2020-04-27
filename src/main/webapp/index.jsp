<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="signInForm" class="gregor.melikhov.vacation.system.web.forms.SignInForm" scope="request"/>
<html>
<head>
  <title>All employees</title>
</head>
<body>

<form action="/vacationSystem/employee/all/signIn" method="post">
    <p>
        <label>
            Логин:
            <input type="text" name="login" value="${signInForm.login}">
        </label>
    </p>

    <p>
        <label>
            Пароль:
            <input type="password" name="password" value="${signInForm.password}">
        </label>
    </p>

    <input type="submit" value="Войти">
</form>
</body>
</html>