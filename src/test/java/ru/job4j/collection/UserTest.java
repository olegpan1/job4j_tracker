package ru.job4j.collection;

import org.junit.Test;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class UserTest {

    @Test
    public void whenAsc() {
        Set<User> users = new TreeSet<>();
        users.add(new User("Petr", 30));
        users.add(new User("Ivan", 32));
        users.add(new User("Ivan", 20));
        users.add(new User("Ivan", 31));
        users.add(new User("Petr", 10));
        users.add(new User("Petr", 30));
        users.add(new User("Ivan", 20));
        Iterator<User> it = users.iterator();
        assertThat(it.next(), is(new User("Petr", 10)));
        assertThat(it.next(), is(new User("Ivan", 20)));
        assertThat(it.next(), is(new User("Petr", 30)));
        assertThat(it.next(), is(new User("Ivan", 31)));
        assertThat(it.next(), is(new User("Ivan", 32)));
    }

    @Test
    public void whenCompareWithUserSorter() {
        Set<User> users = new TreeSet<>(new UserSorter());
        users.add(new User("Petr", 30));
        users.add(new User("Ivan", 32));
        users.add(new User("Ivan", 20));
        users.add(new User("Ivan", 31));
        users.add(new User("Petr", 10));
        users.add(new User("Petr", 30));
        users.add(new User("Ivan", 20));
        System.out.println(users);
        Iterator<User> it = users.iterator();
        assertThat(it.next(), is(new User("Ivan", 20)));
        assertThat(it.next(), is(new User("Ivan", 31)));
        assertThat(it.next(), is(new User("Ivan", 32)));
        assertThat(it.next(), is(new User("Petr", 10)));
        assertThat(it.next(), is(new User("Petr", 30)));
    }

    @Test
    public void whenComparePetrVSIvan() {
        int rsl = new User("Petr", 32)
                .compareTo(
                        new User("Ivan", 31)
                );
        assertThat(rsl, greaterThan(0));
    }
}
