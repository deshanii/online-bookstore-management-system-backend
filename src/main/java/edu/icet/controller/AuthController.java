package edu.icet.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import edu.icet.dto.AuthenticationRequest;
import edu.icet.dto.SignupRequest;
import edu.icet.dto.UserDto;
import edu.icet.entity.User;
import edu.icet.repository.UserRepository;
import edu.icet.service.AuthService;
import edu.icet.util.JwtUtil;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.header.Header;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;

    private final UserDetailsService userDetailsService;

    private final UserRepository userRepository;

    private final JwtUtil jwtUtil;

    public static final String TOKEN_PREFIX = "Bearer";

    public static final String  HEADER_SIRING = "Authorization";

    private final AuthService authService;



    @PostMapping("/authenticate")
    public void createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest, HttpServletResponse response) throws IOException, JSONException {
         try{
             authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),
                     authenticationRequest.getPassword()));
         }catch (BadCredentialsException e){
             throw new BadCredentialsException("Incorrect username or password.");
         }

         final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
         Optional<User> optionalUser = userRepository.findFirstByEmail(userDetails.getUsername());
         final String jwt = jwtUtil.generateToken(userDetails.getUsername());

         if(optionalUser.isPresent()){
             response.getWriter().write(new JSONObject()
                     .put("userId", optionalUser.get().getId())
                     .put("role", optionalUser.get().getRole())
                     .toString()
             );


             response.addHeader(HEADER_SIRING , TOKEN_PREFIX + jwt);
         }

    }

    @PostMapping("/sign-up")
    public ResponseEntity<?> signupUser(@RequestBody SignupRequest signupRequest){
        if(authService.hasUserWithEmail(signupRequest.getEmail())){
            return new ResponseEntity<>("User already exixts" , HttpStatus.NOT_ACCEPTABLE);
        }

        UserDto userDto = authService.createUser(signupRequest);
        return new ResponseEntity<>(userDto, HttpStatus.OK);

    }

}
