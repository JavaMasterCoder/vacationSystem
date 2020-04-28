package gregor.melikhov.vacation.system.db;

import gregor.melikhov.vacation.system.model.Employee;
import gregor.melikhov.vacation.system.model.Vacation;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.*;
public class EmployeeDAOTest {
    private EntityManagerFactory factory;
    private EntityManager manager;
    private EmployeeDAO employeeDAO;

    @Before
    public void connect() {
        factory = Persistence.createEntityManagerFactory("TestPersistenceUnit");
        manager = factory.createEntityManager();
        employeeDAO = new EmployeeDAO(manager);
    }

    @After
    public void close() {
        if (manager != null) {
            manager.close();
        }

        if (factory != null) {
            factory.close();
        }
    }

    @Test
    public void findEmployeeByLoginTest() {
        String FIO = "JJ Abrams";
        int personalNumber = 115;
        String post = "newbie";
        String login = "login";
        String password = "password";
        Date birthDate = new Date(new java.util.Date().getTime());
        Date dateOfStratWorking = new Date(new java.util.Date().getTime());

        Employee employee = new Employee(FIO, birthDate, personalNumber, post, dateOfStratWorking, login, password);

        manager.getTransaction().begin();
        manager.persist(employee);
        manager.getTransaction().commit();

        Employee foundEmployee = employeeDAO.findEmployeeByLogin(login);
        assertNotNull(foundEmployee);
        assertEquals(FIO, foundEmployee.getFIO());
        assertEquals(login, foundEmployee.getLogin());
        assertEquals(password, foundEmployee.getPassword());
        assertEquals(post, foundEmployee.getPost());
        assertEquals(personalNumber, foundEmployee.getPersonalNumber());

        Employee foundEmployee2 = employeeDAO.findEmployeeByLogin("anotherLogin");
        assertNull(foundEmployee2);
    }

    @Test
    public void findVacationsByEmployeesTest() {
        String FIO = "JJ Abrams";
        int personalNumber = 115;
        String post = "newbie";
        String login = "login";
        String password = "password";
        Date birthDate = new Date(new java.util.Date().getTime());
        Date dateOfStratWorking = new Date(new java.util.Date().getTime());

        Employee employee = new Employee(FIO, birthDate, personalNumber, post, dateOfStratWorking, login, password);

        Calendar calendar = Calendar.getInstance();
        calendar.set(2020, 11, 13);
        Date vacationStartDate = new Date(calendar.getTimeInMillis());

        calendar.set(2020, 11, 27);
        Date vacationEndDate = new Date(calendar.getTimeInMillis());
        Vacation vacation = new Vacation(employee, vacationStartDate, vacationEndDate);

        employee.addVacationToList(vacation);

        manager.getTransaction().begin();
        manager.persist(employee);
        manager.persist(vacation);
        manager.getTransaction().commit();

        Employee foundEmployee = employeeDAO.findEmployeeByLogin("gregor");
        assertNotNull(foundEmployee);
        assertNotNull(foundEmployee.getVacations());

        List<Vacation> employeeVacations = employeeDAO.findVacationsByEmployee(foundEmployee);
        assertNotNull(employeeVacations);
        assertTrue(!employeeVacations.isEmpty());
    }
}