package com.jobportal.Controller;

import com.jobportal.Entities.Role;
import com.jobportal.Entities.Users;
import com.jobportal.Service.ApplicationService;
import com.jobportal.Service.JobService;
import com.jobportal.Service.UsersService;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegisterController {

    @Autowired
    private UsersService userService;
    
    @PostMapping("/login")
    public String processLogin(@RequestParam String email, @RequestParam String password, HttpSession session, Model model) {
        
    	var optionalUser = userService.findByEmail(email);
    	
        if (optionalUser.isPresent()) {
            Users user = optionalUser.get();
            if (userService.checkPassword(password, user.getPassword())) {
                session.setAttribute("currentUser", user);
                if (user.getRole().contains(Role.ROLE_RECRUITER)) {
                    return "redirect:/recruiter/rdashboard";
                } else if (user.getRole().contains(Role.ROLE_CANDIDATE)) {
                    return "redirect:/candidate/cdashboard";
                } else {
                    model.addAttribute("error", "User has no valid role assigned.");
                    return "login";
                }
            } else {
                model.addAttribute("error", "Invalid password");
                return "login";
            }
        } else {
            model.addAttribute("error", "User not found");
            return "login";
        }
    }
    
    @PostMapping("/register")
    public String newUser(@RequestParam String name, @RequestParam String email, @RequestParam String password, @RequestParam Role role, Model model)
    {
    	userService.registerUser(name, email, password, role);
    	model.addAttribute("sucess","User registered successfully!");
    	return "register";
    }
    
}
