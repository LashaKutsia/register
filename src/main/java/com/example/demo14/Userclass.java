package com.example.demo14;

public class Userclass {

    private String name;

    private String surname;
    private String email;
    private String profession;
    private String password;

    public Userclass (String name, String surname, String email, String profession, String password) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.profession = profession;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
