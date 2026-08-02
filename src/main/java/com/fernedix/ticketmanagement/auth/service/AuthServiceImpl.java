package com.fernedix.ticketmanagement.auth.service;

import com.fernedix.ticketmanagement.auth.dto.RegisterRequest;
import com.fernedix.ticketmanagement.auth.dto.RegisterResponse;
import com.fernedix.ticketmanagement.auth.mapper.AuthMapper;
import com.fernedix.ticketmanagement.common.constant.SecurityConstants;
import com.fernedix.ticketmanagement.user.Role;
import com.fernedix.ticketmanagement.user.RoleRepository;
import com.fernedix.ticketmanagement.user.User;
import com.fernedix.ticketmanagement.user.UserRepository;
import com.fernedix.ticketmanagement.user.exception.RoleNotFoundException;
import com.fernedix.ticketmanagement.user.exception.UserAlreadyExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthMapper authMapper;

    @Override
    public RegisterResponse register(RegisterRequest request) {

        if (userRepository.existsByEmail(request.email())) {
            throw new UserAlreadyExistsException(request.email());
        }

        User user = authMapper.toEntity(request);

        user.setPassword(passwordEncoder.encode(request.password()));

        user.setEnabled(true);

        Role customerRole = roleRepository
                .findByName(SecurityConstants.ROLE_CUSTOMER)
                .orElseThrow(() ->
                        new RoleNotFoundException(SecurityConstants.ROLE_CUSTOMER));

        user.addRole(customerRole);

        User savedUser = userRepository.save(user);

        return authMapper.toResponse(savedUser);
    }
}