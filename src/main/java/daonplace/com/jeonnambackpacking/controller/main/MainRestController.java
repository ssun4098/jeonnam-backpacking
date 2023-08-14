package daonplace.com.jeonnambackpacking.controller.main;

import daonplace.com.jeonnambackpacking.service.member.TentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

@Slf4j
@RequiredArgsConstructor
@RestController
public class MainRestController {
    private final TentService tentService;

    @GetMapping("/api/tents")
    public ResponseEntity<String> search(
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "size", defaultValue = "10") int size,
            @RequestParam(name = "page", defaultValue = "0") int page) throws UnsupportedEncodingException {
        return ResponseEntity.ok(tentService.getTentList(name, size, page));
    }

    @GetMapping("/api/tents/{id}")
    public ResponseEntity<String> imgList(@PathVariable String id) {
        return ResponseEntity.ok(tentService.getTentImgList(id));
    }
}
