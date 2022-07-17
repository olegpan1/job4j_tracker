package ru.job4j.search;

import org.hamcrest.MatcherAssert;
import org.junit.Test;

import static org.hamcrest.Matchers.is;

public class PhoneDictionaryTest {

    @Test
    public void whenFindByName() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        var persons = phones.find("534");
        MatcherAssert.assertThat(persons.get(0).getSurname(), is("Arsentev"));
    }

    @Test
    public void whenDontFindByName() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        var persons = phones.find("533");
        MatcherAssert.assertThat(persons.size(), is(0));
    }
}