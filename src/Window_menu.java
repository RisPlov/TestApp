import javax.swing.*;

public class Window_menu extends JFrame {

    static JButton dw = new JButton("Загрузить данные ");/// кнопка "загрузить данные"
    static JButton fo = new JButton("Формирование отчета ");/// кнопка "формирование отчета"
    static JButton rd = new JButton("Изменение данных ");/// кнопка "изменение данных"
    static JButton pi = new JButton("Просмотр информации ");/// кнопка "просмотр информации"
    static JButton ex = new JButton("Выход ");/// скнопка "выход"

        Window_menu(){
            super("Меню"); //Заголовок окна
            setBounds(600, 400, 600, 400);//размер и положение
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //это нужно для того чтобы при закрытии окна закрывалась и программа, иначе она останется висеть в процессах
            dw.setSize(200, 30);
            dw.setLocation(200, 50);
            fo.setSize(200, 30);
            fo.setLocation(200, 100);
            rd.setSize(200, 30);
            rd.setLocation(200, 150);
            pi.setSize(200, 30);
            pi.setLocation(200, 200);
            ex.setSize(200, 30);
            ex.setLocation(200, 250);
            JPanel contents = new JPanel(null);
            contents.add(dw);
            contents.add(fo);
            contents.add(rd);
            contents.add(pi);
            contents.add(ex);
            setContentPane(contents);
        }
}
