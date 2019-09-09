package xyz.welog.kevin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * 功能描述:
 *      开启资源服务 - @EnableResourceServer
 * @author : Kevin
 * @date : 2019/9/9 14:34
 */
@EnableEurekaClient
@EnableResourceServer
@SpringBootApplication
public class IceAuthApplication {
    public static void main( String[] args ) {
        SpringApplication.run(IceAuthApplication.class,args);
    }
}
