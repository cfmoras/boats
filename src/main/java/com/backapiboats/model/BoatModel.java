package com.backapiboats.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "boat")

public class BoatModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String brand;
    private Integer year;
    private String name;
    private String description;

    public BoatModel() {
    }

    public BoatModel(String brand, Integer year, Integer category_id, String name, String description) {
        this.brand = brand;
        this.year = year;
        this.name = name;
        this.description = description;
    }

    public BoatModel(Integer id, String brand, Integer year, Integer category_id, String name, String description) {
        this.id = id;
        this.brand = brand;
        this.year = year;
        this.name = name;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "BoatModel{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", year=" + year +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
