package data.comparator;

import data.Worker;

import java.util.Comparator;

/**
 * Данный код исопльзуется для сравнения зп сотрудников
 *
 * @see managers.commands.BasicCommand
 * @see data.Organization
 * @author Mar1ik
 * @since 1.0
 */
public class SalaryComp implements Comparator<Worker> {
    @Override
    public int compare(Worker o1, Worker o2) {
        float salary1 = o1.getSalary();
        float salary2 = o2.getSalary();
        if (salary1 > salary2) {
            return 1;
        } else if (salary1 < salary2) {
            return -1;
        } else {
            return 0;
        }

    }
}
