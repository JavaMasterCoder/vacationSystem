package gregor.melikhov.vacation.system.web.forms;

import gregor.melikhov.vacation.system.model.Employee;

import java.util.List;

public class AllEmployeesForm {
    private List<Employee> employees;

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
