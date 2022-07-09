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
package Application.Commands.Menu.ChangingData.CreateEmployee;

import Application.DatabaseClient;
import Application.Windows.WindowsCgengingData.WindowCreateEmployee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Create extends WindowCreateEmployee {
    private final Logger logs = LoggerFactory.getLogger(Create.class);
    public void ButtonCreate(){
        WindowCreateEmployee.create.addActionListener(e -> {
            try {
                if (sureNameText.getText().equals("")||nameText.getText().equals("")||
                        ageText.getText().equals("")||postText.getText().equals("")||
                        salaryText.getText().equals("")||premiumText.getText().equals("")||
                        hiredText.getText().equals("")){
                    info.setText("Для загрузки анкеты введены не все данные!");
                    logs.error("Для загрузки анкеты введены не все данные!");
                }
                else {
                    String sureName = sureNameText.getText();
                    String name = nameText.getText();
                    Double age = Double.parseDouble(ageText.getText().trim());
                    String post = postText.getText();
                    Double salary = Double.parseDouble(salaryText.getText().trim());
                    Double premium = Double.parseDouble(premiumText.getText().trim());
                    String dataHired = hiredText.getText();

                    Connection Coon = DatabaseClient.StartConnection();
                    String p1 =  "`test_schema`.`staff`";
                    String sql = ("INSERT INTO" +p1+ "(`surname`, `name`, `age`, `post`, `salary`, `premium`, `hired`, `dismissed`) VALUES (?,?,?,?,?,?,?,?)");
                    PreparedStatement preparedStatement = Coon.prepareStatement(sql);
                    preparedStatement.setString(1, sureName);
                    preparedStatement.setString(2, name);
                    preparedStatement.setDouble(3, age);
                    preparedStatement.setString(4, post);
                    preparedStatement.setDouble(5, salary);
                    preparedStatement.setDouble(6, premium);
                    preparedStatement.setString(7, dataHired);
                    preparedStatement.setBoolean(8,true);
                    preparedStatement.executeUpdate();
                    logs.info("Анкета загружена!");
                    info.setText("Анкета загружена! Введите новый адрес!");
                }
            } catch (Exception ex) {
                logs.error("", ex);
            }
        });
    }
}
