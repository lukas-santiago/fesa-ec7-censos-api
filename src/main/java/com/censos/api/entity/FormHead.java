package com.censos.api.entity;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class FormHead {
    Long id;
    String code;
    String name;
    String description;
    LocalDateTime expiredAt;
    Long userId;
}