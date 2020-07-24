package am.gordzka.gordzka.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Controller;

@Controller
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .formLogin()
                .loginPage("/login")
                .and()
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/lodin").permitAll()
                .antMatchers("/index").permitAll();
    }
}
