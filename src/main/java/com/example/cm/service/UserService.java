package com.example.cm.service;

import com.example.cm.data.dto.UserDTO;
import com.example.cm.data.dto.UserResponseDTO;

public interface UserService {
    UserResponseDTO getUser(Long id);

    UserResponseDTO saveUser(UserDTO userDTO);

    UserResponseDTO changeUserName(Long id, String name) throws Exception;

    void deleteUser(Long id) throws Exception;

}
