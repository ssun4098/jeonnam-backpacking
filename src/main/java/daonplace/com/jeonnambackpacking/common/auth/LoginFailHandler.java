package daonplace.com.jeonnambackpacking.common.auth;

import daonplace.com.jeonnambackpacking.common.auth.exception.PasswordNotMatchException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component
public class LoginFailHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        log.info("login fail");
        log.info(exception.toString());
        if(exception instanceof BadCredentialsException) {
            response.sendError(400, "존재하지 않는 계정이거나 비밀번호가 틀렸습니다.");
        } else if(exception instanceof UsernameNotFoundException) {
            response.sendError(400, "존재하지 않는 계정이거나 비밀번호가 틀렸습니다.");
        }
    }
}
