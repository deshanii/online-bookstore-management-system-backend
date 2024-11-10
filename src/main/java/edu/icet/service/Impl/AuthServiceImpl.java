package edu.icet.service.Impl;

import edu.icet.dto.SignupRequest;

import edu.icet.dto.UserDto;
import edu.icet.entity.User;
import edu.icet.enums.UserRole;
import edu.icet.repository.UserRepository;
import edu.icet.service.AuthService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    private final ModelMapper mapper;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserDto createUser(SignupRequest signupRequest) {
//        User user = new User();
//
//        user.setEmail(signupRequest.getEmail());
//        user.setName(signupRequest.getName());
//        user.setPassword(new BCryptPasswordEncoder().encode(signupRequest.getPassword()));
//        user.setRole(UserRole.CUSTOMER);
//        User createdUser = userRepository.save(user);
//
//        UserDto userDto = new UserDto();
//        userDto.setId((createdUser.getId()));
//
//        return userDto;

        return null;

    }

    @Override
    public UserDto createUser(UserDto userDto) {
        userDto.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
        User user = userRepository.save(mapper.map(userDto, User.class));
        return mapper.map(user, UserDto.class);
    }

    public Boolean hasUserWithEmail(String email){
        return userRepository.findFirstByEmail(email).isPresent();
    }

    @Override
    public User findUserByEmail(String email){
        return mapper.map(userRepository.findByEmail(email),User.class);
    }

    @PostConstruct
    public void createAdminAccount(){
//        User adminAccount = userRepository.findByRole(UserRole.ADMIN);
//        if(null == adminAccount){
//            User user = new User();
//            user.setEmail("admin@test.com");
//            user.setName("admin");
//            user.setRole(UserRole.ADMIN);
//            user.setPassword(new BCryptPasswordEncoder().encode("admin"));
//            userRepository.save(user);
//        }
    }
}
