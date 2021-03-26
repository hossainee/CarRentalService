package com.carrental.model;



import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity( name="Body_type")
public class BodyType {

    @Id
    @Column(name="ID",unique =true, nullable=false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer BodyType_ID;
    @Column(name="BodyType",unique =true, nullable=false,length =30)
    private String BodyType;
    @ToString.Exclude
    @OneToMany(mappedBy = "car")
    List<Car> cars;
}
