package xyz.welog.kevin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import xyz.welog.kevin.filter.JwtUtil;

/**
 * 功能描述:
 * 〈token 〉
 *
 * @author ：Kevin
 * @date ：Created in 2019/9/9 14:25
 */
@RestController
public class TokenController {

    @GetMapping("/getToken/{name}")
    public String get(@PathVariable("name") String name)  {
        return JwtUtil.generateToken(name);
    }
}
