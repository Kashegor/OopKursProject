package com.websystique.springsecurity.dao;

import com.websystique.springsecurity.model.Equipment;

import java.util.List;

public interface EqupmentDao {
    public void add(Equipment equpment);
    public void update(Equipment equpment);
    public void remove(int id);
    public Equipment getById(int id);
    public List<Equipment> listEqupment();

}
