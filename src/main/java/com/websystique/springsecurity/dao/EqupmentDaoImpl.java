package com.websystique.springsecurity.dao;

import com.websystique.springsecurity.model.Equipment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EqupmentDaoImpl implements EqupmentDao {
    private static final Logger logger = LoggerFactory.logger(EqupmentDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;


    public void add(Equipment equpment) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(equpment);
        logger.info("Manga successfuly saved. Its details: " + equpment);
    }

    public void update(Equipment manga) {
        Session session = sessionFactory.getCurrentSession();
        session.update(manga);
        logger.info("Manga successfuly update. Its details: " + manga);
    }

    public void remove(int id) {
        Session session = sessionFactory.getCurrentSession();
        Equipment equipment = (Equipment) session.load( Equipment.class, new Integer(id));
        if (equipment != null) {
            session.delete(equipment);
        }
        logger.info("Manga successfuly removed. Its details: " + equipment);
    }

    public Equipment getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Equipment equipment = (Equipment) session.load(Equipment.class, new Integer(id));
        logger.info("Manga successfuly loaded. Its details: " + equipment);
        return equipment;
    }

    public List<Equipment> listEqupment() {
        Session session = sessionFactory.getCurrentSession();
        List<Equipment> equipments = session.createQuery("from Equipment").list();

        for (Equipment equipment: equipments) {
            logger.info("Manga list: " + equipment);
        }

        return equipments;
    }
}
