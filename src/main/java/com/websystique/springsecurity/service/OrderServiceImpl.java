package com.websystique.springsecurity.service;

import com.websystique.springsecurity.dao.OrderDao;
import com.websystique.springsecurity.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.ArrayList;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderDao orderDao;

    //public ArrayList<Order> getOrderByUser(int id) {
    //    return orderDao.findAllByUserId();

    @Transactional
    public void deleteOrderByUser(int userId, int priceId) {
        orderDao.deleteByEquipmentIdAndUserId(userId, priceId);
    }

    @Transactional
    public void addOrder(int userId, int priceId) {
        orderDao.save(userId, priceId);
    }

    //public ArrayList<Order> getOrderByPrice(int id) {
     //   return orderDao.findAllByEquipmentId();
   // }
}
