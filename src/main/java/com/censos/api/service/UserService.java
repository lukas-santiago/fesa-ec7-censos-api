package com.censos.api.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.censos.api.entity.User;
import com.censos.api.repository.UserRepository;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class UserService {
    private final UserRepository userRepository;

    public User create(User user) {
        Optional<User> findUserByEmail = userRepository.findByEmail(user.getEmail());
        if (findUserByEmail.isEmpty()) {
            throw new RuntimeException("Already exists user with this email");
        }
        // user.setId(null);
        log.debug("Creating user:" + user);
        return userRepository.save(user);
    }

    public List<User> list() {
        log.debug("Listing users");
        return userRepository.findAll();
    }

    public User get(Long id) {
        Optional<User> findById = userRepository.findById(id);
        if (findById.isEmpty()) {
            throw new RuntimeException("User don't exists");
        }
        log.debug("get user by id: " + id);
        return userRepository.findById(id).get();
    }

    public User update(User user) {
        Optional<User> findById = userRepository.findById(user.getId());
        if (findById.isEmpty()) {
            throw new RuntimeException("User don't exists");
        }
        log.debug("updatting user: " + user);
        userRepository.save(user);
        return user;
    }

    public Boolean delete(Long id) {
        Optional<User> findById = userRepository.findById(id);
        if (findById.isEmpty()) {
            throw new RuntimeException("User don't exists");
        }
        log.debug("delete user by id: " + id);
        userRepository.deleteById(id);
        return true;
    }
}
