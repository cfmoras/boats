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
    private Integer model;
    private Integer category_id;
    private String name;

    public BoatModel() {
    }

    public BoatModel(String brand, Integer model, Integer category_id, String name) {
        this.brand = brand;
        this.model = model;
        this.category_id = category_id;
        this.name = name;
    }

    public BoatModel(Integer id, String brand, Integer model, Integer category_id, String name) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.category_id = category_id;
        this.name = name;
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

    public Integer getModel() {
        return model;
    }

    public void setModel(Integer model) {
        this.model = model;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "BoatModel{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model=" + model +
                ", category_id=" + category_id +
                ", name='" + name + '\'' +
                '}';
    }
}
