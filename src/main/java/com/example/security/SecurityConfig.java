package com.example.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configurable
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	private DataSource dataSource;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication()
//		.withUser("admin").password("123")
//		.roles("ADMIN","USER");
//		auth.inMemoryAuthentication()
//		.withUser("user").password("123")
//		.roles("USER");
		auth.jdbcAuthentication()
		.dataSource(dataSource).usersByUsernameQuery("select username as principale,pass as credentials,active from users where username=? ")
		.authoritiesByUsernameQuery("select username as principale,role as role from users_roles where username=? ")
		.rolePrefix("ROLE_");
		//.passwordEncoder(new Md5PasswordEncoder());


		
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin().loginPage("/login");
		//http.authorizeRequests().anyRequest().authenticated();
		http.authorizeRequests().antMatchers("/saveEntreprise").hasRole("ADMIN");
		http.authorizeRequests().antMatchers("/entreprises","/taxes","/formEntreprise").hasRole("USER");
		http.exceptionHandling().accessDeniedPage("/403");
	}


 @Bean
public static NoOpPasswordEncoder passwordEncoder() {
 return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
}

}
