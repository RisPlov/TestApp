import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Window_authentication extends JFrame {

    public static JLabel logLabel = new JLabel("Введите логин: ");/// указание ввода  логина
    public static JLabel passLabel = new JLabel("Введите пароль: ");/// указание ввода пароля
    public static final JTextField login = new JTextField(12);///  текстовое поле логина
    public static final JPasswordField password = new JPasswordField(12);///текстовое поле пароля
    public static JButton ok = new JButton("OK ");/// кнопка ок
    public static JButton cancel = new JButton("Cancel ");/// конпка отмена
    public static final JTextField mistake = new JTextField(" ");/// текстовое поле сообщающее об ошибке

    Window_authentication() {
        super("My database"); //Заголовок окна
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
    static class Logical extends Window_authentication{
    public void ButtonOK() {
        Window_authentication.ok.addActionListener(e -> {
            String log = Window_authentication.login.getText();
            char[] p = Window_authentication.password.getPassword();
            String pa = String.valueOf(p);
            int pas = Integer.parseInt(pa);

            try (Connection conn = DriverManager.getConnection(Database_client.URL, Database_client.USER_NAME, Database_client.PASSWORD)) {
                System.out.println("Connection to Store DB successfully!");

                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
                String login = null;
                int password = 0;
                while (resultSet.next()) {
                    login = resultSet.getString(2);
                    password = resultSet.getInt(3);
                    if (log.equals(login) & (pas == password)) {
                        Window_authentication.mistake.setText("Добро пожаловать!");
                        break;
                    }
                }
                if (log.equals(login) & (pas == password)) {Test_application.app2.setVisible(true);
                Test_application.app1.setVisible(false);}
                else if (!log.equals(login) | (pas != password)) {
                    Window_authentication.mistake.setText("Данные введены не верно, попробуйте еще раз.");
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
    public void ButtonCANCEL(){
            Window_authentication.cancel.addActionListener(e -> System.exit(0));
        }
    }
    static Logical OK = new Logical();
    static Logical CANCEL = new Logical();
}