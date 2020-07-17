package cn.alexpy.controller;

import cn.alexpy.entity.User;
import cn.alexpy.service.IUserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping("/init")
    public String init() {
        userService.init();
        return "OK";
    }

    @PostMapping("/add")
    public String add(@RequestParam("name") String name) {
        userService.add(name);
        return "OK";
    }

    @PostMapping("/find")
    public User find(@RequestParam("name") String name) {
        return userService.find(name);
    }

    @PostMapping("/like")
    public List<User> like(@RequestParam("name") String name) {
        return userService.like(name);
    }

    @PostMapping("/findAll")
    public List<User> findAll() {
        return userService.findAll();
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("id") Integer id) {
        userService.delete(id);
        return "OK";
    }

    @PostMapping("/deleteAll")
    public String deleteAll() {
        userService.deleteAll();
        return "OK";
    }

}
