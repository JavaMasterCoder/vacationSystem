package gregor.melikhov.vacation.system.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String FIO;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @Column(nullable = false, unique = true)
    private int personalNumber;

    @Column(nullable = false)
    private String post;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateOfStartWorking;

    @Column(nullable = false, unique = true)
    private String login;

    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "employee")
    private List<Vacation> vacations;

    public Employee() {
        FIO = "";
        birthDate = new Date();
        personalNumber = -1;
        post = "";
        dateOfStartWorking = new Date();
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
}