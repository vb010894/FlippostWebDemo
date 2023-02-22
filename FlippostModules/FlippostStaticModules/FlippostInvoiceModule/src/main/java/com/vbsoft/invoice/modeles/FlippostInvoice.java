package com.vbsoft.invoice.modeles;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Table(name = "Invoice")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FlippostInvoice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name = "number")
    String number;

    @Column(name = "weight")
    Float weight;

    @Column(name = "volumeWeight")
    Float volumeWeight;

    @Column(name = "places")
    Float places;
}
