package gregor.melikhov.vacation.system.web.controllers;

import gregor.melikhov.vacation.system.db.EmployeeDAO;
import gregor.melikhov.vacation.system.model.Employee;
import gregor.melikhov.vacation.system.web.forms.ExcelEmployees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class DownloadDocumentController {
    @Autowired
    private EmployeeDAO employeeDAO;

    @GetMapping(path = "/downloadFile")
    public ModelAndView downloadFile() {
        List<Employee> employees = employeeDAO.findAllEmployees();

        return new ModelAndView(new ExcelEmployees(), "employees", employees);
    }
}
