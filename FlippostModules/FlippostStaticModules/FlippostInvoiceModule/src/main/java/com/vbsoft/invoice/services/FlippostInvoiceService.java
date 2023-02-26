package com.vbsoft.invoice.services;

import com.vaadin.flow.component.notification.Notification;
import com.vbsoft.invoice.modeles.FlippostInvoice;
import com.vbsoft.invoice.modeles.FlippostInvoiceRepository;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class FlippostInvoiceService {

    FlippostInvoiceRepository repository;

   // @Autowired
    public FlippostInvoiceService(FlippostInvoiceRepository repository) {
        this.repository = repository;
    }

    public void save(FlippostInvoice invoice) {
        this.repository.save(invoice);
        Notification.show("Сохранено");
    }

}
