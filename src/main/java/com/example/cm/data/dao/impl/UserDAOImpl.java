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
    public User selectUser(Long id) {
        User selectUser = userRepository.getReferenceById(id);

        return selectUser;
    }

    @Override
    public User updateUserName(Long id, String name) throws Exception {
        Optional<User> selectedUser = userRepository.findById(id);

        User updatedUser;
        if(selectedUser.isPresent()) {
            User user = selectedUser.get();

            user.setName(name);
            user.setUpdatedAt(LocalDateTime.now());

            updatedUser = userRepository.save(user);
        } else {
            throw new Exception();
        }

        return updatedUser;
    }

    @Override
    public void deleteUser(Long id) throws Exception {
        Optional<User> selectedUser = userRepository.findById(id);

        if(selectedUser.isPresent()) {
            User user = selectedUser.get();

            userRepository.delete(user);
        } else {
            throw new Exception();
        }
    }
}
