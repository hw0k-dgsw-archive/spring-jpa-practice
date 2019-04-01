package kr.hs.dgsw.web_0326.services;

import kr.hs.dgsw.web_0326.domains.User;
import kr.hs.dgsw.web_0326.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User addUser(User user) {
        if (this.userRepository.findByEmail(user.getEmail()).isPresent()) {
            return null;
        }

        return this.userRepository.save(user);
    }

    @Override
    public List<User> listAllUsers() {
        return this.userRepository.findAll();
    }

    @Override
    public User viewUser(Long id) {
        return this.userRepository.findById(id).orElse(null);
    }

    @Override
    public User updateUser(Long id, User user) {
        Optional<User> target = this.userRepository.findById(id);
        return target.map(this.userRepository::save).orElse(null);
    }

    @Override
    public boolean deleteUser(Long id) {
        try {
            this.userRepository.deleteById(id);
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
