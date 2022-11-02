package dev.arealnemexis.publicatusnotes.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


//    @Bean
//    public WebSecurityCustomizer webSecurityCustomizer() {
//        return (web) -> web.ignoring()
//                .antMatchers("/**");
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.requestMatchers().and()
//                .authorizeRequests()
//                .antMatchers(HttpMethod.POST, "/auth/signon").permitAll()
//                .antMatchers(HttpMethod.GET, "/notes/test").permitAll();
        http.csrf()
                .ignoringAntMatchers("**")
                .and()
                .authorizeRequests()
                .antMatchers("**").permitAll();
    }
//.addFilterAfter(new JwtFilter(), UsernamePasswordAuthenticationFilter.class)

}