//package edu.icet.service.Impl;
//
//import edu.icet.dto.UserValidate;
//import edu.icet.entity.User;
//import edu.icet.repository.UserRepository;
//import lombok.RequiredArgsConstructor;
//
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayDeque;
//import java.util.Optional;
//
//@Service
//@RequiredArgsConstructor
//public class UserDetailsServiceImpl implements UserDetailsService {
//
//    private final UserRepository userRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User authUser = userRepository.findByEmail(username);
//
//        if(authUser == null) {
//            throw new UsernameNotFoundException(username);
//        }
//        return new UserValidate(authUser);
//    }
//}
