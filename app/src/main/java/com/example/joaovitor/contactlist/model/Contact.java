package com.example.joaovitor.contactlist.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by joaovitor on 01/09/17.
 */

public class Contact implements Parcelable {
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.phone);
        dest.writeInt(this.gender == null ? -1 : this.gender.ordinal());
    }

    protected Contact(Parcel in) {
        this.name = in.readString();
        this.phone = in.readString();
        int tmpGender = in.readInt();
        this.gender = tmpGender == -1 ? null : Gender.values()[tmpGender];
    }

    public boolean isNameValid(){
        return name != null && !name.isEmpty();
    }

    public boolean isPhoneValid(){
        return phone != null && !phone.isEmpty();
    }

    public boolean isValid(){
        return isNameValid() && isPhoneValid();
    }

    public static final Parcelable.Creator<Contact> CREATOR = new Parcelable.Creator<Contact>() {
        @Override
        public Contact createFromParcel(Parcel source) {
            return new Contact(source);
        }

        @Override
        public Contact[] newArray(int size) {
            return new Contact[size];
        }
    };
}
