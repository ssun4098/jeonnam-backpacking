package daonplace.com.jeonnambackpacking.controller.main;

import daonplace.com.jeonnambackpacking.service.member.TentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@RequiredArgsConstructor
@Controller
public class MainController {
    @GetMapping
    public String homepage() {
        return "main.html";
    }

    @GetMapping("/detail/{id}")
    public String detail(@RequestParam String tentNm, @RequestParam int tentId) {return "detail.html?tentNm=" + tentNm + "&tentId=" + tentId;}
}
