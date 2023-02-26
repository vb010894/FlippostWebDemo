package com.vbsoft.invoice.modeles;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Table(name = "Invoice")
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FlippostInvoice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ToString.Exclude
    Long id;

    @Column(name = "number")
    String number;

    @Column(name = "weight")
    Double weight;

    @Column(name = "volumeWeight")
    Double volumeWeight;

    @Column(name = "places")
    Integer places;
}
