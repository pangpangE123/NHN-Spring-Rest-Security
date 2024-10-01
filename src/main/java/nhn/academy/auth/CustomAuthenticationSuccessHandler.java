package nhn.academy.auth;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import nhn.academy.service.LoginAttemptService;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import java.io.IOException;

public class CustomAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    private LoginAttemptService loginAttemptService;
    public CustomAuthenticationSuccessHandler(LoginAttemptService loginAttemptService) {
        this.loginAttemptService = loginAttemptService;

    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {
        // 로그인 성공 시 추가 작업을 수행하는 로직
        System.out.println("User " + authentication.getName() + " has logged in successfully.");
        loginAttemptService.success(authentication.getName());

        // 원래 요청한 URL로 리다이렉트
        super.onAuthenticationSuccess(request, response, authentication);
    }
}
