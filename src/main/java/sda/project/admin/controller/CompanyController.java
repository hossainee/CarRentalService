package sda.project.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import sda.project.admin.model.Company;
import sda.project.admin.service.CompanyService;

@Controller
public class CompanyController {

    @Autowired
    private CompanyService companyService;


    // display list of employees
    @GetMapping("/viewCompany")
    public String viewCompany(Model model) {
        model.addAttribute("allCompany", companyService.getAllCompany());
        return "viewCompany";
    }

    @GetMapping("/newCompany")
    public String newCompany(Model model) {
        // create model attribute to bind form data
        Company company = new Company();
        model.addAttribute("company", company);
        return "newCompany";
    }

    @PostMapping("/saveCompany")
    public String saveCompany(@ModelAttribute("company") Company company) {
        // save employee to database
        companyService.saveCompany(company);
        return "redirect:/viewCompany";
    }

    @GetMapping("/updateCompany/{id}")
    public String updateCompany(@PathVariable(value = "id") long id, Model model) {

        // get employee from the service
        Company company = companyService.getCompanyById(id);
        // set employee as a model attribute to pre-populate the form
        model.addAttribute("company", company);
        return "viewCompany";
    }

    @GetMapping("/deleteCompany/{id}")
    public String deleteCompany(@PathVariable(value = "id") long id) {

        // call delete employee method
        this.companyService.deleteCompanyById(id);
        return "redirect:/";
    }




}
