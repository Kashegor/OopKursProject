package com.websystique.springsecurity.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "orders")
@Data
public class Order implements Serializable {

    public int getUserId() {
        return userId;
    }

    public int getEquipmentId() {
        return equipmentId;
    }

    @Id
    @Column(name = "USER_ID")
    private int userId;

    @Id
    @Column(name = "EQUIPMENT_ID")
    private int equipmentId;

    public Order() { }

    public Order(int userId, int equipmentId) {
        this.userId = userId;
        this.equipmentId = equipmentId;
    }
}
