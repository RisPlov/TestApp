package Application.Commands.Menu.ReportGeneration;

import Application.EmployeeAccounting;
import Application.Windows.WindowMenu;
import Application.Windows.WindowReportGeneration;

public class ReportGeneration extends WindowReportGeneration {
    public void ButtonWindowReportGeneration(){
        WindowMenu.fo.addActionListener(e -> {
            EmployeeAccounting.app4.setVisible(true);
            EmployeeAccounting.app2.setVisible(false);
        });
    }
}
