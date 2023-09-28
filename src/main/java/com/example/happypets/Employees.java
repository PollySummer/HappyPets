package com.example.happypets;

public class Employees {

    private String first_name;
    private String last_name;
    private String birth_date;
    private String working_field;
    private String work_expirience;
    private String mob_number;
    private String email;

    private String password;

    //private String id;

    public Employees(String first_name, String last_name, String birth_date,
                     String working_field, String work_expirience,
                     String mob_number, String email, String password /*String id*/) {

        this.first_name = first_name;
        this.last_name = last_name;
        this.birth_date = birth_date;
        this.working_field = working_field;
        this.work_expirience = work_expirience;
        this.mob_number = mob_number;
        this.email = email;
        this.password = password;
        //this.id = id;
    }

    public Employees() {

    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }

    public String getWorking_field() {
        return working_field;
    }

    public void setWorking_field(String work_field) {
        this.working_field = work_field;
    }

    public String getWork_expirience() {
        return work_expirience;
    }

    public void setWork_expirience(String work_expirience) {
        this.work_expirience = work_expirience;
    }

    public String getMob_number() {
        return mob_number;
    }

    public void setMob_number(String mob_number) {
        this.mob_number = mob_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /*public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }*/
}
