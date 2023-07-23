package daonplace.com.jeonnambackpacking.model;

import daonplace.com.jeonnambackpacking.dto.member.MemberUpdateRequestDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    Long id;
    String email;
    String password;
    String nickname;
    String grade;
    LocalDateTime signUpDate;
    LocalDateTime infoUpDate;
    boolean ban;
    String banReason;
    boolean withdrawal;

    public void updateInfo(MemberUpdateRequestDto requestDto) {
        this.nickname = requestDto.getNickname();
        this.password = requestDto.getPassword();
        this.infoUpDate = LocalDateTime.now();
    }
}
