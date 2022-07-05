package ro.pcs.tasks02.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableConfigurationProperties
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
               .csrf().disable()
                .authorizeRequests()
             //   .antMatchers("/login").permitAll()
                .antMatchers("/").permitAll()
                .antMatchers("/animals").hasAnyRole("USER", "ADMIN")
                .antMatchers("/animals/**").hasAnyRole("USER", "ADMIN")
             //   .anyRequest().authenticated()
             //   .and().formLogin()
                .and()
                .httpBasic()
                .and().sessionManagement().disable();
               // .loginPage("/login")
               // .usernameParameter("login")
               // .passwordParameter("password")
               // .defaultSuccessUrl("/animals/all")
               // .permitAll();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
        //NoOpPasswordEncoder.getInstance();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }
}