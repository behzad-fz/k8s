package com.behzadfz.user.controller;

import com.behzadfz.user.VO.ResponseTemplateVO;
import com.behzadfz.user.entity.User;
import com.behzadfz.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user) {
        log.info("Inside Controller@save");

        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO findUserById(@PathVariable("id") Long id) {
        return userService.findUserById(id);
    }
}
