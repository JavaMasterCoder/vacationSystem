package gregor.melikhov.vacation.system.web.controllers;

import gregor.melikhov.vacation.system.db.EmployeeDAO;
import gregor.melikhov.vacation.system.model.Vacation;
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

        List<Vacation> vacationsByEmployee = employeeDAO.findVacationsByEmployee(employeeDAO.findEmployeeByLogin(login));

        System.out.println("stop");

        return "employeesVacations";

    }
}
