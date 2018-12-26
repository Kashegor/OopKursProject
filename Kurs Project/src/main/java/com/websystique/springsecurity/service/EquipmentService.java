package com.websystique.springsecurity.service;


import com.websystique.springsecurity.model.Equipment;

import java.util.List;

public interface EquipmentService {
    public void add(Equipment equipment);
    public void update(Equipment equipment);
    public void remove(int id);
    public Equipment getById(int id);
    public List<Equipment> listEquipment();
}
