package com.scs.college.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.scs.college.service.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
class SCSWebSecurityConfig extends WebSecurityConfigurerAdapter
{
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(scsAuthProvider());
	}
	
	@Bean
	public DaoAuthenticationProvider scsAuthProvider() {
		DaoAuthenticationProvider scsDao=new DaoAuthenticationProvider();
		scsDao.setUserDetailsService(scsUser());
		scsDao.setPasswordEncoder(scsPassword());
		
		return scsDao;
	}

    @Bean
	public BCryptPasswordEncoder scsPassword() {
		return new BCryptPasswordEncoder();
	}

    @Bean
	public UserDetailsService scsUser() {
		return new UserDetailsServiceImpl();
	}


	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
        .antMatchers("/","/wadiacollege/post/*","/ wadiacollege/get/*","/wadiacollege/accesDenied").hasAnyAuthority("USER","ADMIN")
        .antMatchers("/wadiacollege/put/*","/wadiacollege/delete/*").hasAuthority("ADMIN")
        .anyRequest().authenticated()
        .and()
        .formLogin().loginProcessingUrl("/login").successForwardUrl("/wadiacollege/get/greet").permitAll()
        .and()
        .logout().logoutSuccessUrl("/login").permitAll()
        .and()
        .exceptionHandling().accessDeniedPage("/wadiacollege/accesDenied")
        .and()
        .cors().and().csrf().disable();

	}
}