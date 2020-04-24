package gregor.melikhov.vacation.system.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
        Employee employee = new Employee();
        employee.setFIO("Мелихов Григорий Федорович");

        manager.getTransaction().begin();
        manager.persist(employee);
        manager.getTransaction().commit();
    }

    @Test
    public void createVacation() {
        Employee employee = new Employee();
        employee.setFIO("Мелихов Григорий Федорович");

        Vacation vacation = new Vacation();
        vacation.setEmployee(employee);

        manager.getTransaction().begin();
        manager.persist(employee);
        manager.persist(vacation);
        manager.getTransaction().commit();

    }
}
