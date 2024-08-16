package vn.edu.hust.project.appledeviceservice.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Key {

    INVENTORY_PRODUCT_DETAIL("inventory::product_detail_id::"),;

    private final String prefixKey;
}
