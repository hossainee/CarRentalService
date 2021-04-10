package sda.project.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import sda.project.admin.model.Branch;
import sda.project.admin.model.CarBrand;
import sda.project.admin.service.BranchService;
import sda.project.admin.service.CarBrandService;
import sda.project.admin.service.CompanyService;

@Controller
public class CarBrandController {
    @Autowired
    private CarBrandService carBrandService;




    // display list of employees
    @GetMapping("/viewCarBrand")
    public String viewCarBrand(Model model) {
        model.addAttribute("allCarBrand", carBrandService.getAllCarBrand());
        return "viewCarBrand";
    }

    @GetMapping("/newCarBrand")
    public String newCarBrand(Model model) {
        // create model attribute to bind form data
        CarBrand carBrand = new CarBrand();
        model.addAttribute("carBrand", carBrand);

        return "newCarBrand";
    }

    @PostMapping("/saveCarBrand")
    public String saveCarBrand(@ModelAttribute("carBrand") CarBrand carBrand) {
        // save employee to database
        carBrandService.saveCarBrand(carBrand);
        return "redirect:/viewCarBrand";
    }

    @GetMapping("/updateCarBrand/{id}")
    public String updateCarBrand(@PathVariable(value = "id") long id, Model model) {
        // get employee from the service
        CarBrand carBrand = carBrandService.getCarBrandById(id);
        // set employee as a model attribute to pre-populate the form
        model.addAttribute("carBrand", carBrand);
        return "viewCarBrand";
    }

    @GetMapping("/deleteCarBrand/{id}")
    public String deleteCarBrand(@PathVariable(value = "id") long id) {

        // call delete employee method
        this.carBrandService.deleteCarBrandById(id);
        return "redirect:/";
    }


}
