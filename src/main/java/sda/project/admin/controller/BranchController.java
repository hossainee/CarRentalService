package sda.project.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import sda.project.admin.model.Branch;
import sda.project.admin.service.BranchService;
import sda.project.admin.service.CompanyService;


@Controller
public class BranchController {

    @Autowired
    private BranchService branchService;

    @Autowired
    private CompanyService companyService;


    // display list of employees
    @GetMapping("/viewBranch")
    public String viewBranch(Model model) {
        model.addAttribute("allBranch", branchService.getAllBranch());
        return "viewBranch";
    }

    @GetMapping("/newBranch")
    public String newBranch(Model model) {
        // create model attribute to bind form data
        Branch branch = new Branch();
        model.addAttribute("branch", branch);
        model.addAttribute("allCompany",companyService.getAllCompany());
        return "newBranch";
    }

    @PostMapping("/saveBranch")
    public String saveBranch(@ModelAttribute("branch") Branch branch) {
        // save employee to database
        branchService.saveBranch(branch);
        return "redirect:/viewBranch";
    }

    @GetMapping("/updateBranch/{id}")
    public String updateBranch(@PathVariable(value = "id") long id, Model model) {
        // get employee from the service
        Branch branch = branchService.getBranchById(id);
        // set employee as a model attribute to pre-populate the form
        model.addAttribute("branch", branch);
        return "viewBranch";
    }

    @GetMapping("/deleteBranch/{id}")
    public String deleteBranch(@PathVariable(value = "id") long id) {

        // call delete employee method
        this.branchService.deleteBranchById(id);
        return "redirect:/";
    }




}
