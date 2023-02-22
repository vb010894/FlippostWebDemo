package com.vbsoft.orders.repository;

import com.vbsoft.orders.models.FlippestOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlippestOrderRepository extends JpaRepository<FlippestOrder, Long> {
}