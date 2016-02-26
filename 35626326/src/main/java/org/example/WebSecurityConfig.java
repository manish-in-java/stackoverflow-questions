package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter
{
  protected void configure(HttpSecurity http) throws Exception
  {
    http.authorizeRequests().antMatchers("/css/**", "/font/**", "/script/**", "/login").permitAll()
        .anyRequest().authenticated()
        .and().formLogin().loginPage("/login").permitAll()
        .and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login");

    http.csrf().disable();
  }

  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception
  {
    auth.inMemoryAuthentication().withUser("user").password("password").roles("USER");
  }
}
