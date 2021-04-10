package sda.project.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import sda.project.admin.model.Branch;
import sda.project.admin.model.CarColor;
import sda.project.admin.service.BranchService;
import sda.project.admin.service.CarColorService;
import sda.project.admin.service.CompanyService;

@Controller
public class CarColorController {
    @Autowired
    private CarColorService carColorService;


    // display list of employees
    @GetMapping("/viewCarColor")
    public String viewCarColor(Model model) {
        model.addAttribute("allCarColor", carColorService.getAllCarColor());
        return "viewCarColor";
    }

    @GetMapping("/newCarColor")
    public String newCarColor(Model model) {
        // create model attribute to bind form data
        CarColor carColor = new CarColor();
        model.addAttribute("carColor", carColor);
       // model.addAttribute("allCompany",companyService.getAllCompany());
        return "newCarColor";
    }

    @PostMapping("/saveCarColor")
    public String saveCarColor(@ModelAttribute("carColor") CarColor carColor) {
        // save employee to database
        carColorService.saveCarColor(carColor);
        return "redirect:/viewCarColor";
    }

    @GetMapping("/updateCarColor/{id}")
    public String updateCarColor(@PathVariable(value = "id") long id, Model model) {
        // get employee from the service
        CarColor carColor = carColorService.getCarColorById(id);
        // set employee as a model attribute to pre-populate the form
        model.addAttribute("carColor", carColor);
        return "viewCarColor";
    }

    @GetMapping("/deleteCarColor/{id}")
    public String deleteCarColor(@PathVariable(value = "id") long id) {

        // call delete employee method
        this.carColorService.deleteCarColorById(id);
        return "redirect:/";
    }


}
