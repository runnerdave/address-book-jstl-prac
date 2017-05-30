package net.runnerdave.model;

import java.time.Instant;
import java.time.MonthDay;

/**
 * Created by David A. Jiménez (e67997) on 30/05/2017.
 */
public class Contact implements Comparable<Contact> {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;

    public Contact() {
    }

    public Contact(String firstName, String lastName, String phoneNumber, String address, MonthDay birthday, Instant dateCreated) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.birthday = birthday;
        this.dateCreated = dateCreated;
    }

    public String getFirstName() {

        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public MonthDay getBirthday() {
        return birthday;
    }

    public Instant getDateCreated() {
        return dateCreated;
    }

    private MonthDay birthday;
    private Instant dateCreated;

    @Override
    public int compareTo(Contact other) {
        int last = lastName.compareTo(other.lastName);
        if (last == 0)
            return firstName.compareTo(other.firstName);
        return last;
    }
}
