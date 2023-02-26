package com.vbsoft.flippoststarter.routes;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.VaadinSessionScope;
import com.vbsoft.main.views.FlippostMainView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.security.RolesAllowed;

@Component
@Route("")
@VaadinSessionScope
public class FlippostRootView extends VerticalLayout {

    FlippostMainView view;
    @Autowired
    public FlippostRootView(FlippostMainView view) {
        this.view = view;
        add(view);
    }
}
