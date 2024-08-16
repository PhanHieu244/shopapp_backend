package com.project.shopapp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ImageEntity extends BaseEntity {

    private Long entityId;

    private String img;

    private String type;
}
