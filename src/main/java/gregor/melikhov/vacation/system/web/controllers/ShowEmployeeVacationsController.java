package gregor.melikhov.vacation.system.web.controllers;

import gregor.melikhov.vacation.system.db.EmployeeDAO;
import gregor.melikhov.vacation.system.model.Vacation;
import gregor.melikhov.vacation.system.web.forms.EmployeesVacationsForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ShowEmployeeVacationsController {
    @Autowired
    private EmployeeDAO employeeDAO;

    @GetMapping(path = "vacations/employee")
    public String getEmployeesVacationForm(ModelMap model, @RequestParam String login) {

        List<Vacation> vacations = employeeDAO.findVacationsByEmployee(employeeDAO.findEmployeeByLogin(login));

        EmployeesVacationsForm employeesVacationsForm = new EmployeesVacationsForm();
        employeesVacationsForm.setVacations(vacations);

        model.addAttribute("employeesVacationsForm", employeesVacationsForm);

        return "employeesVacations";
    }
}
