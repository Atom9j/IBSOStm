<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <%@ page contentType="text/html; charset=UTF-8" %>

    <link rel="stylesheet" href="css/style.css">
    <script src="js/jquery-latest.js"></script>
    <script src="js/maskedinput.js"></script>
    <script src="js/ipmask.js"></script>

    <script>
        $(document).ready(function () {
            $('#ip').ipmask();
            $('#port').mask('9999');
            $('#submitConfig').click(function (event) {
                var ip = $('#ip').val();
                var action = "Save_config";
                var port = $('#port').val();
                var sid = $('#sid').val();
                var login = $('#login').val();
                var pass = $('#pass').val();

                $.get('kz.bss.ibsostm.ConfServlet', {
                    action: action,
                    ip: ip,
                    port: port,
                    sid: sid,
                    login: login,
                    pass: pass
                }, function (responseText) {
                    var str = document.getElementById('current').value;
                    $('#current').text(responseText);
                });
            });
            $('#currentConfig').click(function (event) {
                var action = "Current_config";

                $.get('kz.bss.ibsostm.ConfServlet', {
                    action: action
                }, function (responseText) {
                    var str = document.getElementById('current').value;
                    $('#current').text(responseText);
                });
            });
        });

        function Reset() {
            $('#current').text(""),
                $('#ip').text(""),
                $('#port').text(""),
                $('#sid').text(""),
                $('#login').text(""),
                $('#pass').text("");
        }

        jQuery(function ($) {
            $("#dateOfBirth").mask("99.99.9999", {placeholder: "dd.mm.yyyy"});
        });
        function check() {
            var inp1 = document.getElementById('ip'),
            inp2 = document.getElementById('port'),
            inp3 = document.getElementById('sid');
            inp4 = document.getElementById('login');
            inp5 = document.getElementById('pass');
            document.getElementById('submitConfig').disabled =
                inp1.value && inp2.value && inp3.value && inp4.value && inp5.value ? false : "disabled";
        }
    </script>
</head>
<body>
<div id="something">
    <form class="pure-form pure-form-stacked">
        <fieldset>

            <legend style="font-size: 36px" align="center">IBSO выписки</legend>

            <font size="4">Настройки подключения к БД</font>
            <table>
            </br>
                <label id="current"> </label>
                <tr>
                    <td>
                        <label for="ip">IP</label>
                    </td>
                    <td>
                        <label for="port">Порт</label>
                    </td>
                    <td>
                        <label for="sid">SID</label>
                    </td>
                    <td width="15px">
                    </td>
                </tr>
                <tr>
                    <td>
                        <div style="float:left ">
                            <input id="ip" type="text" required maxlength="15" onkeyup="check();">
                        </div>
                    </td>
                    <td>
                        <div style="float:left ">
                            <input id="port" type="text" required maxlength="5" onkeyup="check();">
                        </div>
                    </td>
                    <td>
                        <div style="float:left ">
                            <input id="sid" type="text" required maxlength="10" onkeyup="check();">
                        </div>
                    </td>
                </tr>
            </table>
            <table>
                <tr>
                    <td>
                        <label for="login">Логин</label>
                    </td>
                    <td>
                        <label for="pass">Пароль</label>
                    </td>
                </tr>
                <tr>
                    <td>
                        <div style="float:left ">
                            <input id="login" type="text" required maxlength="20" onkeyup="check();">
                        </div>
                    </td>
                    <td>
                        <div style="float:left ">
                            <input id="pass" type="text" required maxlength="20" onkeyup="check();">
                        </div>
                    </td>
                    <td>
                        <button id="submitConfig" type="button" class="pure-button pure-button-primary" onclick="Reset()" disabled = "disabled">
                            Сохранить
                        </button>
                        <button id="currentConfig" type="button" class="pure-button pure-button-primary" onclick="Reset()">
                            Текущая конфигурация
                        </button>
                    </td>
                </tr>
            </table>
            <hr>
            <br>
        </fieldset>
    </form>
</div>
</body>
</html>
