package com.example.joaovitor.contactlist.model;

/**
 * Created by joaovitor on 01/09/17.
 */

public enum Gender {
    Male("Masculino"), Female("Feminino");

    private final String gender;

    Gender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return this.gender;
    }
}
