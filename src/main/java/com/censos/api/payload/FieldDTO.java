package com.censos.api.payload;

import com.censos.api.entity.Field;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class FieldDTO {
    public Long id;
    public String type;

    public FieldDTO(Field field) {
        id = field.getId();
        type = field.getType();
    }

}
