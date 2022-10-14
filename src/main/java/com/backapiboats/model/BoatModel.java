package com.backapiboats.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "boat")
@NoArgsConstructor
@Getter
@Setter
public class BoatModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String brand;
    private Integer year;
    private String description;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    @JsonIgnoreProperties({"boats"})
    private CategoryModel category;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "boat")
    @JsonIgnoreProperties({"boat","client"})
    private List<MessageModel> messages;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "boat")
    @JsonIgnoreProperties({"boat","message"})
    public List<ReservationModel> reservations;

}
