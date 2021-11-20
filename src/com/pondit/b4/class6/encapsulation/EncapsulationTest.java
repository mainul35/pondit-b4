package com.pondit.b4.class6.encapsulation;

import java.util.ArrayList;

public class EncapsulationTest {
    public static void main(String[] args) {
        Address address1 = new Address();
        address1.setPostCode(10260);
        address1.setStreet("Sukumvit 64");

        Address address2 = new Address();
        address2.setPostCode(1230);
        address2.setStreet("Sonargaon Janapath Road");

        Person person = new Person();
        person.setName("Mainul");
        person.setAge(27);
        person.addAddress(address1);
        person.addAddress(address2);

        var filteredAddresses = person.getAddresses(10260);
        System.out.println(filteredAddresses);
        filteredAddresses.clear();
        System.out.println(filteredAddresses);
        System.out.println(person.getAddresses(10260));
//        System.out.println(person);
    }
}
