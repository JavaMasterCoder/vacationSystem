package gregor.melikhov.vacation.system.web.forms;

import gregor.melikhov.vacation.system.model.Employee;
import gregor.melikhov.vacation.system.model.Vacation;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.util.List;
import java.util.Map;

public class ExcelEmployees extends AbstractXlsView {

    @Override
    protected void buildExcelDocument(Map<String, Object> map, Workbook workbook,
                            HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setHeader("Content-disposition", "attachment; filename=\"employees_file.xls\"");

        List<Employee> employees = (List<Employee>) map.get("employees");

        Sheet sheet = workbook.createSheet("Employees");

        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("Id");
        header.createCell(1).setCellValue("ФИО");
        header.createCell(2).setCellValue("Дата начала отпуска");
        header.createCell(3).setCellValue("Дата окончания отпуска");
        header.createCell(4).setCellValue("Дней в отпуске");

        int rowNum = 1;

        for (Employee employee : employees) {
            for (Vacation vacation : employee.getVacations()) {
                Date vacationStartDate = vacation.getVacationStartDate();
                Date vacationEndDate = vacation.getVacationEndDate();

                String vacationStart = vacationStartDate.toString();
                String vacationEnd = vacationEndDate.toString();

                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(employee.getId());
                row.createCell(1).setCellValue(employee.getFIO());
                row.createCell(2).setCellValue(vacationStart);
                row.createCell(3).setCellValue(vacationEnd);

                long days = (vacationEndDate.getTime() - vacationStartDate.getTime()) / (24 * 60 * 60 * 1000);

                row.createCell(4).setCellValue(days);
            }
        }
    }
}
