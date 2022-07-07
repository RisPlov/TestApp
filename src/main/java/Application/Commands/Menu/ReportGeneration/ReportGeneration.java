package Application.Commands.Menu.ReportGeneration;

import Application.EmployeeAccounting;
import Application.Windows.WindowMenu;

public class ReportGeneration extends WindowMenu {
    public void ButtonReportGeneration(){
        WindowMenu.fo.addActionListener(e -> {
            EmployeeAccounting.app4.setVisible(true);
            EmployeeAccounting.app2.setVisible(false);
        });
    }
}
