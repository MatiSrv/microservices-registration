package com.project.template.services;

import org.springframework.stereotype.Service;

import com.project.template.models.User;

@Service
public interface UserService {
    User register(User user);
}
