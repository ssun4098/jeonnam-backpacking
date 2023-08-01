package daonplace.com.jeonnambackpacking.service.member.impl;

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
    private final String tentUrl = "http://apis.data.go.kr/6460000/tentInfo/getTentInfoList";
    private final String imgUrl = "http://apis.data.go.kr/6460000/tentInfo/getTentInfoFile";
    @Override
    public String getTentList(String name, int page, int size) {
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(tentUrl)
                .queryParam("serviceKey", key)
                .queryParam("pageSize", page)
                .queryParam("startPage", size);

        if(Objects.nonNull(name)) {
            uriBuilder.queryParam("tentNm", name);
        }

        String response = null;
        try {
            response = restTemplate.getForObject(uriBuilder.build(true).toUri(), String.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    @Override
    public String getTentImgList(String id) {
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(imgUrl)
                .queryParam("serviceKey", key)
                .queryParam("tentId", id);

        String response = null;
        try {
            response = restTemplate.getForObject(uriBuilder.build(true).toUri(), String.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }
}
