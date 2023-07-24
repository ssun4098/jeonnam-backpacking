package daonplace.com.jeonnambackpacking.dto.tent;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class Body {
    private int pageIndex;
    private int pageSize;
    private int startPage;
    private int totalCount;

    private List<TentSearchResponseContentDto> list;
}
