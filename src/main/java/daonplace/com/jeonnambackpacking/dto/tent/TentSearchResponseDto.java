package daonplace.com.jeonnambackpacking.dto.tent;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TentSearchResponseDto {
    private Header header;
    private Body body;

    public TentSearchResponseDto(@JsonProperty("header") Header header, @JsonProperty("body") Body body) {
        this.header = header;
        this.body = body;
    }

    public Header getHeader() {
        return header;
    }

    public Body getBody() {
        return body;
    }
}
