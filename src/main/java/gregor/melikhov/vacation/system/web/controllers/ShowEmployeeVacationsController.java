package gregor.melikhov.vacation.system.web.controllers;

import gregor.melikhov.vacation.system.db.EmployeeDAO;
import gregor.melikhov.vacation.system.model.Employee;
import gregor.melikhov.vacation.system.model.Vacation;
import gregor.melikhov.vacation.system.web.forms.EmployeesVacationsForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
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

    @PostMapping(path = "vacations/employee/deleteVacation")
    public String deleteVacation(ModelMap model, @RequestParam Integer vacId,
                                 @RequestParam String login) {

        employeeDAO.removeVacation(employeeDAO.findVacationById(vacId));

        EmployeesVacationsForm employeesVacationsForm = new EmployeesVacationsForm();
        employeesVacationsForm.setVacations(employeeDAO.findVacationsByEmployee(employeeDAO.findEmployeeByLogin(login)));

        model.addAttribute("employeesVacationsForm", employeesVacationsForm);

        return "employeesVacations";
    }
}
