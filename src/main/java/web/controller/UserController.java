package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.User;
import web.service.UserService;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping({"/","/list", "/show"})
    public String showUsers(Model model) {
        model.addAttribute("users", userService.getUserTable());
        return "list";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "/new";
    }

    @PostMapping("/new")
    public String create(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/show";
    }

    @GetMapping("/update")
    public String editUser(Model model, @RequestParam("id") long id) {
        model.addAttribute("user", userService.findUser(id));
        return "/edit";
    }

    @PostMapping("/edit")
    public String update(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/show";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") long id) {
        userService.deleteUser(id);
        return "redirect:/show";
    }
}
