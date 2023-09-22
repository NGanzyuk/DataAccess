package homework3.dataaccess.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("user1").password("123");
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.formLogin().and()
                .authorizeRequests().antMatchers("/products/fetch").permitAll()
                .and()
                .authorizeRequests().anyRequest().authenticated();
    }
}
