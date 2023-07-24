package daonplace.com.jeonnambackpacking.dto.tent;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.xml.bind.annotation.XmlElement;

@Getter
@AllArgsConstructor
public class TentSearchResponsePageDto {
    @XmlElement(name = "pageIndex")
    private int pageIndex;
    @XmlElement(name = "pageSize")
    private int pageSize;
    @XmlElement(name = "startPage")
    private int startPage;
    @XmlElement(name = "totalCount")
    private int totalCount;
}
