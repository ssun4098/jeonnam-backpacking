package daonplace.com.jeonnambackpacking.dto.tent;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
public class TentSearchResponseContentDto {
    private int tentId;
    private String tentNm;
    private String tentAddr;
    private String tentReservation;
    private String tentHomepage;
    private String tentOpen;
    private String tentIntro;
    private String tentTrafficInfo;
}
