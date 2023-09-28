package com.example.happypets;

public class Patients {
    private Integer id;
    private String name_patient;
    private String kind;
    private String breed_patient;
    private String age_patient;
    private String gender_patient;
    private String vaccination_patient;
    private String health_patient;
    private String name_owner;
    private String adress_owner;
    private String phone_owner;

    public Patients(Integer id, String name_patient, String kind, String breed_patient,
                    String age_patient, String gender_patient, String vaccination_patient,
                    String health_patient, String name_owner, String adress_owner, String phone_owner) {
        this.id = id;
        this.name_patient = name_patient;
        this.kind = kind;
        this.breed_patient = breed_patient;
        this.age_patient = age_patient;
        this.gender_patient = gender_patient;
        this.vaccination_patient = vaccination_patient;
        this.health_patient = health_patient;
        this.name_owner = name_owner;
        this.adress_owner = adress_owner;
        this.phone_owner = phone_owner;
    }

    public Patients(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName_patient() {
        return name_patient;
    }

    public void setName_patient(String name_patient) {
        this.name_patient = name_patient;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getBreed_patient() {
        return breed_patient;
    }

    public void setBreed_patient(String breed_patient) {
        this.breed_patient = breed_patient;
    }

    public String getAge_patient() {
        return age_patient;
    }

    public void setAge_patient(String age_patient) {
        this.age_patient = age_patient;
    }

    public String getGender_patient() {
        return gender_patient;
    }

    public void setGender_patient(String gender_patient) {
        this.gender_patient = gender_patient;
    }

    public String getVaccination_patient() {
        return vaccination_patient;
    }

    public void setVaccination_patient(String vaccination_patient) {
        this.vaccination_patient = vaccination_patient;
    }

    public String getHealth_patient() {
        return health_patient;
    }

    public void setHealth_patient(String health_patient) {
        this.health_patient = health_patient;
    }

    public String getName_owner() {
        return name_owner;
    }

    public void setName_owner(String name_owner) {
        this.name_owner = name_owner;
    }

    public String getAdress_owner() {
        return adress_owner;
    }

    public void setAdress_owner(String adress_owner) {
        this.adress_owner = adress_owner;
    }

    public String getPhone_owner() {
        return phone_owner;
    }

    public void setPhone_owner(String phone_owner) {
        this.phone_owner = phone_owner;
    }



}
