import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;


public class AviaSoulsTest {
    Ticket ticket1 = new Ticket("Москва", "Санкт-Петербург", 1000, 14, 15);
    Ticket ticket2 = new Ticket("Москва", "Новосибирск", 2500, 10, 14);
    Ticket ticket3 = new Ticket("Москва", "Екатеринбург", 1800, 15, 18);
    Ticket ticket4 = new Ticket("Москва", "Казань", 1800, 11, 13);
    Ticket ticket5 = new Ticket("Москва", "Сочи", 3000, 14, 19);
    Ticket ticket6 = new Ticket("Москва", "Санкт-Петербург", 1100, 14, 16);
    Ticket ticket7 = new Ticket("Москва", "Санкт-Петербург", 1300, 14, 18);
    Ticket ticket8 = new Ticket("Москва", "Санкт-Петербург", 1200, 14, 17);

    AviaSouls aviaSouls = new AviaSouls();
    TicketTimeComparator comparator = new TicketTimeComparator();

    @Test
    public void CompareToTest() {
        Assertions.assertEquals(-1, ticket1.compareTo(ticket2));
        Assertions.assertEquals(1, ticket2.compareTo(ticket3));
        Assertions.assertEquals(0, ticket3.compareTo(ticket4));
        Assertions.assertEquals(-1, ticket4.compareTo(ticket5));
    }

    @Test
    public void SearchTest() {
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);
        aviaSouls.add(ticket7);
        aviaSouls.add(ticket8);

        Ticket[] search1 = aviaSouls.search("Москва", "Санкт-Петербург");
        Ticket[] search2 = aviaSouls.search("Москва", "Новосибирск");
        Ticket[] search3 = aviaSouls.search("Москва", "Екатеринбург");
        Ticket[] search4 = aviaSouls.search("Москва", "Казань");
        Ticket[] search5 = aviaSouls.search("Москва", "Сочи");

        Assertions.assertArrayEquals(new Ticket[] {
                ticket1, ticket6, ticket8, ticket7
        }, search1);
        Assertions.assertArrayEquals(new Ticket[] {ticket2}, search2);
        Assertions.assertArrayEquals(new Ticket[] {ticket3}, search3);
        Assertions.assertArrayEquals(new Ticket[] {ticket4}, search4);
        Assertions.assertArrayEquals(new Ticket[] {ticket5}, search5);
    }

    @Test
    public void TicketTimeComparatorTest() {
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);

        Ticket[] tickets = aviaSouls.findAll();
        Arrays.sort(tickets, comparator);

        Assertions.assertArrayEquals(new Ticket[] {
                ticket1, ticket4, ticket3, ticket2, ticket5
        }, tickets);
    }

    @Test
    public void SearchAndSortByTest() {
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);
        aviaSouls.add(ticket7);
        aviaSouls.add(ticket8);

        Ticket[] searchedTickets = aviaSouls.searchAndSortBy("Москва", "Санкт-Петербург", comparator);

        Assertions.assertArrayEquals(new Ticket[] {
                ticket1, ticket6, ticket8, ticket7
        }, searchedTickets);
    }
}
