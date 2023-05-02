package com.mongocrud.pojo;

public class StudentDTO {

    private long id;
    private String name;
    private String city;
    private String college;

    public StudentDTO(int id, String name, String city, String college) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.college = college;
    }

    public StudentDTO() {
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getCollege() {
        return college;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCollege(String college) {
        this.college = college;
    }

}
