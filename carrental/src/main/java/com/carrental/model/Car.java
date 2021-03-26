package com.carrental.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Car {
    @Id
    @Column(name="ID",unique =true, nullable=false)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer Car_ID;
    @Column(name="Branch_ID")
    private Integer Branch_ID;
    @Column(name="Car_Code",unique =true, nullable=false,length =100)
    private Integer Car_Code;
    @Column(name="Brand_ID")
    private Integer Brand_ID;
    @Column(name="Model_ID")
    private Integer Model_ID;
    @Column(name="BodyType_ID")
    private Integer BodyType_ID;
    @Column(name="Color_ID")
    private Integer Color_ID;
    @Column(name="Year")
    private Integer Year;
    @Column(name="Per_date_rate")
    private Float Per_date_rate;
    @Column(name="Status_ID")
    private Integer Status_ID;



}
