package edu.icet.service;

import edu.icet.dto.SignupRequest;
import edu.icet.dto.UserDto;

public interface AuthService {

    UserDto createUser(SignupRequest signupRequest);
    Boolean hasUserWithEmail(String email);


}
