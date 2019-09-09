package xyz.welog.kevin.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.welog.kevin.vo.User;

/**
 * 功能描述:
 * 〈用户〉
 *
 * @author ：Kevin
 * @date ：Created in 2019/9/9 17:34
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
