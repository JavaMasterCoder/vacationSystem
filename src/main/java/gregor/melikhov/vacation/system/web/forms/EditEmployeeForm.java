package gregor.melikhov.vacation.system.web.forms;

import java.util.Date;

public class EditEmployeeForm {
    private int id;
    private String FIO;
    private java.sql.Date birthDate;
    private int personalNumber;
    private String post;
    private java.sql.Date dateOfStartWorking;
    private String login;
    private String password;

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

    public void setBirthDate(Date birthDate) {
        this.birthDate = new java.sql.Date(birthDate.getTime());
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
        this.dateOfStartWorking = new java.sql.Date(dateOfStartWorking.getTime());
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
}
