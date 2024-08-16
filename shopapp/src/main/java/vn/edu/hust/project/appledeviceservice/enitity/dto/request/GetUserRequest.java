package vn.edu.hust.project.appledeviceservice.enitity.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetUserRequest extends BaseGetRequest {
    private String role;
    private Long roleId;
}
