package gregor.melikhov.vacation.system.web.forms;

import gregor.melikhov.vacation.system.model.Vacation;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AllVacationsForm {
    private List<Vacation> allVacations;
    private Date startOfPeriod;
    private Date endOfPeriod;

    public AllVacationsForm() {

    }

    public AllVacationsForm(List<Vacation> allVacations, boolean sortByVacations) {
        if (!sortByVacations) {
            allVacations.sort((vacation1, vacation2) -> vacation1.getEmployee().getFIO().compareTo(vacation2.getEmployee().getFIO()));
        } else {
            allVacations.sort((vacation1, vacation2) -> {
                if (getPeriod(vacation1) > getPeriod(vacation2)) {
                    return 1;
                } else if (getPeriod(vacation1) < getPeriod(vacation2)) {
                    return -1;
                } else {
                    return 0;
                }
            });
        }
        this.allVacations = allVacations;
    }

    public AllVacationsForm(List<Vacation> allVacations, String sortByFIO) {
        this.allVacations = allVacations.stream()
                    .filter(vacation -> vacation.getEmployee().getFIO().equals(sortByFIO))
                    .collect(Collectors.toList());
    }

    public AllVacationsForm(List<Vacation> allVacations, Date startOfPeriod, Date endOfPeriod) {
        this.startOfPeriod = startOfPeriod;
        this.endOfPeriod = endOfPeriod;

        this.allVacations = allVacations.stream()
                .filter(vacation -> vacation.getVacationStartDate().getTime() >= startOfPeriod.getTime()
                                    && vacation.getVacationEndDate().getTime() <= endOfPeriod.getTime())
                .collect(Collectors.toList());
    }

    private long getPeriod(Vacation vacation) {
        return vacation.getVacationEndDate().getTime() - vacation.getVacationStartDate().getTime();
    }

    public List<Vacation> getAllVacations() {
        return allVacations;
    }

    public void setAllVacations(List<Vacation> allVacations) {
        this.allVacations = allVacations;
    }

    public Date getStartOfPeriod() {
        return startOfPeriod;
    }

    public void setStartOfPeriod(Date startOfPeriod) {
        this.startOfPeriod = startOfPeriod;
    }

    public Date getEndOfPeriod() {
        return endOfPeriod;
    }

    public void setEndOfPeriod(Date endOfPeriod) {
        this.endOfPeriod = endOfPeriod;
    }
}
