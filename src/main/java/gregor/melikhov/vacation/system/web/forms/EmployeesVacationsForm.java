package gregor.melikhov.vacation.system.web.forms;

import gregor.melikhov.vacation.system.model.Employee;
import gregor.melikhov.vacation.system.model.Vacation;

import java.util.List;

public class EmployeesVacationsForm {
    private List<Vacation> vacations;
    private Employee employee;

    public List<Vacation> getVacations() {
        return vacations;
    }

    public void setVacations(List<Vacation> vacations) {
        this.vacations = vacations;
        employee = !vacations.isEmpty() ? vacations.get(0).getEmployee() : null;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
