package org.example.stackoverflow;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
public class WebApplicationSecurityConfiguration extends WebSecurityConfigurerAdapter
{
  @Bean
  public UserDetailsService userDetailsService()
  {
    final InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();

    userDetailsManager.createUser(User.withDefaultPasswordEncoder()
                                      .username("protected")
                                      .password("password")
                                      .authorities("protected")
                                      .build());

    userDetailsManager.createUser(User.withDefaultPasswordEncoder()
                                      .username("private")
                                      .password("password")
                                      .authorities("private")
                                      .build());

    return userDetailsManager;
  }

  @Override
  protected void configure(final HttpSecurity http) throws Exception
  {
    http.authorizeRequests()
        .antMatchers("/", "/public/**").permitAll()
        .antMatchers("/protected/**").hasAuthority("protected")
        .anyRequest().authenticated()
        .and()
        .httpBasic()
        .and()
        .logout().clearAuthentication(true).deleteCookies("JSESSIONID").invalidateHttpSession(true).logoutSuccessUrl("/")
        .and()
        .csrf().disable();
  }
}
