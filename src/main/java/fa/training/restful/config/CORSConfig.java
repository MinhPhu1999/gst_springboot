package fa.training.restful.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CORSConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
    	return new WebMvcConfigurer() {
    		@Override
    		public void addCorsMappings(CorsRegistry registry) {
//    			registry.addMapping("/**").allowedOrigins("http://localhost:4200");
    			registry.addMapping("/**")
    			//.allowedOrigins("http://localhost:4200")
                .allowedMethods("HEAD", "GET", "PUT", "POST", "DELETE", "PATCH");
    		}
		};
    }

}
