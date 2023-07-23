package daonplace.com.jeonnambackpacking.service.member.impl;

import daonplace.com.jeonnambackpacking.mapper.MemberMapper;
import daonplace.com.jeonnambackpacking.model.Member;
import daonplace.com.jeonnambackpacking.model.MemberDetails;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class MemberDetailsService implements UserDetailsService {
    private final MemberMapper memberMapper;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        log.info(email);
        Member member = memberMapper.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(email));
        return MemberDetails.builder()
                .email(member.getEmail())
                .password(member.getPassword())
                .grade(member.getGrade())
                .build();
    }
}
