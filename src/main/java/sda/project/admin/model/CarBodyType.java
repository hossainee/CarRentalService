package sda.project.admin.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "CarBodyType")
public class CarBodyType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="BodyType_ID")
    private long bodyTypeId;

    @Column(name = "Body_Type", unique = true, length=30)
    private String bodyType;


}
