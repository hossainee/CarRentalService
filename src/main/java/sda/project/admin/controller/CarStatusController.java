package sda.project.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import sda.project.admin.model.Branch;
import sda.project.admin.model.CarStatus;
import sda.project.admin.service.BranchService;
import sda.project.admin.service.CarStatusService;
import sda.project.admin.service.CompanyService;

@Controller
public class CarStatusController {
    @Autowired
    private CarStatusService carStatusService;




    // display list of employees
    @GetMapping("/viewCarStatus")
    public String viewCarStatus(Model model) {
        model.addAttribute("allCarStatus", carStatusService.getAllCarStatus());
        return "viewCarStatus";
    }

    @GetMapping("/newCarStatus")
    public String newCarStatus(Model model) {
        // create model attribute to bind form data
        CarStatus carStatus = new CarStatus();
        model.addAttribute("carStatus", carStatus);
       // model.addAttribute("allCompany",companyService.getAllCompany());
        return "newCarStatus";
    }

    @PostMapping("/saveCarStatus")
    public String saveCarStatus(@ModelAttribute("carStatus") CarStatus carStatus) {
        // save employee to database
        carStatusService.saveCarStatus(carStatus);
        return "redirect:/viewCarStatus";
    }

    @GetMapping("/updateCarStatus/{id}")
    public String updateCarStatus(@PathVariable(value = "id") long id, Model model) {
        // get employee from the service
        CarStatus carStatus = carStatusService.getCarStatusById(id);
        // set employee as a model attribute to pre-populate the form
        model.addAttribute("carStatus", carStatus);
        return "viewCarStatus";
    }

    @GetMapping("/deleteCarStatus/{id}")
    public String deleteCarStatus(@PathVariable(value = "id") long id) {

        // call delete employee method
        this.carStatusService.deleteCarStatusById(id);
        return "redirect:/";
    }


}
