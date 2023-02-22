package com.vbsoft.invoice.controllers;

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

    public void add(FlippostInvoiceCreate form) {
        FlippostInvoice invoice = new FlippostInvoice();
        invoice.setNumber(form.getNumber().getValue());
        invoice.setWeight(form.getWeight().getValue().floatValue());
        invoice.setVolumeWeight(form.getVolumeWeight().getValue().floatValue());
        invoice.setPlaces(form.getPlaces().getValue().floatValue());
        this.service.save(invoice);

    }



}
