package com.example.cm.data.dao.impl;

import com.example.cm.data.dao.UserDAO;
import com.example.cm.data.entity.User;
import com.example.cm.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class UserDAOImpl implements UserDAO {
    private final UserRepository userRepository;

    @Autowired
    public UserDAOImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User insertUser(User user) {
        User saveUser = userRepository.save(user);

        return saveUser;
    }

    @Override
    public User selectUser(Long userId) {
        User selectUser = userRepository.getReferenceById(userId);

        return selectUser;
    }

    @Override
    public User updateUserName(Long userId, String userName) throws Exception {
        Optional<User> selectedUser = userRepository.findById(userId);

        User updatedUser;
        if(selectedUser.isPresent()) {
            User user = selectedUser.get();

            user.setUserName(userName);
            user.setUpdatedAt(LocalDateTime.now());

            updatedUser = userRepository.save(user);
        } else {
            throw new Exception();
        }

        return updatedUser;
    }

    @Override
    public void deleteUser(Long userId) throws Exception {
        Optional<User> selectedUser = userRepository.findById(userId);

        if(selectedUser.isPresent()) {
            User user = selectedUser.get();

            userRepository.delete(user);
        } else {
            throw new Exception();
        }
    }
}
