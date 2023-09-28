package com.example.happypets;

public class Services {

    Integer serv_id;
    Integer pat_id;
    String serv_type;
    String medicine;
    String pat_status;
    String date;
    String doctor;
    Integer price;

    public Services(Integer serv_id, Integer pat_id, String serv_type, String medicine,
                    String pat_status, String date, String doctor, Integer price) {
        this.serv_id = serv_id;
        this.pat_id = pat_id;
        this.serv_type = serv_type;
        this.medicine = medicine;
        this.pat_status = pat_status;
        this.date = date;
        this.doctor = doctor;
        this.price = price;
    }

    public Services() {

    }

    public Integer getServ_id() {
        return serv_id;
    }

    public void setServ_id(Integer serv_id) {
        this.serv_id = serv_id;
    }

    public Integer getPat_id() {
        return pat_id;
    }

    public void setPat_id(Integer pat_id) {
        this.pat_id = pat_id;
    }

    public String getServ_type() {
        return serv_type;
    }

    public void setServ_type(String serv_type) {
        this.serv_type = serv_type;
    }

    public String getMedicine() {
        return medicine;
    }

    public void setMedicine(String medicine) {
        this.medicine = medicine;
    }

    public String getPat_status() {
        return pat_status;
    }

    public void setPat_status(String pat_status) {
        this.pat_status = pat_status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
