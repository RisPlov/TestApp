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

import Application.Commands.Menu.ChangingData.CreateEmployee.BackCreateEmployee;
import Application.Commands.Menu.ChangingData.CreateEmployee.Create;

import javax.swing.*;

public class WindowCreateEmployee extends JFrame {

    public static JLabel sureName = new JLabel("Введите фамилию сотрудника");
    public static JLabel name = new JLabel("Введите имя сотрудника");
    public static final JTextField sureNameText = new JTextField(12);
    public static final JTextField nameText = new JTextField(12);
    public static JLabel age = new JLabel("Введите возраст сотрудника");
    public static JLabel post = new JLabel("Введите должность сотрудника");
    public static final JTextField ageText = new JTextField(12);
    public static final JTextField postText = new JTextField(12);
    public static JLabel salary = new JLabel("Введите зарплату сотрудника");
    public static JLabel premium = new JLabel("Введите премию сотрудника");
    public static final JTextField salaryText = new JTextField(12);
    public static final JTextField premiumText = new JTextField(12);
    public static JLabel hired = new JLabel("Введите дату приема сотрудника на работу");
    public static final JTextField hiredText = new JTextField(12);
    public static JLabel info = new JLabel("");
    public static JButton create = new JButton("Создать ");
    public static JButton back = new JButton("Назад ");

    public WindowCreateEmployee(){
        super("Добавить данные о новом сотруднике"); //Заголовок окна
        setBounds(400, 300, 800, 600);//размер и положение
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //это нужно для того чтобы при закрытии окна закрывалась и программа, иначе она останется висеть в процессах
        sureName.setSize(200, 30);
        sureName.setLocation(100, 50);
        sureNameText.setSize(200, 30);
        sureNameText.setLocation(100, 100);
        name.setSize(200, 30);
        name.setLocation(500, 50);
        nameText.setSize(200, 30);
        nameText.setLocation(500, 100);
        age.setSize(200, 30);
        age.setLocation(100, 150);
        ageText.setSize(200, 30);
        ageText.setLocation(100, 200);
        post.setSize(200, 30);
        post.setLocation(500, 150);
        postText.setSize(200, 30);
        postText.setLocation(500, 200);
        salary.setSize(200, 30);
        salary.setLocation(100, 250);
        salaryText.setSize(200, 30);
        salaryText.setLocation(100, 300);
        premium.setSize(200, 30);
        premium.setLocation(500, 250);
        premiumText.setSize(200, 30);
        premiumText.setLocation(500, 300);

        hired.setSize(300, 30);
        hired.setLocation(500, 350);
        hiredText.setSize(200, 30);
        hiredText.setLocation(500, 400);

        info.setSize(300, 30);
        info.setLocation(100, 400);
        create.setSize(200, 30);
        create.setLocation(100, 500);
        back.setSize(200, 30);
        back.setLocation(500, 500);
        JPanel contents = new JPanel(null);
        contents.add(sureName);
        contents.add(name);
        contents.add(sureNameText);
        contents.add(nameText);
        contents.add(age);
        contents.add(ageText);
        contents.add(post);
        contents.add(postText);
        contents.add(salary);
        contents.add(salaryText);
        contents.add(premium);
        contents.add(premiumText);
        contents.add(hired);
        contents.add(hiredText);
        contents.add(info);
        contents.add(create);
        contents.add(back);
        setContentPane(contents);
    }
    public static BackCreateEmployee backWindowCreateEmployee = new BackCreateEmployee();
    public static Create createElement = new Create();
}
