package ru.job4j.chapter_003.search;

import java.util.ArrayList;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {

        ArrayList<Person> result = new ArrayList<>();

        for (int index = 0; index < persons.size(); index++) {

            if(persons != null) {
                String str1 = persons.get(index).getName();
                String str2 = persons.get(index).getSurname();
                String str3 = persons.get(index).getPhone();
                String str4 = persons.get(index).getAddress();

                boolean got1 = str1.contains(key);
                boolean got2 = str2.contains(key);
                boolean got3 = str3.contains(key);
                boolean got4 = str4.contains(key);

                if (got1 || got2 || got3 || got4) {
                    result.add(persons.get(index));
                }
            }
        }
        return result;
    }
}

