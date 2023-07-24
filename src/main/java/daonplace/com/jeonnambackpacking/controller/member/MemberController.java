package daonplace.com.jeonnambackpacking.controller.member;

import daonplace.com.jeonnambackpacking.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/members")
@Controller
public class MemberController {

    @GetMapping("/login")
    String loginPage() {
        return "login";
    }

    @GetMapping("/signup")
    String signUp() {
        return "signup";
    }
}
