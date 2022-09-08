//package eu.nickel.customerdataapi.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//public class RestServiceCorsApplication extends WebSecurityConfigurerAdapter {
//    @Bean
//    public WebMvcConfigurer corsConfigure(){
//        return new WebMvcConfigurer() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/customers")
//                        .allowedOrigins("http://localhost:3000");
//            }
//        };
//    }
//    }
