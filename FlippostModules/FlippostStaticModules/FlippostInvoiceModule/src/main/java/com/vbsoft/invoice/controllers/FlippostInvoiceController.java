package com.vbsoft.invoice.controllers;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vbsoft.invoice.modeles.FlippostInvoice;
import com.vbsoft.invoice.services.FlippostInvoiceService;
import com.vbsoft.invoice.views.FlippostInvoiceCreate;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class FlippostInvoiceController {

    FlippostInvoiceService service;

    @Autowired
    public FlippostInvoiceController(FlippostInvoiceService service) {
        this.service = service;
    }


    public void cancelEvent(Dialog window) {
        window.close();
    }

    public void saveEvent(Binder<FlippostInvoice> binder) {
        FlippostInvoice invoice = new FlippostInvoice();
        try {
            binder.writeBean(invoice);
        } catch (ValidationException e) {
            Notification.show("Не удалось сохранить накладную. Ошибка валидации");
            return;
        }
        this.service.save(invoice);
    }



}
