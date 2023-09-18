package com.example.cm.service;

import com.example.cm.data.dto.UserDTO;
import com.example.cm.data.dto.UserResponseDTO;

public interface UserService {
    UserResponseDTO getUser(Long userId);

    UserResponseDTO saveUser(UserDTO userDTO);

    UserResponseDTO changeUserName(Long userId, String userName) throws Exception;

    void deleteUser(Long userId) throws Exception;

}
