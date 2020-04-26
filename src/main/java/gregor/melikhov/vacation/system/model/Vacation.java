package gregor.melikhov.vacation.system.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.sql.Date;
import java.util.Calendar;

@Entity
@Table
public class Vacation {
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @NotNull
    private Employee employee;

    @Column
//    @Temporal(TemporalType.DATE)
    private Date vacationStartDate;

    @Column
//    @Temporal(TemporalType.DATE)
    private Date vacationEndDate;

    public Vacation() {
        employee = null;
        vacationStartDate = new Date(Calendar.getInstance().getTime().getTime());
        vacationEndDate = new Date(Calendar.getInstance().getTime().getTime());
    }

    public Vacation(Employee employee, Date vacationStartDate, Date vacationEndDate) {
        this.employee = employee;
        this.vacationStartDate = vacationStartDate;
        this.vacationEndDate = vacationEndDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Date getVacationStartDate() {
        return vacationStartDate;
    }

    public void setVacationStartDate(Date vacationStartDate) {
        this.vacationStartDate = vacationStartDate;
    }

    public Date getVacationEndDate() {
        return vacationEndDate;
    }

    public void setVacationEndDate(Date vacationEndDate) {
        this.vacationEndDate = vacationEndDate;
    }

    @Override
    public String toString() {
        return "Vacation{" +
                "vacationStartDate = " + vacationStartDate +
                ", vacationEndDate = " + vacationEndDate +
                '}';
    }
}
