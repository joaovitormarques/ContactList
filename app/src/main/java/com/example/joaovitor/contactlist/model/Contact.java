package com.example.joaovitor.contactlist.model;

/**
 * Created by joaovitor on 01/09/17.
 */

public class Contact {
    private String name;
    private String phone;
    private Gender gender;

    public Contact(){}
    public Contact(String name, String phone, Gender gender){
        this.name = name;
        this.phone = phone;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
