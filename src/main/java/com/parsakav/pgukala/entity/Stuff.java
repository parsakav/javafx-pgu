package com.parsakav.pgukala.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Table(name = "TBL_STUFF")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Stuff implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private String imagePath;
    @Column(name = "sttype")
    @Enumerated(EnumType.STRING)
    private StuffType stuffType;

    @Column(name="price")
private Double price;

    public Stuff(String name, String description, String imagePath,StuffType stuffType,double price) {
        this.name = name;
        this.description = description;
        this.imagePath = imagePath;
        this.stuffType=stuffType;
        this.price=price;
    }
}
