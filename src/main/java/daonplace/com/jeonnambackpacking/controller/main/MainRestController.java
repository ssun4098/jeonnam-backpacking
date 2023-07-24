package daonplace.com.jeonnambackpacking.controller.main;

import daonplace.com.jeonnambackpacking.service.member.TentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class MainRestController {
    private final TentService tentService;

    @GetMapping("/api/tents")
    public ResponseEntity<String> search(
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "size", defaultValue = "10") int size,
            @RequestParam(name = "page", defaultValue = "0") int page) {
        return ResponseEntity.ok(tentService.getTentList(name, size, page));
    }
    
}