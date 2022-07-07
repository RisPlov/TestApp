package Application.Commands.Menu.ChangingData;

import Application.EmployeeAccounting;
import Application.Windows.WindowsCgengingData.WindowChangingData;

public class BackCD extends WindowChangingData {
    public void ButtonBackCD(){
        WindowChangingData.back.addActionListener(e ->{
            EmployeeAccounting.app2.setVisible(true);
            EmployeeAccounting.app5.setVisible(false);
        });
    }
}
