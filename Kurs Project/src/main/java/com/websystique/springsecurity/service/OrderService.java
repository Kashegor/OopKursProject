package com.websystique.springsecurity.service;

import com.websystique.springsecurity.model.Order;

import java.util.ArrayList;

public interface OrderService {

    void deleteOrderByUser(int userId, int priceId);
    void addOrder(int userId, int priceId);
}
