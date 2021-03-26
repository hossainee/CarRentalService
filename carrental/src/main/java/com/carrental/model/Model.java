package com.carrental.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Model {
    @Id
    @Column(name="Model_ID",unique =true, nullable=false)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer Model_ID;
    @Column(name="Status",unique =true, nullable=false,length =30)
    private String Status;
}
