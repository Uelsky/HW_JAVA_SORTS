import java.util.Comparator;

public class TicketTimeComparator implements Comparator<Ticket> {

    @Override
    public int compare(Ticket t1, Ticket t2) {
        int timeT1 = t1.getTimeTo() - t1.getTimeFrom();
        int timeT2 = t2.getTimeTo() - t2.getTimeFrom();

        if (timeT1 < timeT2) {
            return -1;
        } else if (timeT1 > timeT2) {
            return 1;
        } else {
            return 0;
        }
    }
}
