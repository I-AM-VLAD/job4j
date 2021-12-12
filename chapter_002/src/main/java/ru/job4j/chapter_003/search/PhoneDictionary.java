package ru.job4j.chapter_003.search;

import java.util.ArrayList;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {

        ArrayList<Person> result = new ArrayList<>();

        for (var index = 0; index < persons.size(); index++) {

            if(persons != null) {
                var str1 = persons.get(index).getName();
                var str2 = persons.get(index).getSurname();
                var str3 = persons.get(index).getPhone();
                var str4 = persons.get(index).getAddress();

                var got1 = str1.contains(key);
                var got2 = str2.contains(key);
                var got3 = str3.contains(key);
                var got4 = str4.contains(key);

                if (got1 || got2 || got3 || got4) {
                    result.add(persons.get(index));
                }
            }
        }
        return result;
    }
}

