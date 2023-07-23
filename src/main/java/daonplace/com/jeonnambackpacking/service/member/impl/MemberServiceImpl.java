package daonplace.com.jeonnambackpacking.service.member.impl;

import daonplace.com.jeonnambackpacking.dto.member.*;
import daonplace.com.jeonnambackpacking.mapper.MemberMapper;
import daonplace.com.jeonnambackpacking.model.Member;
import daonplace.com.jeonnambackpacking.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Slf4j
@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService {
    private final MemberMapper memberMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public MemberCreateResponseDto create(MemberCreateRequestDto requestDto) {
        LocalDateTime now = LocalDateTime.now();
        Member member = Member.builder()
                .email(requestDto.getEmail())
                .password(passwordEncoder.encode(requestDto.getPassword()))
                .nickname(requestDto.getNickname())
                .grade("ROLE_MEMBER")
                .signUpDate(now)
                .infoUpDate(now)
                .build();
        memberMapper.insertMember(member);
        return new MemberCreateResponseDto(now);
    }

    @Override
    public MemberUpdateResponseDto update(MemberUpdateRequestDto requestDto) {
        return null;
    }

    @Override
    public boolean exists(MemberExistRequestDto requestDto) {
        return memberMapper.exists(requestDto);
    }

    private boolean emailCheck(String email) {
        MemberExistRequestDto requestDto = new MemberExistRequestDto();
        requestDto.setEmail(email);
        return memberMapper.exists(requestDto);
    }

    private boolean nicknameCheck(String nickname) {
        MemberExistRequestDto requestDto = new MemberExistRequestDto();
        requestDto.setNickname(nickname);
        return memberMapper.exists(requestDto);
    }
}
