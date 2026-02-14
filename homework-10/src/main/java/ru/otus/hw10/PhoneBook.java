package ru.otus.hw10;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PhoneBook {
    private Map<String, Set<String>> phonebook;

    public PhoneBook() {
        this.phonebook = new HashMap<>();
    }

    public void add(String name, String phoneNumber) {
        if (!phonebook.containsKey(name)) {
            phonebook.put(name, new HashSet<>());
        }
        phonebook.get(name).add(phoneNumber);
    }

    public Set<String> find(String name) {
        if (phonebook.containsKey(name)) {
            return phonebook.get(name);
        }
        return new HashSet<>();
    }

    public boolean containsPhoneNumber(String phoneNumber) {
        for (Set<String> phones : phonebook.values()) {
            if (phones.contains(phoneNumber)) {
                return true;
            }
        }
        return false;
    }
}
