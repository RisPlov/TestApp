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
package Application.Windows.WindowsCgengingData;
import Application.Commands.Menu.ChangingData.BackCD;
import Application.Commands.Menu.ChangingData.CreateEmployee.CreateEmployee;
import javax.swing.*;

public class WindowChangingData extends JFrame {
    public static JButton rg = new JButton("Добавить сотрудника");
    public static JButton ed = new JButton("Изменить данные сотрудника");
    public static JButton del = new JButton("Удалить данные о сотруднике");
    public static JButton back = new JButton("Назад ");

    public WindowChangingData(){
        super("Изменение данных");
        setBounds(600, 400, 600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rg.setSize(400, 30);
        rg.setLocation(100, 50);
        ed.setSize(400, 30);
        ed.setLocation(100, 100);
        del.setSize(400, 30);
        del.setLocation(100, 150);
        back.setSize(200, 30);
        back.setLocation(200, 250);
        JPanel contents = new JPanel(null);
        contents.add(rg);
        contents.add(ed);
        contents.add(del);
        contents.add(back);
        setContentPane(contents);
    }
    public static CreateEmployee createEmployee = new CreateEmployee();
    public static BackCD backWindowChangingData = new BackCD();
}
