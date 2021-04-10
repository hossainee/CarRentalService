package sda.project.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PostMapping;
import sda.project.admin.model.Customer;
import sda.project.admin.service.CustomerService;


@Controller
public class UserRegController {


    @Autowired
    private CustomerService customerService;


    // display list of employees
  //  @GetMapping("/viewEmployee")
 //   public String viewEmployee(Model model) {
 //       model.addAttribute("allEmployee", employeeService.getAllEmployee());
 //       return "viewEmployee";
 //   }

    @GetMapping("/userReg")
    public String newCustomer(Model model) {
        // create model attribute to bind form data
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "userReg";
    }

    @PostMapping("/saveUserReg")
    public String saveCustomer(@ModelAttribute("customer") Customer customer) {
        // save employee to database
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(customer.getPassword());
        customer.setPassword(encodedPassword);
     //   customer.setUserRole("USER");
        customerService.saveCustomer(customer);
        return "userConf";
    }

 //   @GetMapping("/updateEmployee/{id}")
 //   public String updateEmployee(@PathVariable(value = "id") long id, Model model) {

        // get employee from the service
  //      Employee employee = employeeService.getEmployeeById(id);

 //       // set employee as a model attribute to pre-populate the form
 //       model.addAttribute("employee", employee);
 //       return "viewEmployee";
//   }

 //   @GetMapping("/deleteEmployee/{id}")
 //   public String deleteEmployee(@PathVariable(value = "id") long id) {

        // call delete employee method
 //       this.employeeService.deleteEmployeeById(id);
 //       return "redirect:/";
 //   }


}
