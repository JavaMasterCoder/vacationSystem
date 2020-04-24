package gregor.melikhov.vacation.system.db;

import com.sun.istack.Nullable;
import gregor.melikhov.vacation.system.model.Employee;
import gregor.melikhov.vacation.system.model.Vacation;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class EmployeeDAO {
    private EntityManager manager;

    public EmployeeDAO(EntityManager manager) {
        Objects.requireNonNull(manager, "EntityManager cannot be null");
        this.manager = manager;
    }

    @Nullable
    public Employee findEmployeeByLogin(String login) {
        try {
            return manager.createQuery("SELECT e from Employee e WHERE e.login = :loginToSearch", Employee.class)
                    .setParameter("loginToSearch", login)
                    .getSingleResult();
        } catch (NoResultException cause) {
            return null;
        }
    }

    public boolean addVacation(Employee employee, Date vacationStartDate, Date vacationEndDate) {
        Vacation vacation = new Vacation(employee, vacationStartDate, vacationEndDate);
        return employee.addVacationToList(vacation);
    }

    @Nullable
    public List<Vacation> findVacationsByEmployee(Employee employee) {
        try {
            return manager.createQuery("SELECT v from Vacation v WHERE employee.id= :employeeId", Vacation.class)
                    .setParameter("employeeId", employee.getId())
                    .getResultList();
        } catch (NoResultException cause) {
            return null;
        }
    }

}
