package eu.nickel.customerdataapi.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http = http.cors().and().csrf().disable();

                // Set permissions on endpoints
                http
                        .authorizeRequests()

                // private endpoints
                .antMatchers(HttpMethod.GET, "/customers").hasAnyRole("MANAGER", "ANALYST", "CLIENT")
                .antMatchers(HttpMethod.GET, "/customer/{id}").hasAnyRole("MANAGER", "ANALYST", "CLIENT")
                        .anyRequest().authenticated();
                http.httpBasic();

//        //Set session management to stateless
//        http
//                .sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and();
}

//    @Override
//    public void configure(AuthenticationManagerBuilder auth) throws Exception{
//        auth.inMemoryAuthentication()
//                .withUser("manager").password(passwordEncoder().encode("managerPass"))
//                .roles("MANAGER")
//                .and()
//                .withUser("analyst").password(passwordEncoder().encode("analystPass"))
//                .roles("ANALYST")
//                .and()
//                .withUser("client").password(passwordEncoder().encode("clientPass"))
//                .roles("CLIENT");
//    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source =
                new UrlBasedCorsConfigurationSource();

        CorsConfiguration configuration = new CorsConfiguration();

        configuration.setAllowedOrigins(Arrays.asList("http://localhost:3000"));
                configuration.setAllowedMethods(Arrays.asList("GET"));

        source.registerCorsConfiguration("/**", configuration);
        return new CorsFilter(source);
    }
}
