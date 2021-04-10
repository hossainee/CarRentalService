package sda.project.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import sda.project.admin.model.Branch;
import sda.project.admin.model.CarModel;
import sda.project.admin.service.BranchService;
import sda.project.admin.service.CarModelService;
import sda.project.admin.service.CompanyService;

@Controller
public class CarModelController {
    @Autowired
    private CarModelService carModelService;


    // display list of employees
    @GetMapping("/viewCarModel")
    public String viewCarModel(Model model) {
        model.addAttribute("allCarModel", carModelService.getAllCarModel());
        return "viewCarModel";
    }

    @GetMapping("/newCarModel")
    public String newCarModel(Model model) {
        // create model attribute to bind form data
        CarModel carModel = new CarModel();
        model.addAttribute("carModel", carModel);
       // model.addAttribute("allCompany",companyService.getAllCompany());
        return "newCarModel";
    }

    @PostMapping("/saveCarModel")
    public String saveCarModel(@ModelAttribute("carModel") CarModel carModel) {
        // save employee to database
        carModelService.saveCarModel(carModel);
        return "redirect:/viewCarModel";
    }

    @GetMapping("/updateCarModel/{id}")
    public String updateCarModel(@PathVariable(value = "id") long id, Model model) {
        // get employee from the service
        CarModel carModel = carModelService.getCarModelById(id);
        // set employee as a model attribute to pre-populate the form
        model.addAttribute("carModel", carModel);
        return "viewCarModel";
    }

    @GetMapping("/deleteCarModel/{id}")
    public String deleteCarModel(@PathVariable(value = "id") long id) {

        // call delete employee method
        this.carModelService.deleteCarModelById(id);
        return "redirect:/";
    }


}
