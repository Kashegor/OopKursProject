package com.websystique.springsecurity.dao;

import com.websystique.springsecurity.model.Equipment;
import com.websystique.springsecurity.model.Order;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderDaoImpl implements OrderDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void deleteByEquipmentIdAndUserId(int userId, int priceId ) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select from orders ");
        ArrayList<Order> orders = (ArrayList<Order>) query.list();

        Order rorder = null;
        for (Order order: orders) {
            if (order.getUserId() == userId && order.getEquipmentId() == priceId){
                rorder = order;
                break;
            }
        }


        if (rorder != null) {
            session.delete(rorder);
        }
    }

    public void save(int userId, int priceId) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(new Order(userId, priceId));
    }
}
