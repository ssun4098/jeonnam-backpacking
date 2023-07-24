package daonplace.com.jeonnambackpacking.common.config;

import daonplace.com.jeonnambackpacking.common.auth.CustomAuthenticationProvider;
import daonplace.com.jeonnambackpacking.common.auth.LoginFailHandler;
import daonplace.com.jeonnambackpacking.common.auth.LoginSuccessHandler;
import daonplace.com.jeonnambackpacking.model.MemberDetails;
import daonplace.com.jeonnambackpacking.service.member.impl.MemberDetailsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@Slf4j
@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig {
    private final CustomAuthenticationProvider customAuthenticationProvider;
    private final LoginFailHandler loginFailHandler;
    private final LoginSuccessHandler loginSuccessHandler;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.csrf().disable();
        http.httpBasic().disable();

        http.formLogin()
                .loginPage("/members/login")
                .loginProcessingUrl("/login")
                .usernameParameter("email")
                .passwordParameter("password")
                .successHandler(loginSuccessHandler)
                .failureHandler(loginFailHandler);

        http.authorizeHttpRequests(
                (auth) -> {
                    auth.antMatchers("/api/members/**").permitAll();
                    auth.antMatchers("/members/**").permitAll();
                    auth.antMatchers("/").permitAll();
                }
                );
        http.authenticationManager(authenticationManager(http));
        return http.build();
    }

    private AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder =
                http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.authenticationProvider(customAuthenticationProvider);
        return authenticationManagerBuilder.build();
    }

}
