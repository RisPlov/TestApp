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

import Application.Commands.Menu.ReportGeneration.BackRG;
import Application.Commands.Menu.ReportGeneration.Report;
import javax.swing.*;

public class WindowReportGeneration extends JFrame {
    public static JLabel text = new JLabel("Введите фамилию сотрудника");
    public static final JTextField TextPlace = new JTextField(12);
    public static JButton report = new JButton("Сформировать ");
    public static JButton back = new JButton("Назад ");

    public WindowReportGeneration(){
        super("Формирование отчета"); //Заголовок окна
        setBounds(600, 400, 600, 400);//размер и положение
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //это нужно для того чтобы при закрытии окна закрывалась и программа, иначе она останется висеть в процессах
        text.setSize(200, 30);
        text.setLocation(200, 50);
        TextPlace.setSize(200, 30);
        TextPlace.setLocation(200, 100);
        report.setSize(200, 30);
        report.setLocation(200, 150);
        back.setSize(200, 30);
        back.setLocation(200, 300);
        JPanel contents = new JPanel(null);
        contents.add(text);
        contents.add(TextPlace);
        contents.add(report);
        contents.add(back);
        setContentPane(contents);
    }
    public static BackRG backWindowReportGeneration = new BackRG();
    public static Report REPORT = new Report();
}
