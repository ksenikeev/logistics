package ru.icmit.logistics.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import ru.icmit.logistics.service.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(getUserDetailsService())
                .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/usercheck").permitAll()
                .antMatchers("/usercheckform").permitAll()
                .antMatchers("/css/**").permitAll()
                .antMatchers("/img/**").permitAll()
                .antMatchers("/js/**").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/**").authenticated()//.hasRole("ADMIN")
                .and()
                // Делаем свою форму логина
                .formLogin()
                .failureHandler(new SimpleUrlAuthenticationFailureHandler())
                .loginPage("/login")
                .failureUrl("/login?error")
                // После успешной аутентификации по умолчанию отправляем на /
                .defaultSuccessUrl("/")
                // Аутентификация будет проходить по адресу /usercheckform
                //.loginProcessingUrl("/usercheckform")
                // Используем следующие названия полей для логина и пароля
                //.usernameParameter("username").passwordParameter("password")
                .and()
                // После логаута отправляем на /
                .logout().logoutSuccessUrl("/").invalidateHttpSession(true);
        http.csrf().disable();
    }


    @Override
    public void configure(WebSecurity web) throws Exception {
        // Вывести ресурсы из под контроля Spring Security чтобы они могли кешироваться
        web.ignoring().antMatchers("/resources/**","/templates/**");
    }

    @Bean
    public UserDetailsService getUserDetailsService(){
        return  userDetailsService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}