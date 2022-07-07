package Application.Commands.Menu.ChangingData;


import Application.EmployeeAccounting;
import Application.Windows.WindowMenu;

public class ChangingData extends WindowMenu {
    public void ButtonChangingData(){
        WindowMenu.rd.addActionListener(e ->{
            EmployeeAccounting.app5.setVisible(true);
            EmployeeAccounting.app2.setVisible(false);
        });
    }
}
