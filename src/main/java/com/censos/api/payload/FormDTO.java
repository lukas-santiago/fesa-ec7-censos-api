package com.censos.api.payload;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class FormDTO {
    private Long id;
    private String name;
    private String description;
    LocalDateTime expiredAt;
}