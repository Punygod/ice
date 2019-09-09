package xyz.welog.kevin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xyz.welog.kevin.service.UserService;
import xyz.welog.kevin.vo.User;

/**
 * 功能描述:
 * 〈〉
 *
 * @author ：Kevin
 * @date ：Created in 2019/9/9 18:25
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/registry", method = RequestMethod.POST)
    public User createUser(@RequestParam("username") String username,
                           @RequestParam("password") String password) {
        return userService.create(username,password);
    }
}
