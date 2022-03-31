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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Ok extends WindowAuthentication {
    public void ButtonOK() {//конструктор кнопки OK
        WindowAuthentication.ok.addActionListener(e -> {
            String log = WindowAuthentication.login.getText();
            char[] p = WindowAuthentication.password.getPassword();
            String pa = String.valueOf(p);
            int pas = Integer.parseInt(pa);

            try (Connection conn = DriverManager.getConnection(
                    DatabaseСlient.URL,
                    DatabaseСlient.USER_NAME,
                    DatabaseСlient.PASSWORD)){
                System.out.println("Connection to Store DB successfully!");

                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
                String login = null;
                int password = 0;
                while (resultSet.next()) {
                    login = resultSet.getString(2);
                    password = resultSet.getInt(3);
                    if (log.equals(login) & (pas == password)) {
                        WindowAuthentication.mistake.setText("Добро пожаловать!");
                        break;
                    }
                }
                if (log.equals(login) & (pas == password)) {
                    EmployeeAccounting.app2.setVisible(true);
                    EmployeeAccounting.app1.setVisible(false);
                } else if (!log.equals(login) | (pas != password)) {
                    WindowAuthentication.mistake.setText("Данные введены не верно, попробуйте еще раз.");
                    conn.close();
                   /* String sql = "SELECT * FROM users;";
                    statement.execute(sql);
                    final ResultSet rs = statement.getResultSet();
                    while (rs.next()) {
                        int userid = rs.getInt(1);
                        String x = rs.getString(2);
                        String y = rs.getString(3);
                        System.out.printf("id: %d, name: %s, author: %s %n", userid, x, y);
                    }*/
                }
            } catch (Exception ex) {
                System.out.println("Connection failed!!!!..");
            }
        });
    }
}
