package gregor.melikhov.vacation.system.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Date;
import java.util.Calendar;

public class HibernateConnectionTest {
    private EntityManagerFactory factory;
    private EntityManager manager;

    @Before
    public void connect() {
        factory = Persistence.createEntityManagerFactory("TestPersistenceUnit");
        manager = factory.createEntityManager();
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
    public void createEmployeeTest() {
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
    }

    @Test
    public void createVacation() {
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

        manager.getTransaction().begin();
        manager.persist(employee);
        manager.persist(vacation);
        manager.getTransaction().commit();

    }
}
