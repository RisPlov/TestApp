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
package Application.Commands.Menu.LoadQuestionnaire;

import Application.Windows.WindowUploadQuestionnaire;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Load  extends WindowUploadQuestionnaire{
    private final Logger logs = LoggerFactory.getLogger(Load.class);
    public void ButtonLoad(){
        WindowUploadQuestionnaire.load.addActionListener(e -> {
            FileInputStream file;
            try {
                String Address = WindowUploadQuestionnaire.AddressText.getText();
                file = new FileInputStream(Address);
                //"C:\\Users\\Admin\\IdeaProjects\\ApplicationEmployeeAccounting\\src\\main\\resources\\Анкета.xls"
                HSSFWorkbook WB = new HSSFWorkbook(file);

                Date DataHired = WB.getSheetAt(0).getRow(6).getCell(1).getDateCellValue();////читаем дату из файла
                SimpleDateFormat YearMonthDay = new SimpleDateFormat("yyyy-MM-dd");
                String dataHired = YearMonthDay.format(DataHired);




                /*String p1 =  "`test_schema`.`staff`";
                String sql = ("INSERT INTO" +p1+ "(`surname`, `name`, `age`, `post`, `salary`, `premium`, `hired`) VALUES (?,?,?,?,?,?,?)");
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setString(1, motor);
                preparedStatement.setString(2, data);
                preparedStatement.setString(3, formatForDateNow.format(tame));
                preparedStatement.setString(4, String.valueOf(value));
                preparedStatement.executeUpdate();*/

                System.out.println(dataHired);
                logs.info("Test log record!!!");
            } catch (IOException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
                logs.error("Неверно указан адрес файла или файл имеет не верный формат!");
            }
        });
    }

}
