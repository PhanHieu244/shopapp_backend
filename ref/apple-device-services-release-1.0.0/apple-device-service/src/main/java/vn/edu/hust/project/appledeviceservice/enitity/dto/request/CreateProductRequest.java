package vn.edu.hust.project.appledeviceservice.enitity.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class CreateProductRequest {

    private String name;

    private String code;

    private String description;

    private List<String> descriptionImages;

    private List<String> images;

    private String bannerImg;

    private String status;

    private Long warrantyDuration;

    private Long typeId;
}
