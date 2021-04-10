package sda.project.admin.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import sda.project.admin.config.WebSecurityConfig;
import sda.project.admin.model.Customer;
import sda.project.admin.repository.CarRepository;
import sda.project.admin.repository.UserRepository;


@Controller
public class AppController {

    @Autowired
    private CarRepository carRepository;


    @Autowired
    private UserRepository userRepository;



    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("allCarDetail",  carRepository.getAvailableCar());

        return "userHome";
    }

    @GetMapping("/userHome")
    public String viewHomePage2(Model model) {
        model.addAttribute("allCarDetail",  carRepository.getAvailableCar());

        return "userHome";
    }

    @GetMapping("/innerHome")
    public String viewHomePage3(Model model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        Customer customer = userRepository.findByEmail(currentPrincipalName);

        model.addAttribute("loginCustomer",customer);
        model.addAttribute("allCarDetail",  carRepository.getAvailableCar());
        return "innerHome";
    }



 //   @GetMapping("/userReg")
  //  public String viewRegPage() {
  //      return "userReg";
 //   }

    @GetMapping("/login")
    public String viewLoginPage()
    {
        return "login";
    }

    @GetMapping("/home")
    public String viewAdminPage()
    {
        return "home";
    }


}
