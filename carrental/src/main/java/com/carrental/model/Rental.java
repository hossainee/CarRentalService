package com.carrental.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Rental {
    @Id
    @Column(name="ID",unique =true, nullable=false)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer Company_ID;
    @Column(name="Address",unique =true, nullable=false,length =200)
    private String CompanyName;
    @Column(name="Address",unique =true, nullable=false,length =100)
    private String Address;
    @Column(name="Owner",unique =true, nullable=false,length =100)
    private String Owner;
    @Column(name="Web",unique =true, nullable=false,length =100)
    private String Web;
    @Column(name="Email",unique =true, nullable=false,length =100)
    private String Email;
    @Column(name="Phone",unique =true, nullable=false,length =20)
    private String Phone;

}
