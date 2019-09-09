package xyz.welog.kevin.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.sql.DataSource;

/**
 * 功能描述:
 * 〈认证服务器〉
 *
 * @author ：Kevin
 * @date ：Created in 2019/9/9 17:51
 */
public class OAuth2AuthorizationConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    @Qualifier("dataSource")
    private DataSource dataSource;

    // 将Token存储在内存中
    // private TokenStore tokenStore = new InMemoryTokenStore();
    private TokenStore tokenStore = new JdbcTokenStore(dataSource);


    @Autowired
    @Qualifier("authenticationManagerBean")
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userServiceDetail;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        // 将客户端的信息存储在内存中
        clients.inMemory()
                // 创建了一个client名为browser的客户端
                .withClient("browser")
                // 配置验证类型
                .authorizedGrantTypes("refresh_token", "password")
                // 配置客户端域为“ui”
                .scopes("ui")
                .and()
                .withClient("service-hi")
                .secret("123456")
                .authorizedGrantTypes("client_credentials", "refresh_token","password")
                .scopes("server");
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        // 配置Token的存储方式
        endpoints.tokenStore(tokenStore)
                // 注入WebSecurityConfig配置的bean
                .authenticationManager(authenticationManager)
                // 读取用户的验证信息
                .userDetailsService(userServiceDetail);
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
        // 对获取Token的请求不再拦截
        oauthServer.tokenKeyAccess("permitAll()")
                // 验证获取Token的验证信息
                .checkTokenAccess("isAuthenticated()");
    }
}
