package gregor.melikhov.vacation.system.web.controllers;

import gregor.melikhov.vacation.system.db.EmployeeDAO;
import gregor.melikhov.vacation.system.model.Vacation;
import gregor.melikhov.vacation.system.web.forms.AllVacationsForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
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

        model.addAttribute("allVacationsForm", allVacationsForm);
        return "allVacations";
    }

    @PostMapping(path = "vacations/all/sortByEmployees")
    public String sortByEmployees(ModelMap model) {
        List<Vacation> allVacations = employeeDAO.findAllVacations();

        AllVacationsForm allVacationsForm = new AllVacationsForm(allVacations, false);

        model.addAttribute("allVacationsForm", allVacationsForm);

        return "allVacations";
    }

    @PostMapping(path = "vacations/all/sortByPeriod")
    public String sortByPeriod(ModelMap model) {
        List<Vacation> allVacations = employeeDAO.findAllVacations();

        AllVacationsForm allVacationsForm = new AllVacationsForm(allVacations, true);

        model.addAttribute("allVacationsForm", allVacationsForm);

        return "allVacations";
    }

    @PostMapping(path = "vacations/all/sortByEmployee")
    public String sortByEmployee(ModelMap model, @RequestParam String FIO) {
        List<Vacation> allVacations = employeeDAO.findAllVacations();

        AllVacationsForm allVacationsForm = new AllVacationsForm(allVacations, FIO);

        model.addAttribute("allVacationsForm", allVacationsForm);

        return "allVacations";
    }

    @PostMapping(path = "vacations/all/sortBySpecifiedPeriod")
    public String sortBySpecifiedPeriod(ModelMap model,
                                        @RequestParam Date startOfPeriod,
                                        @RequestParam Date endOfPeriod) {
        List<Vacation> allVacations = employeeDAO.findAllVacations();

        AllVacationsForm allVacationsForm = new AllVacationsForm(allVacations, startOfPeriod, endOfPeriod);

        model.addAttribute("allVacationsForm", allVacationsForm);

        return "allVacations";
    }
}
