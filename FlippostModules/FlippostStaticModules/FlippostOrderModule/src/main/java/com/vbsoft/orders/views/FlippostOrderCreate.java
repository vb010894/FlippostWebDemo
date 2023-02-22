package com.vbsoft.orders.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.spring.annotation.UIScope;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

@Component
@UIScope
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class FlippostOrderCreate {

    Dialog window = new Dialog();

    TextField senderName = new TextField("Имя отправителя");
    TextField receiverName = new TextField("Имя получателя");
    Button save = new Button("Сохранить", VaadinIcon.FILE_ADD.create());
    Button cancel = new Button("Сохранить", VaadinIcon.FILE_ADD.create());

    public Dialog getCreateWindow() {
        FormLayout form = new FormLayout(this.senderName, this.receiverName);
        this.window.setHeaderTitle("Создание заказа");
        this.window.add(form);
        this.window.getFooter().add(save, cancel);
        return this.window;
    }
}
