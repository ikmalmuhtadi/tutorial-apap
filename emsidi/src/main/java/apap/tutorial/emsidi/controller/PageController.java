package apap.tutorial.emsidi.controller;

import apap.tutorial.emsidi.model.UserModel;
import apap.tutorial.emsidi.service.RoleService;
import apap.tutorial.emsidi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class PageController {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @RequestMapping("/")
    public String home(HttpServletRequest request, Model model) {
        String username = request.getRemoteUser();
        UserModel user = userService.getUserByUsername(username);
        String role = user.getRole().getRole();
        model.addAttribute("role", role);
        return "home";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }
}
