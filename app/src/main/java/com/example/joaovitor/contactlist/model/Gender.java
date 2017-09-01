package com.example.joaovitor.contactlist.model;

/**
 * Created by joaovitor on 01/09/17.
 */

public enum Gender {
    Masculino("Masculino"), Feminino("Feminino");

    private final String gender;

    Gender(String gender) {
        this.gender = gender;
    }

    public String toString() {
        return this.gender;
    }
}
