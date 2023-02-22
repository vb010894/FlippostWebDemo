package com.vbsoft.invoice.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.spring.annotation.UIScope;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@UIScope
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@NoArgsConstructor
public class FlippostInvoiceCreate extends VerticalLayout {

    Dialog window = new Dialog();

    TextField number = new TextField("Номер накладной");
    NumberField weight = new NumberField("Вес");
    NumberField volumeWeight = new NumberField("Объемный вес");
    NumberField places = new NumberField("Мес");

    Button save = new Button("Сохранть", VaadinIcon.FILE_ADD.create());
    Button cancel = new Button("Отмена", VaadinIcon.CLOSE.create());


    public Dialog getInvoiceWindow() {
        FormLayout form = new FormLayout(number, weight, volumeWeight, places);
        this.window.add(form);
        this.window.getFooter().add(save, cancel);
        add(this.window);
        return window;
    }
}
