package com.vbsoft.main.models;

import com.vbsoft.invoice.modeles.FlippostInvoice;
import com.vbsoft.orders.models.FlippestOrder;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FlippostInvoiceOrderReference {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @OneToOne
    @JoinColumn(name = "order_id")
    FlippestOrder order;

    @OneToOne
    @JoinColumn(name = "invoice_id")
    FlippostInvoice invoice;
}
