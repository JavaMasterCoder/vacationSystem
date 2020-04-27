package gregor.melikhov.vacation.system.web.controllers;

import gregor.melikhov.vacation.system.db.EmployeeDAO;
import gregor.melikhov.vacation.system.model.Employee;
import gregor.melikhov.vacation.system.web.forms.AllEmployeesForm;
import gregor.melikhov.vacation.system.web.forms.ExcelEmployees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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

    @GetMapping(path = "employee/all/downloadFile")
    public ModelAndView downloadFile() {
        List<Employee> employees = employeeDAO.findAllEmployees();

        return new ModelAndView(new ExcelEmployees(), "employees", employees);
    }

    @PostMapping(path = "employee/all/signIn")
    public String signIn(@RequestParam String login,
                         @RequestParam String password) {
        Employee employeeByLogin = employeeDAO.findEmployeeByLogin(login);

        if (employeeByLogin != null && employeeByLogin.getPassword().equals(password)) {
            return "redirect:/employee/all";
        }

        return "redirect:/";
    }
}
