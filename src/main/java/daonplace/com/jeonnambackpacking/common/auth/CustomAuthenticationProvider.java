package daonplace.com.jeonnambackpacking.common.auth;

import daonplace.com.jeonnambackpacking.common.auth.exception.PasswordNotMatchException;
import daonplace.com.jeonnambackpacking.model.MemberDetails;
import daonplace.com.jeonnambackpacking.service.member.impl.MemberDetailsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Slf4j
@Component("authenticationProvider")
@RequiredArgsConstructor
public class CustomAuthenticationProvider implements AuthenticationProvider {
    private final MemberDetailsService memberDetailsService;
    private final PasswordEncoder passwordEncoder;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        log.info(authentication.toString());
        String loginId = authentication.getName();

        String password = (String) authentication.getCredentials();

        log.info("loginId: {}", loginId);
        log.info("password: {}", password);
        UserDetails memberDetails = memberDetailsService.loadUserByUsername(loginId);

        if(!passwordEncoder.matches(password, memberDetails.getPassword())) {
            throw new BadCredentialsException("Password Not Match");
        }
        return new UsernamePasswordAuthenticationToken(memberDetails, null, memberDetails.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
