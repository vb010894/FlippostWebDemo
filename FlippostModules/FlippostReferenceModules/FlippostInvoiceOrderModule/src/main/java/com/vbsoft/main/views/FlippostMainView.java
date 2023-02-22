package com.vbsoft.main.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.spring.annotation.UIScope;
import com.vbsoft.main.controllers.FlippostInvoiceOrderReferenceController;
import com.vbsoft.main.models.FlippostInvoiceOrderReference;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@UIScope
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class FlippostMainView extends VerticalLayout {

    FlippostInvoiceOrderReferenceController controller = new FlippostInvoiceOrderReferenceController();
    Button createOrder = new Button("Создать заказ");
    Button createInvoice = new Button("Создать накладную");

    HorizontalLayout tools = new HorizontalLayout(createOrder, createInvoice);

    Grid<FlippostInvoiceOrderReference> grid = new Grid<>();

    public FlippostMainView() {
        createOrder.addClickListener(listener -> this.controller.showOrder(this));
        createInvoice.addClickListener(listener -> this.controller.showInvoice(this));
        this.grid.addColumn(reference -> reference.getInvoice().getNumber()).setHeader("Номер накладной");
        this.grid.addColumn(reference -> reference.getInvoice().getWeight()).setHeader("Вес");
        this.grid.addColumn(reference -> reference.getInvoice().getVolumeWeight()).setHeader("Объемный вес");
        this.grid.addColumn(reference -> reference.getInvoice().getPlaces()).setHeader("Мест");
        this.grid.addColumn(reference -> reference.getOrder().getSenderName()).setHeader("Имя отправителя");
        this.grid.addColumn(reference -> reference.getOrder().getResiverName()).setHeader("Имя получателя");
        add(tools, grid);
    }
}
