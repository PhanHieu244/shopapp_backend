package vn.edu.hust.project.appledeviceservice.utils;

import org.springframework.data.domain.Page;
import vn.edu.hust.project.appledeviceservice.enitity.dto.response.PageInfo;

public class PageInfoUtils {
    public static final PageInfoUtils INSTANCE = new PageInfoUtils();
    public static <T> PageInfo getPageInfoUtils(Page<T> result) {
        var pageInfo = new PageInfo();
        pageInfo.setTotalRecord(result.getTotalElements());
        pageInfo.setTotalPage((long) result.getTotalPages());
        if (result.hasNext()) {
            pageInfo.setNextPage((long) result.nextPageable().getPageNumber());
        }

        if (result.hasPrevious()) {
            pageInfo.setPreviousPage((long) result.previousPageable().getPageNumber());
        }
        return pageInfo;
    }
}
