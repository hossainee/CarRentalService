package sda.project.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import sda.project.admin.model.Branch;
import sda.project.admin.model.Car;
import sda.project.admin.service.*;

@Controller
public class CarController {

    @Autowired
    private CarService carService;

    @Autowired
    private CarBrandService carBrandService;

    @Autowired
    private CarModelService carModelService;

    @Autowired
    private CarBodyTypeService carBodyTypeService;

    @Autowired
    private CarColorService carColorService;

    @Autowired
    private CarStatusService carStatusService;

    @Autowired
    private BranchService branchService;

    @Autowired
    private CompanyService companyService;


    // display list of employees
    @GetMapping("/viewCar")
    public String viewCar(Model model) {
        model.addAttribute("allCar", carService.getAllCar());
        return "viewCar";
    }

    @GetMapping("/newCar")
    public String newCar(Model model) {
        // create model attribute to bind form data
        Car car = new Car();
        model.addAttribute("car", car);
        model.addAttribute("allCar",carService.getAllCar());
        model.addAttribute("allBranch",branchService.getAllBranch());
        model.addAttribute("allBrand",carBrandService.getAllCarBrand());
        model.addAttribute("allModel",carModelService.getAllCarModel());
        model.addAttribute("allColor",carColorService.getAllCarColor());
        model.addAttribute("allBodyType",carBodyTypeService.getAllCarBodyType());
        model.addAttribute("allCarStatus",carStatusService.getAllCarStatus());
        return "newCar";
    }

    @PostMapping("/saveCar")
    public String saveCar(@ModelAttribute("car") Car car) {
        // save employee to database
        carService.saveCar(car);
        return "redirect:/viewCar";
    }

    @GetMapping("/updateCar/{id}")
    public String updateCar(@PathVariable(value = "id") long id, Model model) {
        // get employee from the service
        Car car = carService.getCarById(id);
        // set employee as a model attribute to pre-populate the form
        model.addAttribute("car", car);
        return "viewCar";
    }

    @GetMapping("/deleteCar/{id}")
    public String deleteCar(@PathVariable(value = "id") long id) {

        // call delete employee method
        this.carService.deleteCarById(id);
        return "redirect:/";
    }


}
