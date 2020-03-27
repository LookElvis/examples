package PublicClass;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Elvis on 2020/3/26.
 */
public class SortListMutiCondition {
    public static void main(String[] args) {
        List<Person> persons = getPersons();
//        List<Person> result = persons.stream().sorted(Comparator.comparing(Person::getNamePinyin).thenComparing(Person::getAge)).collect(Collectors.toList());
        // 先按name升序，再按age升序
        List<Person> result = persons.stream()
                .sorted(Comparator.comparing(Person::getName).thenComparing(Person::getAge))
                .collect(Collectors.toList());
        for(Person p: result) {
            System.out.println(p.getName() + " " + p.getAge());
        }
    }

    public static List<Person> getPersons() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1, 24));
        persons.add(new Person(2, 23));
        persons.add(new Person(3, 78));
        persons.add(new Person(6, 23));
        persons.add(new Person(6, 21));
        persons.add(new Person(11, 23));
        persons.add(new Person(4, 23));

        return persons;
    }
}

class Person {
    private Integer name;
    private Integer age;

    public Person() {
    }

    public Person(Integer name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Integer getName() {
        return name;
    }

    public void setName(Integer name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}