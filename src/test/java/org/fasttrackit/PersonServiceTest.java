package org.fasttrackit;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class PersonServiceTest {

    @Test
    public void listAllPersonsNameTest() {
        //GIVEN
        PersonService personService = new PersonService(PersonService.instantiatePersonServiceTest());

        //WHEN
        List<String> result = personService.listAllPersonsName();

        //THEN
        Assertions.assertThat(result).isNotEmpty();
        Assertions.assertThat(result).hasSize(6);
        Assertions.assertThat(result).containsExactly("Denisa Ghent", "Alina Fodor", "Roxana Bulzan", "Andrei Vaida", "Florin Popa", "Maria Popescu");

    }

    @Test
    public void listAllPersonsThatAreMajorTest() {
        //GIVEN
        PersonService personService = new PersonService(PersonService.instantiatePersonServiceTest());

        //WHEN
        List<Person> result = personService.listAllPersonsThatAreMajor();

        //THEN
        Assertions.assertThat(result).isNotEmpty();
        Assertions.assertThat(result).hasSize(5);
        Assertions.assertThat(result.stream().map(Person::firstName).toList()).containsExactly("Denisa", "Alina", "Roxana", "Andrei", "Maria");
    }

    @Test
    public void listAllPersonsFromOradeaTest() {
        //GIVEN
        PersonService personService = new PersonService(PersonService.instantiatePersonServiceTest());

        //WHEN
        List<Person> result = personService.listAllPersonsFromOradea();

        //THEN
        Assertions.assertThat(result).isNotEmpty();
        Assertions.assertThat(result).hasSize(2);
        Assertions.assertThat(result.stream().map(Person::firstName).toList()).containsExactly("Denisa", "Alina");
    }

    @Test
    public void listAllPersonsFromOradeaOrClujTest() {
        //GIVEN
        PersonService personService = new PersonService(PersonService.instantiatePersonServiceTest());

        //WHEN
        List<Person> result = personService.listAllPersonsFromOradeaOrCluj();

        //THEN
        Assertions.assertThat(result).isNotEmpty();
        Assertions.assertThat(result).hasSize(4);
        Assertions.assertThat(result.stream().map(Person::firstName).toList()).containsExactly("Denisa", "Alina", "Roxana", "Andrei");
    }

    @Test
    public void listAllFirstNamesCapitalizedTest() {
        //GIVEN
        PersonService personService = new PersonService(PersonService.instantiatePersonServiceTest());

        //WHEN
        List<String> result = personService.listAllFirstNamesCapitalized();

        //THEN
        Assertions.assertThat(result).isNotEmpty();
        Assertions.assertThat(result).hasSize(6);
        Assertions.assertThat(result).containsExactly("DENISA", "ALINA", "ROXANA", "ANDREI", "FLORIN", "MARIA");

    }

    @Test
    public void listFirstNameFirstLetterFromLastNameTest() {
        //GIVEN
        PersonService personService = new PersonService(PersonService.instantiatePersonServiceTest());

        //WHEN
        List<String> result = personService.listFirstNameFirstLetterFromLastName();

        //THEN
        Assertions.assertThat(result).isNotEmpty();
        Assertions.assertThat(result).hasSize(6);
        Assertions.assertThat(result).containsExactly("Denisa G.", "Alina F.", "Roxana B.", "Andrei V.", "Florin P.", "Maria P.");

    }

    @Test
    public void listAllPersonsWithAgeBetween18And60Test() {
        //GIVEN
        PersonService personService = new PersonService(PersonService.instantiatePersonServiceTest());

        //WHEN
        List<Person> result = personService.listAllPersonsWithAgeBetween18And60();

        //THEN
        Assertions.assertThat(result).isNotEmpty();
        Assertions.assertThat(result).hasSize(4);
        Assertions.assertThat(result.stream().map(Person::firstName).toList()).containsExactly("Denisa", "Alina", "Roxana", "Andrei");
    }

    @Test
    public void listAllPersonsHavingFirstNameStartingWithATest() {
        //GIVEN
        PersonService personService = new PersonService(PersonService.instantiatePersonServiceTest());

        //WHEN
        List<Person> result = personService.listAllPersonsHavingFirstNameStartingWithA();

        //THEN
        Assertions.assertThat(result).isNotEmpty();
        Assertions.assertThat(result).hasSize(2);
        Assertions.assertThat(result.stream().map(Person::firstName).toList()).containsExactly( "Alina", "Andrei");
    }

    @Test
    public void listAllFirstNamesUniquelyTest() {
        //GIVEN
        PersonService personService = new PersonService(PersonService.instantiatePersonServiceTest());

        //WHEN
        List<String> result = personService.listAllFirstNamesUniquely();

        //THEN
        Assertions.assertThat(result).isNotEmpty();
        Assertions.assertThat(result).hasSize(6);
        Assertions.assertThat(result).containsExactly("Denisa", "Alina", "Roxana", "Andrei", "Florin", "Maria");

    }

    @Test
    public void sortThePersonsByFirstNameTest() {
        //GIVEN
        PersonService personService = new PersonService(PersonService.instantiatePersonServiceTest());

        //WHEN
        List<Person> result = personService.sortThePersonsByFirstName();

        //THEN
        Assertions.assertThat(result).isNotEmpty();
        Assertions.assertThat(result).hasSize(6);
        Assertions.assertThat(result.stream().map(Person::firstName).toList()).containsExactly( "Alina", "Andrei", "Denisa", "Florin", "Maria", "Roxana");
    }

    @Test
    public void sortThePersonsByLastNameTest() {
        //GIVEN
        PersonService personService = new PersonService(PersonService.instantiatePersonServiceTest());

        //WHEN
        List<Person> result = personService.sortThePersonsByLastName();

        //THEN
        Assertions.assertThat(result).isNotEmpty();
        Assertions.assertThat(result).hasSize(6);
        Assertions.assertThat(result.stream().map(Person::lastName).toList()).containsExactly( "Bulzan", "Fodor", "Ghent", "Popa", "Popescu", "Vaida");
    }

    @Test
    public void sortThePersonsByFirstNameLastNameAndAge() {
        //GIVEN
        PersonService personService = new PersonService(PersonService.instantiatePersonServiceTest());

        //WHEN
        List<Person> result = personService.sortThePersonsByFirstNameLastNameAndAge();

        //THEN
        Assertions.assertThat(result).isNotEmpty();
        Assertions.assertThat(result).hasSize(6);
        Assertions.assertThat(result.stream().map(Person::firstName).toList()).containsExactly( "Alina", "Andrei", "Denisa", "Florin", "Maria", "Roxana");
    }
}
