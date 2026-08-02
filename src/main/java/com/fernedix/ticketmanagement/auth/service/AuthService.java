package com.fernedix.ticketmanagement.auth.service;

import com.fernedix.ticketmanagement.auth.dto.RegisterRequest;
import com.fernedix.ticketmanagement.auth.dto.RegisterResponse;

public interface AuthService {

    RegisterResponse register(RegisterRequest request);

}