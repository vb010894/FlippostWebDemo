package com.vbsoft.invoice.repository;

import com.vbsoft.invoice.modeles.FlippostInvoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlippostInvoiceRepository extends JpaRepository<FlippostInvoice, Long> {
}