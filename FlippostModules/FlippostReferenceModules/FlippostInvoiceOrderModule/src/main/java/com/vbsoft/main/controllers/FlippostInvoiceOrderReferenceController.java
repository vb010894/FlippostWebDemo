package com.vbsoft.main.controllers;

import com.vaadin.flow.component.dialog.Dialog;
import com.vbsoft.invoice.views.FlippostInvoiceCreate;
import com.vbsoft.main.views.FlippostMainView;
import com.vbsoft.orders.views.FlippostOrderCreate;

public class FlippostInvoiceOrderReferenceController {

    public void showInvoice(FlippostMainView view) {
        Dialog create = new FlippostInvoiceCreate().getInvoiceWindow();
        view.add(create);
        create.open();
    }

    public void showOrder(FlippostMainView view) {
        Dialog orderCreate = new FlippostOrderCreate().getWindow();
        view.add(orderCreate);
        orderCreate.open();
    }

}
