package sda.project.admin.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AvailableCar {

    private long carId;
    private String branchName;
    private String carCode;
    private String brandName;
    private String modelName;
    private String bodyType;
    private String year;
    private String colorName;
    private double rentPerDay;

}
