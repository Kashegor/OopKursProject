package com.websystique.springsecurity.service;

import com.websystique.springsecurity.dao.EqupmentDao;
import com.websystique.springsecurity.model.Equipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("equipmentService")
public class EquipmentServiceImpl implements EquipmentService {

    @Autowired
    private EqupmentDao equpmentDao;


    @Transactional
    public void add(Equipment equipment) {

        equpmentDao.add(equipment);
    }

    @Transactional
    public void update(Equipment equipment) {

        equpmentDao.update(equipment);
    }

    @Transactional
    public void remove(int id) {

        equpmentDao.remove(id);
    }

    @Transactional
    public Equipment getById(int id) {

        return equpmentDao.getById(id);
    }

    @Transactional
    public List<Equipment> listEquipment() {

        return equpmentDao.listEqupment();
    }

    @Transactional
    public List<Equipment> bucketEquipment() {

        return equpmentDao.listEqupment();
    }
}
