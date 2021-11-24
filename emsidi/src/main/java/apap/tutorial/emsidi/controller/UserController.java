package apap.tutorial.emsidi.controller;

import apap.tutorial.emsidi.model.CabangModel;
import apap.tutorial.emsidi.model.RoleModel;
import apap.tutorial.emsidi.model.UserModel;
import apap.tutorial.emsidi.service.RoleService;
import apap.tutorial.emsidi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @GetMapping(value = "/add")
    private String addUserFormPage(Model model) {
        UserModel user = new UserModel();
        List<RoleModel> listRole = roleService.findAll();
        model.addAttribute("user", user);
        model.addAttribute("listRole", listRole);
        return "form-add-user";
    }

    @PostMapping(value = "/add")
    private String addUserSubmit(@ModelAttribute UserModel user, Model model) {
        userService.addUser(user);
        model.addAttribute("user", user);
        return "redirect:/";
    }

    @GetMapping(value = "/viewall")
    public String listUser(Model model){
        List<UserModel> listUser = userService.getUserList();
        model.addAttribute("listUser", listUser);
        return "viewall-user";
    }

    @GetMapping(value = "/delete/{username}")
    public String deleteUser(
            @PathVariable String username,
            Model model
    ){
        UserModel user = userService.getUserByUsername(username);
        model.addAttribute("user", user);
        userService.deleteUser(user);
        return "delete-user";
    }

    @RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
    private String FormUpdatePassword (@RequestParam(value = "oldPassword") String oldPassword,
                                       @RequestParam(value = "newPassword") String newPassword,
                                       @RequestParam(value = "confirmNewPassword") String confirmNewPassword,
                                       HttpServletRequest request, Model model) {
        Principal principal = request.getUserPrincipal();
        UserModel user = userService.getUserByUsername(principal.getName());

        if(!newPassword.equals(confirmNewPassword)) {
            model.addAttribute("pesanGagal", "Password baru tidak sesuai, harap input ulang!");
            return "form-update-password";
        }

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        if(passwordEncoder.matches(oldPassword, user.getPassword())) {
            boolean flagPassword = userService.checkPassword(newPassword);
            if(flagPassword == true) {
                userService.updatePasswordUser(user, newPassword);
                model.addAttribute("pesanBerhasil", "Password berhasil diubah!");
            } else {
                model.addAttribute("pesanGagal", "Password baru tidak sesuai, harap input ulang!");
            }
        } else {
            model.addAttribute("pesanGagal", "Password baru tidak sesuai, harap input ulang!");
            return "form-update-password";
        }
        return "form-update-password";
    }

    @GetMapping(value = "/updatePassword")
    private String FormUpdatePassword(){
        return "form-update-password";
    }

}
