package org.zerhusen.rest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.ImmutableList;

@RestController
public class PersonRestService {

    private static List<Person> persons = ImmutableList.of(new Person("hello", "world"), //
            new Person("foo", "bar")); //

    @RequestMapping(path = "/persons", method = RequestMethod.GET)
    public static List<Person> getPersons() {
        return persons;
    }

    @RequestMapping(path = "/persons/{name}", method = RequestMethod.GET)
    public static Person getPerson(@PathVariable("name") String name) {
        return persons.stream() //
                .filter(person -> name.equalsIgnoreCase(person.getName())) //
                .findAny() //
                .orElse(null);
    }
}
