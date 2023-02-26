package com.vbsoft.orders.services;

import com.vaadin.flow.component.notification.Notification;
import com.vbsoft.orders.models.FlippestOrder;
import com.vbsoft.orders.models.FlippestOrderRepository;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class FlippostOrderService {

   FlippestOrderRepository repository;

    @Autowired
    public FlippostOrderService(FlippestOrderRepository repository) {
        this.repository = repository;
    }

    public void save(FlippestOrder order) {
        Notification.show("Сохранено");
        this.repository.save(order);
        System.out.println(order);
        //this.repository.save(order);
    }

}
