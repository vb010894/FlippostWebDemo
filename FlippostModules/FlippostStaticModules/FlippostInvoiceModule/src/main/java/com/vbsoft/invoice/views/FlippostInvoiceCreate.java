package com.vbsoft.invoice.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vbsoft.invoice.controllers.FlippostInvoiceController;
import com.vbsoft.invoice.modeles.FlippostInvoice;
import com.vbsoft.invoice.services.FlippostInvoiceService;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class FlippostInvoiceCreate extends VerticalLayout {

    FlippostInvoiceService service;
    FlippostInvoiceController controller;
    Dialog window = new Dialog();

    Binder<FlippostInvoice> binder = new Binder<>();

    TextField number = new TextField("Номер накладной");
    NumberField weight = new NumberField("Вес");
    NumberField volumeWeight = new NumberField("Объемный вес");
    IntegerField places = new IntegerField("Мес");

    Button save = new Button("Сохранть", VaadinIcon.FILE_ADD.create());
    Button cancel = new Button("Отмена", VaadinIcon.CLOSE.create());

    @Autowired
    public FlippostInvoiceCreate(FlippostInvoiceService service, FlippostInvoiceController controller) {
        this.service = service;
        this.controller = controller;
        this.initBinder();
        this.save.addClickListener(event -> this.controller.saveEvent(this.binder));
        this.cancel.addClickListener(event -> this.controller.cancelEvent(this.window));
    }


    public Dialog getInvoiceWindow() {
        FormLayout form = new FormLayout(number, weight, volumeWeight, places);
        this.window.add(form);
        this.window.getFooter().add(save, cancel);
        add(this.window);
        return window;
    }

    private void initBinder() {
        this.binder.forField(this.number).bind(FlippostInvoice::getNumber, FlippostInvoice::setNumber);
        this.binder.forField(this.weight).bind(FlippostInvoice::getWeight, FlippostInvoice::setWeight);
        this.binder.forField(this.volumeWeight).bind(FlippostInvoice::getVolumeWeight, FlippostInvoice::setVolumeWeight);
        this.binder.forField(this.places).bind(FlippostInvoice::getPlaces, FlippostInvoice::setPlaces);
    }


}
