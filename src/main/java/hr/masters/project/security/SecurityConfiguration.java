package hr.masters.project.security;

import hr.masters.project.internationalization.Localization;
import hr.masters.project.service.impl.CustomUserDetailsServiceImpl;
import hr.masters.project.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter implements WebMvcConfigurer
{

    @Autowired
    private CustomUserDetailsServiceImpl userDetailsService;

    @Autowired
    private Localization localization;

    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception
    {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception
    {
        http.csrf().disable();
        http.authorizeRequests()
            .antMatchers(Constants.Paths.CSS).permitAll()//
            .antMatchers(Constants.Paths.FONTS).permitAll()//
            .antMatchers(Constants.Paths.IMAGES).permitAll()//
            .antMatchers(Constants.Paths.IMG).permitAll()//
            .antMatchers(Constants.Paths.JS).permitAll()//
            .antMatchers(Constants.Paths.STYLE).permitAll()//
            .antMatchers(Constants.Paths.EMPTY).permitAll()//
            .antMatchers(Constants.Paths.ERROR).permitAll()//
            .antMatchers(Constants.Paths.FORGOT_PASSWORD).permitAll()//
            .antMatchers(Constants.Paths.INDEX).permitAll()//
            .antMatchers(Constants.Paths.LOGIN).permitAll()//
            .antMatchers(Constants.Paths.NEW_PASSWORD_SUCCESS).permitAll()//
            .antMatchers(Constants.Paths.REGISTER).permitAll()//
            .antMatchers(Constants.Paths.REGISTRATION_SUCCESS).permitAll()//
            .anyRequest().authenticated()
            .and()//
            .formLogin().loginPage(Constants.Paths.LOGIN)//
            .defaultSuccessUrl(Constants.Paths.HOME)//
            .permitAll().and()//
            .logout().logoutUrl(Constants.Paths.LOGOUT)//
            .logoutSuccessUrl(Constants.Paths.EMPTY);
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder()
    {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void addInterceptors(final InterceptorRegistry registry)
    {
        registry.addInterceptor(localization.localeChangeInterceptor());
    }
}