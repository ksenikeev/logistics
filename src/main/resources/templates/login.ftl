<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <meta charset="utf-8"/>
</head>
<body>
<h2>Логистика поставок</h2>
<form method="POST" action="${model['app_path']}/usercheckform" enctype="application/x-www-form-urlencoded">
    <table>
        <tbody>
        <tr>
            <td>
                <label for="username">Логин</label>
            </td>
            <td>
                <input id="username" name="username" type="text"/>
            </td>
        </tr>
        <tr>
            <td>
                <label for="password">Пароль</label>
            </td>
            <td>
                <input id="password" name="password" type="password"/>
            </td>
        </tr>
        </tbody>
    </table>
    <button class="default" type="submit">Войти</button>
</form>
</body>
</html>