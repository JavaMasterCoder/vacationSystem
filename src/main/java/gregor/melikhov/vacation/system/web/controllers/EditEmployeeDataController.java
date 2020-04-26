package gregor.melikhov.vacation.system.web.controllers;

import gregor.melikhov.vacation.system.db.EmployeeDAO;
import gregor.melikhov.vacation.system.model.Employee;
import gregor.melikhov.vacation.system.web.forms.EditEmployeeForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;

@Controller
public class EditEmployeeDataController {
    @Autowired
    private EmployeeDAO employeeDAO;

    @GetMapping(path = "employee/edit")
    public String getEditEmployeeForm(ModelMap model, @RequestParam String login) {
        Employee employeeToEdit = employeeDAO.findEmployeeByLogin(login);

        EditEmployeeForm form = new EditEmployeeForm();
        form.setId(employeeToEdit.getId());
        form.setFIO(employeeToEdit.getFIO());
        form.setBirthDate(employeeToEdit.getBirthDate());
        form.setPersonalNumber(employeeToEdit.getPersonalNumber());
        form.setPost(employeeToEdit.getPost());
        form.setDateOfStartWorking(employeeToEdit.getDateOfStartWorking());
        form.setLogin(employeeToEdit.getLogin());
        form.setPassword(employeeToEdit.getPassword());

        model.addAttribute("form", form);

        return "editEmployeeData";
    }

    @PostMapping(path = "employee/edit")
    public String processEditForm(@RequestParam(value = "id") Integer id,
                                  @RequestParam String FIO,
                                  @RequestParam Date birthDate,
                                  @RequestParam Integer personalNumber,
                                  @RequestParam String post,
                                  @RequestParam Date dateOfStartWorking,
                                  @RequestParam String login,
                                  @RequestParam String password) {

        if (id == null) {
            return "redirect:/";
        }

        Employee editedEmployee = employeeDAO.findEmployeeById(id);
        editedEmployee.setFIO(FIO);
        editedEmployee.setBirthDate(birthDate);
        editedEmployee.setPersonalNumber(personalNumber);
        editedEmployee.setPost(post);
        editedEmployee.setDateOfStartWorking(dateOfStartWorking);
        editedEmployee.setLogin(login);
        editedEmployee.setPassword(password);

        employeeDAO.updateEditedEmployee(editedEmployee);

        return "redirect:/employee/all";
    }
}
