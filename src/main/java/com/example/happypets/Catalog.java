package com.example.happypets;

public class Catalog {
    private Integer service_id;
    private String title;
    private String type;
    private String price;
    private String info;

    public Catalog(Integer service_id, String title, String type, String price, String info) {
        this.service_id = service_id;
        this.title = title;
        this.type = type;
        this.price = price;
        this.info = info;
    }

    public Catalog(){

    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }


    public Integer getService_id() {
        return service_id;
    }

    public void setService_id(Integer service_id) {
        this.service_id = service_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

}
