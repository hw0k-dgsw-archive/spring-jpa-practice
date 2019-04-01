package kr.hs.dgsw.web_0326.controllers;

import kr.hs.dgsw.web_0326.domains.User;
import kr.hs.dgsw.web_0326.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public User addUser(@RequestBody User user) {
        return this.userService.addUser(user);
    }

    @GetMapping("/user")
    public List<User> listAllUsers() {
        return this.userService.listAllUsers();
    }

    @GetMapping("/user/{id}")
    public User viewUser(@PathVariable Long id) {
        return this.userService.viewUser(id);
    }

    @PutMapping("/user/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        return this.userService.updateUser(id, user);
    }

    @DeleteMapping("/user/{id}")
    public boolean deleteUser(@PathVariable Long id) {
        return this.userService.deleteUser(id);
    }
}
