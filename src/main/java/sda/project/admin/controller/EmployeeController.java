package sda.project.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import sda.project.admin.model.Employee;
import sda.project.admin.service.BranchService;
import sda.project.admin.service.EmployeeService;

@Controller
public class EmployeeController {


    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private BranchService branchService;


    // display list of employees
    @GetMapping("/viewEmployee")
    public String viewEmployee(Model model) {
        model.addAttribute("allEmployee", employeeService.getAllEmployee());

        return "viewEmployee";
    }

    @GetMapping("/newEmployee")
    public String newEmployee(Model model) {
        // create model attribute to bind form data
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        model.addAttribute("allBranch", branchService.getAllBranch());
        return "newEmployee";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        // save employee to database
        employeeService.saveEmployee(employee);
        return "redirect:/viewEmployee";
    }

    @GetMapping("/updateEmployee/{id}")
    public String updateEmployee(@PathVariable(value = "id") long id, Model model) {

        // get employee from the service
        Employee employee = employeeService.getEmployeeById(id);

        // set employee as a model attribute to pre-populate the form
        model.addAttribute("employee", employee);
        return "viewEmployee";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable(value = "id") long id) {

        // call delete employee method
        this.employeeService.deleteEmployeeById(id);
        return "redirect:/";
    }


}
