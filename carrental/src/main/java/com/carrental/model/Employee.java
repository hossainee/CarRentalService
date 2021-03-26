package com.carrental.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Employee {
    @Id
    @Column(name="ID",unique =true, nullable=false)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer Employee_ID;
    @Column(name="Branch_ID")
    private String Branch_ID;
    @Column(name="First_Name",unique =true, nullable=false,length =100)
    private String First_Name;
    @Column(name="Surname",unique =true, nullable=false,length =100)
    private String Surname;
    @Column(name="Position",unique =true, nullable=false,length =20)
    private String Position;

}
