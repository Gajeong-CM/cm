package com.example.cm.data.dto;

import com.example.cm.data.entity.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    private String name;
    private String password;
    private User.Role role;

    public UserDTO(String name, String password, User.Role role) {
        this.name = name;
        this.password = password;
        this.role = role;
    }
}
