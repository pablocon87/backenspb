package com.example.sesion.sesion;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import java.util.Arrays;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.reactive.PathRequest;
import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@SpringBootApplication/*(scanBasePackages={
"com.example.sesion.sesion.repository.PersonaRepository", "com.example.sesion.sesion.service.PersonaService"})*/
public class SesionApplication {

	public static void main(String[] args) {
		SpringApplication.run(SesionApplication.class, args);
	}
       // @EnableWebMvc
	@Configuration
        
        
        @EnableWebSecurity
	class WebSecurityConfig extends WebSecurityConfigurerAdapter {

         
       public void configuress(List<HttpMessageConverter <?>> converters)  {
       MappingJackson2HttpMessageConverter jackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
       ObjectMapper objectMapper = new ObjectMapper();
       objectMapper.setSerializationInclusion(JsonInclude.Include.NON_ABSENT);
       
       objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
                      SimpleModule simpleModule = new SimpleModule();
                      simpleModule.addSerializer(Long.class,ToStringSerializer.instance);
                      simpleModule.addSerializer(Long.TYPE,ToStringSerializer.instance);
                      objectMapper.registerModule(simpleModule);
                      jackson2HttpMessageConverter.setObjectMapper(objectMapper);
                      List<MediaType> mediaTypes = Arrays.asList(
                      
                      MediaType.APPLICATION_JSON,
                      MediaType.TEXT_PLAIN,
                      MediaType.TEXT_HTML,
                      MediaType.TEXT_XML,
                      MediaType.APPLICATION_OCTET_STREAM
                      
                      );
       
                          jackson2HttpMessageConverter.setSupportedMediaTypes(mediaTypes);
                          converters.add(jackson2HttpMessageConverter);
   }
  /*@Override
    public void configure(ResourceHandlerRegistry registry) throws Exception {
        registry
                .addResourceHandler("/resources/**")
                .addResourceLocations("/resources/");
    }*/
  /*@Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/static/styles/**");
    }*/
  

         String[] resources = new String[]{
            "/include/**","/styles/**","/icons/**","/img/**","/js/**","/layer/**","/","/Carga"};
 @Bean
    CorsConfigurationSource corsConfigurationSource() 
    {
       
        CorsConfiguration configuration = new CorsConfiguration();
                                                        //https://argpro-f55b0.web.app https://porfoarp.herokuapp.com/
        configuration.setAllowCredentials(true);
        configuration.setAllowedOrigins(Arrays.asList("https://argpro-f55b0.web.app","https://porfoarp.herokuapp.com"));
        configuration.setAllowedHeaders(Arrays.asList("Origin","Content-Type", "Authorization"));
        configuration.setAllowedMethods(Arrays.asList("GET","POST","OPTIONS","PUT","DELETE"));
        configuration.setMaxAge(36000L);//
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
      
        return source;
    }
   
		@Override
                protected void configure(HttpSecurity http) throws Exception {
                  
                   /* CorsRegistry registry = new CorsRegistry();
                    registry.addMapping("/**").allowedOrigins("http://localhost:7000");*/
               
                  
                   http.cors();
                         
                           http
			.csrf().disable()
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
				.antMatchers(HttpMethod.POST,"/user/crear").permitAll().and().authorizeRequests().and().authorizeRequests()
				.antMatchers(HttpMethod.PUT,"/user/editar/{id}").permitAll()
				.antMatchers(resources).permitAll().and().authorizeRequests()
				.antMatchers("/static/styles/**").permitAll().and().authorizeRequests()
                                .anyRequest().authenticated().and()
                                    ;
                 
                                
                                
		}
  /*   @Override
   public void configure(ViewControllerRegistry registry) throws Exception {
      registry.addViewController("/").setViewName("main");
   }*/
                @Bean
   public ViewResolver viewResolver() {
      InternalResourceViewResolver bean = new InternalResourceViewResolver();

      bean.setViewClass(JstlView.class);
      bean.setPrefix("/static/styles/");
      bean.setSuffix(".css");

      return bean;
   }
   
  
                   
	}


}
