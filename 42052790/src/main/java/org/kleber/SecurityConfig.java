package org.kleber;

import java.io.Serializable;

import org.kleber.model.usuario.UsuarioDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;

//@Configuration
@ComponentScan
@EnableWebSecurity
@EnableGlobalMethodSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private PermissionEvaluator permissionEvaluator;

	public void configure(HttpSecurity http) throws Exception {
		http
			.csrf()
				.disable()
			.authorizeRequests()
				.antMatchers("/**").permitAll()
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.loginPage("/signin")
				.loginProcessingUrl("/login")
				.usernameParameter("login")
				.passwordParameter("senha")
				.and()
			.logout()
				.logoutUrl("/logout")
				.deleteCookies("remember-me")
				.and()
			.rememberMe();
	}

	public void configure(WebSecurity web) {
		DefaultWebSecurityExpressionHandler handler = new DefaultWebSecurityExpressionHandler();
		handler.setPermissionEvaluator(permissionEvaluator);
		web.expressionHandler(handler);
	}

	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.userDetailsService(userDetailsService)
			.passwordEncoder(new BCryptPasswordEncoder());
	}

	@Bean
	public UserDetailsService userDetailsService() {
		return new UserDetailsService() {
			@Autowired
			private UsuarioDao usuario;

			public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
				return (UserDetails) usuario.findBy("login", username);
			}

		};
	}

	@Bean
	public PermissionEvaluator permissionEvaluator() {
		return new PermissionEvaluator() {

			public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
				if(authentication == null || !authentication.isAuthenticated())
					return false;
				else
					for(GrantedAuthority authority: authentication.getAuthorities())
						if(authority.getAuthority().equals(permission))
							return true;
					return false;
			}

			public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
				if(authentication == null || !authentication.isAuthenticated())
					return false;
				else
					for(GrantedAuthority authority: authentication.getAuthorities())
						if(authority.getAuthority().equals(permission))
							return true;
					return false;
			}

		};
	}
}
