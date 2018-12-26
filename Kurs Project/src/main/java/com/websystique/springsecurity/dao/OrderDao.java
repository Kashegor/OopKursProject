package com.websystique.springsecurity.dao;

import com.websystique.springsecurity.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

public interface OrderDao {
    void deleteByEquipmentIdAndUserId(int userId, int priceId);
    void save(int userId, int priceId);
}
