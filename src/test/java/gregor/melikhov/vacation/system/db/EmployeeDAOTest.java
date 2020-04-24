package gregor.melikhov.vacation.system.db;

import gregor.melikhov.vacation.system.model.Employee;
import gregor.melikhov.vacation.system.model.Vacation;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.util.Calendar;
import java.util.Date;
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
    public void testFindEmployeeByLogin() {
        Employee employee = new Employee();
        employee.setFIO("Мелихов Григорий Федорович");
        employee.setLogin("gregor");
        employee.setPassword("root");
        employee.setPost("Programmer");
        employee.setPersonalNumber(1000);

        manager.getTransaction().begin();
        manager.persist(employee);
        manager.getTransaction().commit();

        Employee foundEmployee = employeeDAO.findEmployeeByLogin("gregor");
        assertNotNull(foundEmployee);
        assertEquals("Мелихов Григорий Федорович", foundEmployee.getFIO());
        assertEquals("gregor", foundEmployee.getLogin());
        assertEquals("root", foundEmployee.getPassword());
        assertEquals("Programmer", foundEmployee.getPost());
        assertEquals(1000, foundEmployee.getPersonalNumber());

        Employee foundEmployee2 = employeeDAO.findEmployeeByLogin("anotherLogin");
        assertNull(foundEmployee2);
    }

    @Test
    public void findVacationsByEmployeesTest() {
        Employee employee = new Employee();
        employee.setFIO("Мелихов Григорий Федорович");
        employee.setLogin("gregor");
        employee.setPassword("root");
        employee.setPost("Programmer");
        employee.setPersonalNumber(1000);

        Calendar calendar = Calendar.getInstance();
        calendar.set(1997, 9, 10);
        calendar.set(Calendar.MILLISECOND, 0);
        employee.setBirthDate(calendar.getTime());

        calendar.set(2020, 4, 7);
        calendar.set(Calendar.MILLISECOND, 0);
        employee.setDateOfStartWorking(calendar.getTime());

        Vacation vacation = new Vacation(employee, new Date(), new Date());
        calendar.set(2020, 11, 13);
        calendar.set(Calendar.MILLISECOND, 0);
        vacation.setVacationStartDate(calendar.getTime());
        calendar.set(2020, 11, 27);
        calendar.set(Calendar.MILLISECOND, 0);
        vacation.setVacationEndDate(calendar.getTime());

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