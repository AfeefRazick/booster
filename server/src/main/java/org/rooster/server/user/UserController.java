package org.rooster.server.user;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(("/user"))
public class UserController {
    @GetMapping(path = "/create")
    public void addUser(){

    }
}