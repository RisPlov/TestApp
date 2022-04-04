/*
 * %W% %E% Имя Фамилия
 *
 * Копирайт (c) 1993-1996 Sun Microsystems, Inc. Все права защищены.
 *
 * Это программное обеспечение является конфиденциальной и закрытой информацией Sun
 * Microsystems, Inc. («Конфиденциальная информация»). Вы не должены
 * раскрывать такую Конфиденциальную информацию и использовать ее только в
 * соответствии с условиями лицензионного соглашения, в которых вы состоите
 * с Sun.
 *
 * SUN НЕ ДАЁТ НИКАКИХ ГАРАНТИЙ, ЯВНЫХ ИЛИ КОСВЕННЫХ (ВКЛЮЧАЯ - НО НЕ
 * ОГРАНИЧИВАЯСЬ ИМИ - ГАРАНТИИ РЕАЛИЗУЕМОСТИ), СООТВЕТСТВИЯ ОПРЕДЕЛЁННОМУ
 * НАЗНАЧЕНИЮ ИЛИ НЕНАРУШЕНИЯ УСЛОВИЙ, ЧТО СОДЕРЖИМОЕ ДАННОЙ СПЕЦИФИКАЦИИ
 * ПОДХОДИТ ДЛЯ КАКИХ-ЛИБО ЦЕЛЕЙ ИЛИ ЧТО ЛЮБОЕ ИСПОЛЬЗОВАНИЕ ИЛИ РЕАЛИЗАЦИЯ
 * ТАКОГО СОДЕРЖИМОГО НЕ БУДЕТ НАРУШАТЬ КАКИХ-ЛИБО ПАТЕНТОВ ТРЕТЬЕЙ СТОРОНЫ,
 * АВТОРСКИХ ПРАВ, КОММЕРЧЕСКОЙ ТАЙНЫ ИЛИ ИНЫХ ПРАВ.
 */
package Application.Commands.Authentication;

import Application.DatabaseСlient;

import Application.EmployeeAccounting;
import Application.Windows.WindowAuthentication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Ok extends WindowAuthentication {
    public final Logger logs = LoggerFactory.getLogger(Ok.class);
    public void ButtonOK() {//конструктор кнопки OK
        WindowAuthentication.ok.addActionListener(e -> {
            try {
                String Login = WindowAuthentication.login.getText();
                char[] p = WindowAuthentication.password.getPassword();
                String pa = String.valueOf(p);
                int pas = Integer.parseInt(pa);

                Connection Coon = DatabaseСlient.StartConnection();
                Statement statement = Coon.createStatement();

                ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
                String login = null;
                int password = 0;
                while (resultSet.next()) {
                    login = resultSet.getString(2);
                    password = resultSet.getInt(3);
                    if (Login.equals(login) & (pas == password)) {
                        EmployeeAccounting.app2.setVisible(true);
                        EmployeeAccounting.app1.setVisible(false);
                        logs.info("Приложение запущено! Пользователь: "+Login);
                        break;
                    }else if (!Login.equals(login) | (pas != password)) {
                        mistake.setText("Данные введены не верно, попробуйте еще раз!");
                        logs.info("Данные введены не верно, попробуйте еще раз! Пароль: "+pas+" Логин: "+Login);
                        Coon.close();
                    }
                }
            } catch (Exception ex) {
                mistake.setText("Данные введены не верно, попробуйте еще раз!");
                logs.info("Данные введены не верно, попробуйте еще раз!");
            }
        });
    }
}
