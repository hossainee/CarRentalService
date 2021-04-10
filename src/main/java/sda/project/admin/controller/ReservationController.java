package sda.project.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import sda.project.admin.model.Car;

import sda.project.admin.model.Customer;

import sda.project.admin.repository.UserRepository;
import sda.project.admin.service.BranchService;
import sda.project.admin.service.CarService;

@Controller
public class ReservationController {



     @Autowired
    BranchService branchService;

    @Autowired
    CarService carService;

    @Autowired
    UserRepository userRepository;


    @GetMapping("/reservation/{id}")
    public String updateReservation(@PathVariable(value = "id") long id, Model model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        Customer customer = userRepository.findByEmail(currentPrincipalName);

        model.addAttribute("customer",customer);

        Car car = carService.getCarById(id);
        model.addAttribute("allBranch", branchService.getAllBranch());
        model.addAttribute("car", car);
        return "newReservation";
    }









    }
