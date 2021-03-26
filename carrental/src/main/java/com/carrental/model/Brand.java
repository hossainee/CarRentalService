package com.carrental.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity( name="brand")
public class Brand {

    @Id
    @Column(name="Brand_ID",unique =true, nullable=false)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer Brand_ID;
    @Column(name="Brand",unique =true, nullable=false,length =100)
    private String Brand;



}
