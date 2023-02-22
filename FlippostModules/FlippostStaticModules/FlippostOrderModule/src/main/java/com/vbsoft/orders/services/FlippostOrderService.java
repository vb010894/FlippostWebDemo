package com.vbsoft.orders.services;

import com.vbsoft.orders.models.FlippestOrder;
import com.vbsoft.orders.repository.FlippestOrderRepository;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class FlippostOrderService {

    FlippestOrderRepository repository;

    @Autowired
    public FlippostOrderService(FlippestOrderRepository repository) {
        this.repository = repository;
    }

    public void save(FlippestOrder order) {
        this.repository.save(order);
    }

    public List<FlippestOrder> getAll() {
        return this.repository.findAll();
    }
}
