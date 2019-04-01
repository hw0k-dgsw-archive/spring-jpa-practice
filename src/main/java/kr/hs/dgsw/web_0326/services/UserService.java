package kr.hs.dgsw.web_0326.services;

import kr.hs.dgsw.web_0326.domains.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User addUser(User user);
    List<User> listAllUsers();
    User viewUser(Long id);
    User updateUser(Long id, User user);
    boolean deleteUser(Long id);
}
