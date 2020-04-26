package gregor.melikhov.vacation.system.web.controllers;

import gregor.melikhov.vacation.system.db.EmployeeDAO;
import gregor.melikhov.vacation.system.model.Vacation;
import gregor.melikhov.vacation.system.web.forms.AllVacationsForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ShowAllVacationsController {
    @Autowired
    private EmployeeDAO employeeDAO;

    private static final String SORT_BY_PERIOD = "period";
    private static final String FORM_ATTRIBUTE = "allVacationsForm";

    @GetMapping(path = "vacations/all")
    public String getAllVacations(ModelMap model) {
        List<Vacation> allVacations = employeeDAO.findAllVacations();

        AllVacationsForm allVacationsForm = new AllVacationsForm();
        allVacationsForm.setAllVacations(allVacations);

        model.addAttribute(FORM_ATTRIBUTE, allVacationsForm);
        return "allVacations";
    }

    @GetMapping(path = "vacations/all?sortBy=")
    public String sortByEmployees(ModelMap model, @RequestParam String sortBy) {
        List<Vacation> allVacations = employeeDAO.findAllVacations();

        AllVacationsForm allVacationsForm;
        if (SORT_BY_PERIOD.equals(sortBy)) {
             allVacationsForm = new AllVacationsForm(allVacations, true);
        } else {
            allVacationsForm = new AllVacationsForm(allVacations, false);
        }

        model.addAttribute(FORM_ATTRIBUTE, allVacationsForm);

        return "allVacations";
    }

}
