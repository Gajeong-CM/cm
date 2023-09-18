package com.example.cm.service.impl;

import com.example.cm.data.dao.UserDAO;
import com.example.cm.data.dto.UserDTO;
import com.example.cm.data.dto.UserResponseDTO;
import com.example.cm.data.entity.User;
import com.example.cm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService {
    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public UserResponseDTO getUser(Long id) {
        User user = userDAO.selectUser(id);

        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setId(user.getId());
        userResponseDTO.setName(user.getName());
        userResponseDTO.setPassword(user.getPassword());
        userResponseDTO.setRole(user.getRole());

        return userResponseDTO;
    }

    @Override
    public UserResponseDTO saveUser(UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        user.setPassword(userDTO.getPassword());
        user.setRole(userDTO.getRole());
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());

        User savedUser = userDAO.insertUser(user);

        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setId(savedUser.getId());
        userResponseDTO.setName(savedUser.getName());
        userResponseDTO.setPassword(savedUser.getPassword());
        userResponseDTO.setRole(savedUser.getRole());

        return userResponseDTO;
    }

    @Override
    public UserResponseDTO changeUserName(Long id, String name) throws Exception {
        User changeUser = userDAO.updateUserName(id, name);

        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setId(changeUser.getId());
        userResponseDTO.setName(changeUser.getName());
        userResponseDTO.setPassword(changeUser.getPassword());
        userResponseDTO.setRole(changeUser.getRole());

        return userResponseDTO;
    }

    @Override
    public void deleteUser(Long id) throws Exception {
        userDAO.deleteUser(id);
    }
}
