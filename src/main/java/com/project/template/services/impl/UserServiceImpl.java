package com.project.template.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.project.template.entities.UserEntity;
import com.project.template.models.User;
import com.project.template.repositories.UserJpaRepository;
import com.project.template.services.UserService;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    UserJpaRepository userJpaRepository;

    @Override

    public User register(User user) {

        Optional<UserEntity> userOptional = userJpaRepository.findByEmail(user.getEmail());

        if(userOptional.isPresent()) {
            throw new DuplicateKeyException("This email already exists");
        }

        UserEntity userEntity = modelMapper.map(user, UserEntity.class);

        userJpaRepository.save(userEntity);

        return modelMapper.map(userEntity, User.class);

    }

}
