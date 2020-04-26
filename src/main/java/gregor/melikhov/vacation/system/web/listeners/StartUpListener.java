package gregor.melikhov.vacation.system.web.listeners;

import gregor.melikhov.vacation.system.db.EmployeeDAO;
import gregor.melikhov.vacation.system.model.Employee;
import gregor.melikhov.vacation.system.model.Vacation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.Calendar;

@Component
public class StartUpListener {
    @Autowired
    private EmployeeDAO employeeDAO;

    @EventListener
    public void applicationStarted(ContextRefreshedEvent event) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1997, Calendar.OCTOBER, 9);
        Date birthDate = new Date(calendar.getTime().getTime());

        calendar.set(2020, Calendar.MAY, 12);
        Date dateOfStartWorking = new Date(calendar.getTime().getTime());

        String FIO = "Melikhov Grigorii";
        int personalNumber = 1;
        String post = "Junior Java-developer";
        String login = "gregor";
        String password = "root";

        employeeDAO.createEmployee(FIO, birthDate, personalNumber, post, dateOfStartWorking, login, password);

        calendar.set(2020, Calendar.JUNE, 7);
        Date dateOfStartVacation = new Date(calendar.getTime().getTime());

        calendar.set(2020, Calendar.JUNE, 14);
        Date dateOfEndVacation = new Date(calendar.getTime().getTime());

        Vacation vacation = new Vacation(employeeDAO.findEmployeeByLogin(login), dateOfStartVacation, dateOfEndVacation);
        employeeDAO.addVacation(vacation);
    }

    private Employee createSecondEmployee() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1997, Calendar.OCTOBER, 9);
        Date birthDate = new Date(calendar.getTime().getTime());

        calendar.set(2020, Calendar.MAY, 12);
        Date dateOfStartWorking = new Date(calendar.getTime().getTime());

        String FIO = "Melikhov Ivan";
        int personalNumber = 1;
        String post = "C++-programmer";
        String login = "ivan";
        String password = "ivan";

        return new Employee(FIO, birthDate, personalNumber, post, dateOfStartWorking, login, password);
    }

    private Vacation createVacationForSecondEmployee(Employee employee) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2020, Calendar.JUNE, 8);
        Date dateOfStartVacation = new Date(calendar.getTime().getTime());

        calendar.set(2020, Calendar.JUNE, 10);
        Date dateOfEndVacation = new Date(calendar.getTime().getTime());

        return new Vacation(employee, dateOfStartVacation, dateOfEndVacation);
    }
}