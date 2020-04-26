package gregor.melikhov.vacation.system.web.forms;

import gregor.melikhov.vacation.system.model.Vacation;

import java.util.Comparator;
import java.util.List;

public class AllVacationsForm {
    private List<Vacation> allVacations;

    public AllVacationsForm() {

    }

    public AllVacationsForm(List<Vacation> allVacations, boolean sortByVacations) {
        if (!sortByVacations) {
            allVacations.sort((vacation1, vacation2) -> vacation1.getEmployee().getFIO().compareTo(vacation2.getEmployee().getFIO()));
        } else {
            allVacations.sort(new Comparator<Vacation>() {
                @Override
                public int compare(Vacation o1, Vacation o2) {
                    if (getPeriod(o1) < getPeriod(o2)) {
                        return 1;
                    } else if (getPeriod(o1) > getPeriod(o2)) {
                        return -1;
                    } else {
                        return 0;
                    }
                }
            });
        }
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


}
