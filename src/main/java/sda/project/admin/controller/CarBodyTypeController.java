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
import sda.project.admin.model.CarBodyType;
import sda.project.admin.service.BranchService;
import sda.project.admin.service.CarBodyTypeService;
import sda.project.admin.service.CompanyService;

@Controller
public class CarBodyTypeController {

    @Autowired
    private CarBodyTypeService carBodyTypeService;




    // display list of employees
    @GetMapping("/viewCarBodyType")
    public String viewCarBodyType(Model model) {
        model.addAttribute("allCarBodyType", carBodyTypeService.getAllCarBodyType());
        return "viewCarBodyType";
    }

    @GetMapping("/newCarBodyType")
    public String newCarBodyType(Model model) {
        // create model attribute to bind form data
        CarBodyType carBodyType = new CarBodyType();
        model.addAttribute("carBodyType", carBodyType);
        return "newCarBodyType";
    }

    @PostMapping("/saveCarBodyType")
    public String saveCarBodyType(@ModelAttribute("carBodyType") CarBodyType carBodyType) {
        // save employee to database
        carBodyTypeService.saveCarBodyType(carBodyType);
        return "redirect:/viewCarBodyType";
    }

    @GetMapping("/updateCarBodyType/{id}")
    public String updateCarBodyType(@PathVariable(value = "id") long id, Model model) {
        // get employee from the service
        CarBodyType carBodyType = carBodyTypeService.getCarBodyTypeById(id);
        // set employee as a model attribute to pre-populate the form
        model.addAttribute("carBodyType", carBodyType);
        return "viewBranch";
    }

    @GetMapping("/deleteCarBodyType/{id}")
    public String deleteCarBodyType(@PathVariable(value = "id") long id) {

        // call delete employee method
        this.carBodyTypeService.deleteCarBodyTypeById(id);
        return "redirect:/";
    }



}
