package gregor.melikhov.vacation.system.web.controllers;

import gregor.melikhov.vacation.system.db.EmployeeDAO;
import gregor.melikhov.vacation.system.model.Employee;
import gregor.melikhov.vacation.system.web.forms.AllEmployeesForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ShowAllEmployeesController {
    @Autowired
    private EmployeeDAO employeeDAO;

    @RequestMapping(path = "employee/all")
    public String getAllEmployeesData(ModelMap model) {
        List<Employee> employees = employeeDAO.findAllEmployees();

        AllEmployeesForm allEmployeesForm = new AllEmployeesForm();
        allEmployeesForm.setEmployees(employees);

        model.addAttribute("allEmployees", allEmployeesForm);

        return "allEmployees";
    }
}
