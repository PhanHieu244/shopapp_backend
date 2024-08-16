package vn.edu.hust.project.appledeviceservice.enitity.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageInfo {

    private Long totalPage;

    private Long totalRecord;

    private Long pageSize;

    private Long nextPage;

    private Long previousPage;

}
