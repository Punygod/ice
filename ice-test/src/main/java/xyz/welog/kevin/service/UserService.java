package xyz.welog.kevin.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import xyz.welog.kevin.dao.UserRepository;
import xyz.welog.kevin.vo.User;

/**
 * 功能描述:
 * 〈〉
 *
 * @author ：Kevin
 * @date ：Created in 2019/9/9 18:24
 */
@Service
public class UserService {
    private static final BCryptPasswordEncoder ENCODER = new BCryptPasswordEncoder();

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User create(String username, String password) {
        User user = new User();
        user.setUsername(username);
        String hash = ENCODER.encode(password);
        user.setPassword(hash);
        return userRepository.save(user);
    }
}
