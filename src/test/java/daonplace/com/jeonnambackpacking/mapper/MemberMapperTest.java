package daonplace.com.jeonnambackpacking.mapper;

import daonplace.com.jeonnambackpacking.dto.member.MemberExistRequestDto;
import daonplace.com.jeonnambackpacking.dto.member.MemberUpdateRequestDto;
import daonplace.com.jeonnambackpacking.model.Member;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@MybatisTest
class MemberMapperTest {
    @Autowired
    private MemberMapper memberMapper;

    @Test
    void createTest() {
        LocalDateTime now = LocalDateTime.now();
        Member member = Member.builder()
                .email("member@daon.com")
                .password("password")
                .nickname("nickname")
                .signUpDate(now)
                .infoUpDate(now)
                .build();
        memberMapper.insertMember(member);

        System.out.println(member.getId());

        Optional<Member> result = memberMapper.findByEmail(member.getEmail());
        System.out.println(result.isPresent());
    }

    @Test
    void existTest() {
        LocalDateTime now = LocalDateTime.now();
        Member member = Member.builder()
                .email("member@daon.com")
                .password("password")
                .nickname("nickname")
                .signUpDate(now)
                .infoUpDate(now)
                .build();
        memberMapper.insertMember(member);

        MemberExistRequestDto requestDto = new MemberExistRequestDto();
        requestDto.setEmail("member@daon.co");

        boolean result = memberMapper.exists(requestDto);
        System.out.println(result);
    }

    @Test
    void updateTest() {
        LocalDateTime now = LocalDateTime.now();
        Member member = Member.builder()
                .email("member@daon.com")
                .password("password")
                .nickname("nickname")
                .signUpDate(now)
                .infoUpDate(now)
                .build();
        memberMapper.insertMember(member);

        MemberUpdateRequestDto requestDto = new MemberUpdateRequestDto(member.getEmail(), "nick", "12345");

        member.updateInfo(requestDto);
        memberMapper.updateMember(member);
        Optional<Member> result = memberMapper.findByEmail(member.getEmail());
        System.out.println(result.isPresent());
        System.out.println(result.get().getPassword());
    }

    @Test
    void test() {
        LocalDateTime now = LocalDateTime.now();
        Member member = Member.builder()
                .email("member@daon.com")
                .password("password")
                .nickname("nickname")
                .grade("MEMBER")
                .signUpDate(now)
                .infoUpDate(now)
                .build();
        memberMapper.insertMember(member);
        Optional<Member> res = memberMapper.findByEmail("member@daon.com");
        System.out.println(res.isPresent());
    }
}