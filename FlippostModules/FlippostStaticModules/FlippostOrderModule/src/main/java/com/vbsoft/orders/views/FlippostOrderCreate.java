package com.vbsoft.orders.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.spring.annotation.UIScope;
import com.vbsoft.orders.controllers.FlippostOrderController;
import com.vbsoft.orders.models.FlippestOrder;
import com.vbsoft.orders.services.FlippostOrderService;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FlippostOrderCreate {

    FlippostOrderService service;
    FlippostOrderController controller;

    Binder<FlippestOrder> binder = new Binder<>();

    Dialog window = new Dialog();

    TextField senderName = new TextField("Имя отправителя");
    TextField receiverName = new TextField("Имя получателя");
    Button save = new Button("Сохранить", VaadinIcon.FILE_ADD.create());
    Button cancel = new Button("Отмена", VaadinIcon.CLOSE.create());

    @Autowired
    public FlippostOrderCreate(FlippostOrderService service, FlippostOrderController controller) {
        this.initBinder();
        this.service = service;
        this.controller = controller;
        this.save.addClickListener(event -> this.controller.saveEvent(this.binder));
        this.cancel.addClickListener(event -> this.controller.cancelEvent(this.window));
    }

    public Dialog getCreateWindow() {
        FormLayout form = new FormLayout(this.senderName, this.receiverName);
        this.window.setHeaderTitle("Создание заказа");
        this.window.add(form);
        this.window.getFooter().add(save, cancel);
        return this.window;
    }

    private void initBinder() {
        this.binder.forField(this.senderName).bind(FlippestOrder::getSenderName, FlippestOrder::setSenderName);
        this.binder.forField(this.receiverName).bind(FlippestOrder::getResiverName, FlippestOrder::setResiverName);
    }
}
