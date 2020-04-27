package gregor.melikhov.vacation.system.web.forms;

import java.sql.Date;

public class AddVacationForm {
    private String login;
    private Date vacationStartDate;
    private Date vacationEndDate;
    private boolean error = false;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }
}
