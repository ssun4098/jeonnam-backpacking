package daonplace.com.jeonnambackpacking.service.member.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import daonplace.com.jeonnambackpacking.dto.tent.TentSearchResponseDto;
import daonplace.com.jeonnambackpacking.service.member.TentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Objects;

@Slf4j
@RequiredArgsConstructor
@Service
public class TentServiceImpl implements TentService {
    private final RestTemplate restTemplate;
    @Value("${tent.api-key}")
    private String key;
    private final String url = "http://apis.data.go.kr/6460000/tentInfo/getTentInfoList";
    private final ObjectMapper objectMapper;
    @Override
    public String getTentList(String name, int page, int size) {
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("serviceKey", key)
                .queryParam("pageSize", page)
                .queryParam("startPage", size);

        if(Objects.nonNull(name)) {
            uriBuilder.queryParam("tentNm", name);
        }

        String response = null;
        try {
            response = restTemplate.getForObject(uriBuilder.build(true).toUri(), String.class);
            TentSearchResponseDto responseDto = objectMapper.readValue(response, TentSearchResponseDto.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }
}
