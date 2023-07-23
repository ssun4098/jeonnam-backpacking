package daonplace.com.jeonnambackpacking.mapper;

import daonplace.com.jeonnambackpacking.dto.member.MemberExistRequestDto;
import daonplace.com.jeonnambackpacking.dto.member.MemberUpdateRequestDto;
import daonplace.com.jeonnambackpacking.model.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface MemberMapper {
    void insertMember(Member member);
    void updateMember(Member member);
    Optional<Member> findByEmail(String email);
    boolean exists(MemberExistRequestDto requestDto);
}
