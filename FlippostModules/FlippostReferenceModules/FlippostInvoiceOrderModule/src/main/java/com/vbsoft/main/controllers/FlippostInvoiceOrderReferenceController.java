package com.vbsoft.main.controllers;

import com.vaadin.flow.component.dialog.Dialog;
import com.vbsoft.invoice.views.FlippostInvoiceCreate;
import com.vbsoft.main.models.FlippostInvoiceOrderReference;
import com.vbsoft.main.services.FlippostOrderInvoiceService;
import com.vbsoft.main.views.FlippostMainView;
import com.vbsoft.orders.views.FlippostOrderCreate;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class FlippostInvoiceOrderReferenceController {

    FlippostOrderCreate orderCreate;
    FlippostInvoiceCreate invoiceCreate;

    FlippostOrderInvoiceService service;

    @Autowired
    public FlippostInvoiceOrderReferenceController(FlippostOrderCreate orderCreate, FlippostInvoiceCreate invoiceCreate, FlippostOrderInvoiceService service) {
        this.orderCreate = orderCreate;
        this.invoiceCreate = invoiceCreate;
        this.service = service;
    }

    public List<FlippostInvoiceOrderReference> getTableData() {
        return this.service.getAllRef();
    }

    public void showInvoice(FlippostMainView view) {
        Dialog create = this.invoiceCreate.getInvoiceWindow();
        view.add(create);
        create.open();
    }

    public void showOrder(FlippostMainView view) {
        Dialog orderCreate = this.orderCreate.getCreateWindow();
        view.add(orderCreate);
        orderCreate.open();
    }

}
