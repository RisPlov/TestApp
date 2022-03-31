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

import Application.Commands.Menu.LoadQuestionnaire.Load;

import javax.swing.*;

public class WindowUploadQuestionnaire extends JFrame {
    static JLabel aq = new JLabel("Введите адрес анкеты: ");/// указание ввода  адреса файла
    static final JTextField aft = new JTextField(120);/// текстовое поле адреса файла
    public static JButton load = new JButton("Загрузить ");///  кнопка "загрузить"
    static JButton exz = new JButton("Назад ");/// кнопка "назад"

    public WindowUploadQuestionnaire(){
        super("Загрузка данных"); //Заголовок окна
        setBounds(600, 400, 600, 400);//размер и положение
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //это нужно для того чтобы при закрытии окна закрывалась и программа, иначе она останется висеть в процессах
        aq.setSize(200, 30);
        aq.setLocation(200, 150);
        aft.setSize(200, 30);
        aft.setLocation(200, 200);
        load.setSize(200, 30);
        load.setLocation(200, 250);
        exz.setSize(200, 30);
        exz.setLocation(200, 300);
        JPanel contents = new JPanel(null);
        contents.add(aq);
        contents.add(aft);
        contents.add(load);
        contents.add(exz);
        setContentPane(contents);
    }
    public static Load LOAD = new Load();
}
