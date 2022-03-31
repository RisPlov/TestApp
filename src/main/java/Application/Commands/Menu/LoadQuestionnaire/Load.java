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

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Load extends WindowUploadQuestionnaire {
    public static final Logger LOGGER = LoggerFactory.getLogger(Load.class);
    public void ButtonLoad(){
        WindowUploadQuestionnaire.load.addActionListener(e -> {
            FileInputStream file = null;
            try {
                file = new FileInputStream("C:\\Users\\Admin\\IdeaProjects\\ApplicationEmployeeAccounting\\src\\main\\resources\\Анкета.xls");
                HSSFWorkbook WB = new HSSFWorkbook(file);
                String motor = WB.getSheetAt(0).getRow(1).getCell(0).getStringCellValue();////читаем номер двигателя из файла
                System.out.println(motor);
                LOGGER.info("Test log record!!!");
            } catch (IOException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
                LOGGER.error("В программе возникла ошибка!");
            }

        });
    }

}
