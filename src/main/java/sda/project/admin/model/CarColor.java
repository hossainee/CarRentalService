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
@Table(name = "CarColor")
public class CarColor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Color_ID")
    private long colorId;

    @Column(name = "Color_Name", unique = true, length=30)
    private String colorName;


}
