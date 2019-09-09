package xyz.welog.kevin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * 功能描述:
 * 〈〉
 *
 * @author ：Kevin
 * @date ：Created in 2019/9/9 18:04
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping("/current")
    public Principal getUser(Principal principal) {
        return principal;
    }
}
