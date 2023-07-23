package daonplace.com.jeonnambackpacking.controller.member;

import daonplace.com.jeonnambackpacking.service.member.MemberService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/members")
@Controller
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/login")
    String loginPage() {
        return "/html/login.html";
    }

    @GetMapping("/signup")
    String signUp() {
        return "/html/signup.html";
    }
}
