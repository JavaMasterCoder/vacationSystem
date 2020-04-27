package gregor.melikhov.vacation.system.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.sql.Date;
import java.util.Calendar;

@Entity
@Table(name = "vacation")
public class Vacation {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
//    @SequenceGenerator(name = "hibernate_sequence",
//                        sequenceName = "hibernate_sequence",
//                        allocationSize = 1)
    private int id;

    @ManyToOne(fetch = FetchType.EAGER,
                cascade = CascadeType.ALL)
    @NotNull
    private Employee employee;

    @Column(name = "vacationstartdate")
    private Date vacationStartDate;

    @Column(name = "vacationenddate")
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
