package xyz.welog.kevin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 功能描述:
 * 〈〉
 *
 * @author ：Kevin
 * @date ：Created in 2019/9/9 18:31
 */
@EnableEurekaClient
@SpringBootApplication
public class IceTestApplication {
    public static void main(String[] args) {
        SpringApplication.run(IceTestApplication.class, args);
    }
}
