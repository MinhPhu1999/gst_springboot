package fa.training.restful.config;

//import fa.training.restful.security.JwtAuthenticationFilter;
import fa.training.restful.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.CorsConfigurer;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebSecurity
public class WebConfig extends WebSecurityConfigurerAdapter {
//    @Bean
//    public JwtAuthenticationFilter jwtAuthenticationFilter() {
//        return new JwtAuthenticationFilter();
//    }

    @Autowired
    UserService userService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        .cors().disable()
        .csrf().disable()
        .authorizeRequests()
        .filterSecurityInterceptorOncePerRequest(true)
        .antMatchers("/users/login").permitAll()

        .antMatchers(HttpMethod.POST,"/products/add").hasAnyAuthority("admin")
        .antMatchers(HttpMethod.GET, "/products").hasAnyAuthority("admin", "user")
        .antMatchers(HttpMethod.GET, "/products/{id:\\d+}").hasAnyAuthority("admin", "user")
        .antMatchers(HttpMethod.DELETE, "/products/delete/{id:\\d+}").hasAnyAuthority("admin");


//        http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
        //http.addFilterBefore(UsernamePasswordAuthenticationFilter.class);
    }
}
