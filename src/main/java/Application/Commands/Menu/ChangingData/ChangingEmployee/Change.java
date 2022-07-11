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
package Application.Commands.Menu.ChangingData.ChangingEmployee;

import Application.Windows.WindowsCgengingData.WindowChangingEmployee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Change extends WindowChangingEmployee {
    private final Logger logs = LoggerFactory.getLogger(Change.class);
    public void ButtonChange(){
        WindowChangingEmployee.change.addActionListener(e -> {
            try {
                if (sureNameText.getText().equals("")){
                    info.setText("Для загрузки анкеты введите фимилию!");
                    logs.error("Для загрузки анкеты введите фимилию!");
                }
                else {
                    String sureName = sureNameText.getText();
                    String name = nameText.getText();
                    Double age = Double.parseDouble(ageText.getText().trim());
                    String post = postText.getText();
                    Double salary = Double.parseDouble(salaryText.getText().trim());
                    Double premium = Double.parseDouble(premiumText.getText().trim());
                    String dataHired = hiredText.getText();
                    String dataDismissal = dismissalText.getText();
                }
            } catch (Exception ex) {
                logs.error("", ex);
            }
        });
    }
}
