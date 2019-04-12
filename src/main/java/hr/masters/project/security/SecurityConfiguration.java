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
        http.csrf().disable().
                authorizeRequests().antMatchers(Constants.Fragments.HOME_USER)
            .authenticated().anyRequest().permitAll()
            .and()//
            .formLogin().loginPage(Constants.Fragments.HOME)//
            .defaultSuccessUrl(Constants.Fragments.HOME_USER)//
            .permitAll().and()//
            .logout().logoutUrl(Constants.Fragments.LOGOUT)//
            .logoutSuccessUrl(Constants.Fragments.HOME);
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