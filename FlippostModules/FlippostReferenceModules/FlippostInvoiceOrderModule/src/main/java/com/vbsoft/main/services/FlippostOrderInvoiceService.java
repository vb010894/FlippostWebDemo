package com.vbsoft.main.services;

import com.vbsoft.main.models.FlippostInvoiceOrderReference;
import com.vbsoft.main.repositories.FlippostInvoiceOrderReferenceRepository;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class FlippostOrderInvoiceService {

    FlippostInvoiceOrderReferenceRepository repository;

    @Autowired
    public FlippostOrderInvoiceService(FlippostInvoiceOrderReferenceRepository repository) {
        this.repository = repository;
    }

    public List<FlippostInvoiceOrderReference> getAllRef() {
        return this.repository.findAll();
    }
}
