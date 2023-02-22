package com.vbsoft.flippoststarter.routes;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vbsoft.main.views.FlippostMainView;

@Route("")
public class FlippostRootView extends VerticalLayout {

    public FlippostRootView() {
        FlippostMainView view = new FlippostMainView();
        add(view);
    }
}
