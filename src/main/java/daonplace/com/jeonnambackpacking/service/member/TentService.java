package daonplace.com.jeonnambackpacking.service.member;

public interface TentService {
    String getTentList(String name, int page, int size);
    String getTentImgList(String id);
}
