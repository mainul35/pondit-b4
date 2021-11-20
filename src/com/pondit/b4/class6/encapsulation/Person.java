package com.pondit.b4.class6.encapsulation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private int age;
    private List<Address> addresses = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Address> getAddresses(int postCode) {
        List<Address> addressList = new ArrayList<>();
        for (var address: addresses) {
            if (address.getPostCode() == postCode) {
                addressList.add(address);
            }
        }
        return addressList;
//        return addresses.stream().filter(address -> address.getPostCode() == postCode).collect(Collectors.toList());
    }

    public void addAddress(Address address) {
        this.addresses.add(address);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", addresses=" + addresses +
                '}';
    }
}
