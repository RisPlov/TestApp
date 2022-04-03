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
package Application.Windows;

import Application.Commands.Authentication.Cancel;
import Application.Commands.Authentication.Ok;

import javax.swing.*;

public class WindowAuthentication extends JFrame {

    public static JLabel logLabel = new JLabel("Введите логин: ");/// указание ввода  логина
    public static JLabel passLabel = new JLabel("Введите пароль: ");/// указание ввода пароля
    public static final JTextField login = new JTextField(12);///  текстовое поле логина
    public static final JPasswordField password = new JPasswordField(12);///текстовое поле пароля
    public static JButton ok = new JButton("OK ");/// кнопка ок
    public static JButton cancel = new JButton("Cancel ");/// конпка отмена
    public static final JLabel mistake = new JLabel(" ");/// текстовое поле сообщающее об ошибке


    public WindowAuthentication() {
        super("Employee accounting"); //Заголовок окна
        setBounds(600, 400, 600, 400);//размер и положение
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //это нужно для того чтобы при закрытии окна закрывалась и программа, иначе она останется висеть в процессах
        logLabel.setSize(150, 100);
        logLabel.setLocation(20, 40);
        passLabel.setSize(150, 100);
        passLabel.setLocation(20, 100);
        login.setSize(150, 25);
        login.setLocation(300, 80);
        password.setEchoChar('*');
        password.setSize(150, 25);
        password.setLocation(300, 140);
        ok.setSize(60, 30);
        ok.setLocation(300, 200);
        cancel.setSize(100, 30);
        cancel.setLocation(400, 200);
        mistake.setSize(300, 30);
        mistake.setLocation(200, 250);
        JPanel contents = new JPanel(null);
        contents.add(passLabel);
        contents.add(logLabel);
        contents.add(password);
        contents.add(login);
        contents.add(ok);
        contents.add(cancel);
        contents.add(mistake);
        setContentPane(contents);//// создание окна со всеми элементами

    }
    public static Ok OK = new Ok();
    public static Cancel CANCEL = new Cancel();
}