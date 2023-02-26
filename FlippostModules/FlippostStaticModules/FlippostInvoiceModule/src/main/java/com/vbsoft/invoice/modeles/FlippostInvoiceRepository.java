package com.vbsoft.invoice.modeles;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlippostInvoiceRepository extends JpaRepository<FlippostInvoice, Long> {
}