package co.edu.uniminuto.security;

import java.util.List;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {
	
	@Bean
	public InMemoryUserDetailsManager userManager() {
		List<UserDetails> users = List.of(
				User
				.withUsername("paquita")
				.password("{noop}$2a$10$.KBSlmybsjKPdnk.qIz66OkMICtmBCWK/h4qvMudWFU68z4v4KygO\n")
				.roles("USERS")
				.build(),
				
				User
				.withUsername("master")
				.password("{noop}$2a$10$J86z7pAKbLjHCFpH57hvQONcmrka73wzNvDq6LX4HYnSDW9ToQhLW")
				.roles("ADMINS")
				.build()
				
				);
		return new InMemoryUserDetailsManager(users);
				
				
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http.csrf(cus->cus.disable())
		.authorizeHttpRequests(aut->
		aut.requestMatchers(HttpMethod.GET,"/pet/mascotas").hasAnyRole("USERS")
		.requestMatchers(HttpMethod.GET,"/pet/mascotas/{id}").hasAnyRole("ADMINS")
		.requestMatchers(HttpMethod.GET,"/pet/mascotas").authenticated()
		)
		.httpBasic(Customizer.withDefaults());
		
		return http.build();
	}


}
