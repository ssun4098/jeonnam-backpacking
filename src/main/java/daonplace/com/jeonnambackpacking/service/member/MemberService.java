package daonplace.com.jeonnambackpacking.service.member;

import daonplace.com.jeonnambackpacking.dto.member.*;

public interface MemberService {
    MemberCreateResponseDto create(MemberCreateRequestDto requestDto);
    MemberUpdateResponseDto update(MemberUpdateRequestDto requestDto);
    boolean exists(MemberExistRequestDto requestDto);
}
