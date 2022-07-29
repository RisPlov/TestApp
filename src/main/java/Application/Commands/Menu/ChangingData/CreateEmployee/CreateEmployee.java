
package Application.Commands.Menu.ChangingData.CreateEmployee;

import Application.EmployeeAccounting;
import Application.Windows.WindowsCgengingData.WindowChangingData;

public class CreateEmployee extends WindowChangingData {
    public void ButtonCreateEmployee(){
        WindowChangingData.rg.addActionListener(e -> {
            EmployeeAccounting.app6.setVisible(true);
            EmployeeAccounting.app5.setVisible(false);
        });
    }
}
