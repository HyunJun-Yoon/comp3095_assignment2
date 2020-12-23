package com.example.demo.config;

import com.example.demo.config.auth.PrincipalDetail;
import com.example.demo.config.auth.PrincipalDetailService;
import com.example.demo.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.header.writers.StaticHeadersWriter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;



@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private PrincipalDetailService principalDetailService;

    long userId;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                    .antMatchers(
                            "/h2-console/**",
                            "/",
                            "/auth/**",
                            "/loginPage",
                            "/js/**",
                            "/css/**",
                            "/addUser/**",
                            "/resources/**",
                            "/img/**",
                            "/webjars/**"
                            )
                    .permitAll()
                    .antMatchers(SecurityConstants.H2_CONSOLE)
                    .permitAll()
                    .anyRequest()
                    .authenticated()
                .and()
                    .formLogin()
                    .loginPage("/")
                    .loginProcessingUrl("/auth/loginPage")
                    .defaultSuccessUrl("/dashboard")
                    .and()
                    .csrf().requireCsrfProtectionMatcher(new AntPathRequestMatcher("!/h2-console/**")) .and().headers().addHeaderWriter(new StaticHeadersWriter("X-Content-Security-Policy","script-src 'self'")).frameOptions().disable();
    }


    @Bean
    public BCryptPasswordEncoder encodePWD(){
        return new BCryptPasswordEncoder();
    }

    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin@isp.net").password(encodePWD().encode("P@ssword1")).roles("ADMIN");
        auth.userDetailsService(principalDetailService).passwordEncoder(encodePWD());
    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//
//    }


}

