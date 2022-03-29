package Application.Commands;

import Application.Windows.WindowAuthentication;

public class Cancel extends WindowAuthentication {
    public void ButtonCANCEL(){//конструктор кнопки CANCEL
        WindowAuthentication.cancel.addActionListener(e -> System.exit(0));
    }
}
