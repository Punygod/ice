package xyz.welog.kevin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.codec.ServerCodecConfigurer;

/**
 * 功能描述: 〈〉
 * @author : Kevin
 * @date : 2019/9/9 14:17
 */
@SpringBootApplication
@EnableDiscoveryClient
public class IceGatewayApplication {
    public static void main( String[] args ) {
        SpringApplication.run(IceGatewayApplication.class,args);
    }

    @Bean
    public ServerCodecConfigurer serverCodecConfigurer() {
        return ServerCodecConfigurer.create();
    }
}
