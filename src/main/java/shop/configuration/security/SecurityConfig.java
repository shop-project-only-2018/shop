package shop.configuration.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import shop.controller.AdviceController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import static shop.configuration.security.SecurityRouting.PROTECTED_URLS;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private AdviceController adviceController;
    private TokenAuthenticationProvider provider;

    @Autowired
    public void setAdviceController(AdviceController adviceController) {
        this.adviceController = adviceController;
    }

    @Autowired
    public void setProvider(TokenAuthenticationProvider provider) {
        this.provider = provider;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authenticationProvider(provider)
//                .addFilterBefore(authenticationFilter(), AnonymousAuthenticationFilter.class)

                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .exceptionHandling().accessDeniedHandler(accessDeniedHandler()).and()

//                .authorizeRequests()
//                .requestMatchers(ADMIN_API_URLS).hasRole("ADMIN")
//                .requestMatchers(USER_API_URLS).hasRole("USER")
//                .and()

                .httpBasic().disable()
                .formLogin().disable()
                .logout().disable()
                .csrf().disable();
    }

    @Bean
    public FilterRegistrationBean registrationBean(final TokenAuthenticationFilter authenticationFilter) {
        final FilterRegistrationBean<TokenAuthenticationFilter> bean = new FilterRegistrationBean<>();
        bean.setFilter(authenticationFilter);
        bean.setEnabled(false);
        return bean;
    }

    @Bean
    public TokenAuthenticationFilter authenticationFilter()
            throws Exception {

        final TokenAuthenticationFilter filter = new TokenAuthenticationFilter(PROTECTED_URLS);
        filter.setAuthenticationManager(authenticationManager());
        filter.setAuthenticationSuccessHandler(successHandler());
        filter.setAuthenticationFailureHandler(failureHandler());

        return filter;
    }

    @Bean
    public AuthenticationSuccessHandler successHandler() {
        final SimpleUrlAuthenticationSuccessHandler successHandler = new SimpleUrlAuthenticationSuccessHandler();
        successHandler.setRedirectStrategy((httpServletRequest, httpServletResponse, s) -> {
        });

        return successHandler;
    }

    @Bean
    public AuthenticationFailureHandler failureHandler() {
        // TODO: REDO
        return (request, response, ex) -> {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);

            ServletOutputStream out = response.getOutputStream();
            out.flush();
        };
    }

    @Bean
    public AccessDeniedHandler accessDeniedHandler() {
        // TODO: REDO
        return (request, response, ex) -> {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);

            ServletOutputStream out = response.getOutputStream();
            out.flush();
        };
    }

    @Bean
    public BCryptPasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder(10);
    }
}
