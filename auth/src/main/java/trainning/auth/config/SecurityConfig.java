package trainning.auth.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import trainning.auth.service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity  //开启Spring Security
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // register as a bean,否则在context中@Autowired非context管理的类会报null exception
    @Bean
    public UserDetailsService userDetailsService() {
        return new CustomUserDetailsService();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable();

        http
                .formLogin().successForwardUrl("/success").permitAll();

        http
                .authorizeRequests()
                .antMatchers("/html/index").permitAll().
                anyRequest().authenticated();


    }

    @Autowired
    public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception {
                 auth.
                         userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
    }
}


