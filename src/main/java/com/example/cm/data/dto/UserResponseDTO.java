package com.example.cm.data.dto;

import com.example.cm.data.entity.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseDTO {
    private Long id;
    private String name;
    private String password;
    private User.Role role;

    public UserResponseDTO() {}

    public UserResponseDTO(Long id, String name, String password, User.Role role) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.role = role;
    }
}
