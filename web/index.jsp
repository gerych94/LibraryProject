<%--
  Created by IntelliJ IDEA.
  User: Vitaliy
  Date: 21.02.2017
  Time: 0:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%if(session.getAttribute("j_username")!=null)
  session.invalidate();%>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <title>Онлайн библиотека::Вход</title>
  <link href="resources/css/style_index.css" rel="stylesheet" type="text/css">
  <script src="resources/js/validationName.js" type="text/javascript"></script>
</head>
  <body>
  <div class="main">
    <div class="content">
      <p class="title"><span class="text"><img src="resources/images/lib.png" width="76" height="77" hspace="10" vspace="10" align="middle"></span></p>
      <p class="title">Онлайн библиотека</p>
      <p class="text">Добро пожаловать в онлайн библиотеку, где вы сможете найти любую книгу на ваш вкус. Доступны функции поиска, просмотра, сортировки и многие другие.</p>
      <p class="text">Проект находится в разработке, поэтому дизайн и функционал будет постоянно дорабатываться.</p>
      <p class="text">По всем вопросам обращайтесь по адресу <a href="mailto:support@testlibrary.com">support@testlibrary.com</a></p>
      <p>&nbsp;</p>
    </div>
    <div class="login_div">
      <p class="title">Для входа введите свои данные:</p>
     <form class="login_form" name="username" action="resources/pages/main.jsp" method="POST" onsubmit="return validateform()">
     <!-- <form class="login_form" name="username" action="/private" method="POST">-->
        Имя: <input type="text" name="j_username" size="20" autocomplete="off"/><br/>
        Пароль: <input type="password" name="j_password" size="20" autocomplete="off"/>
        <input type="submit" value="Войти" />
      </form>
    </div>
    <div class="footer">
      Разработчик: Виталий Кондратюк, 2017 г
    </div>
  </div>
  </body>
</html>
