package ru.job4j.stream;

import org.junit.Test;

import java.util.Arrays;
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

    @Test
    public void whenTestMethodCollectSortWithoutDuplicate() {
        Address first = new Address("City1", "Street1", 1, 1);
        Address second = new Address("City2", "Street2", 2, 2);
        Address third = new Address("City3", "Street3", 3, 3);
        Address fourth = new Address("City1", "Street1", 1, 1);
        Address fifth = new Address("City2", "Street2", 2, 2);
        Address seventh = new Address("City3", "Street3", 3, 3);
        List<Profile> profiles = Arrays.asList(
                new Profile(second),
                new Profile(fourth),
                new Profile(fifth),
                new Profile(first),
                new Profile(seventh),
                new Profile(third)
        );
        List<Address> result = new Profiles().collect(profiles);
        List<Address> expected = Arrays.asList(first, second, third);
        assertEquals(expected, result);
    }
}