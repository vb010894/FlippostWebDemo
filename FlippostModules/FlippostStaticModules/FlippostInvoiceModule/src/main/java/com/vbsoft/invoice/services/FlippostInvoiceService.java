package com.vbsoft.invoice.services;

import com.vbsoft.invoice.modeles.FlippostInvoice;
import com.vbsoft.invoice.repository.FlippostInvoiceRepository;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class FlippostInvoiceService {

    FlippostInvoiceRepository repository;

    @Autowired
    public FlippostInvoiceService(FlippostInvoiceRepository repository) {
        this.repository = repository;
    }

    public void save(FlippostInvoice invoice) {
        this.repository.save(invoice);
    }

    public List<FlippostInvoice> getAll() {
        return this.repository.findAll();
    }
}
