package daonplace.com.jeonnambackpacking.controller.member;

import daonplace.com.jeonnambackpacking.dto.member.MemberCreateRequestDto;
import daonplace.com.jeonnambackpacking.dto.member.MemberCreateResponseDto;
import daonplace.com.jeonnambackpacking.dto.member.MemberExistRequestDto;
import daonplace.com.jeonnambackpacking.mapper.MemberMapper;
import daonplace.com.jeonnambackpacking.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/members")
@RestController
public class MemberRestController {
    private final MemberService memberService;

    @GetMapping("/duplication")
    ResponseEntity<Boolean> duplicationCheck(@ModelAttribute MemberExistRequestDto requestDto) {
        log.info("Email: {}", requestDto.getEmail());
        log.info("Nickname: {}", requestDto.getNickname());
        return ResponseEntity.ok(memberService.exists(requestDto));
    }

    @PostMapping("/signup")
    ResponseEntity<MemberCreateResponseDto> create(@RequestBody MemberCreateRequestDto requestDto) {
        return new ResponseEntity<>(memberService.create(requestDto), HttpStatus.CREATED);
    }
}
