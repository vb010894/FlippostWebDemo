package com.vbsoft.orders.models;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Table(name = "Orders")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FlippestOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String senderName;

    String resiverName;

}
