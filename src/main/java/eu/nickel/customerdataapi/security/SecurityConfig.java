package eu.nickel.customerdataapi.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception{
                // Disable CORS and CSRF
         http.cors().and().csrf().disable()

                // Set permissions on endpoints
                .authorizeRequests()
                // private endpoints
                .antMatchers(HttpMethod.GET, "/customers").hasAnyRole("EMPLOYEE")
                .antMatchers(HttpMethod.GET, "/customer/{id}").hasAnyRole("EMPLOYEE")
                        .anyRequest().authenticated()
                 .and().httpBasic();

//        Set session management to stateless
        http
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS).and();

}
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication()
                .withUser("employee").password(passwordEncoder().encode("employeePass"))
                .roles("EMPLOYEE");}
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    CorsFilter corsFilter() {
//        UrlBasedCorsConfigurationSource source =
//                new UrlBasedCorsConfigurationSource();
//
//        CorsConfiguration configuration = new CorsConfiguration();
//
//        configuration.setAllowedOrigins(Arrays.asList("http://localhost:3000"));
//                configuration.setAllowedMethods(Arrays.asList("GET"));
//
//        source.registerCorsConfiguration("/**", configuration);
//        return new CorsFilter(source);
//    }
}
