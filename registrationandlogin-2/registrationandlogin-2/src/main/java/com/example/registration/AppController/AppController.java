package com.example.registration.AppController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.registration.User.User;
import com.example.registration.UserRepository.UserRepository;

import java.util.List;


@Controller
public class AppController {

	

@GetMapping("")
public String viewHomePage() {
return "index";
}

@GetMapping("/users")
public String listUsers(Model model) {
    List<User> listUsers = userRepo.findAll();
    model.addAttribute("listUsers", listUsers);
    return "users";
}

@GetMapping("/logout")
public String viewHomePageLogout() {
return "index";
}


@GetMapping("/index")
public String viewIndexPage() {
return "index";
}

@GetMapping("/draw")
public String viewDrawPage() {
return "draw";
}


@GetMapping("/view")
public String viewPage() {
return "view";
}


@GetMapping("/login")
public String loginPage() {
return "login";
}


@GetMapping("/register")
public String showRegistrationForm(Model model) {
model.addAttribute("user", new User());

return "signup_form";
}

@Autowired
private UserRepository userRepo;

@PostMapping("/process_register")
public String processRegister(User user) {
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    String encodedPassword = passwordEncoder.encode(user.getPassword());
    user.setPassword(encodedPassword);
     
    userRepo.save(user);
     
    return "register_success";
}


}