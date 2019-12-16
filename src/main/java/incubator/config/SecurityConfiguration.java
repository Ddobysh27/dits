package incubator.config;

import incubator.model.User;
import incubator.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private CustomSuccessHandler customSuccessHandler;

    @Autowired
    public void setCustomSuccessHandler(CustomSuccessHandler customSuccessHandler) {
        this.customSuccessHandler = customSuccessHandler;
    }

    @Autowired
    UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        for (User u : userService.getAllUsers()
        ) {
            auth.inMemoryAuthentication().passwordEncoder(passwordEncoder)
                    .withUser(u.getLogin())
                    .password(passwordEncoder.encode("" + u.getPassword()))
                    .roles(u.getNormanRole());
        }
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/user**", "/chooseTest**", "/personalStatistic**", "/goUserHome**", "/UserChoose**", "/goTest**", "/nextTestPage**", "/resultPage**").access("hasRole('USER')")
                .antMatchers("/admin").access("hasRole('ADMIN')")
                .antMatchers("/tutor").access("hasRole('TUTOR')")
                .and().formLogin().loginPage("/login").successHandler(customSuccessHandler)
                .usernameParameter("ssoId").passwordParameter("password")
                .and().csrf()
                .and().exceptionHandling().accessDeniedPage("/Access_Denied");
    }

}