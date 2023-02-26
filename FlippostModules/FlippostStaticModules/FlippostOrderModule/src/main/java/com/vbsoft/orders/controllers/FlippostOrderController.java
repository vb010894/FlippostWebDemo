package com.vbsoft.orders.controllers;

import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vbsoft.orders.models.FlippestOrder;
import com.vbsoft.orders.services.FlippostOrderService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FlippostOrderController {

    FlippostOrderService service;

    @Autowired
    public FlippostOrderController(FlippostOrderService repository) {
        this.service = repository;
    }

    public void saveEvent(Binder<FlippestOrder> binder) {
        FlippestOrder order = new FlippestOrder();
        try {
            binder.writeBean(order);
        } catch (ValidationException e) {
            Notification.show("Не возможно сохранить заказ. Ошибка валидации");
            return;

        }
        this.service.save(order);
    }

    public void cancelEvent(Dialog dialog) {
        dialog.close();
    }
}
