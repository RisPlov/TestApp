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
package Application.Commands.Menu.ReportGeneration;

import Application.DatabaseClient;
import Application.Windows.WindowReportGeneration;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.FileOutputStream;
import java.sql.*;

public class Report extends WindowReportGeneration {
    private final Logger logs = LoggerFactory.getLogger(Report.class);
    private boolean coincidence = false;
    private String SurnameDB;
    private boolean Dismissal = true;

    public void ButtonReport(){
        WindowReportGeneration.report.addActionListener(e -> {
            try {
                String SurnameTextPlace = WindowReportGeneration.TextPlace.getText();
                Connection Coon = DatabaseClient.StartConnection();
                Statement statement = Coon.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM staff");
                while (resultSet.next()){
                    SurnameDB = resultSet.getString(2);
                    if (SurnameTextPlace.equals(SurnameDB)){
                        HSSFWorkbook workbook = new HSSFWorkbook();
                        HSSFSheet sheet = workbook.createSheet("Анкета_"+SurnameDB);
                        coincidence = true;
                        ResultSetMetaData data = resultSet.getMetaData();
                        HSSFRow RowSurname = sheet.createRow(0);
                        RowSurname.createCell(0).setCellValue(data.getColumnName(2));
                        RowSurname.createCell(1).setCellValue(SurnameDB);
                        HSSFRow RowName = sheet.createRow(1);
                        RowName.createCell(0).setCellValue(data.getColumnName(3));
                        RowName.createCell(1).setCellValue(resultSet.getString(3));
                        HSSFRow RowAge = sheet.createRow(2);
                        RowAge.createCell(0).setCellValue(data.getColumnName(4));
                        RowAge.createCell(1).setCellValue(resultSet.getInt(4));
                        HSSFRow RowPost = sheet.createRow(3);
                        RowPost.createCell(0).setCellValue(data.getColumnName(5));
                        RowPost.createCell(1).setCellValue(resultSet.getString(5));
                        HSSFRow RowSalary = sheet.createRow(4);
                        RowSalary.createCell(0).setCellValue(data.getColumnName(6));
                        RowSalary.createCell(1).setCellValue(resultSet.getInt(6));
                        HSSFRow RowPremium = sheet.createRow(5);
                        RowPremium.createCell(0).setCellValue(data.getColumnName(7));
                        RowPremium.createCell(1).setCellValue(resultSet.getInt(7));
                        HSSFRow RowHired = sheet.createRow(6);
                        RowHired.createCell(0).setCellValue(data.getColumnName(8));
                        Cell Hired =  RowHired.createCell(1);
                        DataFormat format = workbook.createDataFormat();
                        CellStyle dateStyle = workbook.createCellStyle();
                        dateStyle.setDataFormat(format.getFormat("yyyy-MM-dd"));
                        Hired.setCellStyle(dateStyle);
                        Hired.setCellValue(resultSet.getDate(8));
                        Dismissal = resultSet.getBoolean(9);
                        if (!Dismissal){
                            HSSFRow RowDateOfDismissal = sheet.createRow(7);
                            RowDateOfDismissal.createCell(0).setCellValue(data.getColumnName(10));
                            Cell DateOfDismissal = RowDateOfDismissal.createCell(1);
                            DateOfDismissal.setCellStyle(dateStyle);
                            DateOfDismissal.setCellValue(resultSet.getDate(10));
                        }
                        sheet.autoSizeColumn(0);
                        sheet.autoSizeColumn(1);
                        FileOutputStream fileOut = new FileOutputStream("Анкета_"+SurnameDB+".xls");
                        workbook.write(fileOut);
                        fileOut.close();
                        break;
                    }
                }
                text.setText("Отчет сформирован!");
                TextPlace.setText("");
                if (!coincidence){
                    text.setText("Данные введены не верно!");
                    logs.info("Данные введены не верно! Фамилия " + SurnameTextPlace);
                }
            } catch (Exception ex){
                logs.error("", ex);
            }
                }
        );
    }
}
