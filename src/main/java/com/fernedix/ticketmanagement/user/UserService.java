package com.fernedix.ticketmanagement.user;

import com.fernedix.ticketmanagement.auth.dto.RegisterRequest;
import com.fernedix.ticketmanagement.auth.dto.RegisterResponse;

public interface UserService {

    RegisterRequest register(RegisterResponse request);

}