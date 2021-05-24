package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ProfilesTest {

    @Test
    public void collectAddressAndSort() {
        List<Profile> profile = List.of(
                new Profile(new Address("Moscow", "Red Square", 1, 2)),
                new Profile(new Address("London", "Baker street", 221, 1)),
                new Profile(new Address("London", "Baker street", 221, 1)),
                new Profile(new Address("Moscow", "Red Square", 1, 2)),
                new Profile(new Address("Berlin", "Under den Linden", 45, 3))
        );
        Profiles pr = new Profiles();
        List<Address> rsl = pr.collect(profile);
        List<Address> expected = List.of(
                new Address("Berlin", "Under den Linden", 45, 3),
                new Address("London", "Baker street", 221, 1),
                new Address("Moscow", "Red Square", 1, 2));
        assertEquals(rsl, expected);
    }
}