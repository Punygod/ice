package xyz.welog.kevin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 *
 * @author : Kevin
 * @date : 2019/9/9 11:54
 */
@SpringBootApplication
@EnableEurekaServer
public class IceCloudApplication {
    public static void main( String[] args ) {
        SpringApplication.run(IceCloudApplication.class,args);
    }
}
