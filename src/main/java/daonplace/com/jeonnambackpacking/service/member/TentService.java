package daonplace.com.jeonnambackpacking.service.member;

import java.io.UnsupportedEncodingException;

public interface TentService {
    String getTentList(String name, int page, int size) throws UnsupportedEncodingException;
    String getTentImgList(String id);
}
