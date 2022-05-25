package com.censos.api.payload;

import java.time.LocalDateTime;

import com.censos.api.entity.Form;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class FormDTO {
    private Long id;
    private String name;
    private String description;
    LocalDateTime expiredAt;

    public FormDTO(Form form) {
        id = form.getId();
        name = form.getName();
        description = form.getDescription();
        expiredAt = form.getExpiredAt();
    }
}