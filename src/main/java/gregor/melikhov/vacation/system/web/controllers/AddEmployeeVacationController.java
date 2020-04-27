package gregor.melikhov.vacation.system.web.controllers;

import gregor.melikhov.vacation.system.db.EmployeeDAO;
import gregor.melikhov.vacation.system.model.Employee;
import gregor.melikhov.vacation.system.model.Vacation;
import gregor.melikhov.vacation.system.web.forms.AddVacationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;

@Controller
public class AddEmployeeVacationController {
    @Autowired
    private EmployeeDAO employeeDAO;

    @GetMapping(path = "vacation/employee/addVacation")
    public String showForm(ModelMap model, @RequestParam String login) {
        AddVacationForm addVacationForm = new AddVacationForm();
        addVacationForm.setLogin(login);

        model.addAttribute("addVacationForm", addVacationForm);

        return "addEmployeeVacation";
    }



    @PostMapping(path = "vacation/employee/addVacation")
    public String addVacation(ModelMap model, @RequestParam String login,
                              @RequestParam Date vacationStartDate,
                              @RequestParam Date vacationEndDate) {
        if (vacationStartDate.getTime() > vacationEndDate.getTime()) {
            AddVacationForm addVacationForm = new AddVacationForm();
            addVacationForm.setLogin(login);
            addVacationForm.setError(true);

            model.addAttribute("addVacationForm", addVacationForm);

            return "addEmployeeVacation";
        }

        Employee employee = employeeDAO.findEmployeeByLogin(login);
        Vacation newVacation = new Vacation(employee, vacationStartDate, vacationEndDate);

        employeeDAO.addVacation(newVacation);

        return "redirect:/vacations/employee?login=" + login;
    }
}
