package com.deploy.prakrikum1.service.Impl;

import com.deploy.prakrikum1.mapper.UserMapper;
import com.deploy.prakrikum1.model.dto.UserAddRequest;
import com.deploy.prakrikum1.model.dto.UserDto;
import com.deploy.prakrikum1.model.entity.User;
import com.deploy.prakrikum1.repository.UserRepository;
import com.deploy.prakrikum1.service.UserService;
import com.deploy.prakrikum1.util.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ValidationUtil validationUtil;

    @Override
    public UserDto AddUser(UserAddRequest request) {
        validationUtil.validate(request);

        User saveUser = User.builder()
                .id(UUID.randomUUID().toString())
                .name(request.getName())
                .age(request.getAge())
                .build();

        userRepository.save(saveUser);

        UserDto userDto = UserMapper.MAPPER.toUserDtoData(saveUser);

        return userDto;
    }

}