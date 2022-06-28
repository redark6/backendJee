package fr.esgi.cookRecipe.security;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final DataSource dataSource;
    private final ObjectMapper objectMapper;
    private final ApplicationContext context;

    public SecurityConfiguration(DataSource dataSource, ObjectMapper objectMapper,ApplicationContext context) {
        this.dataSource = dataSource;
        this.objectMapper = objectMapper;
        this.context = context;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.headers().frameOptions().disable();
        http.csrf().disable();
        http.authorizeRequests().antMatchers("/login", "/user/create").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .logout().permitAll()
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .logoutSuccessHandler((httpServletRequest, httpServletResponse, authentication) -> {
                    httpServletResponse.setStatus(HttpServletResponse.SC_OK);
                })
                .and()
                .addFilter(new CustomerAuthenticationFilter(authenticationManager(), objectMapper)) // filtre header not body
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                .maximumSessions(1);
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(jdbcUserDetailsManager()).passwordEncoder(bCryptPasswordEncoder());
    }

    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return this.context.getBean(BCryptPasswordEncoder.class);
    }

    public JdbcUserDetailsManager jdbcUserDetailsManager() {
        return this.context.getBean(JdbcUserDetailsManager.class);
    }

}
