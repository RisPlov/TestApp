package Application.Windows;

import javax.swing.*;

public class WindowReportGeneration extends JFrame {
    static JLabel nd1 = new JLabel("Введите номер двигателя");/// указание ввода  номера двигателя
    static final JTextField motonom = new JTextField(12);/// текстовое поле номера двигателя
    static JButton form = new JButton("Сформировать ");/// кнопка "сформировать"
    static JButton exz1 = new JButton("Назад ");/// кнопка "назад"


    public WindowReportGeneration(){
        super("Формирование отчета"); //Заголовок окна
        setBounds(600, 400, 600, 400);//размер и положение
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //это нужно для того чтобы при закрытии окна закрывалась и программа, иначе она останется висеть в процессах
        nd1.setSize(200, 30);
        nd1.setLocation(200, 50);
        motonom.setSize(200, 30);
        motonom.setLocation(200, 100);
        form.setSize(200, 30);
        form.setLocation(200, 150);
        exz1.setSize(200, 30);
        exz1.setLocation(200, 300);
        JPanel contents = new JPanel(null);
        contents.add(nd1);
        contents.add(motonom);
        contents.add(form);
        contents.add(exz1);
        setContentPane(contents);
    }

}
