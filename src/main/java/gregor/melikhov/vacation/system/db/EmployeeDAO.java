package gregor.melikhov.vacation.system.db;

import com.sun.istack.Nullable;
import gregor.melikhov.vacation.system.model.Employee;
import gregor.melikhov.vacation.system.model.Vacation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

@Repository
public class EmployeeDAO {
    private EntityManager manager;

    @Autowired
    public EmployeeDAO(EntityManager manager) {
        Objects.requireNonNull(manager, "EntityManager cannot be null");
        this.manager = manager;
    }

    @Nullable
    public Employee findEmployeeById(Integer id) {
        try {
            return manager.createQuery("SELECT e FROM Employee e WHERE e.id = :idToFind", Employee.class)
                    .setParameter("idToFind", id)
                    .getSingleResult();
        } catch (NoResultException cause) {
            return null;
        }
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

    @Nullable
    public List<Employee> findAllEmployees() {
        try {
            List<Employee> employees = manager.createQuery("FROM Employee").getResultList();
            return employees;
        } catch (NoResultException cause) {
            return null;
        }
    }

    @Nullable
    public List<Vacation> findAllVacations() {
        try {
            return manager.createQuery("FROM Vacation").getResultList();
        } catch (NoResultException cause) {
            return null;
        }
    }

    public void addVacation(Employee employee, Date vacationStartDate, Date vacationEndDate) {
        Vacation vacation = new Vacation(employee, vacationStartDate, vacationEndDate);

        manager.getTransaction().begin();
        manager.persist(vacation);
        manager.getTransaction().commit();
    }

    public void addVacation(Vacation vacation) {
        manager.getTransaction().begin();
        manager.persist(vacation);
        manager.getTransaction().commit();
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

    public void updateEditedEmployee(Employee employee) {
        try {
            manager.getTransaction().begin();
            manager.createQuery("UPDATE Employee e SET e.FIO = :newFIO, " +
                    "e.birthDate = : newBirthDate, " +
                    "e.dateOfStartWorking = :newDateOfStartWorking, " +
                    "e.login = :newLogin, " +
                    "e.password = :newPassword, " +
                    "e.personalNumber = :newPersonalNumber, " +
                    "e.post = :newPost " +
                    "WHERE e.id =:employeeId")
                    .setParameter("newFIO", employee.getFIO())
                    .setParameter("newBirthDate", employee.getBirthDate())
                    .setParameter("newDateOfStartWorking", employee.getDateOfStartWorking())
                    .setParameter("newLogin", employee.getLogin())
                    .setParameter("newPassword", employee.getPassword())
                    .setParameter("newPersonalNumber", employee.getPersonalNumber())
                    .setParameter("newPost", employee.getPost())
                    .setParameter("employeeId", employee.getId())
                    .executeUpdate();
        } catch (Throwable cause) {
            manager.getTransaction().rollback();
            throw cause;
        }
        manager.getTransaction().commit();
    }

    public Employee createEmployee(String FIO, Date birthDate, Integer personalNumber,
                                   String post, Date dateOfStartWorking,
                                   String login, String password) {
        Employee newEmployee = new Employee(FIO, birthDate, personalNumber,
                                            post, dateOfStartWorking,
                                            login, password);

        manager.getTransaction().begin();
        try {
            manager.persist(newEmployee);
        } catch (Throwable cause) {
            manager.getTransaction().rollback();
            throw cause;
        }
        manager.getTransaction().commit();

        return newEmployee;
    }

}
