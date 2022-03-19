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
      /*  configuration.addAllowedHeader("x-fhir-starter");
  configuration.addAllowedHeader("Access-Control-Allow-Origin:http://localhost4200");
  configuration.addAllowedHeader("Accept");
  configuration.addAllowedHeader("X-Requested-With");
  configuration.addAllowedHeader("Content-Type");
  configuration.addAllowedOrigin("http://localhost4200");
  configuration.addExposedHeader("Location");
  configuration.addExposedHeader("Content-Location");https://argpro.herokuapp.com*/
        configuration.setAllowCredentials(true);
        configuration.setAllowedOrigins(Arrays.asList("https://argpro.herokuapp.com"));
        configuration.setAllowedHeaders(Arrays.asList("Origin","Content-Type", "Authorization"));
        configuration.setAllowedMethods(Arrays.asList("GET","POST","OPTIONS","PUT","DELETE"));
        configuration.setMaxAge(36000L);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
/*@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/personas/traer").allowedOrigins("http://localhost:7000");
			}
		};
	}*/
		@Override
                protected void configure(HttpSecurity http) throws Exception {
                    System.err.println("paso por aca");
                    CorsRegistry registry = new CorsRegistry();
                    registry.addMapping("/**").allowedOrigins("http://localhost:7000");
                    
                    //Customizer<HeadersConfigurer<HttpSecurity>> headersCustomizer;
                     /*  HttpServletResponse response = null ;
                        response.addHeader( "Content-Type" , "application/x-www-form-urlencoded");
                        response.addHeader("Access-Control-Allow-Origin", "http://localhost:4200");
                        response.addHeader("Access-Control-Allow-Headers","authorization,Origin,Content-Type");
                        response.addHeader("Access-Control-Allow-Methods", "GET,PUT,POST,DELETE,OPTION");
                       response.addHeader("Access-Control-Allow-Credentials","true");*/
                   //  http.csrf().disable()
                           //  .authorizeRequests().antMatchers(HttpMethod.GET,"/hello").permitAll();
                             //.anyRequest();
              /*  http.authorizeRequests()
                .mvcMatchers(HttpMethod.GET, "/personas/traer").permitAll() // GET requests don't need auth
                .anyRequest()
            .authenticated();*/
            /*.and()
            .oauth2ResourceServer()
            .jwt();*/
         
          
                           //  http.cors();
                   /* http.headers()
                      
				.frameOptions().sameOrigin()
				.httpStrictTransportSecurity().disable();*/
                        //CorsRegistry registry =new CorsRegistry();
				//http.headers().frameOptions().sameOrigin().httpStrictTransportSecurity().disable();
				/*.frameOptions().sameOrigin()
				.httpStrictTransportSecurity().disable();*/
                               /*  http
            .csrf()
                .ignoringAntMatchers()
            .and().authorizeRequests()
                .antMatchers("/**")
                .permitAll();*/
                   /*            http
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .httpBasic();*/
                   http.cors();
                          //http.cors().and().authorizeRequests().antMatchers("*","/**").permitAll();
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
				.antMatchers(HttpMethod.GET,"/personas/traer").permitAll().anyRequest().authenticated();
                                                                                           
                                
                            
                              
                                
                                
		}
    
  
                   
	}

}
