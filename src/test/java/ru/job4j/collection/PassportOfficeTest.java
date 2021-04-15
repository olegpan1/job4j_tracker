package ru.job4j.collection;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class PassportOfficeTest {
    @Test
    public void add() {
        Citizen citizen = new Citizen("99 0123456", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertThat(office.get(citizen.getPassport()), is(citizen));
    }

    @Test
    public void whenAddDuplicate() {
        Citizen citizen1 = new Citizen("99 0123456", "Petr Arsentev");
        Citizen citizen2 = new Citizen("99 0123456", "Ivan Petrov");
        PassportOffice office = new PassportOffice();
        office.add(citizen1);
        assertThat(office.add(citizen2), is(false));
    }
}