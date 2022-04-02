package com.example.sesion.sesion;

import java.util.Arrays;
import javax.servlet.http.HttpServletResponse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication/*(scanBasePackages={
"com.example.sesion.sesion.repository.PersonaRepository", "com.example.sesion.sesion.service.PersonaService"})*/
public class SesionApplication {

	public static void main(String[] args) {
		SpringApplication.run(SesionApplication.class, args);
	}
@EnableWebSecurity
	@Configuration
        @EnableWebMvc

	class WebSecurityConfig extends WebSecurityConfigurerAdapter {
 @Bean
    CorsConfigurationSource corsConfigurationSource() 
    {
        CorsConfiguration configuration = new CorsConfiguration();

        configuration.setAllowCredentials(true);
        configuration.setAllowedOrigins(Arrays.asList("https://argpro-f55b0.web.app"));
        configuration.setAllowedHeaders(Arrays.asList("Origin","Content-Type", "Authorization"));
        configuration.setAllowedMethods(Arrays.asList("GET","POST","OPTIONS","PUT","DELETE"));
        configuration.setMaxAge(36000L);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

		@Override
                protected void configure(HttpSecurity http) throws Exception {
                   
                    CorsRegistry registry = new CorsRegistry();
                    registry.addMapping("/**").allowedOrigins("http://localhost:7000");
                    
                    
                   http.cors();
                          
			http.csrf().disable()
				.addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
				.authorizeRequests()                       
				.antMatchers(HttpMethod.POST,"/user").permitAll()/*.and().authorizeRequests()
                                .antMatchers(HttpMethod.GET,"hello").permitAll().and().authorizeRequests()
				.antMatchers(HttpMethod.OPTIONS,"hello").permitAll()*//*.and().authorizeRequests()*/
                                /*.antMatchers(HttpMethod.GET,"/personas/traer").permitAll().and().authorizeRequests()
                                .antMatchers(HttpMethod.POST,"/personas/crear").permitAll().and().authorizeRequests()
                                .antMatchers(HttpMethod.DELETE,"/personas/borrar/{id}").permitAll().and().authorizeRequests()
                                .antMatchers(HttpMethod.PUT,"/personas/editar/{id}").permitAll()*/
                                .and().authorizeRequests()
				.antMatchers(HttpMethod.POST,"/user/crear").permitAll().and().authorizeRequests()
				.antMatchers(HttpMethod.PUT,"/user/editar/{id}").permitAll()/*.and().authorizeRequests()
				.antMatchers(HttpMethod.PUT,"/user/traer/{user}").permitAll()*/.anyRequest().authenticated();
                                                                                           
                                
                            
                              
                                
                                
		}
    
  
                   
	}

}
