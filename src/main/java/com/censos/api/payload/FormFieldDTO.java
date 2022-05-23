package com.censos.api.payload;

import lombok.Data;

@Data
public class FormFieldDTO {
    Long id;
    Long formId;
    Long fieldId;
    String description;
    String data;
}
