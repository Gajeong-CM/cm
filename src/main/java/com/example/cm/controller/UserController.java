package com.example.cm.controller;

//import com.example.cm.service.UserService;
import com.example.cm.data.dto.UserDTO;
import com.example.cm.data.dto.UserResponseDTO;
import com.example.cm.data.entity.User;
import com.example.cm.data.repository.UserRepository;
import com.example.cm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public String userFrom() {
        return "UserFrom";
    }
    @PostMapping("/signup")
    public UserResponseDTO signup(UserDTO userDTO) {
        return userService.saveUser(userDTO);
    }
    @PostMapping("/login")
    public UserResponseDTO login(UserDTO userDTO) {
        return userService.saveUser(userDTO);
    }

//    @GetMapping("/signup")
//    public String signupFrom() {
//        return "signup";
//    }

//    @PostMapping("/signup")
//    public UserResponseDTO signup(UserDTO userDTO) {
//        return userService.saveUser(userDTO);
//    }

//    @PostMapping("/signup")
//    public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserDTO userDTO) {
//        UserResponseDTO userResponseDTO = userService.saveUser(userDTO);
//
//        return ResponseEntity.status(HttpStatus.OK).body(userResponseDTO);
//    }
}
