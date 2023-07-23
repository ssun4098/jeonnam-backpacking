package daonplace.com.jeonnambackpacking.dto.member;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@AllArgsConstructor
public class MemberCreateRequestDto {
    @NotNull
    @NotBlank
    @Email
    private String email;
    @NotNull
    @NotBlank
    @Size(min = 5, message = "비밀번호를 5글자 이상 입력해주세요.")
    private String password;
    @NotNull
    @NotBlank
    @Size(min = 3, message = "닉네임을 3글자 이상 입력해주세요.")
    @Size(max = 10, message = "닉네임은 최대 10글자까지 허용합니다.")
    private String nickname;
}
