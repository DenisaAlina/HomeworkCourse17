package org.fasttrackit;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class PersonService {

    private List<Person> personList;

    public PersonService() {

    }

    public static List<Person> instantiatePersonServiceTest() {
        List<Person> list = new LinkedList<>();
        Person person = new Person("Denisa", "Ghent", 27, "Oradea");
        Person person1 = new Person("Alina", "Fodor", 22, "Oradea");
        Person person2 = new Person("Roxana", "Bulzan", 33, "Cluj");
        Person person3 = new Person("Andrei", "Vaida", 27, "Cluj");
        Person person4 = new Person("Florin", "Popa", 17, "Timisoara");
        Person person5= new Person("Maria", "Popescu", 63, "Bucuresti");


        list.add(person);
        list.add(person1);
        list.add(person2);
        list.add(person3);
        list.add(person4);
        list.add(person5);

        return list;

    }

    public PersonService(List<Person> personList) {
        this.personList = personList;
    }

    public List<String> listAllPersonsName() {
        return personList.stream()
                .map(person -> person.firstName() + " " + person.lastName())
                .toList();

    }

    public List<Person> listAllPersonsThatAreMajor() {
        return personList.stream()
                .filter(person -> person.age() >= 18)
                .toList();
    }

    public List<Person> listAllPersonsFromOradea() {
        return personList.stream()
                .filter(person -> person.city().equals("Oradea"))
                .toList();
    }

    public List<Person> listAllPersonsFromOradeaOrCluj() {
        return personList.stream()
                .filter(person -> person.city().equals("Oradea") || person.city().equals("Cluj"))
                .toList();
    }

    public static Predicate<Person> combineFilters(Predicate<Person>... predicates) {

        Predicate<Person> p = Stream.of(predicates).reduce(x -> false, Predicate::or);
        return p;

    }

    public List<String> listAllFirstNamesCapitalized() {
        return personList.stream()
                .map(person -> person.firstName().toUpperCase())
                .toList();

    }

    public List<String> listFirstNameFirstLetterFromLastName() {
        return personList.stream()
                .map(person -> person.firstName() + " " + person.lastName().charAt(0)+ ".")
                .toList();

    }


    public List<Person> listAllPersonsWithAgeBetween18And60() {
        return personList.stream()
                .filter(combineTwoFilters(person-> person.age() >18, person-> person.age()<60))
                .toList();
    }

    public static Predicate<Person> combineTwoFilters(Predicate<Person>... predicates) {

        Predicate<Person> p = Stream.of(predicates).reduce(x -> true, Predicate::and);
        return p;

    }


    public List<Person> listAllPersonsHavingFirstNameStartingWithA() {
        return personList.stream()
                .filter(person -> person.firstName().startsWith("A"))
                .toList();
    }

    public List<String> listAllFirstNamesUniquely() {
        return personList.stream()
                .map(person -> person.firstName())
                .distinct()
                .toList();

    }

    public List<Person> sortThePersonsByFirstName() {
        return personList.stream()
                .sorted(Comparator.comparing(Person::firstName))
                .toList();
    }

    public List<Person> sortThePersonsByLastName() {
        return personList.stream()
                .sorted(Comparator.comparing(Person::lastName))
                .toList();
    }

    public List<Person> sortThePersonsByFirstNameLastNameAndAge() {
        return personList.stream()
                .sorted(Comparator.comparing(Person::firstName).thenComparing(Person::lastName).thenComparing(Person::age))
                .toList();
    }

}

