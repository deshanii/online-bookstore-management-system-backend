//package edu.icet.repository;
//
//import edu.icet.entity.User;
//import edu.icet.enums.UserRole;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.Optional;
//
//
//@Repository
//public interface UserRepository extends JpaRepository<User, Long> {
//
//    Optional<User> findFirstByEmail(String email);
//    User findByRole(UserRole userRole);
//    User findByEmail(String email);
//}
