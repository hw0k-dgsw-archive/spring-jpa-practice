package kr.hs.dgsw.web_0326.repositories;

import kr.hs.dgsw.web_0326.domains.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
