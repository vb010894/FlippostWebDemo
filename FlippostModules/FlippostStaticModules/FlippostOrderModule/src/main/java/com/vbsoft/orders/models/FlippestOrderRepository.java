package com.vbsoft.orders.models;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlippestOrderRepository extends JpaRepository<FlippestOrder, Long> {
}