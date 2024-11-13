//package edu.icet.controller;
//
//import edu.icet.dto.AuthenticationRequest;
//import edu.icet.dto.AuthenticationResponse;
//import edu.icet.dto.UserDto;
//import edu.icet.entity.User;
//import edu.icet.repository.UserRepository;
//import edu.icet.service.AuthService;
//import edu.icet.util.JwtUtil;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//
//@RestController
//@RequiredArgsConstructor
//public class AuthController {
//
//    private final AuthenticationManager authenticationManager;
//
//    private final UserDetailsService userDetailsService;
//
//    private final UserRepository userRepository;
//
//    private final JwtUtil jwtUtil;
//
//    public static final String TOKEN_PREFIX = "Bearer";
//
//    public static final String  HEADER_SIRING = "Authorization";
//
//    private final AuthService authService;
//    private final AuthenticationManager authManager;
//
//
//
//    @PostMapping("/login")
//    public ResponseEntity<AuthenticationResponse> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
//        Authentication authentication =
//                authManager.authenticate(
//                        new UsernamePasswordAuthenticationToken(
//                                authenticationRequest.getEmail(),
//                                authenticationRequest.getPassword()
//                        )
//                );
//
//        if (authentication.isAuthenticated()) {
//            String token = jwtUtil.generateToken(authenticationRequest.getEmail());
//            User  user = authService.findUserByEmail(authenticationRequest.getEmail());
//            return new ResponseEntity<>(new AuthenticationResponse(token, user), HttpStatus.OK);
//        }
//        throw new RuntimeException("Invalid access");
//
//    }
//
//    @PostMapping("/signup")
//    public ResponseEntity<UserDto> signupUser(@RequestBody UserDto userDto){
//        UserDto user = authService.createUser(userDto);
//
//        return new ResponseEntity<>(user, HttpStatus.CREATED);
//    }
//
//}
