package gregor.melikhov.vacation.system.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "employee_sequence",
                        sequenceName = "employee_sequence",
                        allocationSize = 1)
    private int id;

    @Column(nullable = false, name = "fio")
    private String FIO;

    @Column(nullable = false, name = "birthdate")
    private Date birthDate;

    @Column(nullable = false, unique = true, name = "personalnumber")
    private int personalNumber;

    @Column(nullable = false, name = "post")
    private String post;

    @Column(nullable = false, name = "dateofstartworking")
    private Date dateOfStartWorking;

    @Column(nullable = false, unique = true, name = "login")
    private String login;

    @Column(nullable = false, name = "password")
    private String password;

    @OneToMany(fetch = FetchType.LAZY,
                mappedBy = "employee",
                cascade = CascadeType.ALL)
    private List<Vacation> vacations;

    public Employee() {
        FIO = "";
        birthDate = new Date(Calendar.getInstance().getTime().getTime());
        personalNumber = -1;
        post = "";
        dateOfStartWorking = new Date(Calendar.getInstance().getTime().getTime());
        login = "";
        password = "";
        vacations = new ArrayList<>();
    }

    public Employee(String FIO, Date birthDate, int personalNumber, String post, Date dateOfStartWorking, String login, String password) {
        this.FIO = FIO;
        this.birthDate = birthDate;
        this.personalNumber = personalNumber;
        this.post = post;
        this.dateOfStartWorking = dateOfStartWorking;
        this.login = login;
        this.password = password;
        this.vacations = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date dateOfBirth) {
        this.birthDate = dateOfBirth;
    }

    public int getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(int personalNumber) {
        this.personalNumber = personalNumber;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public Date getDateOfStartWorking() {
        return dateOfStartWorking;
    }

    public void setDateOfStartWorking(Date dateOfStartWorking) {
        this.dateOfStartWorking = dateOfStartWorking;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Vacation> getVacations() {
        return vacations;
    }

    public void setVacations(List<Vacation> vacations) {
        this.vacations = vacations;
    }

    public boolean addVacationToList(Vacation vacation) {
        return vacations.add(vacation);
    }

    @Override
    public String toString() {
        return FIO;
    }
}
