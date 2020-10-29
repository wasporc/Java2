package ru.geekbrains.java2;

import java.util.*;

public class Phonebook {
    private Map<String, List<String>> phonebook = new HashMap<String, List<String>>();

    public void add(String name, String phoneNumber){
        if(!phonebook.containsKey(name)){
            List<String> numbers = new ArrayList<String>();
            numbers.add(phoneNumber);
            phonebook.put(name, numbers);
        }else {
            List<String> numbers = phonebook.get(name);
            numbers.add(phoneNumber);
        }
    }

    public String get(String name){
        if (!phonebook.containsKey(name)){
            return String.format("Name %s not found", name);
        }else {
            return String.format("%s %s", name, phonebook.get(name).toString());
        }
    }
}
