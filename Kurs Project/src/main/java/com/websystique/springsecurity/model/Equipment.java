package com.websystique.springsecurity.model;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "equipment")
@Data
public class Equipment {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PROVIDER")
    private String provider;

    @Column(name = "PRICE")
    private int price;

    @Column(name = "DESCRIPTION")
    private String description;


}
