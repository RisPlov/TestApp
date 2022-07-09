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
package Application;

import Application.Windows.*;
import Application.Windows.WindowsCgengingData.WindowChangingData;
import Application.Windows.WindowsCgengingData.WindowCreateEmployee;


public class EmployeeAccounting {
    public static WindowAuthentication app1 = new WindowAuthentication();
    public static WindowMenu app2 = new WindowMenu();
    public static WindowUploadQuestionnaire app3 = new WindowUploadQuestionnaire();
    public static WindowReportGeneration app4 = new WindowReportGeneration();
    public static WindowChangingData app5 = new WindowChangingData();
    public static WindowCreateEmployee app6 = new WindowCreateEmployee();
    public static void main(String[] ars){
        app6.setVisible(true);
        WindowAuthentication.OK.ButtonOK();
        WindowAuthentication.CANCEL.ButtonCANCEL();
        WindowMenu.UQ.ButtonUploadQuestionnaire();
        WindowUploadQuestionnaire.LOAD.ButtonLoad();
        WindowUploadQuestionnaire.backWindowUploadQuestionnaire.ButtonBack();
        WindowMenu.reportGeneration.ButtonReportGeneration();
        WindowReportGeneration.REPORT.ButtonReport();
        WindowReportGeneration.backWindowReportGeneration.ButtonBackRG();
        WindowMenu.changingData.ButtonChangingData();
        WindowChangingData.backWindowChangingData.ButtonBackCD();
        WindowMenu.menuExit.ButtonExit();
        WindowChangingData.createEmployee.ButtonCreateEmployee();
        WindowCreateEmployee.backWindowCreateEmployee.ButtonBackCE();
        WindowCreateEmployee.createElement.ButtonCreate();
    }
}
