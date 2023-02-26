package com.vbsoft.main.models;

import com.vbsoft.invoice.modeles.FlippostInvoice;
import com.vbsoft.orders.models.FlippestOrder;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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
    @Fetch(FetchMode.JOIN)
    FlippestOrder order;

    @OneToOne
    @JoinColumn(name = "invoice_id")
    @Fetch(FetchMode.JOIN)
    FlippostInvoice invoice;
}
