package com.carrental.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity

public class ReservationStatus {

    @Id
    @Column(name="ID",unique =true, nullable=false)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer Status_ID;
    @Column(name="Status",unique =true, nullable=false,length =30)
    private Integer Status;
}
