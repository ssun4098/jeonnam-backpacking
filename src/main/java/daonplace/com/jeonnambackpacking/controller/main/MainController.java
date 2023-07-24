package daonplace.com.jeonnambackpacking.controller.main;

import daonplace.com.jeonnambackpacking.service.member.TentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@RequiredArgsConstructor
@Controller
public class MainController {
    @GetMapping("/")
    public String main() {
        return "main";
    }
}
