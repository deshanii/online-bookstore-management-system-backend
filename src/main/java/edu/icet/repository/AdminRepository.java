package edu.icet.repository;

import edu.icet.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface AdminRepository extends JpaRepository<Admin,Integer> {
    Optional<Admin> findOneByEmailAndPassword(String email, String password);
    Admin findByEmail(String email);
}
